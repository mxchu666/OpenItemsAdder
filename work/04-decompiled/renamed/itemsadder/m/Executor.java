package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.inventory.ItemStack;

@FunctionalInterface
public interface Executor {
    public void execute(Object var1, ItemStackBuilder_4 var2, ItemStack var3);
}
