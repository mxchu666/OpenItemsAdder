package itemsadder.m;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import com.jeff_media.armorequipevent.ArmorType;
import itemsadder.m.lg;
import itemsadder.m.qd;
import itemsadder.m.qf;
import itemsadder.m.qg;
import itemsadder.m.qm;
import itemsadder.m.zi;
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

public final class jj
extends Enum {
    public static final /* enum */ jj BLOCK_BREAK = new jj("BLOCK_BREAK", 0, "block_break");
    public static final /* enum */ jj ATTACK = new jj("ATTACK", 1, "attack");
    public static final /* enum */ jj KILL = new jj("KILL", 2, "kill");
    public static final /* enum */ jj INTERACT_ENTITY = new jj("INTERACT_ENTITY", 3, "interact.entity");
    public static final /* enum */ jj INTERACT_LEFT = new jj("INTERACT_LEFT", 4, "interact.left");
    public static final /* enum */ jj INTERACT_LEFT_SHIFT = new jj("INTERACT_LEFT_SHIFT", 5, "interact.left_shift");
    public static final /* enum */ jj INTERACT_RIGHT = new jj("INTERACT_RIGHT", 6, "interact.right");
    public static final /* enum */ jj INTERACT_RIGHT_SHIFT = new jj("INTERACT_RIGHT_SHIFT", 7, "interact.right_shift");
    public static final /* enum */ jj INTERACT_MAINHAND_LEFT = new jj("INTERACT_MAINHAND_LEFT", 8, "interact_mainhand.left");
    public static final /* enum */ jj INTERACT_MAINHAND_LEFT_SHIFT = new jj("INTERACT_MAINHAND_LEFT_SHIFT", 9, "interact_mainhand.left_shift");
    public static final /* enum */ jj INTERACT_MAINHAND_RIGHT = new jj("INTERACT_MAINHAND_RIGHT", 10, "interact_mainhand.right");
    public static final /* enum */ jj INTERACT_MAINHAND_RIGHT_SHIFT = new jj("INTERACT_MAINHAND_RIGHT_SHIFT", 11, "interact_mainhand.right_shift");
    public static final /* enum */ jj INTERACT_OFFHAND_LEFT = new jj("INTERACT_OFFHAND_LEFT", 12, "interact_offhand.left");
    public static final /* enum */ jj INTERACT_OFFHAND_LEFT_SHIFT = new jj("INTERACT_OFFHAND_LEFT_SHIFT", 13, "interact_offhand.left_shift");
    public static final /* enum */ jj INTERACT_OFFHAND_RIGHT = new jj("INTERACT_OFFHAND_RIGHT", 14, "interact_offhand.right");
    public static final /* enum */ jj INTERACT_OFFHAND_RIGHT_SHIFT = new jj("INTERACT_OFFHAND_RIGHT_SHIFT", 15, "interact_offhand.right_shift");
    public static final /* enum */ jj DROP = new jj("DROP", 16, "drop");
    public static final /* enum */ jj PICKUP = new jj("PICKUP", 17, "pickup");
    public static final /* enum */ jj EAT = new jj("EAT", 18, "eat");
    public static final /* enum */ jj DRINK = new jj("DRINK", 19, "drink");
    public static final /* enum */ jj BOW_SHOT = new jj("BOW_SHOT", 20, "bow_shot");
    public static final /* enum */ jj GUN_SHOT = new jj("GUN_SHOT", 21, "gun_shot");
    public static final /* enum */ jj GUN_NO_AMMO = new jj("GUN_NO_AMMO", 22, "gun_no_ammo");
    public static final /* enum */ jj GUN_RELOAD = new jj("GUN_RELOAD", 23, "gun_reload");
    public static final /* enum */ jj BOOK_WRITE = new jj("BOOK_WRITE", 24, "book_write");
    public static final /* enum */ jj BOOK_READ = new jj("BOOK_READ", 25, "book_read");
    public static final /* enum */ jj FISHING_START = new jj("FISHING_START", 26, "fishing_start");
    public static final /* enum */ jj FISHING_CAUGHT = new jj("FISHING_CAUGHT", 27, "fishing_caught");
    public static final /* enum */ jj FISHING_FAILED = new jj("FISHING_FAILED", 28, "fishing_failed");
    public static final /* enum */ jj FISHING_CANCEL = new jj("FISHING_CANCEL", 29, "fishing_cancel");
    public static final /* enum */ jj FISHING_BITE = new jj("FISHING_BITE", 30, "fishing_bite");
    public static final /* enum */ jj FISHING_IN_GROUND = new jj("FISHING_IN_GROUND", 31, "fishing_in_ground");
    public static final /* enum */ jj WEAR = new jj("WEAR", 32, "wear");
    public static final /* enum */ jj UNWEAR = new jj("UNWEAR", 33, "unwear");
    public static final /* enum */ jj HELD = new jj("HELD", 34, "held");
    public static final /* enum */ jj UNHELD = new jj("UNHELD", 35, "unheld");
    public static final /* enum */ jj HELD_OFFHAND = new jj("HELD_OFFHAND", 36, "held_offhand");
    public static final /* enum */ jj UNHELD_OFFHAND = new jj("UNHELD_OFFHAND", 37, "unheld_offhand");
    public static final /* enum */ jj ITEM_THROW = new jj("ITEM_THROW", 38, "item_throw");
    public static final /* enum */ jj ITEM_HIT_GROUND = new jj("ITEM_HIT_GROUND", 39, "item_hit_ground");
    public static final /* enum */ jj ITEM_HIT_ENTITY = new jj("ITEM_HIT_ENTITY", 40, "item_hit_entity");
    public static final /* enum */ jj ITEM_BREAK = new jj("ITEM_BREAK", 41, "item_break");
    public static final /* enum */ jj GLIDE_START = new jj("GLIDE_START", 42, "glide_start");
    public static final /* enum */ jj GLIDE_STOP = new jj("GLIDE_STOP", 43, "glide_stop");
    public static final /* enum */ jj ELYTRA_BOOST = new jj("ELYTRA_BOOST", 44, "elytra_boost");
    public static final /* enum */ jj ELYTRA_COLLISION = new jj("ELYTRA_COLLISION", 45, "elytra_collision");
    public static final /* enum */ jj PLACED_BLOCK_INTERACT = new jj("PLACED_BLOCK_INTERACT", 46, "placed_block.interact");
    public static final /* enum */ jj PLACED_BLOCK_BREAK = new jj("PLACED_BLOCK_BREAK", 47, "placed_block.break");
    public static final /* enum */ jj PLACED_FURNITURE_INTERACT = new jj("PLACED_FURNITURE_INTERACT", 48, "placed_furniture.interact");
    public static final /* enum */ jj PLACED_FURNITURE_BREAK = new jj("PLACED_FURNITURE_BREAK", 49, "placed_furniture.break");
    @Deprecated
    public static final /* enum */ jj PLACED_ARMORSTAND_INTERACT = new jj("PLACED_ARMORSTAND_INTERACT", 50, "placed_armorstand.interact");
    @Deprecated
    public static final /* enum */ jj PLACED_ARMORSTAND_BREAK = new jj("PLACED_ARMORSTAND_BREAK", 51, "placed_armorstand.break");
    @Deprecated
    public static final /* enum */ jj PLACED_ITEMFRAME_INTERACT = new jj("PLACED_ITEMFRAME_INTERACT", 52, "placed_itemframe.interact");
    @Deprecated
    public static final /* enum */ jj PLACED_ITEMFRAME_BREAK = new jj("PLACED_ITEMFRAME_BREAK", 53, "placed_itemframe.break");
    public static final /* enum */ jj ITEM_FRAME_PUT_ITEM = new jj("ITEM_FRAME_PUT_ITEM", 54, "item_frame.put_item");
    public static final /* enum */ jj ITEM_FRAME_REMOVE_ITEM = new jj("ITEM_FRAME_REMOVE_ITEM", 55, "item_frame.remove_item");
    public static final /* enum */ jj ARMOR_STAND_PUT_ITEM = new jj("ARMOR_STAND_PUT_ITEM", 56, "armor_stand.put_item");
    public static final /* enum */ jj ARMOR_STAND_REMOVE_ITEM = new jj("ARMOR_STAND_REMOVE_ITEM", 57, "armor_stand.remove_item");
    public static final /* enum */ jj HOLDING_ITEM_PLAYER_DAMAGED_BY_ENTITY = new jj("HOLDING_ITEM_PLAYER_DAMAGED_BY_ENTITY", 58, "holding_item.player_damaged_by_entity");
    public static final /* enum */ jj HOLDING_ITEM_OFFHAND_PLAYER_DAMAGED_BY_ENTITY = new jj("HOLDING_ITEM_OFFHAND_PLAYER_DAMAGED_BY_ENTITY", 59, "holding_item_offhand.player_damaged_by_entity");
    public static final /* enum */ jj EQUIPPED_ARMOR_ITEM_PLAYER_DAMAGED_BY_ENTITY = new jj("EQUIPPED_ARMOR_ITEM_PLAYER_DAMAGED_BY_ENTITY", 60, "equipped_armor_item.player_damaged_by_entity");
    public static final /* enum */ jj BUCKET_EMPTY = new jj("BUCKET_EMPTY", 61, "bucket_empty");
    public static final /* enum */ jj BUCKET_FILL = new jj("BUCKET_FILL", 62, "bucket_fill");
    private final String text;
    private static final /* synthetic */ jj[] $VALUES;

    public static jj[] values() {
        return (jj[])$VALUES.clone();
    }

    public static jj valueOf(String string) {
        return Enum.valueOf(jj.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private jj() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    @Nullable
    public static EquipmentSlot a(ItemStack itemStack, jj jj2) {
        switch (jj2.ordinal()) {
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

    public void a(BlockBreakEvent blockBreakEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(blockBreakEvent, qm2, itemStack));
    }

    public void a(lg lg2, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(lg2, qm2, itemStack));
    }

    public void a(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.j(playerInteractEvent, qm2, itemStack));
    }

    public void a(EntityDamageByEntityEvent entityDamageByEntityEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(entityDamageByEntityEvent, qm2, itemStack));
    }

    public void a(EntityDeathEvent entityDeathEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(entityDeathEvent, qm2, itemStack));
    }

    public void a(PlayerInteractEntityEvent playerInteractEntityEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerInteractEntityEvent, qm2, itemStack));
    }

    public void a(PlayerDropItemEvent playerDropItemEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerDropItemEvent, qm2, itemStack));
    }

    public void a(EntityShootBowEvent entityShootBowEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(entityShootBowEvent, qm2, itemStack));
    }

    public void a(zi zi2, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(zi2, qm2, itemStack));
    }

    public void a(PlayerItemConsumeEvent playerItemConsumeEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.b(playerItemConsumeEvent, qm2, itemStack));
    }

    public void a(FoodLevelChangeEvent foodLevelChangeEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(foodLevelChangeEvent, qm2, itemStack));
    }

    public void a(PlayerEditBookEvent playerEditBookEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerEditBookEvent, qm2, itemStack));
    }

    public void a(PlayerFishEvent playerFishEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerFishEvent, qm2, itemStack));
    }

    public void a(InventoryClickEvent inventoryClickEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.e(inventoryClickEvent, qm2, itemStack));
    }

    public void a(ProjectileLaunchEvent projectileLaunchEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(projectileLaunchEvent, qm2, itemStack));
    }

    public void a(ProjectileHitEvent projectileHitEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(projectileHitEvent, qm2, itemStack));
    }

    public void a(PlayerItemHeldEvent playerItemHeldEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerItemHeldEvent, qm2, itemStack));
    }

    public void a(InventoryDragEvent inventoryDragEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(inventoryDragEvent, qm2, itemStack));
    }

    public void a(PlayerPickupItemEvent playerPickupItemEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerPickupItemEvent, qm2, itemStack));
    }

    public void a(PlayerBucketEmptyEvent playerBucketEmptyEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerBucketEmptyEvent, qm2, itemStack));
    }

    public void a(PlayerBucketFillEvent playerBucketFillEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerBucketFillEvent, qm2, itemStack));
    }

    public void a(ArmorEquipEvent armorEquipEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(armorEquipEvent, qm2, itemStack));
    }

    public void a(PlayerItemBreakEvent playerItemBreakEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerItemBreakEvent, qm2, itemStack));
    }

    public void a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerSwapHandItemsEvent, qm2, itemStack));
    }

    public void a(PlayerEvent playerEvent, qm qm2, ItemStack itemStack, Player player) {
        qm2.a((LivingEntity)player, this, (Object ou2) -> ou2.a(playerEvent, qm2, itemStack));
    }

    public void a(qf qf2, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)qf2.Fi, this, (Object ou2) -> ou2.b(qf2, qm2, itemStack));
    }

    public void a(qd qd2, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)qd2.Ff, this, (Object ou2) -> ou2.b(qd2, qm2, itemStack));
    }

    public void a(qg qg2, qm qm2, ItemStack itemStack) {
        qm2.a((LivingEntity)qg2.Fk, this, (Object ou2) -> ou2.b(qg2, qm2, itemStack));
    }

    private static /* synthetic */ jj[] kA() {
        return new jj[]{BLOCK_BREAK, ATTACK, KILL, INTERACT_ENTITY, INTERACT_LEFT, INTERACT_LEFT_SHIFT, INTERACT_RIGHT, INTERACT_RIGHT_SHIFT, INTERACT_MAINHAND_LEFT, INTERACT_MAINHAND_LEFT_SHIFT, INTERACT_MAINHAND_RIGHT, INTERACT_MAINHAND_RIGHT_SHIFT, INTERACT_OFFHAND_LEFT, INTERACT_OFFHAND_LEFT_SHIFT, INTERACT_OFFHAND_RIGHT, INTERACT_OFFHAND_RIGHT_SHIFT, DROP, PICKUP, EAT, DRINK, BOW_SHOT, GUN_SHOT, GUN_NO_AMMO, GUN_RELOAD, BOOK_WRITE, BOOK_READ, FISHING_START, FISHING_CAUGHT, FISHING_FAILED, FISHING_CANCEL, FISHING_BITE, FISHING_IN_GROUND, WEAR, UNWEAR, HELD, UNHELD, HELD_OFFHAND, UNHELD_OFFHAND, ITEM_THROW, ITEM_HIT_GROUND, ITEM_HIT_ENTITY, ITEM_BREAK, GLIDE_START, GLIDE_STOP, ELYTRA_BOOST, ELYTRA_COLLISION, PLACED_BLOCK_INTERACT, PLACED_BLOCK_BREAK, PLACED_FURNITURE_INTERACT, PLACED_FURNITURE_BREAK, PLACED_ARMORSTAND_INTERACT, PLACED_ARMORSTAND_BREAK, PLACED_ITEMFRAME_INTERACT, PLACED_ITEMFRAME_BREAK, ITEM_FRAME_PUT_ITEM, ITEM_FRAME_REMOVE_ITEM, ARMOR_STAND_PUT_ITEM, ARMOR_STAND_REMOVE_ITEM, HOLDING_ITEM_PLAYER_DAMAGED_BY_ENTITY, HOLDING_ITEM_OFFHAND_PLAYER_DAMAGED_BY_ENTITY, EQUIPPED_ARMOR_ITEM_PLAYER_DAMAGED_BY_ENTITY, BUCKET_EMPTY, BUCKET_FILL};
    }

    static {
        $VALUES = jj.kA();
    }
}
