package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import itemsadder.m.d;
import itemsadder.m.ql;
import itemsadder.m.qm;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class qv {
    NItem FR;
    final ItemStack Hh;
    Boolean Hi;
    Boolean Hj;
    Boolean Hk;

    public qv(ItemStack itemStack) {
        this.Hh = itemStack;
        if (this.nA()) {
            this.FR = new NItem(itemStack);
        }
    }

    @Nullable
    private String bT(String string) {
        if (this.FR.hasKey("itemsadder")) {
            return this.FR.getCompound("itemsadder").getString(string);
        }
        return null;
    }

    public boolean ny() {
        if (this.FR == null) {
            return false;
        }
        if (this.Hj == null && this.nA()) {
            this.Hj = this.FR.hasKey("itemsadder");
        }
        return this.Hj;
    }

    public boolean nz() {
        if (this.FR == null) {
            return false;
        }
        if (this.Hj != null && !this.Hj.booleanValue()) {
            return false;
        }
        if (this.Hk == null) {
            this.Hk = d.g().e(this.getNamespacedID()) instanceof ql;
        }
        return this.Hk;
    }

    public static boolean J(ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() == Material.AIR) {
            return false;
        }
        return NItem.hasNBT((ItemStack)itemStack);
    }

    public boolean nA() {
        if (this.Hi == null) {
            this.Hi = qv.J(this.Hh);
        }
        return this.Hi;
    }

    public boolean K(ItemStack itemStack) {
        if (!this.ny() || !qm.isCustomItem(itemStack)) {
            return false;
        }
        return qm.u(this.Hh).equals(qm.u(itemStack));
    }

    public boolean bU(String string) {
        if (!this.ny()) {
            return false;
        }
        return this.getNamespacedID().equals(string);
    }

    public String getNamespacedID() {
        return this.bT("namespace") + ":" + this.bT("id");
    }

    public String getNamespace() {
        return this.bT("namespace");
    }

    public String nB() {
        return this.bT("id");
    }
}
