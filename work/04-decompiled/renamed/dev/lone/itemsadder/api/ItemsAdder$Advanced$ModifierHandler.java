package dev.lone.itemsadder.api;

import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface ItemsAdder$Advanced$ModifierHandler {
    public ItemStack call(String var1, ItemStack var2);
}
