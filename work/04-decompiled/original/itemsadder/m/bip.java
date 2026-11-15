package itemsadder.m;

import itemsadder.m.bio;
import itemsadder.m.biq;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public final class bip {
    private static final AtomicBoolean aEh = new AtomicBoolean(false);

    private bip() {
        throw new UnsupportedOperationException();
    }

    public static void register(Plugin plugin) {
        Objects.requireNonNull(plugin, "plugin");
        if (aEh.getAndSet(true)) {
            throw new IllegalStateException("FastInv is already registered");
        }
        Bukkit.getPluginManager().registerEvents((Listener)new biq(plugin), plugin);
    }

    public static void EX() {
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getOpenInventory().getTopInventory().getHolder() instanceof bio).forEach(HumanEntity::closeInventory);
    }

    static /* synthetic */ AtomicBoolean EY() {
        return aEh;
    }
}
