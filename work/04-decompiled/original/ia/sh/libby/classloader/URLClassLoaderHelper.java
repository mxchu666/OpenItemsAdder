package ia.sh.libby.classloader;

import ia.sh.libby.LibraryManager;
import ia.sh.libby.classloader.ClassLoaderHelper;
import java.lang.instrument.Instrumentation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class URLClassLoaderHelper
extends ClassLoaderHelper {
    private MethodHandle addURLMethodHandle = null;

    public URLClassLoaderHelper(@NotNull URLClassLoader uRLClassLoader, @NotNull LibraryManager libraryManager) {
        super(uRLClassLoader);
        Objects.requireNonNull(libraryManager, "libraryManager");
        try {
            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            this.setMethodAccessible(libraryManager, method, "URLClassLoader#addURL(URL)", methodHandle -> {
                this.addURLMethodHandle = methodHandle;
            }, instrumentation -> {
                this.addOpensWithAgent((Instrumentation)instrumentation);
                method.setAccessible(true);
            });
            if (this.addURLMethodHandle == null) {
                this.addURLMethodHandle = MethodHandles.lookup().unreflect(method).bindTo(uRLClassLoader);
            }
        }
        catch (Exception exception) {
            throw new RuntimeException("Couldn't initialize URLClassLoaderHelper", exception);
        }
    }

    @Override
    public void addToClasspath(@NotNull URL uRL) {
        try {
            this.addURLMethodHandle.invokeWithArguments(Objects.requireNonNull(uRL, "url"));
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private void addOpensWithAgent(@NotNull Instrumentation instrumentation) {
        try {
            Method method = Instrumentation.class.getMethod("redefineModule", Class.forName("java.lang.Module"), Set.class, Map.class, Map.class, Set.class, Map.class);
            Method method2 = Class.class.getMethod("getModule", new Class[0]);
            Map<String, Set<Object>> map = Collections.singletonMap("java.net", Collections.singleton(method2.invoke(this.getClass(), new Object[0])));
            method.invoke((Object)instrumentation, method2.invoke(URLClassLoader.class, new Object[0]), Collections.emptySet(), Collections.emptyMap(), map, Collections.emptySet(), Collections.emptyMap());
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
