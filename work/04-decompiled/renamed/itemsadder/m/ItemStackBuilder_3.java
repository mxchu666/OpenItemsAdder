package itemsadder.m;

import itemsadder.m.SuccessEnum_2;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemStackBuilder_3 {
    public final SuccessEnum_2 Ec;
    @Nullable
    public final ItemStack Ed;

    public ItemStackBuilder_3(SuccessEnum_2 successEnum_2, @Nullable ItemStack itemStack) {
        this.Ec = successEnum_2;
        this.Ed = itemStack;
    }

    public static ItemStackBuilder_3 mk() {
        return new ItemStackBuilder_3(SuccessEnum_2.FAILED, null);
    }

    public static ItemStackBuilder_3 l(ItemStack itemStack) {
        return new ItemStackBuilder_3(SuccessEnum_2.FAILED, itemStack);
    }

    public static ItemStackBuilder_3 ml() {
        return new ItemStackBuilder_3(SuccessEnum_2.SUCCESS, null);
    }

    public static ItemStackBuilder_3 m(ItemStack itemStack) {
        return new ItemStackBuilder_3(SuccessEnum_2.SUCCESS, itemStack);
    }
}
