package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBreakEnum;
import itemsadder.m.BoolDoubleData;
import itemsadder.m.ClassRefData;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class EntityDamageByEntityListener
implements PluginContract {
    public EntityDamageByEntityListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(EntityShootBowEvent.class, this::b));
    }

    @EventHandler(ignoreCancelled=true)
    public void f(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (ListenerBridge.h(entityDamageByEntityEvent)) {
            return;
        }
        if (entityDamageByEntityEvent.getCause() != EntityDamageEvent.DamageCause.PROJECTILE) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Arrow) {
            if (!entityDamageByEntityEvent.getDamager().hasMetadata("IAArrowDamage")) {
                return;
            }
            int n = ((MetadataValue)entityDamageByEntityEvent.getDamager().getMetadata("IAArrowDamage").get(0)).asInt();
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getFinalDamage() * (double)n / 2.0);
        }
    }

    @PluginContract_19
    void b(EntityShootBowEvent entityShootBowEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (itemStackBuilder_4 == null) {
            return;
        }
        if (itemStackBuilder_4.getType() != Material.BOW) {
            return;
        }
        BoolDoubleData boolDoubleData = (BoolDoubleData)itemStackBuilder_4;
        if (boolDoubleData.Fp != -1.0) {
            entityShootBowEvent.getProjectile().setMetadata("IAArrowDamage", (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)boolDoubleData.Fp));
        }
        if (boolDoubleData.Fo) {
            entityShootBowEvent.getProjectile().setFireTicks(100);
        }
        entityShootBowEvent.getProjectile().setGlowing(boolDoubleData.Fn);
        itemStackBuilder_4.a(entityShootBowEvent.getEntity(), BlockBreakEnum.BOW_SHOT, builder_14 -> builder_14.a(entityShootBowEvent, itemStackBuilder_4, itemStack));
    }
}
