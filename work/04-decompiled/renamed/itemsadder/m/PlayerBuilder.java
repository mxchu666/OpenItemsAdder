package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.PlayerQuitListener_2;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PlayerBuilder {
    public long azl;
    public int pU;
    boolean azm;

    public static PlayerBuilder a(WeakHashMap weakHashMap, Player player) {
        return weakHashMap.computeIfAbsent(player.getUniqueId(), uUID -> new PlayerBuilder());
    }

    public static void a(WeakHashMap weakHashMap) {
        Bukkit.getPluginManager().registerEvents((Listener)new PlayerQuitListener_2(weakHashMap), (Plugin)Main.rS());
    }

    public boolean g(@Nullable Runnable runnable) {
        boolean bl;
        CommandSenderBridge_5.iA("limited: " + this.azm);
        CommandSenderBridge_5.iA("Count: " + this.pU);
        CommandSenderBridge_5.iA("time: " + (System.currentTimeMillis() - this.azl));
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
