package itemsadder.m;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import com.jeff_media.armorequipevent.ArmorType;
import itemsadder.m.HandlerListItemStackHolder;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PlayerBlockHolder_2;
import itemsadder.m.PlayerEntityHolder;
import itemsadder.m.PlayerEntityHolder_2;
import itemsadder.m.PlayerLivingEntityHolder;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
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
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public final class BlockBreakEnum
extends Enum {
    public static final /* enum */ BlockBreakEnum BLOCK_BREAK = new BlockBreakEnum("BLOCK_BREAK", 0, "block_break");
    public static final /* enum */ BlockBreakEnum ATTACK = new BlockBreakEnum("ATTACK", 1, "attack");
    public static final /* enum */ BlockBreakEnum KILL = new BlockBreakEnum("KILL", 2, "kill");
    public static final /* enum */ BlockBreakEnum INTERACT_ENTITY = new BlockBreakEnum("INTERACT_ENTITY", 3, "interact.entity");
    public static final /* enum */ BlockBreakEnum INTERACT_LEFT = new BlockBreakEnum("INTERACT_LEFT", 4, "interact.left");
    public static final /* enum */ BlockBreakEnum INTERACT_LEFT_SHIFT = new BlockBreakEnum("INTERACT_LEFT_SHIFT", 5, "interact.left_shift");
    public static final /* enum */ BlockBreakEnum INTERACT_RIGHT = new BlockBreakEnum("INTERACT_RIGHT", 6, "interact.right");
    public static final /* enum */ BlockBreakEnum INTERACT_RIGHT_SHIFT = new BlockBreakEnum("INTERACT_RIGHT_SHIFT", 7, "interact.right_shift");
    public static final /* enum */ BlockBreakEnum INTERACT_MAINHAND_LEFT = new BlockBreakEnum("INTERACT_MAINHAND_LEFT", 8, "interact_mainhand.left");
    public static final /* enum */ BlockBreakEnum INTERACT_MAINHAND_LEFT_SHIFT = new BlockBreakEnum("INTERACT_MAINHAND_LEFT_SHIFT", 9, "interact_mainhand.left_shift");
    public static final /* enum */ BlockBreakEnum INTERACT_MAINHAND_RIGHT = new BlockBreakEnum("INTERACT_MAINHAND_RIGHT", 10, "interact_mainhand.right");
    public static final /* enum */ BlockBreakEnum INTERACT_MAINHAND_RIGHT_SHIFT = new BlockBreakEnum("INTERACT_MAINHAND_RIGHT_SHIFT", 11, "interact_mainhand.right_shift");
    public static final /* enum */ BlockBreakEnum INTERACT_OFFHAND_LEFT = new BlockBreakEnum("INTERACT_OFFHAND_LEFT", 12, "interact_offhand.left");
    public static final /* enum */ BlockBreakEnum INTERACT_OFFHAND_LEFT_SHIFT = new BlockBreakEnum("INTERACT_OFFHAND_LEFT_SHIFT", 13, "interact_offhand.left_shift");
    public static final /* enum */ BlockBreakEnum INTERACT_OFFHAND_RIGHT = new BlockBreakEnum("INTERACT_OFFHAND_RIGHT", 14, "interact_offhand.right");
    public static final /* enum */ BlockBreakEnum INTERACT_OFFHAND_RIGHT_SHIFT = new BlockBreakEnum("INTERACT_OFFHAND_RIGHT_SHIFT", 15, "interact_offhand.right_shift");
    public static final /* enum */ BlockBreakEnum DROP = new BlockBreakEnum("DROP", 16, "drop");
    public static final /* enum */ BlockBreakEnum PICKUP = new BlockBreakEnum("PICKUP", 17, "pickup");
    public static final /* enum */ BlockBreakEnum EAT = new BlockBreakEnum("EAT", 18, "eat");
    public static final /* enum */ BlockBreakEnum DRINK = new BlockBreakEnum("DRINK", 19, "drink");
    public static final /* enum */ BlockBreakEnum BOW_SHOT = new BlockBreakEnum("BOW_SHOT", 20, "bow_shot");
    public static final /* enum */ BlockBreakEnum GUN_SHOT = new BlockBreakEnum("GUN_SHOT", 21, "gun_shot");
    public static final /* enum */ BlockBreakEnum GUN_NO_AMMO = new BlockBreakEnum("GUN_NO_AMMO", 22, "gun_no_ammo");
    public static final /* enum */ BlockBreakEnum GUN_RELOAD = new BlockBreakEnum("GUN_RELOAD", 23, "gun_reload");
    public static final /* enum */ BlockBreakEnum BOOK_WRITE = new BlockBreakEnum("BOOK_WRITE", 24, "book_write");
    public static final /* enum */ BlockBreakEnum BOOK_READ = new BlockBreakEnum("BOOK_READ", 25, "book_read");
    public static final /* enum */ BlockBreakEnum FISHING_START = new BlockBreakEnum("FISHING_START", 26, "fishing_start");
    public static final /* enum */ BlockBreakEnum FISHING_CAUGHT = new BlockBreakEnum("FISHING_CAUGHT", 27, "fishing_caught");
    public static final /* enum */ BlockBreakEnum FISHING_FAILED = new BlockBreakEnum("FISHING_FAILED", 28, "fishing_failed");
    public static final /* enum */ BlockBreakEnum FISHING_CANCEL = new BlockBreakEnum("FISHING_CANCEL", 29, "fishing_cancel");
    public static final /* enum */ BlockBreakEnum FISHING_BITE = new BlockBreakEnum("FISHING_BITE", 30, "fishing_bite");
    public static final /* enum */ BlockBreakEnum FISHING_IN_GROUND = new BlockBreakEnum("FISHING_IN_GROUND", 31, "fishing_in_ground");
    public static final /* enum */ BlockBreakEnum WEAR = new BlockBreakEnum("WEAR", 32, "wear");
    public static final /* enum */ BlockBreakEnum UNWEAR = new BlockBreakEnum("UNWEAR", 33, "unwear");
    public static final /* enum */ BlockBreakEnum HELD = new BlockBreakEnum("HELD", 34, "held");
    public static final /* enum */ BlockBreakEnum UNHELD = new BlockBreakEnum("UNHELD", 35, "unheld");
    public static final /* enum */ BlockBreakEnum HELD_OFFHAND = new BlockBreakEnum("HELD_OFFHAND", 36, "held_offhand");
    public static final /* enum */ BlockBreakEnum UNHELD_OFFHAND = new BlockBreakEnum("UNHELD_OFFHAND", 37, "unheld_offhand");
    public static final /* enum */ BlockBreakEnum ITEM_THROW = new BlockBreakEnum("ITEM_THROW", 38, "item_throw");
    public static final /* enum */ BlockBreakEnum ITEM_HIT_GROUND = new BlockBreakEnum("ITEM_HIT_GROUND", 39, "item_hit_ground");
    public static final /* enum */ BlockBreakEnum ITEM_HIT_ENTITY = new BlockBreakEnum("ITEM_HIT_ENTITY", 40, "item_hit_entity");
    public static final /* enum */ BlockBreakEnum ITEM_BREAK = new BlockBreakEnum("ITEM_BREAK", 41, "item_break");
    public static final /* enum */ BlockBreakEnum GLIDE_START = new BlockBreakEnum("GLIDE_START", 42, "glide_start");
    public static final /* enum */ BlockBreakEnum GLIDE_STOP = new BlockBreakEnum("GLIDE_STOP", 43, "glide_stop");
    public static final /* enum */ BlockBreakEnum ELYTRA_BOOST = new BlockBreakEnum("ELYTRA_BOOST", 44, "elytra_boost");
    public static final /* enum */ BlockBreakEnum ELYTRA_COLLISION = new BlockBreakEnum("ELYTRA_COLLISION", 45, "elytra_collision");
    public static final /* enum */ BlockBreakEnum PLACED_BLOCK_INTERACT = new BlockBreakEnum("PLACED_BLOCK_INTERACT", 46, "placed_block.interact");
    public static final /* enum */ BlockBreakEnum PLACED_BLOCK_BREAK = new BlockBreakEnum("PLACED_BLOCK_BREAK", 47, "placed_block.break");
    public static final /* enum */ BlockBreakEnum PLACED_FURNITURE_INTERACT = new BlockBreakEnum("PLACED_FURNITURE_INTERACT", 48, "placed_furniture.interact");
    public static final /* enum */ BlockBreakEnum PLACED_FURNITURE_BREAK = new BlockBreakEnum("PLACED_FURNITURE_BREAK", 49, "placed_furniture.break");
    @Deprecated
    public static final /* enum */ BlockBreakEnum PLACED_ARMORSTAND_INTERACT = new BlockBreakEnum("PLACED_ARMORSTAND_INTERACT", 50, "placed_armorstand.interact");
    @Deprecated
    public static final /* enum */ BlockBreakEnum PLACED_ARMORSTAND_BREAK = new BlockBreakEnum("PLACED_ARMORSTAND_BREAK", 51, "placed_armorstand.break");
    @Deprecated
    public static final /* enum */ BlockBreakEnum PLACED_ITEMFRAME_INTERACT = new BlockBreakEnum("PLACED_ITEMFRAME_INTERACT", 52, "placed_itemframe.interact");
    @Deprecated
    public static final /* enum */ BlockBreakEnum PLACED_ITEMFRAME_BREAK = new BlockBreakEnum("PLACED_ITEMFRAME_BREAK", 53, "placed_itemframe.break");
    public static final /* enum */ BlockBreakEnum ITEM_FRAME_PUT_ITEM = new BlockBreakEnum("ITEM_FRAME_PUT_ITEM", 54, "item_frame.put_item");
    public static final /* enum */ BlockBreakEnum ITEM_FRAME_REMOVE_ITEM = new BlockBreakEnum("ITEM_FRAME_REMOVE_ITEM", 55, "item_frame.remove_item");
    public static final /* enum */ BlockBreakEnum ARMOR_STAND_PUT_ITEM = new BlockBreakEnum("ARMOR_STAND_PUT_ITEM", 56, "armor_stand.put_item");
    public static final /* enum */ BlockBreakEnum ARMOR_STAND_REMOVE_ITEM = new BlockBreakEnum("ARMOR_STAND_REMOVE_ITEM", 57, "armor_stand.remove_item");
    public static final /* enum */ BlockBreakEnum HOLDING_ITEM_PLAYER_DAMAGED_BY_ENTITY = new BlockBreakEnum("HOLDING_ITEM_PLAYER_DAMAGED_BY_ENTITY", 58, "holding_item.player_damaged_by_entity");
    public static final /* enum */ BlockBreakEnum HOLDING_ITEM_OFFHAND_PLAYER_DAMAGED_BY_ENTITY = new BlockBreakEnum("HOLDING_ITEM_OFFHAND_PLAYER_DAMAGED_BY_ENTITY", 59, "holding_item_offhand.player_damaged_by_entity");
    public static final /* enum */ BlockBreakEnum EQUIPPED_ARMOR_ITEM_PLAYER_DAMAGED_BY_ENTITY = new BlockBreakEnum("EQUIPPED_ARMOR_ITEM_PLAYER_DAMAGED_BY_ENTITY", 60, "equipped_armor_item.player_damaged_by_entity");
    public static final /* enum */ BlockBreakEnum BUCKET_EMPTY = new BlockBreakEnum("BUCKET_EMPTY", 61, "bucket_empty");
    public static final /* enum */ BlockBreakEnum BUCKET_FILL = new BlockBreakEnum("BUCKET_FILL", 62, "bucket_fill");
    private final String text;
    private static final /* synthetic */ BlockBreakEnum[] $VALUES;

    public static BlockBreakEnum[] values() {
        return (BlockBreakEnum[])$VALUES.clone();
    }

    public static BlockBreakEnum valueOf(String string) {
        return Enum.valueOf(BlockBreakEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BlockBreakEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    @Nullable
    public static EquipmentSlot a(ItemStack itemStack, BlockBreakEnum blockBreakEnum) {
        switch (blockBreakEnum.ordinal()) {
            case 34: 
            case 35: {
                return EquipmentSlot.HAND;
            }
            case 36: 
            case 37: {
                return EquipmentSlot.OFF_HAND;
            }
            case 32: 
            case 33: {
                ArmorType armorType = ArmorType.matchType((ItemStack)itemStack);
                if (armorType == null) {
                    return EquipmentSlot.HEAD;
                }
                return switch (armorType) {
                    default -> throw new MatchException(null, null);
                    case ArmorType.HELMET -> EquipmentSlot.HEAD;
                    case ArmorType.CHESTPLATE -> EquipmentSlot.CHEST;
                    case ArmorType.LEGGINGS -> EquipmentSlot.LEGS;
                    case ArmorType.BOOTS -> EquipmentSlot.FEET;
                };
            }
        }
        return null;
    }

    public void a(BlockBreakEvent blockBreakEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(blockBreakEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerBlockHolder_2 playerBlockHolder_2, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerBlockHolder_2, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.j(playerInteractEvent, itemStackBuilder_4, itemStack));
    }

    public void a(EntityDamageByEntityEvent entityDamageByEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(entityDamageByEntityEvent, itemStackBuilder_4, itemStack));
    }

    public void a(EntityDeathEvent entityDeathEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(entityDeathEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerInteractEntityEvent playerInteractEntityEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerInteractEntityEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerDropItemEvent playerDropItemEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerDropItemEvent, itemStackBuilder_4, itemStack));
    }

    public void a(EntityShootBowEvent entityShootBowEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(entityShootBowEvent, itemStackBuilder_4, itemStack));
    }

    public void a(HandlerListItemStackHolder handlerListItemStackHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(handlerListItemStackHolder, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerItemConsumeEvent playerItemConsumeEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.b(playerItemConsumeEvent, itemStackBuilder_4, itemStack));
    }

    public void a(FoodLevelChangeEvent foodLevelChangeEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(foodLevelChangeEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerEditBookEvent playerEditBookEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerEditBookEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerFishEvent playerFishEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerFishEvent, itemStackBuilder_4, itemStack));
    }

    public void a(InventoryClickEvent inventoryClickEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.e(inventoryClickEvent, itemStackBuilder_4, itemStack));
    }

    public void a(ProjectileLaunchEvent projectileLaunchEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(projectileLaunchEvent, itemStackBuilder_4, itemStack));
    }

    public void a(ProjectileHitEvent projectileHitEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(projectileHitEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerItemHeldEvent playerItemHeldEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerItemHeldEvent, itemStackBuilder_4, itemStack));
    }

    public void a(InventoryDragEvent inventoryDragEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(inventoryDragEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerPickupItemEvent playerPickupItemEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerPickupItemEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerBucketEmptyEvent playerBucketEmptyEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerBucketEmptyEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerBucketFillEvent playerBucketFillEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerBucketFillEvent, itemStackBuilder_4, itemStack));
    }

    public void a(ArmorEquipEvent armorEquipEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(armorEquipEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerItemBreakEvent playerItemBreakEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerItemBreakEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerSwapHandItemsEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerEvent playerEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        itemStackBuilder_4.a((LivingEntity)player, this, (Object builder_14) -> builder_14.a(playerEvent, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerLivingEntityHolder playerLivingEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerLivingEntityHolder.Fi, this, (Object builder_14) -> builder_14.b(playerLivingEntityHolder, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerEntityHolder playerEntityHolder, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerEntityHolder.Ff, this, (Object builder_14) -> builder_14.b(playerEntityHolder, itemStackBuilder_4, itemStack));
    }

    public void a(PlayerEntityHolder_2 playerEntityHolder_2, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        itemStackBuilder_4.a((LivingEntity)playerEntityHolder_2.Fk, this, (Object builder_14) -> builder_14.b(playerEntityHolder_2, itemStackBuilder_4, itemStack));
    }

    private static /* synthetic */ BlockBreakEnum[] kA() {
        return new BlockBreakEnum[]{BLOCK_BREAK, ATTACK, KILL, INTERACT_ENTITY, INTERACT_LEFT, INTERACT_LEFT_SHIFT, INTERACT_RIGHT, INTERACT_RIGHT_SHIFT, INTERACT_MAINHAND_LEFT, INTERACT_MAINHAND_LEFT_SHIFT, INTERACT_MAINHAND_RIGHT, INTERACT_MAINHAND_RIGHT_SHIFT, INTERACT_OFFHAND_LEFT, INTERACT_OFFHAND_LEFT_SHIFT, INTERACT_OFFHAND_RIGHT, INTERACT_OFFHAND_RIGHT_SHIFT, DROP, PICKUP, EAT, DRINK, BOW_SHOT, GUN_SHOT, GUN_NO_AMMO, GUN_RELOAD, BOOK_WRITE, BOOK_READ, FISHING_START, FISHING_CAUGHT, FISHING_FAILED, FISHING_CANCEL, FISHING_BITE, FISHING_IN_GROUND, WEAR, UNWEAR, HELD, UNHELD, HELD_OFFHAND, UNHELD_OFFHAND, ITEM_THROW, ITEM_HIT_GROUND, ITEM_HIT_ENTITY, ITEM_BREAK, GLIDE_START, GLIDE_STOP, ELYTRA_BOOST, ELYTRA_COLLISION, PLACED_BLOCK_INTERACT, PLACED_BLOCK_BREAK, PLACED_FURNITURE_INTERACT, PLACED_FURNITURE_BREAK, PLACED_ARMORSTAND_INTERACT, PLACED_ARMORSTAND_BREAK, PLACED_ITEMFRAME_INTERACT, PLACED_ITEMFRAME_BREAK, ITEM_FRAME_PUT_ITEM, ITEM_FRAME_REMOVE_ITEM, ARMOR_STAND_PUT_ITEM, ARMOR_STAND_REMOVE_ITEM, HOLDING_ITEM_PLAYER_DAMAGED_BY_ENTITY, HOLDING_ITEM_OFFHAND_PLAYER_DAMAGED_BY_ENTITY, EQUIPPED_ARMOR_ITEM_PLAYER_DAMAGED_BY_ENTITY, BUCKET_EMPTY, BUCKET_FILL};
    }

    static {
        $VALUES = BlockBreakEnum.kA();
    }
}
