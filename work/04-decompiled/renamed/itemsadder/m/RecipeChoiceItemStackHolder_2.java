package itemsadder.m;

import itemsadder.m.BlockRegistry;
import itemsadder.m.ItemStackBridge_37;
import itemsadder.m.ItemStackBridge_38;
import itemsadder.m.ItemStackBridge_39;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.MaterialBridge_19;
import java.lang.runtime.SwitchBootstraps;
import java.util.Objects;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.Nullable;

public class RecipeChoiceItemStackHolder_2 {
    final Character MF;
    final RecipeChoice MG;
    final ItemStack MH;
    public final int MI;
    Integer MJ = null;

    public RecipeChoiceItemStackHolder_2(Character c, ItemStackBridge_37 itemStackBridge_37) {
        this(c, itemStackBridge_37, 1);
    }

    public RecipeChoiceItemStackHolder_2(Character c, ItemStackBridge_37 itemStackBridge_37, @Deprecated int n) {
        this.MF = Character.valueOf(Character.toLowerCase(c.charValue()));
        this.MH = itemStackBridge_37.rt();
        this.MH.setAmount(n);
        ItemStackBridge_37 itemStackBridge_372 = itemStackBridge_37;
        Objects.requireNonNull(itemStackBridge_372);
        ItemStackBridge_37 itemStackBridge_373 = itemStackBridge_372;
        int n2 = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{MaterialBridge_19.class, ItemStackBridge_39.class, ItemStackBridge_38.class}, (Object)itemStackBridge_373, n2)) {
            case 0: {
                MaterialBridge_19 materialBridge_19 = (MaterialBridge_19)itemStackBridge_373;
                this.MG = new RecipeChoice.MaterialChoice(materialBridge_19.Ne);
                this.MI = RecipeChoiceItemStackHolder_2.x(this.MH.getType());
                return;
            }
            case 1: {
                ItemStackBridge_39 itemStackBridge_39 = (ItemStackBridge_39)itemStackBridge_373;
                this.MG = new RecipeChoice.ExactChoice(this.MH);
                this.MI = RecipeChoiceItemStackHolder_2.x(this.MH.getType());
                return;
            }
            case 2: {
                ItemStackBridge_38 itemStackBridge_38 = (ItemStackBridge_38)itemStackBridge_373;
                this.MG = new RecipeChoice.ExactChoice(this.MH);
                this.MJ = itemStackBridge_38.oP().Gi;
                this.MI = this.MJ;
                return;
            }
        }
        throw new IllegalStateException("Unexpected ingredient type.");
    }

    public static int x(@Nullable Material material) {
        if (material == null || material.isAir()) {
            return -666;
        }
        return BlockRegistry.tg().C(material);
    }

    public static Integer S(@Nullable ItemStack itemStack) {
        if (itemStack == null) {
            return RecipeChoiceItemStackHolder_2.x(null);
        }
        if (ItemStackBuilder_4.isCustomItem(itemStack)) {
            return ItemStackBuilder_4.v(itemStack);
        }
        return RecipeChoiceItemStackHolder_2.x(itemStack.getType());
    }

    public static int a(@Nullable RecipeChoiceItemStackHolder_2 recipeChoiceItemStackHolder_2) {
        if (recipeChoiceItemStackHolder_2 == null) {
            return RecipeChoiceItemStackHolder_2.x(null);
        }
        return recipeChoiceItemStackHolder_2.MI;
    }

    public RecipeChoice rd() {
        return this.MG;
    }

    public Character ri() {
        return this.MF;
    }

    public ItemStack getItem() {
        return this.MH;
    }

    @Nullable
    public Integer rj() {
        return this.MJ;
    }

    public boolean ny() {
        return this.MJ != null;
    }

    public boolean e(ItemStack itemStack) {
        if (this.ny()) {
            return ItemStackBuilder_4.a((Integer)this.MI, itemStack);
        }
        return this.MH.getType() == itemStack.getType() && !ItemStackBuilder_4.isCustomItem(itemStack);
    }

    public boolean rk() {
        return this.MH == null || this.MH.getType() == Material.AIR;
    }
}
