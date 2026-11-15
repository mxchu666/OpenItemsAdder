package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.HostileEnum;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LivingEntityBridge_6;
import itemsadder.m.LocationBridge_2;
import java.util.Collection;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_12
extends Builder_14 {
    public final float Cu;
    public final int Cv;
    public final List Cw;

    public ItemStackBridge_12(float f, int n, List list) {
        this.Cu = f;
        this.Cv = n;
        this.Cw = list;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        boolean bl = false;
        Collection collection = LocationBridge_2.c(player.getLocation(), this.Cv);
        for (Entity entity : collection) {
            if (!(entity instanceof LivingEntity) || entity == player || !this.Cw.isEmpty() && !this.Cw.contains((Object)HostileEnum.F(entity)) || !LivingEntityBridge_6.a((LivingEntity)player, (LivingEntity)entity, (double)this.Cv, this.Cu)) continue;
            bl = true;
        }
        return bl ? ItemStackBuilder_3.ml() : ItemStackBuilder_3.mk();
    }

    @Override
    public ItemStackBuilder_3 a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        boolean bl = false;
        Collection collection = projectileHitEvent.getHitEntity() != null ? LocationBridge_2.c(projectileHitEvent.getHitEntity().getLocation(), this.Cv) : LocationBridge_2.c(projectileHitEvent.getHitBlock().getLocation(), this.Cv);
        for (Entity entity : collection) {
            if (!(entity instanceof LivingEntity) || !this.Cw.isEmpty() && !this.Cw.contains((Object)HostileEnum.F(entity)) || !LivingEntityBridge_6.a(projectileHitEvent.getEntity(), (LivingEntity)entity, (double)this.Cv, this.Cu)) continue;
            bl = true;
        }
        return bl ? ItemStackBuilder_3.ml() : ItemStackBuilder_3.mk();
    }
}
