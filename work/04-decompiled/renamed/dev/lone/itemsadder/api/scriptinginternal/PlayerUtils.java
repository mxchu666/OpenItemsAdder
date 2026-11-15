package dev.lone.itemsadder.api.scriptinginternal;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.EntityAndBlockEnum;
import itemsadder.m.IaremoveCommand;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerLocationHolder_2;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class PlayerUtils {
    public static boolean isHeld(Player player, String string) {
        ItemStack itemStack = player.getItemInHand();
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        ItemStackBuilder_4 itemStackBuilder_42 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_42 == null) {
            return false;
        }
        return itemStackBuilder_42.l(itemStackBuilder_4);
    }

    public static boolean isHeld(Player player, CustomStack customStack) {
        ItemStack itemStack = player.getItemInHand();
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return itemStackBuilder_4.l(customStack.internal());
    }

    public static boolean isHeld(Player player, Material material) {
        return player.getItemInHand().getType() == material;
    }

    public static boolean setHeld(Player player, String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        player.getInventory().setItemInHand(itemStackBuilder_4.mP());
        return true;
    }

    public static boolean giveItem(Player player, String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_4 == null) {
            Material material = Material.matchMaterial((String)string);
            if (material == null || material == Material.AIR) {
                return false;
            }
            ItemStack itemStack = new ItemStack(material);
            ItemStackBridge_2.f(player, itemStack);
        } else {
            ItemStackBridge_2.f(player, itemStackBuilder_4.mP());
        }
        return true;
    }

    public static boolean removeItem(Player player, String string) {
        ItemStack itemStack;
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_4 == null) {
            Material material = Material.matchMaterial((String)string);
            if (material == null || material == Material.AIR) {
                return false;
            }
            itemStack = new ItemStack(material);
        } else {
            itemStack = itemStackBuilder_4.mP();
        }
        return IaremoveCommand.b(player, itemStack) > 0;
    }

    public static Block blockInFront(Player player) {
        return player.getTargetBlockExact(8);
    }

    public static Block blockInFront(Player player, int n) {
        return player.getTargetBlockExact(n);
    }

    @Nullable
    public static Entity entityInFront(Player player) {
        return PlayerUtils.entityInFront(player, 8);
    }

    @Nullable
    public static Entity entityInFront(Player player, int n) {
        PlayerLocationHolder_2 playerLocationHolder_2 = PlayerLocationHolder_2.a(player, n, 0.02);
        if (playerLocationHolder_2.a(EntityAndBlockEnum.ENTITY) && playerLocationHolder_2.EE()) {
            Entity entity = playerLocationHolder_2.ED();
            return entity;
        }
        return null;
    }
}
