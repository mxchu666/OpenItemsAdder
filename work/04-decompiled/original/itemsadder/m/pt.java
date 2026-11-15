package itemsadder.m;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.pi;
import itemsadder.m.pj;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;

public final class pt
implements ai {
    private final pi EH;

    public pt(pi pi2) {
        this.EH = pi2;
        bev.a(this, (Plugin)Main.rS());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerElytraBoostEvent playerElytraBoostEvent) {
        pj pj2 = this.EH.a(playerElytraBoostEvent.getPlayer(), playerElytraBoostEvent.getItemStack(), (Event)playerElytraBoostEvent);
        if (!pj2.mo()) {
            return;
        }
        if (!pj2.mp()) {
            playerElytraBoostEvent.setCancelled(true);
            return;
        }
        playerElytraBoostEvent.setShouldConsume(pj2.mq());
    }
}
