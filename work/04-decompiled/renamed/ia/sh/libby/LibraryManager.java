package ia.sh.libby;

import ia.sh.libby.Library;
import ia.sh.libby.RepositoryResolutionMode;
import ia.sh.libby.Util;
import ia.sh.libby.classloader.IsolatedClassLoader;
import ia.sh.libby.configuration.Configuration;
import ia.sh.libby.configuration.ConfigurationFetcher;
import ia.sh.libby.logging.LogLevel;
import ia.sh.libby.logging.Logger;
import ia.sh.libby.logging.adapters.LogAdapter;
import ia.sh.libby.relocation.Relocation;
import ia.sh.libby.relocation.RelocationHelper;
import ia.sh.libby.transitive.TransitiveDependencyHelper;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class LibraryManager {
    protected final Logger logger;
    protected final Path saveDirectory;
    protected final Set<String> repositories = new LinkedHashSet<String>();
    protected RelocationHelper relocator;
    protected TransitiveDependencyHelper transitiveDependencyHelper;
    protected ConfigurationFetcher configurationFetcher;
    protected final IsolatedClassLoader globalIsolatedClassLoader = new IsolatedClassLoader(new URL[0]);
    protected final Map<String, IsolatedClassLoader> isolatedLibraries = new HashMap<String, IsolatedClassLoader>();
    protected RepositoryResolutionMode repositoryResolutionMode = RepositoryResolutionMode.DEFAULT;

    @Deprecated
    protected LibraryManager(@NotNull LogAdapter logAdapter, @NotNull Path path) {
        this.logger = new Logger(Objects.requireNonNull(logAdapter, "logAdapter"));
        this.saveDirectory = Objects.requireNonNull(path, "dataDirectory").toAbsolutePath().resolve("lib");
    }

    protected LibraryManager(@NotNull LogAdapter logAdapter, @NotNull Path path, @NotNull String string) {
        this.logger = new Logger(Objects.requireNonNull(logAdapter, "logAdapter"));
        this.saveDirectory = Objects.requireNonNull(path, "dataDirectory").toAbsolutePath().resolve(Objects.requireNonNull(string, "directoryName"));
    }

    protected abstract void addToClasspath(@NotNull Path var1);

    protected void addToIsolatedClasspath(@NotNull Library library, @NotNull Path path) {
        String string2 = library.getLoaderId();
        IsolatedClassLoader isolatedClassLoader = string2 != null ? this.isolatedLibraries.computeIfAbsent(string2, string -> new IsolatedClassLoader(new URL[0])) : this.globalIsolatedClassLoader;
        isolatedClassLoader.addPath(path);
    }

    @NotNull
    public IsolatedClassLoader getGlobalIsolatedClassLoader() {
        return this.globalIsolatedClassLoader;
    }

    @Nullable
    public IsolatedClassLoader getIsolatedClassLoaderById(@NotNull String string) {
        return this.isolatedLibraries.get(string);
    }

    @NotNull
    public LogLevel getLogLevel() {
        return this.logger.getLevel();
    }

    public void setLogLevel(@NotNull LogLevel logLevel) {
        this.logger.setLevel(logLevel);
    }

    @NotNull
    public Logger getLogger() {
        return this.logger;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public Collection<String> getRepositories() {
        LinkedList<String> linkedList;
        Set<String> set = this.repositories;
        synchronized (set) {
            linkedList = new LinkedList<String>(this.repositories);
        }
        return Collections.unmodifiableList(linkedList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addRepository(@NotNull String string) {
        String string2 = Objects.requireNonNull(string, "url").endsWith("/") ? string : string + '/';
        Set<String> set = this.repositories;
        synchronized (set) {
            this.repositories.add(string2);
        }
    }

    public void addMavenLocal() {
        this.addRepository(Paths.get(System.getProperty("user.home"), new String[0]).resolve(".m2/repository").toUri().toString());
    }

    public void addMavenCentral() {
        this.addRepository("https://repo1.maven.org/maven2/");
    }

    public void addSonatype() {
        this.addRepository("https://oss.sonatype.org/content/groups/public/");
    }

    public void addJCenter() {
        this.addRepository("https://jcenter.bintray.com/");
    }

    public void addJitPack() {
        this.addRepository("https://jitpack.io/");
    }

    public RepositoryResolutionMode getRepositoryResolutionMode() {
        return this.repositoryResolutionMode;
    }

    public void setRepositoryResolutionMode(RepositoryResolutionMode repositoryResolutionMode) {
        this.repositoryResolutionMode = repositoryResolutionMode;
    }

    @NotNull
    public Collection<String> resolveLibrary(@NotNull Library library) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(Objects.requireNonNull(library, "library").getUrls());
        boolean bl = library.isSnapshot();
        Collection<String> collection = this.resolveRepositories(library);
        for (String string : collection) {
            if (bl) {
                String string2 = this.resolveSnapshot(string, library);
                if (string2 == null) continue;
                linkedHashSet.add(string + string2);
                continue;
            }
            linkedHashSet.add(string + library.getPath());
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public Collection<String> resolveRepositories(@NotNull Library library) {
        switch (this.getRepositoryResolutionMode()) {
            case GLOBAL_FIRST: {
                return Stream.of(this.getRepositories(), library.getRepositories(), library.getFallbackRepositories()).flatMap(Collection::stream).collect(Collectors.toCollection(LinkedHashSet::new));
            }
            case LIBRARY_FIRST: {
                return Stream.of(library.getRepositories(), library.getFallbackRepositories(), this.getRepositories()).flatMap(Collection::stream).collect(Collectors.toCollection(LinkedHashSet::new));
            }
        }
        return Stream.of(library.getRepositories(), this.getRepositories(), library.getFallbackRepositories()).flatMap(Collection::stream).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Nullable
    protected String resolveSnapshot(@NotNull String string, @NotNull Library library) {
        String string2;
        block15: {
            String string3 = string.startsWith("file") ? "maven-metadata-local.xml" : "maven-metadata.xml";
            String string4 = Objects.requireNonNull(string, "repository") + Objects.requireNonNull(library, "library").getPartialPath() + string3;
            URLConnection uRLConnection = new URL(Objects.requireNonNull(string4, "url")).openConnection();
            uRLConnection.setConnectTimeout(5000);
            uRLConnection.setReadTimeout(5000);
            uRLConnection.setRequestProperty("User-Agent", "libby/2.0.0-SNAPSHOT");
            InputStream inputStream = uRLConnection.getInputStream();
            try {
                string2 = this.getURLFromMetadata(inputStream, library);
                if (inputStream == null) break block15;
            }
            catch (Throwable throwable) {
                try {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    }
                    throw throwable;
                }
                catch (MalformedURLException malformedURLException) {
                    throw new IllegalArgumentException(malformedURLException);
                }
                catch (IOException iOException) {
                    if (iOException instanceof FileNotFoundException) {
                        this.logger.debug("File not found: " + string4);
                    } else if (iOException instanceof SocketTimeoutException) {
                        this.logger.debug("Connect timed out: " + string4);
                    } else if (iOException instanceof UnknownHostException) {
                        this.logger.debug("Unknown host: " + string4);
                    } else {
                        this.logger.debug("Unexpected IOException", iOException);
                    }
                    return null;
                }
            }
            inputStream.close();
        }
        return string2;
    }

    @Nullable
    protected String getURLFromMetadata(@NotNull InputStream inputStream, @NotNull Library library) {
        Objects.requireNonNull(inputStream, "inputStream");
        Objects.requireNonNull(library, "library");
        String string = library.getVersion();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("snapshot");
            if (nodeList.getLength() == 0) {
                return null;
            }
            Node node = nodeList.item(0);
            if (node.getNodeType() != 1) {
                return null;
            }
            Node node2 = ((Element)node).getElementsByTagName("localCopy").item(0);
            if (node2 == null || node2.getNodeType() != 1) {
                Node node3 = ((Element)node).getElementsByTagName("timestamp").item(0);
                if (node3 == null || node3.getNodeType() != 1) {
                    return null;
                }
                Node node4 = ((Element)node).getElementsByTagName("buildNumber").item(0);
                if (node4 == null || node4.getNodeType() != 1) {
                    return null;
                }
                Node node5 = node3.getFirstChild();
                if (node5 == null || node5.getNodeType() != 3) {
                    return null;
                }
                Node node6 = node4.getFirstChild();
                if (node6 == null || node6.getNodeType() != 3) {
                    return null;
                }
                String string2 = node5.getNodeValue();
                String string3 = node6.getNodeValue();
                string = library.getVersion();
                if (string.endsWith("-SNAPSHOT")) {
                    string = string.substring(0, string.length() - "-SNAPSHOT".length());
                }
                string = string + '-' + string2 + '-' + string3;
            }
        }
        catch (ParserConfigurationException | SAXException exception) {
            this.logger.debug("Invalid maven-metadata.xml", exception);
            return null;
        }
        return Util.craftPath(library.getPartialPath(), library.getArtifactId(), string, library.getClassifier());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected byte[] downloadLibrary(@NotNull String string) {
        try {
            URLConnection uRLConnection = new URL(Objects.requireNonNull(string, "url")).openConnection();
            uRLConnection.setConnectTimeout(5000);
            uRLConnection.setReadTimeout(5000);
            uRLConnection.setRequestProperty("User-Agent", "libby/2.0.0-SNAPSHOT");
            InputStream inputStream = uRLConnection.getInputStream();
            try {
                byte[] byArray2 = new byte[8192];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    int n;
                    while ((n = inputStream.read(byArray2)) != -1) {
                        byteArrayOutputStream.write(byArray2, 0, n);
                    }
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    this.logger.warn("Download timed out: " + uRLConnection.getURL());
                    byte[] byArray3 = null;
                    if (inputStream == null) return byArray3;
                    inputStream.close();
                    return byArray3;
                }
                this.logger.info("Downloaded library " + uRLConnection.getURL());
                byte[] byArray = byteArrayOutputStream.toByteArray();
                return byArray;
            }
            finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    }
                    catch (Throwable throwable2) {
                        Throwable throwable;
                        throwable.addSuppressed(throwable2);
                    }
                }
            }
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException(malformedURLException);
        }
        catch (IOException iOException) {
            if (iOException instanceof FileNotFoundException) {
                this.logger.debug("File not found: " + string);
                return null;
            }
            if (iOException instanceof SocketTimeoutException) {
                this.logger.debug("Connect timed out: " + string);
                return null;
            }
            if (iOException instanceof UnknownHostException) {
                this.logger.debug("Unknown host: " + string);
                return null;
            }
            this.logger.debug("Unexpected IOException", iOException);
            return null;
        }
    }

    @NotNull
    public Path downloadLibrary(@NotNull Library library) {
        Collection<String> collection;
        Path path = this.saveDirectory.resolve(Objects.requireNonNull(library, "library").getPath());
        if (Files.exists(path, new LinkOption[0])) {
            if (!library.isSnapshot()) {
                if (library.hasRelocations()) {
                    path = this.relocate(path, library.getRelocatedPath(), library.getRelocations());
                }
                return path;
            }
            try {
                Files.delete(path);
            }
            catch (IOException iOException) {
                throw new UncheckedIOException(iOException);
            }
        }
        if ((collection = this.resolveLibrary(library)).isEmpty()) {
            throw new RuntimeException("Library '" + library + "' couldn't be resolved, add a repository");
        }
        MessageDigest messageDigest = null;
        if (library.hasChecksum()) {
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                throw new RuntimeException(noSuchAlgorithmException);
            }
        }
        Path path2 = path.resolveSibling(path.getFileName() + ".tmp");
        path2.toFile().deleteOnExit();
        try {
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            for (String string : collection) {
                Object object;
                byte[] byArray = this.downloadLibrary(string);
                if (byArray == null) continue;
                if (messageDigest != null && !Arrays.equals(object = messageDigest.digest(byArray), library.getChecksum())) {
                    this.logger.warn("*** INVALID CHECKSUM ***");
                    this.logger.warn(" Library :  " + library);
                    this.logger.warn(" URL :  " + string);
                    this.logger.warn(" Expected :  " + Base64.getEncoder().encodeToString(library.getChecksum()));
                    this.logger.warn(" Actual :  " + Base64.getEncoder().encodeToString((byte[])object));
                    continue;
                }
                Files.write(path2, byArray, new OpenOption[0]);
                Files.move(path2, path, new CopyOption[0]);
                if (library.hasRelocations()) {
                    path = this.relocate(path, library.getRelocatedPath(), library.getRelocations());
                }
                object = path;
                return object;
            }
        }
        catch (IOException iOException) {
            throw new UncheckedIOException(iOException);
        }
        finally {
            try {
                Files.deleteIfExists(path2);
            }
            catch (IOException iOException) {}
        }
        throw new RuntimeException("Failed to download library '" + library + "'");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public Path relocate(@NotNull Path path, @NotNull String string, @NotNull Collection<Relocation> collection) {
        Objects.requireNonNull(path, "in");
        Objects.requireNonNull(string, "out");
        Objects.requireNonNull(collection, "relocations");
        Path path2 = this.saveDirectory.resolve(string);
        if (Files.exists(path2, new LinkOption[0])) {
            return path2;
        }
        Path path3 = path2.resolveSibling(path2.getFileName() + ".tmp");
        path3.toFile().deleteOnExit();
        Object object = this;
        synchronized (object) {
            if (this.relocator == null) {
                this.relocator = new RelocationHelper(this);
            }
        }
        try {
            this.relocator.relocate(path, path3, collection);
            Files.move(path3, path2, new CopyOption[0]);
            this.logger.info("Relocations applied to " + path.getFileName());
            object = path2;
            return object;
        }
        catch (IOException iOException) {
            throw new UncheckedIOException(iOException);
        }
        finally {
            try {
                Files.deleteIfExists(path3);
            }
            catch (IOException iOException) {}
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void resolveTransitiveLibraries(@NotNull Library library) {
        Objects.requireNonNull(library, "library");
        LibraryManager libraryManager = this;
        synchronized (libraryManager) {
            if (this.transitiveDependencyHelper == null) {
                this.transitiveDependencyHelper = new TransitiveDependencyHelper(this, this.saveDirectory);
            }
        }
        for (Library library2 : this.transitiveDependencyHelper.findTransitiveLibraries(library)) {
            this.loadLibrary(library2);
        }
    }

    public void loadLibrary(@NotNull Library library) {
        this.logger.info("Loading library " + library);
        Path path = this.downloadLibrary(Objects.requireNonNull(library, "library"));
        if (library.resolveTransitiveDependencies()) {
            this.resolveTransitiveLibraries(library);
        }
        if (library.isIsolatedLoad()) {
            this.addToIsolatedClasspath(library, path);
        } else {
            this.addToClasspath(path);
        }
    }

    public void loadLibraries(Library ... libraryArray) {
        for (Library library : libraryArray) {
            this.loadLibrary(library);
        }
    }

    public void configureFromJSON() {
        this.configureFromJSON("libby.json");
    }

    public void configureFromJSON(@NotNull String string) {
        this.configureFromJSON(Objects.requireNonNull(this.getResourceAsStream(string), "resourceAsStream"));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void configureFromJSON(@NotNull InputStream inputStream) {
        Object object = this;
        synchronized (object) {
            if (this.configurationFetcher == null) {
                this.configurationFetcher = new ConfigurationFetcher(this);
            }
        }
        object = this.configurationFetcher.readJsonFile(inputStream);
        for (String object2 : ((Configuration)object).getRepositories()) {
            this.addRepository(object2);
        }
        for (Library library : ((Configuration)object).getLibraries()) {
            this.loadLibrary(library);
        }
    }

    @Nullable
    protected InputStream getResourceAsStream(@NotNull String string) {
        return this.getClass().getClassLoader().getResourceAsStream(string);
    }
}
