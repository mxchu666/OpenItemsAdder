package itemsadder.m;

import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class wb {
    final RecipeChoice Nf;
    final ItemStack Ng;
    String Nh;

    public wb(Object object) {
        if (object instanceof Material) {
            this.Ng = new ItemStack((Material)object);
            this.Nf = new RecipeChoice.MaterialChoice((Material)object);
        } else if (object instanceof qm) {
            qm qm2 = (qm)object;
            this.Ng = qm2.mP();
            this.Nf = new RecipeChoice.ExactChoice(this.Ng);
            this.Nh = qm2.Gh;
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
