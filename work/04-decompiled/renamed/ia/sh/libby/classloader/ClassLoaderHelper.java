package ia.sh.libby.classloader;

import ia.sh.libby.Library;
import ia.sh.libby.LibraryManager;
import ia.sh.libby.Util;
import ia.sh.libby.classloader.IsolatedClassLoader;
import ia.sh.libby.logging.Logger;
import java.lang.instrument.Instrumentation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

public abstract class ClassLoaderHelper {
    public static final String SYSTEM_PROPERTY_DISABLE_UNSAFE = "libby.classloaders.unsafeDisabled";
    public static final String SYSTEM_PROPERTY_DISABLE_JAVA_AGENT = "libby.classloaders.javaAgentDisabled";
    public static final String ENV_VAR_DISABLE_UNSAFE = "LIBBY_CLASSLOADERS_UNSAFE_DISABLED";
    public static final String ENV_VAR_DISABLE_JAVA_AGENT = "LIBBY_CLASSLOADERS_JAVA_AGENT_DISABLED";
    private static final String BYTE_BUDDY_AGENT_CLASS = Util.replaceWithDots("net{}bytebuddy{}agent{}ByteBuddyAgent");
    private static final Method getModuleMethod;
    private static final Method addOpensMethod;
    private static final Method getNameMethod;
    private static final Unsafe theUnsafe;
    private static volatile Instrumentation cachedInstrumentation;
    protected final ClassLoader classLoader;

    public ClassLoaderHelper(ClassLoader classLoader) {
        this.classLoader = Objects.requireNonNull(classLoader, "classLoader");
    }

    public abstract void addToClasspath(@NotNull URL var1);

    public void addToClasspath(@NotNull Path path) {
        try {
            this.addToClasspath(Objects.requireNonNull(path, "path").toUri().toURL());
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException(malformedURLException);
        }
    }

    protected void setMethodAccessible(LibraryManager libraryManager, Method method, String string, Consumer<MethodHandle> consumer, Consumer<Instrumentation> consumer2) {
        if (Modifier.isPublic(method.getModifiers())) {
            return;
        }
        try {
            ClassLoaderHelper.openModule(method.getDeclaringClass());
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            method.setAccessible(true);
            return;
        }
        catch (Exception exception) {
            Object object;
            Exception exception2;
            Exception exception3;
            block20: {
                block19: {
                    this.handleInaccessibleObjectException(exception, string);
                    exception3 = null;
                    if (theUnsafe != null && this.canUseUnsafe()) {
                        MethodHandle methodHandle;
                        try {
                            methodHandle = this.getPrivilegedMethodHandle(method).bindTo(this.classLoader);
                        }
                        catch (Exception exception4) {
                            exception3 = exception4;
                            break block19;
                        }
                        consumer.accept(methodHandle);
                        return;
                    }
                }
                exception2 = null;
                if (this.canUseJavaAgent()) {
                    try {
                        object = this.initInstrumentation(libraryManager);
                    }
                    catch (Exception exception5) {
                        exception2 = exception5;
                        break block20;
                    }
                    try {
                        consumer2.accept((Instrumentation)object);
                        return;
                    }
                    catch (Exception exception6) {
                        this.handleInaccessibleObjectException(exception6, string);
                    }
                }
            }
            object = libraryManager.getLogger();
            if (exception3 != null) {
                ((Logger)object).error("Cannot set accessible " + string + " using unsafe", exception3);
            }
            if (exception2 != null) {
                ((Logger)object).error("Cannot set accessible " + string + " using java agent", exception2);
            }
            String string2 = method.getDeclaringClass().getPackage().getName();
            String string3 = null;
            try {
                string3 = (String)getNameMethod.invoke(getModuleMethod.invoke(method.getDeclaringClass(), new Object[0]), new Object[0]);
            }
            catch (Exception exception7) {
                // empty catch block
            }
            if (string3 != null) {
                ((Logger)object).error("Cannot set accessible " + string + ", if you are using Java 9+ try to add the following option to your java command: --add-opens " + string3 + "/" + string2 + "=ALL-UNNAMED");
            } else {
                ((Logger)object).error("Cannot set accessible " + string);
            }
            throw new RuntimeException("Cannot set accessible " + string);
        }
    }

