package ia.sh.libby.relocation;

import ia.sh.libby.Library;
import ia.sh.libby.LibraryManager;
import ia.sh.libby.Util;
import ia.sh.libby.classloader.IsolatedClassLoader;
import ia.sh.libby.relocation.Relocation;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class RelocationHelper {
    private static final String JAR_RELOCATOR_CLASS = Util.replaceWithDots("me{}lucko{}jarrelocator{}JarRelocator");
    private static final String RELOCATION_CLASS = Util.replaceWithDots("me{}lucko{}jarrelocator{}Relocation");
    private final Constructor<?> jarRelocatorConstructor;
    private final Method jarRelocatorRunMethod;
    private final Constructor<?> relocationConstructor;

    public RelocationHelper(@NotNull LibraryManager libraryManager) {
        Objects.requireNonNull(libraryManager, "libraryManager");
        IsolatedClassLoader isolatedClassLoader = new IsolatedClassLoader(new URL[0]);
        isolatedClassLoader.addPath(libraryManager.downloadLibrary(Library.builder().groupId("org{}ow2{}asm").artifactId("asm-commons").version("9.10.1").checksumFromBase64("bQq++3y/ly6hbts37BSDU3JQUGOkX5dqt+qIntlJeJU=").fallbackRepository("https://repo1.maven.org/maven2/").build()));
        isolatedClassLoader.addPath(libraryManager.downloadLibrary(Library.builder().groupId("org{}ow2{}asm").artifactId("asm").version("9.10.1").checksumFromBase64("7YJdEKsTmcjAy2aeaIzwyMgmKbTIOZtYNSto6SyhD8s=").fallbackRepository("https://repo1.maven.org/maven2/").build()));
        isolatedClassLoader.addPath(libraryManager.downloadLibrary(Library.builder().groupId("me{}lucko").artifactId("jar-relocator").version("1.7").checksumFromBase64("b30RhOF6kHiHl+O5suNLh/+eAr1iOFEFLXhwkHHDu4I=").fallbackRepository("https://repo1.maven.org/maven2/").build()));
        try {
            Class<?> clazz = isolatedClassLoader.loadClass(JAR_RELOCATOR_CLASS);
            Class<?> clazz2 = isolatedClassLoader.loadClass(RELOCATION_CLASS);
            this.jarRelocatorConstructor = clazz.getConstructor(File.class, File.class, Collection.class);
            this.jarRelocatorRunMethod = clazz.getMethod("run", new Class[0]);
            this.relocationConstructor = clazz2.getConstructor(String.class, String.class, Collection.class, Collection.class);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }

    public void relocate(@NotNull Path path, @NotNull Path path2, @NotNull Collection<Relocation> collection) {
        Objects.requireNonNull(path, "in");
        Objects.requireNonNull(path2, "out");
        Objects.requireNonNull(collection, "relocations");
        try {
            LinkedList linkedList = new LinkedList();
            for (Relocation relocation : collection) {
                linkedList.add(this.relocationConstructor.newInstance(relocation.getPattern(), relocation.getRelocatedPattern(), relocation.getIncludes(), relocation.getExcludes()));
            }
            this.jarRelocatorRunMethod.invoke(this.jarRelocatorConstructor.newInstance(path.toFile(), path2.toFile(), linkedList), new Object[0]);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }
}
