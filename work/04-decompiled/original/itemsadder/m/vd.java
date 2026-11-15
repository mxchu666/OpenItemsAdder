package itemsadder.m;

import itemsadder.m.bbs;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class vd {
    final RecipeChoice Mu;
    final ItemStack Mv;

    public vd(Object object) {
        if (object instanceof Material) {
            this.Mu = new RecipeChoice.MaterialChoice((Material)object);
            this.Mv = new ItemStack((Material)object);
        } else {
            ItemStack itemStack = bbs.au((ItemStack)object);
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
