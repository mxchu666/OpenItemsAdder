package itemsadder.m;

import itemsadder.m.Builder_14;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_3;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ItemStackBridge_13
extends Builder_14 {
    public final int CA;

    public ItemStackBridge_13(int n) {
        this.CA = n;
    }

    @Override
    public ItemStackBuilder_3 a(Event event, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack, Player player) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return ItemStackBuilder_3.mk();
        }
        if (!ItemStackBridge_2.aq(itemStack)) {
            Integer n;
            ItemStack itemStack2 = null;
            if (itemStack.getAmount() > 1) {
                itemStack2 = itemStack.clone();
                ItemStackBridge_2.aj(itemStack2);
                itemStack.setAmount(1);
            }
            if ((n = ItemStackBuilder_4.z(itemStack)) == null) {
                return ItemStackBuilder_3.mk();
            }
            if (n - this.CA <= 0) {
                ItemStackBridge_2.aj(itemStack);
                return ItemStackBuilder_3.ml();
            }
            ItemStackBuilder_4.a(itemStack, this.CA);
            if (itemStack2 != null) {
                ItemStackBridge_2.f(player, itemStack2);
            }
            ItemStackBuilder_4.A(itemStack);
        } else {
            Integer n;
            ItemStack itemStack3 = null;
            ItemStack itemStack4 = null;
            boolean bl = false;
            if (itemStack.isSimilar(player.getInventory().getItemInMainHand())) {
                itemStack4 = player.getInventory().getItemInMainHand();
            } else if (itemStack.isSimilar(player.getInventory().getItemInOffHand())) {
                itemStack4 = player.getInventory().getItemInOffHand();
                bl = true;
            }
            itemStack4 = itemStack4.clone();
            if (itemStack4.getAmount() > 1) {
                itemStack3 = itemStack4.clone();
                ItemStackBridge_2.aj(itemStack3);
                itemStack4.setAmount(1);
            }
            if ((n = ItemStackBuilder_4.z(itemStack4)) == null) {
                return ItemStackBuilder_3.mk();
            }
            if (n - this.CA <= 0) {
                ItemStackBridge_2.aj(itemStack4);
                return ItemStackBuilder_3.ml();
            }
            ItemStackBuilder_4.a(itemStack4, this.CA);
            if (itemStack3 != null && itemStack3.getAmount() > 0) {
                ItemStack itemStack5 = itemStack3;
                BukkitTaskBridge.c(() -> ItemStackBridge_2.f(player, itemStack5), 2L);
            }
            ItemStackBuilder_4.A(itemStack4);
            boolean bl2 = bl;
            ItemStack itemStack6 = itemStack4;
            BukkitTaskBridge.c(() -> {
                if (bl2) {
                    player.getInventory().setItemInOffHand(itemStack6);
                } else {
                    player.getInventory().setItemInMainHand(itemStack6);
                }
            }, 1L);
        }
        return ItemStackBuilder_3.ml();
    }

    @Override
    public ItemStackBuilder_3 b(PlayerItemConsumeEvent playerItemConsumeEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return ItemStackBuilder_3.mk();
        }
        EquipmentSlot equipmentSlot = null;
        PlayerInventory playerInventory = playerItemConsumeEvent.getPlayer().getInventory();
        if (ItemStackBuilder_4.e(itemStack, playerInventory.getItemInMainHand())) {
            equipmentSlot = EquipmentSlot.HAND;
        } else if (ItemStackBuilder_4.e(itemStack, playerInventory.getItemInOffHand())) {
            equipmentSlot = EquipmentSlot.OFF_HAND;
        }
        if (equipmentSlot == null) {
            return ItemStackBuilder_3.mk();
        }
        Integer n = ItemStackBuilder_4.z(itemStack);
        if (n == null) {
            return ItemStackBuilder_3.mk();
        }
        if (n - this.CA > 0) {
            ItemStackBuilder_4.a(itemStack, this.CA);
            playerItemConsumeEvent.setCancelled(true);
        } else {
            ItemStackBuilder_4.y(itemStack);
            if (ItemStackBridge_2.aj(itemStack) > 0) {
                playerItemConsumeEvent.setCancelled(true);
            }
        }
        ItemStackBuilder_4.A(itemStack);
        playerItemConsumeEvent.getPlayer().getInventory().setItem(equipmentSlot, itemStack);
        return ItemStackBuilder_3.ml();
    }
}
