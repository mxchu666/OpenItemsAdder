package itemsadder.m;

import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class nr
extends ou {
    public final int CL;
    public final boolean CM;
    public final boolean CN;

    public nr(int n, boolean bl, boolean bl2) {
        this.CL = n;
        this.CM = bl;
        this.CN = bl2;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        World world = player.getWorld();
        if (world.createExplosion(player.getLocation(), (float)this.CL, this.CM, this.CN, (Entity)player)) {
            return pa.ml();
        }
        return pa.mk();
    }

    @Override
    public pa a(Event event, Block block, qm qm2, ItemStack itemStack, Player player) {
        World world = player.getWorld();
        if (block == null) {
            return pa.mk();
        }
        if (world.createExplosion(block.getLocation(), (float)this.CL, this.CM, this.CN, (Entity)player)) {
            return pa.ml();
        }
        return pa.mk();
    }

    @Override
    public pa a(ProjectileHitEvent projectileHitEvent, qm qm2, ItemStack itemStack) {
        World world = projectileHitEvent.getEntity().getWorld();
        if (world.createExplosion(projectileHitEvent.getEntity().getLocation(), (float)this.CL, this.CM, this.CN, (Entity)projectileHitEvent.getEntity().getShooter())) {
            return pa.ml();
        }
        return pa.mk();
    }

    @Override
    public pa a(PlayerInteractEntityEvent playerInteractEntityEvent, qm qm2, ItemStack itemStack) {
        World world = playerInteractEntityEvent.getRightClicked().getWorld();
        if (world.createExplosion(playerInteractEntityEvent.getRightClicked().getLocation(), (float)this.CL, this.CM, this.CN, (Entity)playerInteractEntityEvent.getPlayer())) {
            return pa.ml();
        }
        return pa.mk();
    }

    @Override
    public pa a(EntityDamageByEntityEvent entityDamageByEntityEvent, qm qm2, ItemStack itemStack) {
        World world = entityDamageByEntityEvent.getEntity().getWorld();
        if (world.createExplosion(entityDamageByEntityEvent.getEntity().getLocation(), (float)this.CL, this.CM, this.CN)) {
            return pa.ml();
        }
        return pa.mk();
    }
}
