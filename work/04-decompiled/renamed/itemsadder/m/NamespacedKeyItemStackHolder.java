package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBridge_35;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_18;
import itemsadder.m.PlayerHolder_5;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.RecipeBridge;
import lombok.Generated;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.jetbrains.annotations.Nullable;

public abstract class NamespacedKeyItemStackHolder {
    @Nullable
    public PluginFileConfigurationHolder nP;
    public String LY;
    protected NamespacedKey LZ;
    String uI;
    protected ItemStack Ma;
    @Nullable
    protected ItemStackBuilder_4 Mb;
    public int Mc;
    @Nullable
    public Object Hg;
    private Recipe Md;

    public NamespacedKeyItemStackHolder(@Nullable PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, ItemStack itemStack) {
        this.nP = pluginFileConfigurationHolder;
        this.LY = string;
        this.uI = string2;
        this.Ma = ItemStackBridge_2.au(itemStack);
        if (itemStack instanceof ItemStackBuilder_4) {
            ItemStackBuilder_4 itemStackBuilder_4;
            this.Mb = itemStackBuilder_4 = (ItemStackBuilder_4)itemStack;
        }
        if (ItemStackRegistry.g().isCustomItem(itemStack)) {
            this.Mb = ItemStackRegistry.g().a(itemStack);
        }
    }

    public NamespacedKeyItemStackHolder(ItemStack itemStack) {
        this.uI = "";
        this.Ma = ItemStackBridge_2.au(itemStack);
    }

    public ItemStack qN() {
        return this.Ma;
    }

    @Nullable
    public ItemStackBuilder_4 qO() {
        return this.Mb;
    }

    public ItemStack qP() {
        if (this.Ma instanceof ItemStackBuilder_4) {
            return ((ItemStackBuilder_4)this.Ma).mP();
        }
        return ItemStackBridge_2.au(this.Ma);
    }

    public NamespacedKey qQ() {
        return this.LZ;
    }

    public void e(NamespacedKey namespacedKey) {
        this.LZ = namespacedKey;
    }

    public void a(Recipe recipe) {
        this.Md = recipe;
        RecipeBridge.a(recipe);
        this.Hg = PlayerHolder_5.vq().f(this.LZ);
    }

    public Recipe qR() {
        return this.Md;
    }

    public abstract boolean qS();

    public boolean qT() {
        return this instanceof ItemStackBridge_35 || this instanceof MaterialBridge_18;
    }

    public CraftingBookCategory qU() {
        ItemStackBuilder_4 itemStackBuilder_4 = this.qO();
        if (itemStackBuilder_4 != null) {
            if (itemStackBuilder_4 instanceof LocationBridgeBuilder_2) {
                return CraftingBookCategory.BUILDING;
            }
            if (itemStackBuilder_4.Ge.bm("furniture")) {
                return CraftingBookCategory.BUILDING;
            }
            if (itemStackBuilder_4.Ge.bm("hat")) {
                return CraftingBookCategory.EQUIPMENT;
            }
            if (itemStackBuilder_4.Ge.bm("gun")) {
                return CraftingBookCategory.EQUIPMENT;
            }
        }
        if (ItemStackBridge_2.ae(this.qN()) || ItemStackBridge_2.V(this.qN().getType())) {
            return CraftingBookCategory.EQUIPMENT;
        }
        if (this.qN().getType().isBlock()) {
            return CraftingBookCategory.BUILDING;
        }
        return CraftingBookCategory.MISC;
    }

    public String nh() {
        return this.nP.nh();
    }

    @Generated
    public String nf() {
        return this.uI;
    }
}
