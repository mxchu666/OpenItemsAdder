package itemsadder.m;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_3 {
    public final ItemStack aAx;
    public boolean aAy;
    private int mh;

    public ItemStackBridge_3(ItemStack itemStack) {
        this.aAx = itemStack;
        if (itemStack == null) {
            this.aAy = true;
            return;
        }
        this.aAy = itemStack.getType() == Material.AIR;
        this.mh = itemStack.getAmount();
    }

    public int De() {
        return this.mh;
    }

    public Material Df() {
        return this.aAx.getType();
    }

    public void bK(int n) {
        if (n <= 0) {
            this.aAy = true;
            this.mh = 0;
        } else {
            this.aAy = false;
            this.mh = n;
        }
    }

    public void Dg() {
        this.bK(this.mh - 1);
    }

    public void bH(int n) {
        this.bK(this.mh - n);
    }

    public void Dh() {
        this.aAx.setAmount(this.mh);
        if (this.aAy) {
            this.aAx.setType(Material.AIR);
        }
    }

    public ItemStack bL(int n) {
        ItemStack itemStack = this.aAx.clone();
        itemStack.setAmount(n);
        return itemStack;
    }

    public ItemStack bM(int n) {
        ItemStack itemStack = this.aAx.clone();
        itemStack.setAmount(n);
        this.bH(n);
        return itemStack;
    }
}
