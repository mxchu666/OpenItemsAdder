package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.bcp;
import itemsadder.m.ou;
import itemsadder.m.pa;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class nm
extends ou {
    public final int CA;

    public nm(int n) {
        this.CA = n;
    }

    @Override
    public pa a(Event event, qm qm2, ItemStack itemStack, Player player) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return pa.mk();
        }
        if (!bbs.aq(itemStack)) {
            Integer n;
            ItemStack itemStack2 = null;
            if (itemStack.getAmount() > 1) {
                itemStack2 = itemStack.clone();
                bbs.aj(itemStack2);
                itemStack.setAmount(1);
            }
            if ((n = qm.z(itemStack)) == null) {
                return pa.mk();
            }
            if (n - this.CA <= 0) {
                bbs.aj(itemStack);
                return pa.ml();
            }
            qm.a(itemStack, this.CA);
            if (itemStack2 != null) {
                bbs.f(player, itemStack2);
            }
            qm.A(itemStack);
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
                bbs.aj(itemStack3);
                itemStack4.setAmount(1);
            }
            if ((n = qm.z(itemStack4)) == null) {
                return pa.mk();
            }
            if (n - this.CA <= 0) {
                bbs.aj(itemStack4);
                return pa.ml();
            }
            qm.a(itemStack4, this.CA);
            if (itemStack3 != null && itemStack3.getAmount() > 0) {
                ItemStack itemStack5 = itemStack3;
                bcp.c(() -> bbs.f(player, itemStack5), 2L);
            }
            qm.A(itemStack4);
            boolean bl2 = bl;
            ItemStack itemStack6 = itemStack4;
            bcp.c(() -> {
                if (bl2) {
                    player.getInventory().setItemInOffHand(itemStack6);
                } else {
                    player.getInventory().setItemInMainHand(itemStack6);
                }
            }, 1L);
        }
        return pa.ml();
    }

    @Override
    public pa b(PlayerItemConsumeEvent playerItemConsumeEvent, qm qm2, ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return pa.mk();
        }
        EquipmentSlot equipmentSlot = null;
        PlayerInventory playerInventory = playerItemConsumeEvent.getPlayer().getInventory();
        if (qm.e(itemStack, playerInventory.getItemInMainHand())) {
            equipmentSlot = EquipmentSlot.HAND;
        } else if (qm.e(itemStack, playerInventory.getItemInOffHand())) {
            equipmentSlot = EquipmentSlot.OFF_HAND;
        }
        if (equipmentSlot == null) {
            return pa.mk();
        }
        Integer n = qm.z(itemStack);
        if (n == null) {
            return pa.mk();
        }
        if (n - this.CA > 0) {
            qm.a(itemStack, this.CA);
            playerItemConsumeEvent.setCancelled(true);
        } else {
            qm.y(itemStack);
            if (bbs.aj(itemStack) > 0) {
                playerItemConsumeEvent.setCancelled(true);
            }
        }
        qm.A(itemStack);
        playerItemConsumeEvent.getPlayer().getInventory().setItem(equipmentSlot, itemStack);
        return pa.ml();
    }
}
