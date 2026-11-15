package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.adb;
import itemsadder.m.ai;
import itemsadder.m.bbe;
import itemsadder.m.bbs;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bcv;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.ke;
import itemsadder.m.ku;
import itemsadder.m.ms;
import itemsadder.m.qm;
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

public class kt
implements ai {
    private final ConcurrentHashMap zu = new ConcurrentHashMap();
    ku zv;

    public kt(Plugin plugin) {
        bev.a(this, plugin);
        this.zv = new ku(this);
        bev.a(this.zv, plugin);
        bcp.b(bukkitRunnable -> {
            for (Block block : this.zu.keySet()) {
                if (bcc.br(block)) {
                    block.getWorld().spawnParticle(Particle.NOTE, bcc.bp(block), 1);
                    if (block.getType() == Material.JUKEBOX) continue;
                    bcp.i(() -> this.p(block));
                    continue;
                }
                this.zu.remove(block);
            }
        }, 20L, 20L);
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        ai.a(this.zv);
    }

    @EventHandler
    private void a(PlayerInteractEvent playerInteractEvent) {
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        Block block = playerInteractEvent.getClickedBlock();
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK || block.getType() != Material.JUKEBOX) {
            return;
        }
        ms ms2 = d.g().b(block);
        if (this.zu.containsKey(block) || ms2.Z(block) != null) {
            this.a(block, ms2);
            return;
        }
        Jukebox jukebox = (Jukebox)block.getState();
        if (jukebox.isPlaying() || jukebox.getRecord().getType() != Material.AIR) {
            return;
        }
        if (!qm.isCustomItem(playerInteractEvent.getItem())) {
            return;
        }
        qm qm2 = d.g().a(playerInteractEvent.getItem());
        if (qm2 != null) {
            if (!qm2.Ge.bm("music_disc")) {
                return;
            }
            ke ke2 = (ke)qm2.Ge.bn("music_disc");
            if (ke2.yQ == null) {
                return;
            }
            ItemStack itemStack = playerInteractEvent.getItem().clone();
            itemStack.setAmount(1);
            String string = ke2.yP;
            string = bcy.gH(string);
            jukebox.setRecord(itemStack);
            if (!jukebox.update()) {
                bce.warn("Failed to put custom music disc into jukebox: " + bcc.ae(block.getLocation()));
                return;
            }
            ms2.a(block, ke2.yQ);
            adb.tp().a(playerInteractEvent.getPlayer(), bbe.r(bbe.gF(Main.PQ.ir("now-playing").replace("{value}", string))));
            bcv.a(block.getLocation(), ke2.yQ, SoundCategory.RECORDS, 1.0f, 1.0f);
            bbs.cy(playerInteractEvent.getPlayer());
            this.zu.put(block, ke2.yQ);
        }
    }

    @EventHandler(ignoreCancelled=true)
    private void b(BlockBreakEvent blockBreakEvent) {
        if (bev.g(blockBreakEvent)) {
            return;
        }
        if (blockBreakEvent.getBlock().getType() != Material.JUKEBOX) {
            return;
        }
        this.p(blockBreakEvent.getBlock());
    }

    private void p(Block block) {
        ms ms2 = d.g().b(block);
        this.a(block, ms2);
    }

    private void a(Block block, ms ms2) {
        ItemStack itemStack;
        Jukebox jukebox;
        String string = (String)this.zu.remove(block);
        if (string == null) {
            string = ms2.Z(block);
        }
        if (string == null) {
            return;
        }
        bcv.a(block.getLocation(), SoundCategory.RECORDS, string);
        BlockState blockState = block.getState();
        if (blockState instanceof Jukebox) {
            jukebox = (Jukebox)blockState;
            itemStack = jukebox.getRecord();
        } else {
            itemStack = null;
        }
        ItemStack itemStack2 = itemStack;
        jukebox = kt.c(itemStack2, ms2.V(block));
        if (jukebox != null) {
            blockState = bcc.bp(block);
            blockState.subtract(0.5, 0.0, 0.5);
            block.getWorld().dropItemNaturally((Location)blockState, (ItemStack)jukebox);
        }
        ms2.ag(block);
    }

    static ItemStack c(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack == null || itemStack.getType() == Material.AIR ? itemStack2 : null;
    }
}
