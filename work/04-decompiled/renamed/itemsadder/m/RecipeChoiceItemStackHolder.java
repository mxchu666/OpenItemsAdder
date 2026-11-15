package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class RecipeChoiceItemStackHolder {
    final RecipeChoice Mu;
    final ItemStack Mv;

    public RecipeChoiceItemStackHolder(Object object) {
        if (object instanceof Material) {
            this.Mu = new RecipeChoice.MaterialChoice((Material)object);
            this.Mv = new ItemStack((Material)object);
        } else {
            ItemStack itemStack = ItemStackBridge_2.au((ItemStack)object);
            this.Mu = new RecipeChoice.ExactChoice(itemStack);
            this.Mv = itemStack;
        }
    }

    public RecipeChoice rd() {
        return this.Mu;
    }

    public ItemStack getItemStack() {
        return this.Mv;
    }
}
