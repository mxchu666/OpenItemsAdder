package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_17
extends Builder_14 {
    public final int CL;
    public final boolean CM;
    public final boolean CN;

    public ItemStackBridge_17(int n, boolean bl, boolean bl2) {
        this.CL = n;
        this.CM = bl;
        this.CN = bl2;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        World world = player.getWorld();
        if (world.createExplosion(player.getLocation(), (float)this.CL, this.CM, this.CN, (Entity)player)) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }

    @Override
    public ItemStackBuilder_3 a(Event event, Block block, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        World world = player.getWorld();
        if (block == null) {
            return ItemStackBuilder_3.mk();
        }
        if (world.createExplosion(block.getLocation(), (float)this.CL, this.CM, this.CN, (Entity)player)) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }

    @Override
    public ItemStackBuilder_3 a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        World world = projectileHitEvent.getEntity().getWorld();
        if (world.createExplosion(projectileHitEvent.getEntity().getLocation(), (float)this.CL, this.CM, this.CN, (Entity)projectileHitEvent.getEntity().getShooter())) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }

    @Override
    public ItemStackBuilder_3 a(PlayerInteractEntityEvent playerInteractEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        World world = playerInteractEntityEvent.getRightClicked().getWorld();
        if (world.createExplosion(playerInteractEntityEvent.getRightClicked().getLocation(), (float)this.CL, this.CM, this.CN, (Entity)playerInteractEntityEvent.getPlayer())) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }

    @Override
    public ItemStackBuilder_3 a(EntityDamageByEntityEvent entityDamageByEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        World world = entityDamageByEntityEvent.getEntity().getWorld();
        if (world.createExplosion(entityDamageByEntityEvent.getEntity().getLocation(), (float)this.CL, this.CM, this.CN)) {
            return ItemStackBuilder_3.ml();
        }
        return ItemStackBuilder_3.mk();
    }
}
