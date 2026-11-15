package itemsadder.m;

import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_6;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PluginBridge_14
implements PluginContract {
    private final Plugin zE;
    private final ItemStackRegistry zF;

    public PluginBridge_14(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zE = plugin;
        this.zF = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::f));
        itemStackRegistry.ar.a(new ClassRefData(BlockPlaceEvent.class, this::b));
    }

    @PluginContract_19
    private void f(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (playerInteractEvent.isCancelled()) {
            return;
        }
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return;
        }
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("sapling")) {
            return;
        }
        ItemStackBridge_6 itemStackBridge_6 = (ItemStackBridge_6)itemStackBuilder_4.Ge.bn("sapling");
        playerInteractEvent.setCancelled(true);
        itemStackBridge_6.a(itemStack, playerInteractEvent.getPlayer(), playerInteractEvent.getClickedBlock().getRelative(BlockFace.UP));
    }

    @PluginContract_19
    private void b(BlockPlaceEvent blockPlaceEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (blockPlaceEvent.isCancelled()) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("sapling")) {
            return;
        }
        ItemStackBridge_6 itemStackBridge_6 = (ItemStackBridge_6)itemStackBuilder_4.Ge.bn("sapling");
        blockPlaceEvent.setCancelled(true);
        itemStackBridge_6.a(itemStack, blockPlaceEvent.getPlayer(), blockPlaceEvent.getBlockPlaced().getLocation().getBlock());
    }
}
