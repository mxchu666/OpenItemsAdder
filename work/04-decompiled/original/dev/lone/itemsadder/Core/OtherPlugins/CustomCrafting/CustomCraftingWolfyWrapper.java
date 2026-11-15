package dev.lone.itemsadder.Core.OtherPlugins.CustomCrafting;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.function.Consumer;
import me.wolfyscript.customcrafting.CustomCrafting;
import me.wolfyscript.customcrafting.listeners.AnvilListener;
import org.apache.commons.lang.reflect.FieldUtils;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.InventoryView;

class CustomCraftingWolfyWrapper {
    public static CustomCraftingWolfyWrapper instance;
    private static Consumer msg;
    private static Field field_preCraftedRecipes;

    CustomCraftingWolfyWrapper() {
    }

    public static void init(Consumer consumer) {
        msg = consumer;
    }

    public static CustomCraftingWolfyWrapper inst() {
        if (instance == null) {
            instance = new CustomCraftingWolfyWrapper();
        }
        return instance;
    }

    public boolean isCustomCraftingRecipe(InventoryView inventoryView) {
        return CustomCrafting.inst().getCraftManager().has(inventoryView.getPlayer().getUniqueId());
    }

    public boolean isCustomCraftingRecipe(FurnaceSmeltEvent furnaceSmeltEvent) {
        return CustomCrafting.inst().getCookingManager().hasCustomRecipe(furnaceSmeltEvent);
    }

    public boolean isCustomCraftingRecipe(PrepareAnvilEvent prepareAnvilEvent) {
        if (field_preCraftedRecipes == null) {
            return false;
        }
        try {
            HashMap hashMap = (HashMap)field_preCraftedRecipes.get(null);
            return hashMap.containsKey(prepareAnvilEvent.getView().getPlayer().getUniqueId());
        }
        catch (IllegalAccessException illegalAccessException) {
            return false;
        }
    }

    static {
        try {
            field_preCraftedRecipes = FieldUtils.getField(AnvilListener.class, (String)"preCraftedRecipes", (boolean)true);
        }
        catch (Exception exception) {
            msg.accept("Failed to register Anvil recipes compatibility for CustomCrafting plugin: " + exception.getMessage());
        }
    }
}
