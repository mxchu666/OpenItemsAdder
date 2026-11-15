package dev.lone.itemsadder.Core.OtherPlugins.Mimic;

import dev.lone.itemsadder.api.ItemsAdder;
import itemsadder.m.d;
import itemsadder.m.qm;
import java.util.Collection;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.endlesscode.mimic.items.BukkitItemsRegistry;

public class ItemsAdderItemsRegistryCreator
implements BukkitItemsRegistry {
    public boolean isEnabled() {
        return ItemsAdder.areItemsLoaded();
    }

    @NotNull
    public String getId() {
        return "ia";
    }

    @NotNull
    public Collection getKnownIds() {
        return d.g().C.keySet();
    }

    @Nullable
    public ItemStack getItem(@NotNull String string, @Nullable Object object) {
        return this.getItem(string, 1);
    }

    @Nullable
    public ItemStack getItem(@NotNull String string, @Nullable Object object, int n) {
        return this.getItem(string, n);
    }

    @Nullable
    public ItemStack getItem(@NotNull String string, int n) {
        ItemStack itemStack = d.g().q(string);
        if (itemStack == null) {
            return null;
        }
        itemStack.setAmount(n);
        return itemStack;
    }

    @Nullable
    public String getItemId(@NotNull ItemStack itemStack) {
        if (qm.isCustomItem(itemStack)) {
            return qm.u(itemStack);
        }
        return null;
    }

    public boolean isItemExists(@NotNull String string) {
        return d.g().f(string);
    }

    @Nullable
    public ItemStack getItem(@NotNull String string) {
        return d.g().q(string);
    }

    public boolean isSameItem(@NotNull ItemStack itemStack, @NotNull String string) {
        return qm.b(itemStack, string);
    }
}
