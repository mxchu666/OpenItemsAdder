package itemsadder.m;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemStackIntData {
    public final ItemStack itemStack;
    public final ItemStack BF;
    public final int BG;

    public ItemStackIntData(ItemStack itemStack, @Nullable ItemStack itemStack2, int n) {
        this.itemStack = itemStack;
        this.BF = itemStack2;
        this.BG = n;
    }
}
