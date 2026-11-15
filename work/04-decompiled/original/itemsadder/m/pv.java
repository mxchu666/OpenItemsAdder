package itemsadder.m;

import itemsadder.m.ai;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jj;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
import itemsadder.m.zi;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class pv
implements ai {
    private final Plugin EJ;
    private final d EK;

    public pv(Plugin plugin, d d2) {
        this.EJ = plugin;
        this.EK = d2;
        bev.a(this, plugin);
        d2.ar.a(new my(ProjectileLaunchEvent.class, this::b));
        d2.ar.a(new my(zi.class, this::b));
    }

    @mz
    public void b(ProjectileLaunchEvent projectileLaunchEvent, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)projectileLaunchEvent.getEntity().getShooter(), jj.ITEM_THROW, ou2 -> ou2.a(projectileLaunchEvent, qm2, itemStack));
        projectileLaunchEvent.getEntity().setMetadata("IAProjectileNamespacedID", (MetadataValue)new FixedMetadataValue(this.EJ, (Object)qm2.getNamespacedID()));
        projectileLaunchEvent.getEntity().setMetadata("IAProjectileItemStack", (MetadataValue)new FixedMetadataValue(this.EJ, (Object)itemStack));
    }

    @mz
    public void b(zi zi2, qm qm2, ItemStack itemStack) {
        qm2.a(zi2.getEntity(), jj.ITEM_THROW, ou2 -> ou2.a(zi2, qm2, itemStack));
        zi2.sz().setMetadata("IAProjectileNamespacedID", (MetadataValue)new FixedMetadataValue(this.EJ, (Object)qm2.getNamespacedID()));
        zi2.sz().setMetadata("IAProjectileItemStack", (MetadataValue)new FixedMetadataValue(this.EJ, (Object)itemStack));
    }

    @EventHandler
    public void c(ProjectileHitEvent projectileHitEvent) {
        if (!projectileHitEvent.getEntity().hasMetadata("IAProjectileNamespacedID")) {
            return;
        }
        qm qm2 = this.EK.e(((MetadataValue)projectileHitEvent.getEntity().getMetadata("IAProjectileNamespacedID").get(0)).asString());
        ItemStack itemStack = (ItemStack)((MetadataValue)projectileHitEvent.getEntity().getMetadata("IAProjectileItemStack").get(0)).value();
        if (projectileHitEvent.getHitEntity() == null) {
            qm2.a((LivingEntity)projectileHitEvent.getEntity().getShooter(), jj.ITEM_HIT_GROUND, ou2 -> ou2.a(projectileHitEvent, qm2, itemStack));
        } else {
            qm2.a((LivingEntity)projectileHitEvent.getEntity().getShooter(), jj.ITEM_HIT_ENTITY, ou2 -> ou2.a(projectileHitEvent, qm2, itemStack));
        }
    }
}
