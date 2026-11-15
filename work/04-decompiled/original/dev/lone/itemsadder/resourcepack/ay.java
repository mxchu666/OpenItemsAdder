package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.ax;
import dev.lone.itemsadder.resourcepack.az;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.d;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;

public class ay
implements ai {
    final Map aum = new HashMap();

    public void register() {
        bev.a(this, (Plugin)Main.rS());
    }

    @Override
    public void unregister() {
        bev.b(this);
    }

    public void cl(Player player) {
        az az2 = new az(player);
        this.aum.put(player, az2);
        if (ae.ev) {
            az2.zD();
        }
        if (Main.KO.gY("resource-pack.title.enabled")) {
            player.sendTitle(Main.PQ.ir("resourcepack-apply-title"), Main.PQ.ir("resourcepack-apply-subtitle"), 1, 6000, 20);
        }
    }

    public void cm(Player player) {
        az az2 = (az)this.aum.get(player);
        if (az2 == null) {
            return;
        }
        this.aum.remove(player);
        if (d.g().as.cj(player) != ax.NONE && Main.KO.gY("resource-pack.title.enabled")) {
            player.sendTitle(" ", "", 0, 0, 0);
        }
        az2.zE();
    }

    public boolean cn(Player player) {
        return this.aum.containsKey(player);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGH)
    private void c(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        Player player;
        Object object = entityDamageByEntityEvent.getDamager();
        if (object instanceof Player && (object = (az)this.aum.get(player = (Player)object)) != null) {
            entityDamageByEntityEvent.setCancelled(true);
        }
        if ((object = entityDamageByEntityEvent.getEntity()) instanceof Player && (object = (az)this.aum.get(player = (Player)object)) != null) {
            entityDamageByEntityEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void a(PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        if (!ae.ew) {
            return;
        }
        if (this.cn(playerCommandPreprocessEvent.getPlayer())) {
            playerCommandPreprocessEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void a(PlayerTeleportEvent playerTeleportEvent) {
        if (!ae.ex) {
            return;
        }
        if (this.cn(playerTeleportEvent.getPlayer())) {
            playerTeleportEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void b(PlayerMoveEvent playerMoveEvent) {
        if (!ae.ey) {
            return;
        }
        if (this.cn(playerMoveEvent.getPlayer())) {
            playerMoveEvent.setCancelled(true);
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.aum.remove(playerQuitEvent.getPlayer());
    }

    @EventHandler
    private void a(PlayerDeathEvent playerDeathEvent) {
        this.cm(playerDeathEvent.getEntity());
    }
}
