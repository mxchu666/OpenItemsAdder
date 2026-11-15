package itemsadder.m;

import com.destroystokyo.paper.event.player.PlayerElytraBoostEvent;
import dev.lone.itemsadder.Main;
import itemsadder.m.EntityToggleGlideListener;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import itemsadder.m.RecordOfValue_22;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.Plugin;

public final class PlayerElytraBoostListener
implements PluginContract {
    private final EntityToggleGlideListener EH;

    public PlayerElytraBoostListener(EntityToggleGlideListener entityToggleGlideListener) {
        this.EH = entityToggleGlideListener;
        ListenerBridge.a(this, (Plugin)Main.rS());
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.HIGHEST)
    private void a(PlayerElytraBoostEvent playerElytraBoostEvent) {
        RecordOfValue_22 recordOfValue_22 = this.EH.a(playerElytraBoostEvent.getPlayer(), playerElytraBoostEvent.getItemStack(), (Event)playerElytraBoostEvent);
        if (!recordOfValue_22.mo()) {
            return;
        }
        if (!recordOfValue_22.mp()) {
            playerElytraBoostEvent.setCancelled(true);
            return;
        }
        playerElytraBoostEvent.setShouldConsume(recordOfValue_22.mq());
    }
}
