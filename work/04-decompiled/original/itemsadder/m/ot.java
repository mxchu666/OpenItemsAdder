package itemsadder.m;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import itemsadder.m.lg;
import itemsadder.m.pa;
import itemsadder.m.qd;
import itemsadder.m.qe;
import itemsadder.m.qf;
import itemsadder.m.qg;
import itemsadder.m.qm;
import itemsadder.m.zi;
import itemsadder.m.zj;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public interface ot {
    public pa a(Event var1, qm var2, ItemStack var3, Player var4);

    default public pa a(Event event, Block block, qm qm2, ItemStack itemStack, Player player) {
        return this.a(event, qm2, itemStack, player);
    }

    default public pa a(BlockBreakEvent blockBreakEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)blockBreakEvent, blockBreakEvent.getBlock(), qm2, itemStack, blockBreakEvent.getPlayer());
    }

    default public pa a(lg lg2, qm qm2, ItemStack itemStack) {
        return this.a(lg2, lg2.getBlock(), qm2, itemStack, lg2.getPlayer());
    }

    default public pa j(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerInteractEvent, playerInteractEvent.getClickedBlock(), qm2, itemStack, playerInteractEvent.getPlayer());
    }

    default public pa a(EntityDamageByEntityEvent entityDamageByEntityEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)entityDamageByEntityEvent, qm2, itemStack, (Player)entityDamageByEntityEvent.getDamager());
    }

    default public pa a(EntityDeathEvent entityDeathEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)entityDeathEvent, qm2, itemStack, entityDeathEvent.getEntity().getKiller());
    }

    default public pa a(PlayerInteractEntityEvent playerInteractEntityEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerInteractEntityEvent, qm2, itemStack, playerInteractEntityEvent.getPlayer());
    }

    default public pa a(PlayerDropItemEvent playerDropItemEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerDropItemEvent, qm2, itemStack, playerDropItemEvent.getPlayer());
    }

    default public pa b(zj zj2, qm qm2, ItemStack itemStack) {
        return this.a(zj2, qm2, itemStack, zj2.getPlayer());
    }

    default public pa a(EntityShootBowEvent entityShootBowEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)entityShootBowEvent, qm2, itemStack, (Player)entityShootBowEvent.getEntity());
    }

    default public pa a(zi zi2, qm qm2, ItemStack itemStack) {
        return this.a((Event)zi2, qm2, itemStack, (Player)zi2.getEntity());
    }

    default public pa b(PlayerItemConsumeEvent playerItemConsumeEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerItemConsumeEvent, qm2, itemStack, playerItemConsumeEvent.getPlayer());
    }

    default public pa a(FoodLevelChangeEvent foodLevelChangeEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)foodLevelChangeEvent, qm2, itemStack, (Player)foodLevelChangeEvent.getEntity());
    }

    default public pa a(PlayerEditBookEvent playerEditBookEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerEditBookEvent, qm2, itemStack, playerEditBookEvent.getPlayer());
    }

    default public pa a(PlayerFishEvent playerFishEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerFishEvent, qm2, itemStack, playerFishEvent.getPlayer());
    }

    default public pa e(InventoryClickEvent inventoryClickEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)inventoryClickEvent, qm2, itemStack, (Player)inventoryClickEvent.getWhoClicked());
    }

    default public pa a(ProjectileLaunchEvent projectileLaunchEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)projectileLaunchEvent, qm2, itemStack, (Player)projectileLaunchEvent.getEntity().getShooter());
    }

    default public pa a(ProjectileHitEvent projectileHitEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)projectileHitEvent, qm2, itemStack, (Player)projectileHitEvent.getEntity().getShooter());
    }

    default public pa a(PlayerItemHeldEvent playerItemHeldEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerItemHeldEvent, qm2, itemStack, playerItemHeldEvent.getPlayer());
    }

    default public pa a(InventoryDragEvent inventoryDragEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)inventoryDragEvent, qm2, itemStack, (Player)inventoryDragEvent.getWhoClicked());
    }

    default public pa a(PlayerPickupItemEvent playerPickupItemEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerPickupItemEvent, qm2, itemStack, playerPickupItemEvent.getPlayer());
    }

    default public pa a(PlayerBucketEmptyEvent playerBucketEmptyEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerBucketEmptyEvent, playerBucketEmptyEvent.getBlock(), qm2, itemStack, playerBucketEmptyEvent.getPlayer());
    }

    default public pa a(PlayerBucketFillEvent playerBucketFillEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerBucketFillEvent, playerBucketFillEvent.getBlock(), qm2, itemStack, playerBucketFillEvent.getPlayer());
    }

    default public pa a(ArmorEquipEvent armorEquipEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)armorEquipEvent, qm2, itemStack, armorEquipEvent.getPlayer());
    }

    default public pa a(PlayerItemBreakEvent playerItemBreakEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerItemBreakEvent, qm2, itemStack, playerItemBreakEvent.getPlayer());
    }

    default public pa a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerSwapHandItemsEvent, qm2, itemStack, playerSwapHandItemsEvent.getPlayer());
    }

    default public pa a(PlayerEvent playerEvent, qm qm2, ItemStack itemStack) {
        return this.a((Event)playerEvent, qm2, itemStack, playerEvent.getPlayer());
    }

    default public pa b(qf qf2, qm qm2, ItemStack itemStack) {
        return this.a(qf2, qm2, itemStack, qf2.Fi);
    }

    default public pa b(qd qd2, qm qm2, ItemStack itemStack) {
        return this.a(qd2, qm2, itemStack, qd2.Ff);
    }

    default public pa b(qg qg2, qm qm2, ItemStack itemStack) {
        return this.a(qg2, qm2, itemStack, qg2.Fk);
    }

    default public pa a(qe qe2, qm qm2, ItemStack itemStack) {
        return this.a(qe2, qm2, itemStack, qe2.Fh);
    }
}
