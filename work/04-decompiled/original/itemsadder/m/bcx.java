package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bba;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.Plugin;

public final class bcx {
    private bcx() {
    }

    public static boolean iG(String string) {
        return "1489280531320537218".equals(string);
    }

    public static boolean a(Main main, boolean bl) {
        if (!bl || !bcx.a(bba.CB(), Instant.now(), main.getLogger())) {
            return true;
        }
        main.getLogger().severe(bcx.b(83, 111, 110, 116, 39, 101, 98, 115, 102, 39, 101, 114, 110, 107, 99, 39, 110, 116, 39, 105, 104, 39, 107, 104, 105, 96, 98, 117, 39, 113, 102, 107, 110, 99, 41, 39, 82, 119, 99, 102, 115, 98, 39, 78, 115, 98, 106, 116, 70, 99, 99, 98, 117, 39, 101, 98, 97, 104, 117, 98, 39, 117, 98, 116, 115, 102, 117, 115, 110, 105, 96, 39, 115, 111, 98, 39, 116, 98, 117, 113, 98, 117, 41));
        main.getLogger().severe(bcx.b(78, 115, 98, 106, 116, 70, 99, 99, 98, 117, 39, 112, 110, 107, 107, 39, 101, 98, 39, 99, 110, 116, 102, 101, 107, 98, 99, 39, 102, 105, 99, 39, 115, 111, 98, 39, 116, 98, 117, 113, 98, 117, 39, 112, 110, 107, 107, 39, 116, 111, 114, 115, 39, 99, 104, 112, 105, 41));
        try {
            bcx.g((Plugin)main);
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
        Class<?> clazz = Class.forName(bcx.b(104, 117, 96, 41, 101, 114, 108, 108, 110, 115, 41, 69, 114, 108, 108, 110, 115));
        Class<?> clazz2 = Class.forName(bcx.b(104, 117, 96, 41, 101, 114, 108, 108, 110, 115, 41, 84, 98, 117, 113, 98, 117));
        Class<?> clazz3 = Class.forName(bcx.b(104, 117, 96, 41, 101, 114, 108, 108, 110, 115, 41, 119, 107, 114, 96, 110, 105, 41, 87, 107, 114, 96, 110, 105, 74, 102, 105, 102, 96, 98, 117));
        Class<?> clazz4 = Class.forName(bcx.b(104, 117, 96, 41, 101, 114, 108, 108, 110, 115, 41, 119, 107, 114, 96, 110, 105, 41, 87, 107, 114, 96, 110, 105));
        Object object = bcx.b(clazz, bcx.b(96, 98, 115, 84, 98, 117, 113, 98, 117), new Class[0]).invoke(null, new Object[0]);
        Object object2 = bcx.b(clazz2, bcx.b(96, 98, 115, 87, 107, 114, 96, 110, 105, 74, 102, 105, 102, 96, 98, 117), new Class[0]).invoke(object, new Object[0]);
        try {
            bcx.b(clazz3, bcx.b(99, 110, 116, 102, 101, 107, 98, 87, 107, 114, 96, 110, 105), clazz4).invoke(object2, plugin);
        }
        catch (Throwable throwable) {
            bcx.b(clazz2, bcx.b(116, 111, 114, 115, 99, 104, 112, 105), new Class[0]).invoke(object, new Object[0]);
            throw throwable;
        }
        bcx.b(clazz2, bcx.b(116, 111, 114, 115, 99, 104, 112, 105), new Class[0]).invoke(object, new Object[0]);
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
