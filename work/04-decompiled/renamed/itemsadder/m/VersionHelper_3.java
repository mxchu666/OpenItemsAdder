package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import itemsadder.m.PublicEnum;
import itemsadder.m.ServerJarEnum;
import itemsadder.m.VersionHelper;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class VersionHelper_3 {
    public static boolean UO = false;
    public static final String UP = "net.minecraft.world.entity.";
    public static boolean UQ;
    @Nullable
    private static Boolean UR;
    @Nullable
    private static Boolean US;

    public static boolean sV() {
        if (US != null) {
            return US;
        }
        US = !VersionHelper_3.ds("dev.lone.itemsadder.Core.Core");
        return US;
    }

    public static boolean sW() {
        return !VersionHelper_3.sV();
    }

    public static void init() {
        VersionHelper.init();
    }

    public static int sX() {
        return VersionHelper_3.k(Version.get());
    }

    public static int k(Version version) {
        return version.getPackVersion();
    }

    public static int sY() {
        return 250;
    }

    @Nullable
    public static Class dr(String string) {
        try {
            return Class.forName(string);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static MethodHandle a(Class clazz, Class ... classArray) {
        try {
            MethodType methodType = MethodType.methodType(Void.TYPE, classArray);
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            return MethodHandles.privateLookupIn(clazz, lookup).findConstructor(clazz, methodType);
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to find constructor.", throwable);
        }
    }

    public static boolean a(Class clazz, Class clazz2, Object object, Object object2) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType() != clazz2) continue;
            field.setAccessible(true);
            field.set(object, object2);
            return true;
        }
        return false;
    }

    @Nullable
    public static Field a(Class clazz, Class clazz2) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getType() != clazz2) continue;
            field.setAccessible(true);
            return field;
        }
        return null;
    }

    @Nullable
    public static Field b(Class clazz, String string) {
        Field field;
        try {
            field = clazz.getDeclaredField(string);
            field.setAccessible(true);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return null;
        }
        return field;
    }

    @Nullable
    public static Field c(Class clazz, String string) {
        Field field = clazz.getDeclaredField(string);
        field.setAccessible(true);
        return field;
    }

    @Nullable
    public static Object a(Class clazz, Class clazz2, int n) {
        return VersionHelper_3.a(clazz, clazz2, null, n);
    }

    @Nullable
    public static Object a(Class clazz, Class clazz2, Object object, int n) {
        Field field = VersionHelper_3.b(clazz, clazz2, n);
        if (field == null) {
            return null;
        }
        return VersionHelper_3.a(field, object);
    }

    @Nullable
    public static Field b(Class clazz, Class clazz2, int n) {
        Field[] fieldArray = clazz.getDeclaredFields();
        int n2 = 0;
        for (Field field : fieldArray) {
            if (field.getType() != clazz2) continue;
            if (n2 == n) {
                field.setAccessible(true);
                return field;
            }
            ++n2;
        }
        return null;
    }

    @Nullable
    public static Field a(Class clazz, int n) {
        Field[] fieldArray = clazz.getDeclaredFields();
        if (n > fieldArray.length - 1) {
            return null;
        }
        fieldArray[n].setAccessible(true);
        return fieldArray[n];
    }

    @Nullable
    public static Method c(Class clazz, Class clazz2, int n) {
        Method[] methodArray = clazz.getDeclaredMethods();
        int n2 = 0;
        for (Method method : methodArray) {
            if (method.getReturnType() != clazz2) continue;
            if (n2 == n) {
                method.setAccessible(true);
                return method;
            }
            ++n2;
        }
        return null;
    }

    public static Object a(Class clazz, String string, Object object) {
        Field field = VersionHelper_3.c(clazz, string);
        try {
            return field.get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Failed to read field " + field.getName(), illegalAccessException);
        }
    }

    public static Object a(Field field, Object object) {
        try {
            return field.get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Failed to read field " + field.getName(), illegalAccessException);
        }
    }

    public static void a(Field field, Object object, Object object2) {
        try {
            field.setAccessible(true);
            field.set(object, object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException("Failed to write field " + field.getName(), illegalAccessException);
        }
    }

    public static boolean f(Plugin plugin) {
        StackTraceElement[] stackTraceElementArray;
        for (StackTraceElement stackTraceElement : stackTraceElementArray = Thread.currentThread().getStackTrace()) {
            if (!stackTraceElement.getClassName().equals(plugin.getClass().getName()) || !stackTraceElement.getMethodName().equals("onLoad") && !stackTraceElement.getMethodName().equals("onEnable")) continue;
            return true;
        }
        return false;
    }

    public static boolean ds(String string) {
        try {
            Class.forName(string);
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static boolean sZ() {
        if (UR != null) {
            return UR;
        }
        String string = Bukkit.getServer().getName();
        if (string.contains("Paper") || string.contains("Purpur")) {
            UR = true;
            return UR;
        }
        UR = VersionHelper_3.ds("com.destroystokyo.paper.event.player.PlayerSetSpawnEvent$Cause") || VersionHelper_3.ds("com.destroystokyo.paper.utils.PaperPluginLogger") || VersionHelper_3.ds("io.papermc.paper.ServerBuildInfo") || VersionHelper_3.ds("io.papermc.paper.text.PaperComponents");
        return UR;
    }

    public static boolean dt(String string) {
        try {
            Class<?> clazz = Class.forName(string);
            return Modifier.isAbstract(clazz.getModifiers());
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static ServerJarEnum du(String string) {
        try {
            return Class.forName(string).getClassLoader().equals(Bukkit.class.getClassLoader()) ? ServerJarEnum.SERVER_JAR : ServerJarEnum.ANOTHER_JAR;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return ServerJarEnum.NOT_FOUND;
        }
    }

    public static Method a(Class clazz, String string, Class ... classArray) {
        try {
            Method method = clazz.getDeclaredMethod(string, classArray);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Method a(Class clazz, Class clazz2, PublicEnum publicEnum, Class ... classArray) {
        Method[] methodArray = clazz2.getDeclaredMethods();
        int n = methodArray.length;
        int n2 = 0;
        while (true) {
            block11: {
                Class<?>[] classArray2;
                if (n2 >= n) {
                    return null;
                }
                Method method = methodArray[n2];
                switch (publicEnum.ordinal()) {
                    case 0: {
                        if (Modifier.isPublic(method.getModifiers())) break;
                        break block11;
                    }
                    case 1: {
                        if (Modifier.isProtected(method.getModifiers())) break;
                        break block11;
                    }
                    case 2: {
                        if (Modifier.isPrivate(method.getModifiers())) break;
                        break block11;
                    }
                    case 3: {
                        if (Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers()) || Modifier.isPrivate(method.getModifiers())) break block11;
                    }
                }
                if (method.getReturnType() == clazz && (classArray2 = method.getParameterTypes()).length == classArray.length) {
                    boolean bl = true;
                    for (int i = 0; i < classArray2.length; ++i) {
                        if (classArray2[i] == classArray[i]) continue;
                        bl = false;
                        break;
                    }
                    if (bl) {
                        method.setAccessible(true);
                        return method;
                    }
                }
            }
            ++n2;
        }
    }

    static {
        UR = null;
        US = null;
    }
}
