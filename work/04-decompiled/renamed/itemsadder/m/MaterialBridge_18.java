package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecipeChoiceItemStackHolder;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.ItemStack;

public class MaterialBridge_18
extends NamespacedKeyItemStackHolder {
    final RecipeChoiceItemStackHolder Mw;
    final float Mx;
    final int My;
    Material Mz;

    public MaterialBridge_18(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, ItemStack itemStack, RecipeChoiceItemStackHolder recipeChoiceItemStackHolder, float f, int n) {
        super(pluginFileConfigurationHolder, string, string2, itemStack);
        this.Mw = recipeChoiceItemStackHolder;
        this.Mx = f;
        this.My = n;
        this.Mz = Material.FURNACE;
        this.Mc = 1;
    }

    @Override
    public boolean qS() {
        return this.Mw != null && this.Mw.Mv.getType() != Material.AIR;
    }

    public void a(CookingRecipe cookingRecipe) {
        if (this.qO() != null) {
            cookingRecipe.setGroup(this.qO().Gh);
        } else {
            cookingRecipe.setGroup(this.qN().getType().toString());
        }
    }

    public RecipeChoiceItemStackHolder re() {
        return this.Mw;
    }

    public float rf() {
        return this.Mx;
    }

    public int rg() {
        return this.My;
    }

    public boolean Q(ItemStack itemStack) {
        if (ItemStackBuilder_4.isCustomItem(this.Mw.getItemStack())) {
            if (ItemStackBuilder_4.isCustomItem(itemStack)) {
                return ItemStackBuilder_4.b(this.Mw.getItemStack(), itemStack);
            }
            return false;
        }
        try {
            if (ItemStackBuilder_4.isCustomItem(itemStack)) {
                return false;
            }
            if ((this.Mw.getItemStack() != null || this.Mw.getItemStack().getType() != Material.AIR) && itemStack == null) {
                return false;
            }
            if (this.Mw.getItemStack().getType() != itemStack.getType()) {
                return false;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return true;
    }

    public Material rh() {
        return this.Mz;
    }

    public void w(Material material) {
        switch (material) {
            case FURNACE: 
            case BLAST_FURNACE: 
            case SMOKER: {
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid furnace type: " + String.valueOf(material));
            }
        }
        this.Mz = material;
    }

    public boolean aE(Block block) {
        return this.Mz.equals((Object)block.getType());
    }
}
