package itemsadder.m;

import itemsadder.m.BlockBreakEnum;
import itemsadder.m.ClassRefData;
import itemsadder.m.HandlerListItemStackHolder;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class ProjectileHitListener
implements PluginContract {
    private final Plugin EJ;
    private final ItemStackRegistry EK;

    public ProjectileHitListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.EJ = plugin;
        this.EK = itemStackRegistry;
        ListenerBridge.a(this, plugin);
        itemStackRegistry.ar.a(new ClassRefData(ProjectileLaunchEvent.class, this::b));
        itemStackRegistry.ar.a(new ClassRefData(HandlerListItemStackHolder.class, this::b));
    }

    @PluginContract_19
    public void b(ProjectileLaunchEvent projectileLaunchEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)projectileLaunchEvent.getEntity().getShooter(), BlockBreakEnum.ITEM_THROW, builder_14 -> builder_14.a(projectileLaunchEvent, itemStackBuilder_4, itemStack));
        projectileLaunchEvent.getEntity().setMetadata("IAProjectileNamespacedID", (MetadataValue)new FixedMetadataValue(this.EJ, (Object)itemStackBuilder_4.getNamespacedID()));
        projectileLaunchEvent.getEntity().setMetadata("IAProjectileItemStack", (MetadataValue)new FixedMetadataValue(this.EJ, (Object)itemStack));
    }

    @PluginContract_19
    public void b(HandlerListItemStackHolder handlerListItemStackHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a(handlerListItemStackHolder.getEntity(), BlockBreakEnum.ITEM_THROW, builder_14 -> builder_14.a(handlerListItemStackHolder, itemStackBuilder_4, itemStack));
        handlerListItemStackHolder.sz().setMetadata("IAProjectileNamespacedID", (MetadataValue)new FixedMetadataValue(this.EJ, (Object)itemStackBuilder_4.getNamespacedID()));
        handlerListItemStackHolder.sz().setMetadata("IAProjectileItemStack", (MetadataValue)new FixedMetadataValue(this.EJ, (Object)itemStack));
    }

    @EventHandler
    public void c(ProjectileHitEvent projectileHitEvent) {
        if (!projectileHitEvent.getEntity().hasMetadata("IAProjectileNamespacedID")) {
            return;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = this.EK.e(((MetadataValue)projectileHitEvent.getEntity().getMetadata("IAProjectileNamespacedID").get(0)).asString());
        ItemStack itemStack = (ItemStack)((MetadataValue)projectileHitEvent.getEntity().getMetadata("IAProjectileItemStack").get(0)).value();
        if (projectileHitEvent.getHitEntity() == null) {
            itemStackBuilder_4.a((LivingEntity)projectileHitEvent.getEntity().getShooter(), BlockBreakEnum.ITEM_HIT_GROUND, builder_14 -> builder_14.a(projectileHitEvent, itemStackBuilder_4, itemStack));
        } else {
            itemStackBuilder_4.a((LivingEntity)projectileHitEvent.getEntity().getShooter(), BlockBreakEnum.ITEM_HIT_ENTITY, builder_14 -> builder_14.a(projectileHitEvent, itemStackBuilder_4, itemStack));
        }
    }
}
