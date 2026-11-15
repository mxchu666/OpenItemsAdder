package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_2;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

public class EffectBridge
extends Builder_14 {
    public final Effect De;

    public EffectBridge(Effect effect) {
        this.De = effect;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        int n = (int)player.getLocation().getYaw();
        int n2 = 0;
        switch (LocationBridge_2.a(n, false)) {
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
        return ItemStackBuilder_3.ml();
    }

    @Override
    public ItemStackBuilder_3 a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (projectileHitEvent.getHitEntity() != null) {
            projectileHitEvent.getHitEntity().getWorld().playEffect(projectileHitEvent.getHitEntity().getLocation(), this.De, 0);
        } else {
            projectileHitEvent.getHitBlock().getWorld().playEffect(projectileHitEvent.getHitBlock().getLocation(), this.De, 0);
        }
        return ItemStackBuilder_3.ml();
    }
}
