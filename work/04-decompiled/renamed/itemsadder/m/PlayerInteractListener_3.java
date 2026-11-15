package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.InventoryMoveItemListener;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationBridge_3;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginContract;
import itemsadder.m.StringData_7;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Jukebox;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PlayerInteractListener_3
implements PluginContract {
    private final ConcurrentHashMap zu = new ConcurrentHashMap();
    InventoryMoveItemListener zv;

    public PlayerInteractListener_3(Plugin plugin) {
        ListenerBridge.a(this, plugin);
        this.zv = new InventoryMoveItemListener(this);
        ListenerBridge.a(this.zv, plugin);
        BukkitTaskBridge.b(bukkitRunnable -> {
            for (Block block : this.zu.keySet()) {
                if (LocationBridge_2.br(block)) {
                    block.getWorld().spawnParticle(Particle.NOTE, LocationBridge_2.bp(block), 1);
                    if (block.getType() == Material.JUKEBOX) continue;
                    BukkitTaskBridge.i(() -> this.p(block));
                    continue;
                }
                this.zu.remove(block);
            }
        }, 20L, 20L);
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        PluginContract.a(this.zv);
    }

    @EventHandler
    private void a(PlayerInteractEvent playerInteractEvent) {
        if (ItemStackBridge_2.q(playerInteractEvent)) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK || block.getType() != Material.JUKEBOX) {
            return;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (this.zu.containsKey(block) || blockBridge_9.Z(block) != null) {
            this.a(block, blockBridge_9);
            return;
        }
        Jukebox jukebox = (Jukebox)block.getState();
        if (jukebox.isPlaying() || jukebox.getRecord().getType() != Material.AIR) {
            return;
        }
        if (!ItemStackBuilder_4.isCustomItem(playerInteractEvent.getItem())) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(playerInteractEvent.getItem());
        if (itemStackBuilder_4 != null) {
            if (!itemStackBuilder_4.Ge.bm("music_disc")) {
                return;
            }
            StringData_7 stringData_7 = (StringData_7)itemStackBuilder_4.Ge.bn("music_disc");
            if (stringData_7.yQ == null) {
                return;
            }
            ItemStack itemStack = playerInteractEvent.getItem().clone();
            itemStack.setAmount(1);
            String string = stringData_7.yP;
            string = ColorBridge.gH(string);
            jukebox.setRecord(itemStack);
            if (!jukebox.update()) {
                CommandSenderBridge_5.warn("Failed to put custom music disc into jukebox: " + LocationBridge_2.ae(block.getLocation()));
                return;
            }
            blockBridge_9.a(block, stringData_7.yQ);
            PacketContainerHolder.tp().a(playerInteractEvent.getPlayer(), PluginBridge_6.r(PluginBridge_6.gF(Main.PQ.ir("now-playing").replace("{value}", string))));
            LocationBridge_3.a(block.getLocation(), stringData_7.yQ, SoundCategory.RECORDS, 1.0f, 1.0f);
            ItemStackBridge_2.cy(playerInteractEvent.getPlayer());
            this.zu.put(block, stringData_7.yQ);
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (ListenerBridge.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getBlock().getType() != Material.JUKEBOX) {
            return;
        }
        this.p(blockBreakEvent.getBlock());
    }

    private void p(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        this.a(block, blockBridge_9);
    }

    private void a(Block block, BlockBridge_9 blockBridge_9) {
        ItemStack itemStack;
        Jukebox jukebox;
        String string = (String)this.zu.remove(block);
        if (string == null) {
            string = blockBridge_9.Z(block);
        }
        if (string == null) {
            return;
        }
        LocationBridge_3.a(block.getLocation(), SoundCategory.RECORDS, string);
        BlockState blockState = block.getState();
        if (blockState instanceof Jukebox) {
            jukebox = (Jukebox)blockState;
            itemStack = jukebox.getRecord();
        } else {
            itemStack = null;
        }
        ItemStack itemStack2 = itemStack;
        jukebox = PlayerInteractListener_3.c(itemStack2, blockBridge_9.V(block));
        if (jukebox != null) {
            blockState = LocationBridge_2.bp(block);
            blockState.subtract(0.5, 0.0, 0.5);
            block.getWorld().dropItemNaturally((Location)blockState, (ItemStack)jukebox);
        }
        blockBridge_9.ag(block);
    }

    static ItemStack c(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack == null || itemStack.getType() == Material.AIR ? itemStack2 : null;
    }
}
