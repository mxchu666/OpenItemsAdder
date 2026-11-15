package itemsadder.m;

import itemsadder.m.asf;
import itemsadder.m.asg;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class uu
implements Listener {
    private final asf LU;

    public uu(Plugin plugin, asf asf2) {
        this.LU = asf2;
        d.g().ar.a(new my(PlayerPickupItemEvent.class, this::c));
        d.g().ar.a(new my(InventoryClickEvent.class, this::f));
        bev.a(this, plugin);
    }

    boolean a(Player player2, qm qm2) {
        List list;
        if (this.LU.amp.containsKey(player2) && (list = (List)this.LU.amp.get(player2)) != null && list.contains(qm2)) {
            return true;
        }
        this.LU.amp.computeIfAbsent(player2, player -> new ArrayList()).add(qm2);
        return false;
    }

    @mz
    private void c(PlayerPickupItemEvent playerPickupItemEvent, qm qm2, ItemStack itemStack) {
        Player player = playerPickupItemEvent.getPlayer();
        if (this.a(player, qm2)) {
            return;
        }
        asg.a(player, d.g().aW.u(qm2));
        asg.a(player, d.g().aW.v(qm2));
    }

    @mz
    private void f(InventoryClickEvent inventoryClickEvent, qm qm2, ItemStack itemStack) {
        if (inventoryClickEvent.isCancelled()) {
            return;
        }
        HumanEntity humanEntity = inventoryClickEvent.getWhoClicked();
        if (!(humanEntity instanceof Player)) {
            return;
        }
        Player player = (Player)humanEntity;
        if (this.a(player, qm2)) {
            return;
        }
        asg.a(player, d.g().aW.u(qm2));
        asg.a(player, d.g().aW.v(qm2));
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.LU.amp.remove(playerQuitEvent.getPlayer());
    }
}
