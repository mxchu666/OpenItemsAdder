package itemsadder.m;

import itemsadder.m.pb;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class pa {
    public final pb Ec;
    @Nullable
    public final ItemStack Ed;

    public pa(pb pb2, @Nullable ItemStack itemStack) {
        this.Ec = pb2;
        this.Ed = itemStack;
    }

    public static pa mk() {
        return new pa(pb.FAILED, null);
    }

    public static pa l(ItemStack itemStack) {
        return new pa(pb.FAILED, itemStack);
    }

    public static pa ml() {
        return new pa(pb.SUCCESS, null);
    }

    public static pa m(ItemStack itemStack) {
        return new pa(pb.SUCCESS, itemStack);
    }
}
