package itemsadder.m;

import itemsadder.m.bbh;
import itemsadder.m.bcc;
import itemsadder.m.ni;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import java.util.Collection;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class nh
extends ou {
    public final float Cu;
    public final int Cv;
    public final List Cw;

    public nh(float f, int n, List list) {
        this.Cu = f;
        this.Cv = n;
        this.Cw = list;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        boolean bl = false;
        Collection collection = bcc.c(player.getLocation(), this.Cv);
        for (Entity entity : collection) {
            if (!(entity instanceof LivingEntity) || entity == player || !this.Cw.isEmpty() && !this.Cw.contains((Object)ni.F(entity)) || !bbh.a((LivingEntity)player, (LivingEntity)entity, (double)this.Cv, this.Cu)) continue;
            bl = true;
        }
        return bl ? pa.ml() : pa.mk();
    }

    @Override
    public pa a(ProjectileHitEvent projectileHitEvent, qm qm2, ItemStack itemStack) {
        boolean bl = false;
        Collection collection = projectileHitEvent.getHitEntity() != null ? bcc.c(projectileHitEvent.getHitEntity().getLocation(), this.Cv) : bcc.c(projectileHitEvent.getHitBlock().getLocation(), this.Cv);
        for (Entity entity : collection) {
            if (!(entity instanceof LivingEntity) || !this.Cw.isEmpty() && !this.Cw.contains((Object)ni.F(entity)) || !bbh.a(projectileHitEvent.getEntity(), (LivingEntity)entity, (double)this.Cv, this.Cu)) continue;
            bl = true;
        }
        return bl ? pa.ml() : pa.mk();
    }
}
