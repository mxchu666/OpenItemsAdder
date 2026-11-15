package itemsadder.m;

import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PlayerQuitListenerBase;
import itemsadder.m.PluginContract_19;
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

public class PlayerQuitListener_4
implements Listener {
    private final PlayerQuitListenerBase LU;

    public PlayerQuitListener_4(Plugin plugin, PlayerQuitListenerBase playerQuitListenerBase) {
        this.LU = playerQuitListenerBase;
        ItemStackRegistry.g().ar.a(new ClassRefData(PlayerPickupItemEvent.class, this::c));
        ItemStackRegistry.g().ar.a(new ClassRefData(InventoryClickEvent.class, this::f));
        ListenerBridge.a(this, plugin);
    }

    boolean a(Player player2, ItemStackBuilder_4 itemStackBuilder_4) {
        List list;
        if (this.LU.amp.containsKey(player2) && (list = (List)this.LU.amp.get(player2)) != null && list.contains(itemStackBuilder_4)) {
            return true;
        }
        this.LU.amp.computeIfAbsent(player2, player -> new ArrayList()).add(itemStackBuilder_4);
        return false;
    }

    @PluginContract_19
    private void c(PlayerPickupItemEvent playerPickupItemEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Player player = playerPickupItemEvent.getPlayer();
        if (this.a(player, itemStackBuilder_4)) {
            return;
        }
        PlayerHolder_5.a(player, ItemStackRegistry.g().aW.u(itemStackBuilder_4));
        PlayerHolder_5.a(player, ItemStackRegistry.g().aW.v(itemStackBuilder_4));
    }

    @PluginContract_19
    private void f(InventoryClickEvent inventoryClickEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (inventoryClickEvent.isCancelled()) {
            return;
        }
        HumanEntity humanEntity = inventoryClickEvent.getWhoClicked();
        if (!(humanEntity instanceof Player)) {
            return;
        }
        Player player = (Player)humanEntity;
        if (this.a(player, itemStackBuilder_4)) {
            return;
        }
        PlayerHolder_5.a(player, ItemStackRegistry.g().aW.u(itemStackBuilder_4));
        PlayerHolder_5.a(player, ItemStackRegistry.g().aW.v(itemStackBuilder_4));
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        this.LU.amp.remove(playerQuitEvent.getPlayer());
    }
}
