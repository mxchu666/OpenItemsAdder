package itemsadder.m;

import itemsadder.m.bcp;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public final class bbr {
    private static final Object aAi = new Object();
    private static final Object aAj = new Object();
    private static Object aAk;
    private static Method aAl;
    private static Method aAm;
    private static BossBar zS;
    private static volatile boolean vG;
    private static String yT;
    private static double aAn;
    private static long aAo;

    private bbr() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean tc() {
        Object object = aAi;
        synchronized (object) {
            return vG && aAk != null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void CY() {
        long l;
        Object object = aAi;
        synchronized (object) {
            vG = true;
            l = ++aAo;
        }
        bbr.b("> ", l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void CZ() {
        Object object = aAi;
        synchronized (object) {
            vG = false;
            ++aAo;
        }
    }

    public static void in(String string) {
        bbr.c(string, 1.0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void c(String string, double d) {
        long l;
        Object object = aAi;
        synchronized (object) {
            yT = string;
            aAn = d;
            l = ++aAo;
        }
        if (vG) {
            bbr.b(string + "\n> ", l);
        }
        bbr.d(string, d);
    }

    public static void bf(String string) {
        bbr.c(string, aAn);
    }

    public static void s(double d) {
        bbr.c(yT, d);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String getTitle() {
        Object object = aAi;
        synchronized (object) {
            return yT;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io(String string) {
        Object object = aAi;
        synchronized (object) {
            if (yT.equals(string)) {
                bbr.clear();
            }
        }
    }

    private static void d(String string, double d) {
        bcp.i(() -> {
            if (zS == null) {
                zS = Bukkit.createBossBar((String)" ", (BarColor)BarColor.WHITE, (BarStyle)BarStyle.SEGMENTED_20, (BarFlag[])new BarFlag[0]);
            }
            zS.setVisible(true);
            zS.setTitle(string);
            zS.setProgress(Math.max(0.0, Math.min(1.0, d)));
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!player.isOp() && !player.hasPermission("ia.admin.iazip")) continue;
                zS.addPlayer(player);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void clear() {
        boolean bl;
        long l;
        Object object = aAi;
        synchronized (object) {
            yT = " ";
            aAn = 1.0;
            l = ++aAo;
            bl = vG;
        }
        if (bl) {
            bbr.b("> ", l);
        }
        if (Bukkit.isPrimaryThread()) {
            bbr.Da();
        } else if (bl) {
            bcp.i(bbr::Da);
        }
    }

    private static void Da() {
        if (zS != null) {
            zS.setVisible(false);
            zS.removeAll();
        }
    }

    private static void b(String string, long l) {
        bcp.h(() -> {
            Object object = aAj;
            synchronized (object) {
                Method method;
                Method method2;
                Object object2;
                Object object3 = aAi;
                synchronized (object3) {
                    if (!vG || l != aAo) {
                        return;
                    }
                    object2 = aAk;
                    method2 = aAl;
                    method = aAm;
                }
                if (object2 == null) {
                    if (!bbr.Db()) {
                        return;
                    }
                    object3 = aAi;
                    synchronized (object3) {
                        if (!vG || l != aAo) {
                            return;
                        }
                        object2 = aAk;
                        method2 = aAl;
                        method = aAm;
                    }
                }
                bbr.a(object2, method2, method, string);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean Db() {
        Class<?> clazz = aAi;
        synchronized (clazz) {
            if (aAk != null) {
                return true;
            }
        }
        try {
            clazz = Class.forName("net.minecrell.terminalconsole.TerminalConsoleAppender");
            Object object = clazz.getMethod("getReader", new Class[0]).invoke(null, new Object[0]);
            if (object == null) {
                return false;
            }
            Method method = object.getClass().getMethod("setPrompt", String.class);
            Method method2 = object.getClass().getMethod("redisplay", new Class[0]);
            Object object2 = aAi;
            synchronized (object2) {
                aAk = object;
                aAl = method;
                aAm = method2;
            }
            return true;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            aAk = null;
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void a(Object object, Method method, Method method2, String string) {
        try {
            method.invoke(object, string);
            method2.invoke(object, new Object[0]);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            Object object2 = aAi;
            synchronized (object2) {
                if (aAk == object) {
                    aAk = null;
                }
            }
        }
    }

    static {
        vG = true;
        yT = " ";
        aAn = 1.0;
    }
}