    private void handleInaccessibleObjectException(Exception exception, String string) {
        if (!exception.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            throw new RuntimeException("Cannot set accessible " + string, exception);
        }
    }

    protected static void openModule(Class<?> clazz) {
        Object object = getModuleMethod.invoke(clazz, new Object[0]);
        Object object2 = getModuleMethod.invoke(ClassLoaderHelper.class, new Object[0]);
        addOpensMethod.invoke(object, clazz.getPackage().getName(), object2);
    }

    protected MethodHandle getPrivilegedMethodHandle(Method method) {
        for (Field field : MethodHandles.Lookup.class.getDeclaredFields()) {
            if (field.getType() != MethodHandles.Lookup.class || !Modifier.isStatic(field.getModifiers()) || field.isSynthetic()) continue;
            try {
                MethodHandles.Lookup lookup = (MethodHandles.Lookup)theUnsafe.getObject(theUnsafe.staticFieldBase(field), theUnsafe.staticFieldOffset(field));
                return lookup.unreflect(method);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        throw new RuntimeException("Cannot get privileged method handle.");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected Instrumentation initInstrumentation(LibraryManager libraryManager) {
        Instrumentation instrumentation = cachedInstrumentation;
        if (instrumentation != null) {
            return instrumentation;
        }
        IsolatedClassLoader isolatedClassLoader = new IsolatedClassLoader(new URL[0]);
        try {
            Instrumentation instrumentation2;
            isolatedClassLoader.addPath(libraryManager.downloadLibrary(Library.builder().groupId("net{}bytebuddy").artifactId("byte-buddy-agent").version("1.12.1").checksumFromBase64("mcCtBT9cljUEniB5ESpPDYZMfVxEs1JRPllOiWTP+bM=").fallbackRepository("https://repo1.maven.org/maven2/").build()));
            Class<?> clazz = isolatedClassLoader.loadClass(BYTE_BUDDY_AGENT_CLASS);
            cachedInstrumentation = instrumentation2 = (Instrumentation)clazz.getMethod("install", new Class[0]).invoke(null, new Object[0]);
            Instrumentation instrumentation3 = instrumentation2;
            return instrumentation3;
        }
        finally {
            try {
                isolatedClassLoader.close();
            }
            catch (Exception exception) {}
        }
    }

    protected boolean canUseUnsafe() {
        return !Boolean.parseBoolean(System.getProperty(SYSTEM_PROPERTY_DISABLE_UNSAFE)) && !Boolean.parseBoolean(System.getenv(ENV_VAR_DISABLE_UNSAFE));
    }

    protected boolean canUseJavaAgent() {
        return !Boolean.parseBoolean(System.getProperty(SYSTEM_PROPERTY_DISABLE_JAVA_AGENT)) && !Boolean.parseBoolean(System.getenv(ENV_VAR_DISABLE_JAVA_AGENT));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static {
        Object object = null;
        Object object2 = null;
        Method method = null;
        try {
            Class<?> clazz = Class.forName("java.lang.Module");
            object = Class.class.getMethod("getModule", new Class[0]);
            Method method2 = clazz.getMethod("addOpens", String.class, clazz);
            method = clazz.getMethod("getName", new Class[0]);
            getModuleMethod = object;
            addOpensMethod = method2;
            getNameMethod = method;
        }
        catch (Exception exception) {
            getModuleMethod = object;
            addOpensMethod = object2;
            getNameMethod = method;
        }
        catch (Throwable throwable) {
            getModuleMethod = object;
            addOpensMethod = object2;
            getNameMethod = method;
            throw throwable;
        }
        object = null;
        for (Field field : Unsafe.class.getDeclaredFields()) {
            try {
                if (field.getType() != Unsafe.class || !Modifier.isStatic(field.getModifiers())) continue;
                field.setAccessible(true);
                object = (Unsafe)field.get(null);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        theUnsafe = object;
    }
}
