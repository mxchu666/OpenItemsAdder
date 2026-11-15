package itemsadder.m;

import itemsadder.m.BoolData_3;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.PlayerHolder_2;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecipeChoiceItemStackHolder_3;
import itemsadder.m.VersionHelper;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemStackBridge_41
extends NamespacedKeyItemStackHolder {
    public final RecipeChoiceItemStackHolder_3 Ni;
    public final RecipeChoiceItemStackHolder_3 Nj;
    public final RecipeChoiceItemStackHolder_3 Nk;
    public final BoolData_3 Nl;

    public ItemStackBridge_41(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, ItemStack itemStack, RecipeChoiceItemStackHolder_3 recipeChoiceItemStackHolder_3, RecipeChoiceItemStackHolder_3 recipeChoiceItemStackHolder_32, RecipeChoiceItemStackHolder_3 recipeChoiceItemStackHolder_33, BoolData_3 boolData_3) {
        super(pluginFileConfigurationHolder, string, string2, itemStack);
        this.Ni = recipeChoiceItemStackHolder_3;
        this.Nj = recipeChoiceItemStackHolder_32;
        this.Nk = recipeChoiceItemStackHolder_33;
        this.Nl = boolData_3;
        this.Mc = 1;
    }

    @Override
    public boolean qS() {
        return this.Nj != null && this.Nj.Ng.getType() != Material.AIR && this.Nk != null && this.Nk.Ng.getType() != Material.AIR;
    }

    public ItemStack T(ItemStack itemStack) {
        ItemStack itemStack2 = ItemStackBridge_2.au(this.Ma);
        if (this.Nl.Ns) {
            PlayerHolder_2.tX().f(itemStack, itemStack2);
        }
        if (VersionHelper.Va) {
            List list;
            ItemMeta itemMeta = itemStack2.getItemMeta();
            ItemMeta itemMeta2 = itemStack.getItemMeta();
            if (this.Nl.Nm && itemMeta2.hasDisplayName()) {
                itemMeta.displayName(itemMeta2.displayName());
            }
            if (this.Nl.Nn && (list = itemMeta2.lore()) != null) {
                List list2 = itemMeta.lore();
                if (list2 != null) {
                    list.addAll(list2);
                }
                itemMeta.lore(list);
            }
            itemStack2.setItemMeta(itemMeta);
        }
        if (this.Nl.No) {
            ItemStackBridge_2.i(itemStack, itemStack2);
        }
        if (this.Nl.Np && ItemStackBridge_2.av(itemStack)) {
            int n = ItemStackBridge_2.al(itemStack);
            int n2 = ItemStackBridge_2.E(itemStack2);
            int n3 = (int)Math.ceil((double)n / (double)ItemStackBridge_2.E(itemStack) * (double)n2);
            ItemStackBridge_2.d(itemStack2, n3);
        }
        if (this.Nl.Nr) {
            ItemStackBridge_2.j(itemStack, itemStack2);
        }
        if (this.Nl.Nq) {
            itemStack2.setType(itemStack.getType());
        }
        return itemStack2;
    }

    public boolean b(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
        return this.a(this.Ni, itemStack) && this.a(this.Nj, itemStack2) && this.a(this.Nk, itemStack3);
    }

    private boolean a(RecipeChoiceItemStackHolder_3 recipeChoiceItemStackHolder_3, ItemStack itemStack) {
        if ((itemStack == null || itemStack.getType() == Material.AIR) && recipeChoiceItemStackHolder_3.getItem() != null && recipeChoiceItemStackHolder_3.getItem().getType() != Material.AIR) {
            return false;
        }
        boolean bl = ItemStackBuilder_4.isCustomItem(itemStack);
        if (recipeChoiceItemStackHolder_3.ru()) {
            if (bl) {
                return recipeChoiceItemStackHolder_3.cy(ItemStackBuilder_4.u(itemStack));
            }
            return false;
        }
        if (bl) {
            return false;
        }
        return recipeChoiceItemStackHolder_3.getItem().getType() == itemStack.getType();
    }
}
