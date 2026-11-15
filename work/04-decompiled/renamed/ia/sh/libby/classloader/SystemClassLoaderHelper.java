package ia.sh.libby.classloader;

import ia.sh.libby.LibraryManager;
import ia.sh.libby.classloader.ClassLoaderHelper;
import java.lang.instrument.Instrumentation;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Objects;
import java.util.jar.JarFile;
import org.jetbrains.annotations.NotNull;

public class SystemClassLoaderHelper
extends ClassLoaderHelper {
    private MethodHandle appendMethodHandle = null;
    private Instrumentation appendInstrumentation = null;

    public SystemClassLoaderHelper(ClassLoader classLoader, @NotNull LibraryManager libraryManager) {
        super(classLoader);
        Objects.requireNonNull(libraryManager, "libraryManager");
        try {
            Method method = classLoader.getClass().getDeclaredMethod("appendToClassPathForInstrumentation", String.class);
            this.setMethodAccessible(libraryManager, method, classLoader.getClass().getName() + "#appendToClassPathForInstrumentation(String)", methodHandle -> {
                this.appendMethodHandle = methodHandle;
            }, instrumentation -> {
                this.appendInstrumentation = instrumentation;
            });
        }
        catch (Exception exception) {
            throw new RuntimeException("Couldn't initialize SystemClassLoaderHelper", exception);
        }
    }

    @Override
    public void addToClasspath(@NotNull URL uRL) {
        try {
            if (this.appendInstrumentation != null) {
                this.appendInstrumentation.appendToSystemClassLoaderSearch(new JarFile(uRL.toURI().getPath()));
            } else {
                this.appendMethodHandle.invokeWithArguments(uRL.toURI().getPath());
            }
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }
}
