package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.LocationBridgeImpl;
import itemsadder.m.MaterialBarColorHolder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_33
extends LocationBridgeImpl {
    public boolean a(ItemStack itemStack, Material material) {
        if (itemStack.getType() == Material.SHEARS) {
            switch (material) {
                case ACACIA_LEAVES: 
                case BIRCH_LEAVES: 
                case DARK_OAK_LEAVES: 
                case JUNGLE_LEAVES: 
                case OAK_LEAVES: 
                case SPRUCE_LEAVES: 
                case STRING: 
                case TRIPWIRE: {
                    return true;
                }
            }
            return material.toString().endsWith("_LEAVES");
        }
        if (material == Material.SPAWNER && MaterialBarColorHolder.ef) {
            return false;
        }
        return ItemStackBridge_2.a(itemStack, Enchantment.SILK_TOUCH);
    }

    public boolean b(ItemStack itemStack, Material material) {
        if (itemStack.getType() == Material.SHEARS) {
            switch (material) {
                case ACACIA_LEAVES: 
                case BIRCH_LEAVES: 
                case DARK_OAK_LEAVES: 
                case JUNGLE_LEAVES: 
                case OAK_LEAVES: 
                case SPRUCE_LEAVES: {
                    return true;
                }
            }
            return material.toString().endsWith("_LEAVES");
        }
        if (material == Material.SPAWNER && MaterialBarColorHolder.ef) {
            return false;
        }
        return ItemStackBridge_2.a(itemStack, Enchantment.SILK_TOUCH);
    }
}
