package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bbs;
import itemsadder.m.ul;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class tz
extends ul {
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
        if (material == Material.SPAWNER && ae.ef) {
            return false;
        }
        return bbs.a(itemStack, Enchantment.SILK_TOUCH);
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
        if (material == Material.SPAWNER && ae.ef) {
            return false;
        }
        return bbs.a(itemStack, Enchantment.SILK_TOUCH);
    }
}
