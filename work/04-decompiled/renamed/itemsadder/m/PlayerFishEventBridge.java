package itemsadder.m;

import itemsadder.m.BlockBreakEnum;
import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PlayerFishEventBridge
implements PluginContract {
    public PlayerFishEventBridge(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        itemStackRegistry.ar.a(new ClassRefData(PlayerFishEvent.class, this::b));
    }

    @PluginContract_19
    void b(PlayerFishEvent playerFishEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        BlockBreakEnum blockBreakEnum = null;
        switch (playerFishEvent.getState()) {
            case FISHING: {
                blockBreakEnum = BlockBreakEnum.FISHING_START;
                break;
            }
            case CAUGHT_ENTITY: 
            case CAUGHT_FISH: {
                blockBreakEnum = BlockBreakEnum.FISHING_CAUGHT;
                break;
            }
            case FAILED_ATTEMPT: {
                blockBreakEnum = BlockBreakEnum.FISHING_FAILED;
                break;
            }
            case REEL_IN: {
                blockBreakEnum = BlockBreakEnum.FISHING_CANCEL;
                break;
            }
            case BITE: {
                blockBreakEnum = BlockBreakEnum.FISHING_BITE;
                break;
            }
            case IN_GROUND: {
                blockBreakEnum = BlockBreakEnum.FISHING_IN_GROUND;
            }
        }
        if (blockBreakEnum == null) {
            return;
        }
        itemStackBuilder_4.a((LivingEntity)playerFishEvent.getPlayer(), blockBreakEnum, builder_14 -> builder_14.a(playerFishEvent, itemStackBuilder_4, itemStack));
    }
}
