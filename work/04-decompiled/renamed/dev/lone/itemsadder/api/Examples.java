package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.CustomCrop;
import dev.lone.itemsadder.api.CustomMob;
import dev.lone.itemsadder.api.CustomStack;
import dev.lone.itemsadder.api.Events.CustomEntityDeathEvent;
import dev.lone.itemsadder.api.ItemsAdder;
import itemsadder.m.PluginContract;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;

public class Examples
implements PluginContract {
    @EventHandler
    void test(CustomEntityDeathEvent customEntityDeathEvent) {
        System.out.println(customEntityDeathEvent.getKiller().getName() + " killed " + customEntityDeathEvent.getNamespacedID());
        Player player = customEntityDeathEvent.getKiller();
        CustomStack customStack = CustomStack.byItemStack(player.getItemInHand());
        if (customStack == null) {
            System.out.println("killed using: " + String.valueOf(player.getItemInHand().getType()) + " (non custom item)");
            return;
        }
        System.out.println("killed using: " + customStack.getNamespacedID());
        System.out.println("       model_path:    " + customStack.getModelPath());
        System.out.println("       config_path:   " + customStack.getConfigPath());
        System.out.println("       attack_damage: " + customStack.getDamageMainhand());
        ItemMeta itemMeta = customStack.getItemStack().getItemMeta();
        itemMeta.setDisplayName("TEST");
        customStack.getItemStack().setItemMeta(itemMeta);
    }

    @EventHandler
    void test(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK || playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        CustomBlock customBlock = CustomBlock.getInstance("ruby_ore");
        customBlock.place(playerInteractEvent.getClickedBlock().getLocation().add(1.0, 0.0, 1.0));
        if (customBlock != null) {
            customBlock.setCurrentLightLevel(15);
            System.out.println(customBlock.getLoot());
        }
        CustomCrop customCrop = CustomCrop.place("tomato_seeds", playerInteractEvent.getClickedBlock().getLocation().add(0.0, 1.0, 0.0));
        customCrop.setFullyGrown();
        if (customCrop != null) {
            System.out.println(customCrop.getSeed().getItemStack());
        }
        ItemsAdder.playTotemAnimation(playerInteractEvent.getPlayer(), "bruh");
        CustomMob customMob = CustomMob.spawn("soul", playerInteractEvent.getClickedBlock().getLocation().add(0.0, 1.0, 0.0));
        if (customMob != null) {
            System.out.println("Spawned mob: " + customMob.getName());
        }
    }

    @EventHandler
    void interact(PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        CustomCrop customCrop = CustomCrop.byAlreadyPlaced(playerInteractEvent.getClickedBlock());
        if (customCrop == null) {
            System.out.println("Not a crop");
        } else {
            System.out.println(customCrop.getSeed().getNamespacedID());
        }
        CustomBlock customBlock = CustomBlock.byAlreadyPlaced(playerInteractEvent.getClickedBlock());
        if (customBlock == null) {
            System.out.println("Not a custom block");
        } else {
            System.out.println(customBlock.getNamespacedID());
            System.out.println(customBlock.generateBlockData());
        }
    }

    @EventHandler
    void interact(PlayerInteractAtEntityEvent playerInteractAtEntityEvent) {
        if (playerInteractAtEntityEvent.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        CustomMob customMob = CustomMob.byAlreadySpawned(playerInteractAtEntityEvent.getRightClicked());
        if (customMob == null) {
            System.out.println("Not a custom mob");
            return;
        }
        System.out.println(customMob.getNamespacedID());
    }
}
