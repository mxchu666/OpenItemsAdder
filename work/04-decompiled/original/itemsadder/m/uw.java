package itemsadder.m;

import itemsadder.m.asg;
import itemsadder.m.bbf;
import itemsadder.m.bbs;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.ux;
import itemsadder.m.ve;
import itemsadder.m.vk;
import lombok.Generated;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.jetbrains.annotations.Nullable;

public abstract class uw {
    @Nullable
    public bbf nP;
    public String LY;
    protected NamespacedKey LZ;
    String uI;
    protected ItemStack Ma;
    @Nullable
    protected qm Mb;
    public int Mc;
    @Nullable
    public Object Hg;
    private Recipe Md;

    public uw(@Nullable bbf bbf2, String string, String string2, ItemStack itemStack) {
        this.nP = bbf2;
        this.LY = string;
        this.uI = string2;
        this.Ma = bbs.au(itemStack);
        if (itemStack instanceof qm) {
            qm qm2;
            this.Mb = qm2 = (qm)itemStack;
        }
        if (d.g().isCustomItem(itemStack)) {
            this.Mb = d.g().a(itemStack);
        }
    }

    public uw(ItemStack itemStack) {
        this.uI = "";
        this.Ma = bbs.au(itemStack);
    }

    public ItemStack qN() {
        return this.Ma;
    }

    @Nullable
    public qm qO() {
        return this.Mb;
    }

    public ItemStack qP() {
        if (this.Ma instanceof qm) {
            return ((qm)this.Ma).mP();
        }
        return bbs.au(this.Ma);
    }

    public NamespacedKey qQ() {
        return this.LZ;
    }

    public void e(NamespacedKey namespacedKey) {
        this.LZ = namespacedKey;
    }

    public void a(Recipe recipe) {
        this.Md = recipe;
        ux.a(recipe);
        this.Hg = asg.vq().f(this.LZ);
    }

    public Recipe qR() {
        return this.Md;
    }

    public abstract boolean qS();

    public boolean qT() {
        return this instanceof vk || this instanceof ve;
    }

    public CraftingBookCategory qU() {
        qm qm2 = this.qO();
        if (qm2 != null) {
            if (qm2 instanceof ql) {
                return CraftingBookCategory.BUILDING;
            }
            if (qm2.Ge.bm("furniture")) {
                return CraftingBookCategory.BUILDING;
            }
            if (qm2.Ge.bm("hat")) {
                return CraftingBookCategory.EQUIPMENT;
            }
            if (qm2.Ge.bm("gun")) {
                return CraftingBookCategory.EQUIPMENT;
            }
        }
        if (bbs.ae(this.qN()) || bbs.V(this.qN().getType())) {
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
