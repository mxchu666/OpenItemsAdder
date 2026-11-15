package dev.lone.itemsadder;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.c;
import dev.lone.itemsadder.e;
import ia.sh.libby.Library;
import ia.sh.libby.LibraryManager;
import ia.sh.libby.classloader.URLClassLoaderHelper;
import itemsadder.m.zw;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import org.apache.commons.io.FilenameUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class b
extends LibraryManager {
    private final Function Pc;
    private final URLClassLoaderHelper Pd;
    private final YamlConfiguration Pe;
    private final String Pf;

    public b(Main main) {
        this(main, "libraries-libby");
    }

    public b(Main main, e e2) {
        this(main, "libraries-libby", e2);
    }

    public b(Main main, String string) {
        this(main, string, e.Pi);
    }

    public b(Main main, String string2, e e2) {
        super(new c(main), main.getDataFolder().toPath(), "lib");
        Function function;
        this.Pd = new URLClassLoaderHelper(b.d((Plugin)main), this);
        this.Pe = b.e((Plugin)main);
        this.Pf = string2;
        try {
            Class<?> clazz = Class.forName("org.bukkit.plugin.java.LibraryLoader");
            Field field = clazz.getDeclaredField("REMAPPER");
            function = (Function)field.get(null);
        }
        catch (Exception exception) {
            function = null;
        }
        this.Pc = function;
        if (e2.Pj) {
            this.addMavenLocal();
        }
        if (e2.Pk) {
            this.addRepository("https://maven-central.storage-download.googleapis.com/maven2/");
            this.addMavenCentral();
        }
        if (e2.Pl) {
            this.addRepository("https://maven.aliyun.com/repository/central");
        }
        if (e2.Pm != null) {
            e2.Pm.stream().filter(string -> string != null && !string.isEmpty()).forEach(string -> this.addRepository((String)string));
        }
    }

    private static URLClassLoader d(Plugin plugin) {
        ClassLoader classLoader = plugin.getClass().getClassLoader();
        if (!zw.sZ()) {
            return (URLClassLoader)classLoader;
        }
        try {
            Field field = classLoader.getClass().getDeclaredField("libraryLoader");
            field.setAccessible(true);
            Object object = field.get(classLoader);
            if (object instanceof URLClassLoader) {
                return (URLClassLoader)object;
            }
            throw new IllegalStateException("Plugin library classloader is unavailable");
        }
        catch (Exception exception) {
            plugin.getLogger().log(Level.WARNING, "Failed to access the isolated library classloader, falling back to the plugin classloader.", exception);
            return (URLClassLoader)classLoader;
        }
    }

    @Override
    protected void addToClasspath(@NotNull Path path) {
        this.Pd.addToClasspath(path);
    }

    private Path c(Path path) {
        return this.Pc != null ? (Path)((List)this.Pc.apply(Collections.singletonList(path))).get(0) : path;
    }

    private void a(Path path, Path path2) {
        Path path3 = Files.createTempFile("tmp-", ".jar", new FileAttribute[0]);
        try (JarFile jarFile = new JarFile(path.toFile());
             JarOutputStream jarOutputStream = new JarOutputStream(Files.newOutputStream(path3, new OpenOption[0]));){
            Cloneable cloneable;
            Enumeration<JarEntry> enumeration = jarFile.entries();
            while (enumeration.hasMoreElements()) {
                cloneable = enumeration.nextElement();
                if ("META-INF/MANIFEST.MF".equals(((ZipEntry)cloneable).getName())) continue;
                InputStream inputStream = jarFile.getInputStream((ZipEntry)cloneable);
                try {
                    int n;
                    jarOutputStream.putNextEntry(new JarEntry(((ZipEntry)cloneable).getName()));
                    byte[] byArray = new byte[1024];
                    while ((n = inputStream.read(byArray)) != -1) {
                        jarOutputStream.write(byArray, 0, n);
                    }
                    jarOutputStream.closeEntry();
                }
                finally {
                    if (inputStream == null) continue;
                    inputStream.close();
                }
            }
            cloneable = jarFile.getManifest();
            if (cloneable == null) {
                cloneable = new Manifest();
            }
            ((Manifest)cloneable).getMainAttributes().putValue("paperweight-mappings-namespace", "spigot");
            jarOutputStream.putNextEntry(new JarEntry("META-INF/MANIFEST.MF"));
            ((Manifest)cloneable).write(jarOutputStream);
            jarOutputStream.closeEntry();
        }
        Files.move(path3, path2, StandardCopyOption.REPLACE_EXISTING);
    }

    public void a(@NotNull Library library, boolean bl) {
        this.logger.info("Loading library " + library.getArtifactId() + (bl ? " (remapped)" : "") + "...");
        Path path = this.downloadLibrary(Objects.requireNonNull(library, "library"));
        if (library.resolveTransitiveDependencies()) {
            this.resolveTransitiveLibraries(library);
        }
        if (bl) {
            try {
                Path path2 = path.getParent().resolve(FilenameUtils.getBaseName((String)path.getFileName().toString()) + "-modified.jar");
                if (!Files.exists(path2, new LinkOption[0])) {
                    this.a(path, path2);
                }
                path = this.c(path2);
            }
            catch (IOException iOException) {
                throw new RuntimeException("Failed to remap library " + library.getArtifactId(), iOException);
            }
        }
        if (library.isIsolatedLoad()) {
            this.addToIsolatedClasspath(library, path);
        } else {
            this.addToClasspath(path);
        }
    }

    public void rP() {
        this.a(this.Pe.getStringList(this.Pf));
    }

    public void c(Set set) {
        List list = this.Pe.getStringList(this.Pf);
        list.addAll(set);
        this.a(list);
    }

    public void d(Set set) {
        this.a(set);
    }

    private void a(Iterable iterable) {
        for (String string : iterable) {
            String[] stringArray = string.split(":");
            if (stringArray.length != 3) {
                this.logger.warn("Invalid library format: " + string + ". Expected format: groupId:artifactId:version");
                continue;
            }
            boolean bl = false;
            for (int i = 1; i < stringArray.length; ++i) {
                if (!stringArray[i].contains("--remap")) continue;
                bl = true;
                break;
            }
            string = string.split(" ")[0];
            stringArray = string.split(":");
            Library library = Library.builder().groupId(stringArray[0]).artifactId(stringArray[1]).version(stringArray[2]).resolveTransitiveDependencies(true).loaderId("itemsadder-libby-libs").isolatedLoad(false).build();
            try {
                this.a(library, bl);
            }
            catch (Exception | LinkageError throwable) {
                throw new RuntimeException("Failed to load library " + string, throwable);
            }
        }
    }

    @NotNull
    private static YamlConfiguration e(Plugin plugin) {
        File file;
        Object object;
        try {
            object = JavaPlugin.class.getDeclaredMethod("getFile", new Class[0]);
            ((Method)object).setAccessible(true);
            file = (File)((Method)object).invoke((Object)plugin, new Object[0]);
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            throw new RuntimeException("Error accessing plugin JAR file.", reflectiveOperationException);
        }
        try {
            try (JarFile jarFile = new JarFile(file);){
                JarEntry jarEntry = jarFile.getJarEntry("plugin.yml");
                try (InputStream inputStream = jarFile.getInputStream(jarEntry);){
                    object = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
                }
            }
            jarFile = new YamlConfiguration();
            jarFile.loadFromString((String)object);
            return jarFile;
        }
        catch (IOException | InvalidConfigurationException throwable) {
            throw new RuntimeException("plugin.yml not found in the jar file.");
        }
    }
}
