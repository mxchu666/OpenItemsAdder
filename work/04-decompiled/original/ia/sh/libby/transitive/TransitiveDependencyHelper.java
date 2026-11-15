package ia.sh.libby.transitive;

import ia.sh.libby.Library;
import ia.sh.libby.LibraryManager;
import ia.sh.libby.Util;
import ia.sh.libby.classloader.IsolatedClassLoader;
import ia.sh.libby.transitive.ExcludedDependency;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TransitiveDependencyHelper {
    private static final String TRANSITIVE_DEPENDENCY_COLLECTOR_CLASS = Util.replaceWithDots("com{}alessiodp{}libby{}maven{}resolver{}TransitiveDependencyCollector");
    private static final String ARTIFACT_CLASS = Util.replaceWithDots("org{}eclipse{}aether{}artifact{}Artifact");
    private final Object transitiveDependencyCollectorObject;
    private final Method resolveTransitiveDependenciesMethod;
    private final Method artifactGetGroupIdMethod;
    private final Method artifactGetArtifactIdMethod;
    private final Method artifactGetVersionMethod;
    private final Method artifactGetBaseVersionMethod;
    private final Method artifactGetClassifierMethod;
    private final LibraryManager libraryManager;

    public TransitiveDependencyHelper(@NotNull LibraryManager libraryManager, @NotNull Path path) {
        Objects.requireNonNull(libraryManager, "libraryManager");
        this.libraryManager = libraryManager;
        IsolatedClassLoader isolatedClassLoader = new IsolatedClassLoader(new URL[0]);
        isolatedClassLoader.addPath(libraryManager.downloadLibrary(Library.builder().groupId("com{}alessiodp{}libby{}maven{}resolver").artifactId("libby-maven-resolver").version("1.0.1").checksumFromBase64("EmsSUwjtqSeYTt8WEw7LPI/5Yz8bWSxf23XcdLEM7dk=").fallbackRepository("https://repo1.maven.org/maven2/").fallbackRepository("https://repo.alessiodp.com/releases").build()));
        try {
            Class<?> clazz = isolatedClassLoader.loadClass(TRANSITIVE_DEPENDENCY_COLLECTOR_CLASS);
            Class<?> clazz2 = isolatedClassLoader.loadClass(ARTIFACT_CLASS);
            Constructor<?> constructor = clazz.getConstructor(Path.class);
            constructor.setAccessible(true);
            this.transitiveDependencyCollectorObject = constructor.newInstance(path);
            this.resolveTransitiveDependenciesMethod = clazz.getMethod("findTransitiveDependencies", String.class, String.class, String.class, String.class, Stream.class);
            this.resolveTransitiveDependenciesMethod.setAccessible(true);
            this.artifactGetGroupIdMethod = clazz2.getMethod("getGroupId", new Class[0]);
            this.artifactGetArtifactIdMethod = clazz2.getMethod("getArtifactId", new Class[0]);
            this.artifactGetVersionMethod = clazz2.getMethod("getVersion", new Class[0]);
            this.artifactGetBaseVersionMethod = clazz2.getMethod("getBaseVersion", new Class[0]);
            this.artifactGetClassifierMethod = clazz2.getMethod("getClassifier", new Class[0]);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    @NotNull
    public Collection<Library> findTransitiveLibraries(@NotNull Library library) {
        ArrayList<Library> arrayList = new ArrayList<Library>();
        HashSet<ExcludedDependency> hashSet = new HashSet<ExcludedDependency>(library.getExcludedTransitiveDependencies());
        Collection<String> collection = this.libraryManager.getRepositories();
        Collection<String> collection2 = library.getRepositories();
        Collection<String> collection3 = library.getFallbackRepositories();
        if (collection.isEmpty() && collection2.isEmpty() && collection3.isEmpty()) {
            throw new IllegalArgumentException("No repositories have been added before resolving transitive dependencies");
        }
        Stream<String> stream = this.libraryManager.resolveRepositories(library).stream();
        try {
            Collection collection4 = (Collection)this.resolveTransitiveDependenciesMethod.invoke(this.transitiveDependencyCollectorObject, library.getGroupId(), library.getArtifactId(), library.getVersion(), library.getClassifier(), stream);
            for (Object e : collection4) {
                Map.Entry entry = (Map.Entry)e;
                Object k = entry.getKey();
                @Nullable String string = (String)entry.getValue();
                String string2 = (String)this.artifactGetGroupIdMethod.invoke(k, new Object[0]);
                String string3 = (String)this.artifactGetArtifactIdMethod.invoke(k, new Object[0]);
                String string4 = (String)this.artifactGetBaseVersionMethod.invoke(k, new Object[0]);
                String string5 = (String)this.artifactGetClassifierMethod.invoke(k, new Object[0]);
                if (library.getGroupId().equals(string2) && library.getArtifactId().equals(string3) || hashSet.contains(new ExcludedDependency(string2, string3))) continue;
                Library.Builder builder = Library.builder().groupId(string2).artifactId(string3).version(string4).isolatedLoad(library.isIsolatedLoad()).loaderId(library.getLoaderId());
                if (string5 != null && !string5.isEmpty()) {
                    builder.classifier(string5);
                }
                library.getRelocations().forEach(builder::relocate);
                if (string != null) {
                    if (!string.endsWith("/")) {
                        string = string + '/';
                    }
                    String string6 = (String)this.artifactGetVersionMethod.invoke(k, new Object[0]);
                    String string7 = Util.craftPartialPath(string3, string2, string4);
                    String string8 = Util.craftPath(string7, string3, string6, string5);
                    builder.url(string + string8);
                } else {
                    library.getRepositories().forEach(builder::repository);
                    library.getFallbackRepositories().forEach(builder::fallbackRepository);
                }
                arrayList.add(builder.build());
            }
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
        return Collections.unmodifiableCollection(arrayList);
    }
}
