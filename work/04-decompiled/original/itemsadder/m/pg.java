package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qh;
import itemsadder.m.qm;
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

public class pg
implements ai {
    public pg(Plugin plugin, d d2) {
        bev.a(this, plugin);
        d2.ar.a(new my(EntityShootBowEvent.class, this::b));
    }

    @EventHandler(ignoreCancelled=true)
    public void f(EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (bev.h(entityDamageByEntityEvent)) {
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

    @mz
    void b(EntityShootBowEvent entityShootBowEvent, qm qm2, ItemStack itemStack) {
        if (qm2 == null) {
            return;
        }
        if (qm2.getType() != Material.BOW) {
            return;
        }
        qh qh2 = (qh)qm2;
        if (qh2.Fp != -1.0) {
            entityShootBowEvent.getProjectile().setMetadata("IAArrowDamage", (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)qh2.Fp));
        }
        if (qh2.Fo) {
            entityShootBowEvent.getProjectile().setFireTicks(100);
        }
        entityShootBowEvent.getProjectile().setGlowing(qh2.Fn);
        qm2.a(entityShootBowEvent.getEntity(), jj.BOW_SHOT, ou2 -> ou2.a(entityShootBowEvent, qm2, itemStack));
    }
}
