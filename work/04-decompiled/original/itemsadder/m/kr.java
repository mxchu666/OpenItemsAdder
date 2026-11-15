package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ai;
import itemsadder.m.aqp;
import itemsadder.m.bbs;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.kd;
import itemsadder.m.ms;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class kr
implements ai {
    private final d zs;

    public kr(Plugin plugin, d d2) {
        this.zs = d2;
        bev.a(this, plugin);
        d2.ar.a(new my(PlayerInteractEvent.class, this::e));
    }

    @mz
    private void e(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        String string;
        if (bbs.q(playerInteractEvent)) {
            return;
        }
        if (!qm2.Ge.bm("liquid_analyzer")) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        Block block = playerInteractEvent.getClickedBlock() != null ? playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace()) : aqp.bZ(playerInteractEvent.getPlayer());
        if (kd.c(block.getType())) {
            Levelled levelled = (Levelled)block.getBlockData();
            ms ms2 = this.zs.a(block.getChunk());
            if (!ms2.T(block)) {
                if (levelled.getLevel() > 0 && levelled.getLevel() < levelled.getMaximumLevel()) {
                    playerInteractEvent.getPlayer().sendMessage(Main.PQ.ir("liquid-analyzer-low-level"));
                    return;
                }
                string = block.getType().toString();
            } else {
                string = ms2.ab(block);
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
            bbs.aj(playerInteractEvent.getItem());
        }
    }
}
