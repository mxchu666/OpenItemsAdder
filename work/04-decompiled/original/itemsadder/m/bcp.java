package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bcq;
import itemsadder.m.bcr;
import itemsadder.m.bcs;
import itemsadder.m.bct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class bcp {
    private static final HashMap aAZ = new HashMap();
    private static final ExecutorService aBa = Executors.newCachedThreadPool();

    private static String Dm() {
        return Thread.currentThread().getStackTrace()[3].getClassName();
    }

    public static void r(Class clazz) {
        List list = (List)aAZ.get(clazz.getName());
        if (list != null) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                BukkitTask bukkitTask = (BukkitTask)listIterator.next();
                if (bukkitTask != null) {
                    bukkitTask.cancel();
                }
                listIterator.remove();
            }
        }
        aAZ.remove(clazz.getName());
    }

    public static void a(Consumer consumer, long l, long l2) {
        BukkitTask bukkitTask = new bcq(consumer).runTaskTimer((Plugin)Main.rS(), l, l2);
        aAZ.computeIfAbsent(bcp.Dm(), string -> new ArrayList()).add(bukkitTask);
    }

    public static void a(Runnable runnable, long l) {
        BukkitTask bukkitTask = Bukkit.getScheduler().runTaskTimer(Main.rT(), runnable, l, l);
        aAZ.computeIfAbsent(bcp.Dm(), string -> new ArrayList()).add(bukkitTask);
    }

    @NotNull
    public static BukkitScheduler Dn() {
        return Bukkit.getServer().getScheduler();
    }

    @NotNull
    public static BukkitTask h(Runnable runnable) {
        return Bukkit.getScheduler().runTaskAsynchronously(Main.rT(), runnable);
    }

    public static void b(Runnable runnable, long l) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.rT(), runnable, l);
    }

    @NotNull
    public static BukkitTask h(Consumer consumer) {
        BukkitTask bukkitTask = new bcr(consumer).runTaskAsynchronously((Plugin)Main.rS());
        aAZ.computeIfAbsent(bcp.Dm(), string -> new ArrayList()).add(bukkitTask);
        return bukkitTask;
    }

    public static BukkitTask b(Consumer consumer, long l, long l2) {
        BukkitTask bukkitTask = new bcs(consumer).runTaskTimerAsynchronously((Plugin)Main.rS(), l, l2);
        aAZ.computeIfAbsent(bcp.Dm(), string -> new ArrayList()).add(bukkitTask);
        return bukkitTask;
    }

    public static void i(Runnable runnable) {
        if (!Bukkit.isPrimaryThread()) {
            Bukkit.getScheduler().runTask(Main.rT(), runnable);
        } else {
            runnable.run();
        }
    }

    public static void c(Runnable runnable, long l) {
        Bukkit.getScheduler().runTaskLater(Main.rT(), runnable, l);
    }

    public static void a(Runnable runnable, long l, boolean bl) {
        if (bl) {
            Bukkit.getScheduler().runTaskLater(Main.rT(), runnable, l);
        } else {
            runnable.run();
        }
    }

    public static BukkitTask c(Consumer consumer, long l, long l2) {
        return new bct(consumer).runTaskTimer((Plugin)Main.rS(), l, l2);
    }

    public static void a(Runnable runnable, boolean bl) {
        if (bl) {
            aBa.submit(runnable);
        } else {
            runnable.run();
        }
    }

    public static void j(Runnable runnable) {
        aBa.submit(runnable);
    }

    public static void a(Runnable runnable, int n) {
        aBa.submit(() -> {
            try {
                Thread.sleep(n);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            runnable.run();
        });
    }

    public static void b(Runnable runnable, boolean bl) {
        bcp.a(runnable, bl, 0L);
    }

    public static void a(Runnable runnable, boolean bl, long l) {
        if (bl) {
            bcp.c(runnable, l);
        } else {
            runnable.run();
        }
    }

    public static void a(Callable callable, Runnable runnable, int n) {
        Bukkit.getScheduler().runTaskTimer(Main.rT(), bukkitTask -> {
            try {
                if (((Boolean)callable.call()).booleanValue()) {
                    runnable.run();
                    bukkitTask.cancel();
                }
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }, 0L, (long)n);
    }

    public static void b(Entity entity, Location location) {
        bcp.i(() -> entity.teleport(location));
    }
}
