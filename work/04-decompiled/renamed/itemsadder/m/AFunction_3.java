package itemsadder.m;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import itemsadder.m.HandlerListItemStackHolder;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackPlayerHolder;
import itemsadder.m.PlayerBlockHolder_2;
import itemsadder.m.PlayerBridge_24;
import itemsadder.m.PlayerEntityHolder;
import itemsadder.m.PlayerEntityHolder_2;
import itemsadder.m.PlayerLivingEntityHolder;
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

public interface AFunction_3 {
    public ItemStackBuilder_3 a(Event var1, ItemStackBuilder_4 var2, ItemStack var3, Player var4);

    default public ItemStackBuilder_3 a(Event event, Block block, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        return this.a(event, itemStackBuilder_4, itemStack, player);
    }

    default public ItemStackBuilder_3 a(BlockBreakEvent blockBreakEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)blockBreakEvent, blockBreakEvent.getBlock(), itemStackBuilder_4, itemStack, blockBreakEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(PlayerBlockHolder_2 playerBlockHolder_2, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a(playerBlockHolder_2, playerBlockHolder_2.getBlock(), itemStackBuilder_4, itemStack, playerBlockHolder_2.getPlayer());
    }

    default public ItemStackBuilder_3 j(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerInteractEvent, playerInteractEvent.getClickedBlock(), itemStackBuilder_4, itemStack, playerInteractEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(EntityDamageByEntityEvent entityDamageByEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)entityDamageByEntityEvent, itemStackBuilder_4, itemStack, (Player)entityDamageByEntityEvent.getDamager());
    }

    default public ItemStackBuilder_3 a(EntityDeathEvent entityDeathEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)entityDeathEvent, itemStackBuilder_4, itemStack, entityDeathEvent.getEntity().getKiller());
    }

    default public ItemStackBuilder_3 a(PlayerInteractEntityEvent playerInteractEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerInteractEntityEvent, itemStackBuilder_4, itemStack, playerInteractEntityEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(PlayerDropItemEvent playerDropItemEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerDropItemEvent, itemStackBuilder_4, itemStack, playerDropItemEvent.getPlayer());
    }

    default public ItemStackBuilder_3 b(ItemStackPlayerHolder itemStackPlayerHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a(itemStackPlayerHolder, itemStackBuilder_4, itemStack, itemStackPlayerHolder.getPlayer());
    }

    default public ItemStackBuilder_3 a(EntityShootBowEvent entityShootBowEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)entityShootBowEvent, itemStackBuilder_4, itemStack, (Player)entityShootBowEvent.getEntity());
    }

    default public ItemStackBuilder_3 a(HandlerListItemStackHolder handlerListItemStackHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)handlerListItemStackHolder, itemStackBuilder_4, itemStack, (Player)handlerListItemStackHolder.getEntity());
    }

    default public ItemStackBuilder_3 b(PlayerItemConsumeEvent playerItemConsumeEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerItemConsumeEvent, itemStackBuilder_4, itemStack, playerItemConsumeEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(FoodLevelChangeEvent foodLevelChangeEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)foodLevelChangeEvent, itemStackBuilder_4, itemStack, (Player)foodLevelChangeEvent.getEntity());
    }

    default public ItemStackBuilder_3 a(PlayerEditBookEvent playerEditBookEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerEditBookEvent, itemStackBuilder_4, itemStack, playerEditBookEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(PlayerFishEvent playerFishEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerFishEvent, itemStackBuilder_4, itemStack, playerFishEvent.getPlayer());
    }

    default public ItemStackBuilder_3 e(InventoryClickEvent inventoryClickEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)inventoryClickEvent, itemStackBuilder_4, itemStack, (Player)inventoryClickEvent.getWhoClicked());
    }

    default public ItemStackBuilder_3 a(ProjectileLaunchEvent projectileLaunchEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)projectileLaunchEvent, itemStackBuilder_4, itemStack, (Player)projectileLaunchEvent.getEntity().getShooter());
    }

    default public ItemStackBuilder_3 a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)projectileHitEvent, itemStackBuilder_4, itemStack, (Player)projectileHitEvent.getEntity().getShooter());
    }

    default public ItemStackBuilder_3 a(PlayerItemHeldEvent playerItemHeldEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerItemHeldEvent, itemStackBuilder_4, itemStack, playerItemHeldEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(InventoryDragEvent inventoryDragEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)inventoryDragEvent, itemStackBuilder_4, itemStack, (Player)inventoryDragEvent.getWhoClicked());
    }

    default public ItemStackBuilder_3 a(PlayerPickupItemEvent playerPickupItemEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerPickupItemEvent, itemStackBuilder_4, itemStack, playerPickupItemEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(PlayerBucketEmptyEvent playerBucketEmptyEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerBucketEmptyEvent, playerBucketEmptyEvent.getBlock(), itemStackBuilder_4, itemStack, playerBucketEmptyEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(PlayerBucketFillEvent playerBucketFillEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerBucketFillEvent, playerBucketFillEvent.getBlock(), itemStackBuilder_4, itemStack, playerBucketFillEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(ArmorEquipEvent armorEquipEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)armorEquipEvent, itemStackBuilder_4, itemStack, armorEquipEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(PlayerItemBreakEvent playerItemBreakEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerItemBreakEvent, itemStackBuilder_4, itemStack, playerItemBreakEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerSwapHandItemsEvent, itemStackBuilder_4, itemStack, playerSwapHandItemsEvent.getPlayer());
    }

    default public ItemStackBuilder_3 a(PlayerEvent playerEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a((Event)playerEvent, itemStackBuilder_4, itemStack, playerEvent.getPlayer());
    }

    default public ItemStackBuilder_3 b(PlayerLivingEntityHolder playerLivingEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a(playerLivingEntityHolder, itemStackBuilder_4, itemStack, playerLivingEntityHolder.Fi);
    }

    default public ItemStackBuilder_3 b(PlayerEntityHolder playerEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a(playerEntityHolder, itemStackBuilder_4, itemStack, playerEntityHolder.Ff);
    }

    default public ItemStackBuilder_3 b(PlayerEntityHolder_2 playerEntityHolder_2, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a(playerEntityHolder_2, itemStackBuilder_4, itemStack, playerEntityHolder_2.Fk);
    }

    default public ItemStackBuilder_3 a(PlayerBridge_24 playerBridge_24, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        return this.a(playerBridge_24, itemStackBuilder_4, itemStack, playerBridge_24.Fh);
    }
}
