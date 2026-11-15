package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.Opaque012;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.Plugin;

public final class MainHelper {
    private MainHelper() {
    }

    public static boolean iG(String string) {
        return "1489280531320537218".equals(string);
    }

    public static boolean a(Main main, boolean bl) {
        if (!bl || !MainHelper.a(Opaque012.CB(), Instant.now(), main.getLogger())) {
            return true;
        }
        main.getLogger().severe("This beta build is no longer valid. Update ItemsAdder before restarting the server.");
        main.getLogger().severe("ItemsAdder will be disabled and the server will shut down.");
        try {
            MainHelper.g((Plugin)main);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }

    static boolean a(long l, Instant instant, Logger logger) {
        try {
            Instant instant2 = Instant.ofEpochSecond(l);
            long l2 = Duration.between(instant2, instant).toDays();
            if (l2 <= 30L) {
                return false;
            }
            logger.severe("Beta expiration details: buildTime=" + String.valueOf(instant2) + ", serverTime=" + String.valueOf(instant) + ", ageDays=" + l2);
            return true;
        }
        catch (Exception exception) {
            logger.log(Level.SEVERE, "Failed to check beta build expiration. ItemsAdder will continue loading.", exception);
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void g(Plugin plugin) {
        Class<?> clazz = Class.forName("org.bukkit.Bukkit");
        Class<?> clazz2 = Class.forName("org.bukkit.Server");
        Class<?> clazz3 = Class.forName("org.bukkit.plugin.PluginManager");
        Class<?> clazz4 = Class.forName("org.bukkit.plugin.Plugin");
        Object object = MainHelper.b(clazz, "getServer", new Class[0]).invoke(null, new Object[0]);
        Object object2 = MainHelper.b(clazz2, "getPluginManager", new Class[0]).invoke(object, new Object[0]);
        try {
            MainHelper.b(clazz3, "disablePlugin", clazz4).invoke(object2, plugin);
        }
        finally {
            MainHelper.b(clazz2, "shutdown", new Class[0]).invoke(object, new Object[0]);
        }
    }

    private static Method b(Class clazz, String string, Class ... classArray) {
        return clazz.getMethod(string, classArray);
    }

    private static String b(int ... nArray) {
        StringBuilder stringBuilder = new StringBuilder(nArray.length);
        for (int n : nArray) {
            stringBuilder.append((char)(n ^ 7));
        }
        return stringBuilder.toString();
    }
}
