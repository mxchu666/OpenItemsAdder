package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class pm
implements ai {
    public pm(Plugin plugin, d d2) {
        d2.ar.a(new my(PlayerFishEvent.class, this::b));
    }

    @mz
    void b(PlayerFishEvent playerFishEvent, qm qm2, ItemStack itemStack) {
        jj jj2 = null;
        switch (playerFishEvent.getState()) {
            case FISHING: {
                jj2 = jj.FISHING_START;
                break;
            }
            case CAUGHT_ENTITY: 
            case CAUGHT_FISH: {
                jj2 = jj.FISHING_CAUGHT;
                break;
            }
            case FAILED_ATTEMPT: {
                jj2 = jj.FISHING_FAILED;
                break;
            }
            case REEL_IN: {
                jj2 = jj.FISHING_CANCEL;
                break;
            }
            case BITE: {
                jj2 = jj.FISHING_BITE;
                break;
            }
            case IN_GROUND: {
                jj2 = jj.FISHING_IN_GROUND;
            }
        }
        if (jj2 == null) {
            return;
        }
        qm2.a((LivingEntity)playerFishEvent.getPlayer(), jj2, ou2 -> ou2.a(playerFishEvent, qm2, itemStack));
    }
}
