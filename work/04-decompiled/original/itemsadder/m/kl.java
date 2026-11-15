package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jq;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class kl
implements ai {
    public kl(Plugin plugin) {
        bev.a(this, plugin);
        d.g().ar.a(new my(PlayerInteractEvent.class, this::a));
    }

    @mz
    private void a(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        jq jq2 = (jq)qm2.Ge.bn("entity_summoner");
        if (jq2 == null) {
            return;
        }
        bce.iA("getClickedPosition: " + String.valueOf(playerInteractEvent.getClickedPosition()));
        bce.iA("getClickedBlock: " + String.valueOf(playerInteractEvent.getClickedBlock()));
        jq2.a(playerInteractEvent.getPlayer(), itemStack, bcy.r(playerInteractEvent));
    }
}
