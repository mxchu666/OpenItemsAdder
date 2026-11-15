package itemsadder.m;

import org.bukkit.entity.HumanEntity;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class bfc
extends FoodLevelChangeEvent {
    public bfc(@NotNull HumanEntity humanEntity, int n) {
        super(humanEntity, n);
    }

    public bfc(@NotNull HumanEntity humanEntity, int n, @Nullable ItemStack itemStack) {
        super(humanEntity, n, itemStack);
    }
}
