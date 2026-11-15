package itemsadder.m;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBridge_6;
import itemsadder.m.PluginContract;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PlayerInteractListener_6
implements PluginContract {
    private final ItemStackRegistry Eg;

    public PlayerInteractListener_6(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Eg = itemStackRegistry;
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true)
    void a(ArmorEquipEvent armorEquipEvent) {
        ItemStackBuilder_4 itemStackBuilder_4 = this.Eg.a(armorEquipEvent.getOldArmorPiece());
        ItemStackBuilder_4 itemStackBuilder_42 = this.Eg.a(armorEquipEvent.getNewArmorPiece());
        if (itemStackBuilder_4 == null && itemStackBuilder_42 == null) {
            return;
        }
        if (itemStackBuilder_42 != null) {
            this.a(armorEquipEvent, armorEquipEvent.getNewArmorPiece(), itemStackBuilder_42, true);
            if (!this.i(itemStackBuilder_42)) {
                armorEquipEvent.setCancelled(true);
                return;
            }
        }
        if (itemStackBuilder_4 != null) {
            this.a(armorEquipEvent, armorEquipEvent.getOldArmorPiece(), itemStackBuilder_4, false);
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void n(PlayerInteractEvent playerInteractEvent) {
        ItemStackBuilder_4 itemStackBuilder_4;
        if (playerInteractEvent.getItem() != null && playerInteractEvent.getClickedBlock() != null && playerInteractEvent.getClickedBlock().getType() == Material.WATER_CAULDRON && (itemStackBuilder_4 = ItemStackRegistry.g().a(playerInteractEvent.getItem())) instanceof MaterialBridge_6) {
            playerInteractEvent.setUseInteractedBlock(Event.Result.DENY);
            playerInteractEvent.setUseItemInHand(Event.Result.DENY);
        }
    }

    private boolean i(ItemStackBuilder_4 itemStackBuilder_4) {
        if (itemStackBuilder_4 instanceof MaterialBridge_6) {
            return ((MaterialBridge_6)itemStackBuilder_4).mC();
        }
        return true;
    }

    void a(ArmorEquipEvent armorEquipEvent, ItemStack itemStack, ItemStackBuilder_4 itemStackBuilder_4, boolean bl) {
        if (bl) {
            if (!this.i(itemStackBuilder_4)) {
                armorEquipEvent.setCancelled(true);
            } else {
                itemStackBuilder_4.a((LivingEntity)armorEquipEvent.getPlayer(), BlockBreakEnum.WEAR, builder_14 -> builder_14.a(armorEquipEvent, itemStackBuilder_4, itemStack));
            }
        } else {
            itemStackBuilder_4.a((LivingEntity)armorEquipEvent.getPlayer(), BlockBreakEnum.UNWEAR, builder_14 -> builder_14.a(armorEquipEvent, itemStackBuilder_4, itemStack));
        }
    }
}
