package dev.lone.itemsadder.api.scriptinginternal;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.bbs;
import itemsadder.m.bfo;
import itemsadder.m.bfp;
import itemsadder.m.d;
import itemsadder.m.qm;
import itemsadder.m.yq;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class PlayerUtils {
    public static boolean isHeld(Player player, String string) {
        ItemStack itemStack = player.getItemInHand();
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return false;
        }
        qm qm3 = d.g().e(string);
        if (qm3 == null) {
            return false;
        }
        return qm3.l(qm2);
    }

    public static boolean isHeld(Player player, CustomStack customStack) {
        ItemStack itemStack = player.getItemInHand();
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return false;
        }
        return qm2.l(customStack.internal());
    }

    public static boolean isHeld(Player player, Material material) {
        return player.getItemInHand().getType() == material;
    }

    public static boolean setHeld(Player player, String string) {
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            return false;
        }
        player.getInventory().setItemInHand(qm2.mP());
        return true;
    }

    public static boolean giveItem(Player player, String string) {
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            Material material = Material.matchMaterial((String)string);
            if (material == null || material == Material.AIR) {
                return false;
            }
            ItemStack itemStack = new ItemStack(material);
            bbs.f(player, itemStack);
        } else {
            bbs.f(player, qm2.mP());
        }
        return true;
    }

    public static boolean removeItem(Player player, String string) {
        ItemStack itemStack;
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            Material material = Material.matchMaterial((String)string);
            if (material == null || material == Material.AIR) {
                return false;
            }
            itemStack = new ItemStack(material);
        } else {
            itemStack = qm2.mP();
        }
        return yq.b(player, itemStack) > 0;
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
        bfo bfo2 = bfo.a(player, n, 0.02);
        if (bfo2.a(bfp.ENTITY) && bfo2.EE()) {
            Entity entity = bfo2.ED();
            return entity;
        }
        return null;
    }
}
