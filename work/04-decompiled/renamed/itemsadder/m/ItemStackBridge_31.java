package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemStackBridge_31 {
    NItem FR;
    final ItemStack Hh;
    Boolean Hi;
    Boolean Hj;
    Boolean Hk;

    public ItemStackBridge_31(ItemStack itemStack) {
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
            this.Hk = ItemStackRegistry.g().e(this.getNamespacedID()) instanceof LocationBridgeBuilder_2;
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
            this.Hi = ItemStackBridge_31.J(this.Hh);
        }
        return this.Hi;
    }

    public boolean K(ItemStack itemStack) {
        if (!this.ny() || !ItemStackBuilder_4.isCustomItem(itemStack)) {
            return false;
        }
        return ItemStackBuilder_4.u(this.Hh).equals(ItemStackBuilder_4.u(itemStack));
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
