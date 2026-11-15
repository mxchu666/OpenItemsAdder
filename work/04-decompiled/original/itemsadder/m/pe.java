package itemsadder.m;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.qj;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class pe
implements ai {
    private final d Eg;

    public pe(Plugin plugin, d d2) {
        this.Eg = d2;
        bev.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true)
    void a(ArmorEquipEvent armorEquipEvent) {
        qm qm2 = this.Eg.a(armorEquipEvent.getOldArmorPiece());
        qm qm3 = this.Eg.a(armorEquipEvent.getNewArmorPiece());
        if (qm2 == null && qm3 == null) {
            return;
        }
        if (qm3 != null) {
            this.a(armorEquipEvent, armorEquipEvent.getNewArmorPiece(), qm3, true);
            if (!this.i(qm3)) {
                armorEquipEvent.setCancelled(true);
                return;
            }
        }
        if (qm2 != null) {
            this.a(armorEquipEvent, armorEquipEvent.getOldArmorPiece(), qm2, false);
        }
    }

    @EventHandler(priority=EventPriority.LOWEST)
    private void n(PlayerInteractEvent playerInteractEvent) {
        qm qm2;
        if (playerInteractEvent.getItem() != null && playerInteractEvent.getClickedBlock() != null && playerInteractEvent.getClickedBlock().getType() == Material.WATER_CAULDRON && (qm2 = d.g().a(playerInteractEvent.getItem())) instanceof qj) {
            playerInteractEvent.setUseInteractedBlock(Event.Result.DENY);
            playerInteractEvent.setUseItemInHand(Event.Result.DENY);
        }
    }

    private boolean i(qm qm2) {
        if (qm2 instanceof qj) {
            return ((qj)qm2).mC();
        }
        return true;
    }

    void a(ArmorEquipEvent armorEquipEvent, ItemStack itemStack, qm qm2, boolean bl) {
        if (bl) {
            if (!this.i(qm2)) {
                armorEquipEvent.setCancelled(true);
            } else {
                qm2.a((LivingEntity)armorEquipEvent.getPlayer(), jj.WEAR, ou2 -> ou2.a(armorEquipEvent, qm2, itemStack));
            }
        } else {
            qm2.a((LivingEntity)armorEquipEvent.getPlayer(), jj.UNWEAR, ou2 -> ou2.a(armorEquipEvent, qm2, itemStack));
        }
    }
}
