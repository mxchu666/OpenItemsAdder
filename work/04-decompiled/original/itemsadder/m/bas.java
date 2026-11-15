package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bat;
import itemsadder.m.bce;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class bas {
    public long azl;
    public int pU;
    boolean azm;

    public static bas a(WeakHashMap weakHashMap, Player player) {
        return weakHashMap.computeIfAbsent(player.getUniqueId(), uUID -> new bas());
    }

    public static void a(WeakHashMap weakHashMap) {
        Bukkit.getPluginManager().registerEvents((Listener)new bat(weakHashMap), (Plugin)Main.rS());
    }

    public boolean g(@Nullable Runnable runnable) {
        boolean bl;
        bce.iA("limited: " + this.azm);
        bce.iA("Count: " + this.pU);
        bce.iA("time: " + (System.currentTimeMillis() - this.azl));
        if (this.azm) {
            if (System.currentTimeMillis() - this.azl > 20000L) {
                this.azl = System.currentTimeMillis();
                this.pU = 0;
                this.azm = false;
            }
            return true;
        }
        if (System.currentTimeMillis() - this.azl > 5000L) {
            this.azl = System.currentTimeMillis();
            this.pU = 0;
            this.azm = false;
        }
        ++this.pU;
        boolean bl2 = bl = this.pU >= 20;
        if (bl && !this.azm) {
            this.azm = true;
            if (runnable != null) {
                runnable.run();
            }
        }
        return bl;
    }
}
