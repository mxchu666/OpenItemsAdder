package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class RecipeChoiceItemStackHolder_3 {
    final RecipeChoice Nf;
    final ItemStack Ng;
    String Nh;

    public RecipeChoiceItemStackHolder_3(Object object) {
        if (object instanceof Material) {
            this.Ng = new ItemStack((Material)object);
            this.Nf = new RecipeChoice.MaterialChoice((Material)object);
        } else if (object instanceof ItemStackBuilder_4) {
            ItemStackBuilder_4 itemStackBuilder_4 = (ItemStackBuilder_4)object;
            this.Ng = itemStackBuilder_4.mP();
            this.Nf = new RecipeChoice.ExactChoice(this.Ng);
            this.Nh = itemStackBuilder_4.Gh;
        } else if (object instanceof ItemStack) {
            this.Ng = (ItemStack)object;
            this.Nf = new RecipeChoice.ExactChoice((ItemStack)object);
        } else {
            throw new IllegalArgumentException("Invalid ingredient type: " + object.getClass().getName());
        }
    }

    public ItemStack getItem() {
        return this.Ng;
    }

    public boolean cy(String string) {
        return string.equals(this.Nh);
    }

    public boolean ru() {
        return this.Nh != null;
    }
}
