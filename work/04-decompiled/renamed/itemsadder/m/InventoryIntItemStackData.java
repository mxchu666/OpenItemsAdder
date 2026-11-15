package itemsadder.m;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

class InventoryIntItemStackData {
    public Inventory gi;
    public int gj;
    public ItemStack gk;
    public ItemStack gl;

    public InventoryIntItemStackData(Inventory inventory, int n, ItemStack itemStack, ItemStack itemStack2) {
        this.gi = inventory;
        this.gj = n;
        this.gk = itemStack;
        this.gl = itemStack2;
    }
}
