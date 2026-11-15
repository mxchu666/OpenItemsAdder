package itemsadder.m;

import itemsadder.m.bcc;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class oa
extends ou {
    public final Effect De;

    public oa(Effect effect) {
        this.De = effect;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        int n = (int)player.getLocation().getYaw();
        int n2 = 0;
        switch (bcc.a(n, false)) {
            case NORTH: 
            case NORTH_EAST: 
            case NORTH_WEST: {
                n2 = 2;
                break;
            }
            case SOUTH: 
            case SOUTH_EAST: 
            case SOUTH_WEST: {
                n2 = 3;
                break;
            }
            case WEST: {
                n2 = 4;
                break;
            }
            case EAST: {
                n2 = 5;
            }
        }
        player.getWorld().playEffect(player.getEyeLocation(), this.De, n2);
        return pa.ml();
    }

    @Override
    public pa a(ProjectileHitEvent projectileHitEvent, qm qm2, ItemStack itemStack) {
        if (projectileHitEvent.getHitEntity() != null) {
            projectileHitEvent.getHitEntity().getWorld().playEffect(projectileHitEvent.getHitEntity().getLocation(), this.De, 0);
        } else {
            projectileHitEvent.getHitBlock().getWorld().playEffect(projectileHitEvent.getHitBlock().getLocation(), this.De, 0);
        }
        return pa.ml();
    }
}
