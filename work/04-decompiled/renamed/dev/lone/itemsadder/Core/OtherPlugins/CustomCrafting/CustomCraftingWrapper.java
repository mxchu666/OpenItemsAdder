package dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting;

import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingPetuWrapper;
import dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting.CustomCraftingWolfyWrapper;
import java.util.function.Consumer;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.InventoryView;

public class CustomCraftingWrapper {
    public static CustomCraftingWrapper instance;
    static boolean isPetuFork;

    public static void init(Consumer consumer) {
        try {
            Class.forName("me.wolfyscript.customcrafting.listeners.cooking.CookingManager");
            CustomCraftingPetuWrapper.init(consumer);
            isPetuFork = true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
    }

    public static CustomCraftingWrapper inst() {
        if (instance == null) {
            instance = new CustomCraftingWrapper();
        }
        return instance;
    }

    public boolean isCustomCraftingRecipe(InventoryView inventoryView) {
        if (isPetuFork) {
            return CustomCraftingPetuWrapper.inst().isCustomCraftingRecipe(inventoryView);
        }
        return CustomCraftingWolfyWrapper.inst().isCustomCraftingRecipe(inventoryView);
    }

    public boolean isCustomCraftingRecipe(FurnaceSmeltEvent furnaceSmeltEvent) {
        if (isPetuFork) {
            return CustomCraftingPetuWrapper.inst().isCustomCraftingRecipe(furnaceSmeltEvent);
        }
        return CustomCraftingWolfyWrapper.inst().isCustomCraftingRecipe(furnaceSmeltEvent);
    }

    public boolean isCustomCraftingRecipe(PrepareAnvilEvent prepareAnvilEvent) {
        if (isPetuFork) {
            return CustomCraftingPetuWrapper.inst().isCustomCraftingRecipe(prepareAnvilEvent);
        }
        return CustomCraftingWolfyWrapper.inst().isCustomCraftingRecipe(prepareAnvilEvent);
    }

    static {
        isPetuFork = false;
    }
}
