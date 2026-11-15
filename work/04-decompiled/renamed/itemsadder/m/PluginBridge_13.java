package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBridge_7;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PluginBridge_13
implements PluginContract {
    private final ItemStackRegistry zs;

    public PluginBridge_13(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.zs = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(PlayerInteractEvent.class, this::e));
    }

    @PluginContract_19
    private void e(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        String string;
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return;
        }
        if (!itemStackBuilder_4.Ge.bm("liquid_analyzer")) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        Block block = playerInteractEvent.getClickedBlock() != null ? playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace()) : PlayerHolder_4.bZ(playerInteractEvent.getPlayer());
        if (BlockBridge_7.c(block.getType())) {
            Levelled levelled = (Levelled)block.getBlockData();
            BlockBridge_9 blockBridge_9 = this.zs.a(block.getChunk());
            if (!blockBridge_9.T(block)) {
                if (levelled.getLevel() > 0 && levelled.getLevel() < levelled.getMaximumLevel()) {
                    playerInteractEvent.getPlayer().sendMessage(Main.PQ.ir("liquid-analyzer-low-level"));
                    return;
                }
                string = block.getType().toString();
            } else {
                string = blockBridge_9.ab(block);
            }
            if (string == null) {
                return;
            }
        } else {
            playerInteractEvent.getPlayer().sendMessage(Main.PQ.ir("liquid-analyzer-no-liquid"));
            return;
        }
        playerInteractEvent.getPlayer().sendMessage(string);
        if (playerInteractEvent.getPlayer().getGameMode() != GameMode.CREATIVE) {
            ItemStackBridge_2.aj(playerInteractEvent.getItem());
        }
    }
}
