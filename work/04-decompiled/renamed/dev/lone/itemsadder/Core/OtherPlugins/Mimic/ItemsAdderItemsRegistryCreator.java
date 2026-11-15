package dev.lone.itemsadder.Core.OtherPlugins.Mimic;

import dev.lone.itemsadder.api.ItemsAdder;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
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
        return ItemStackRegistry.g().C.keySet();
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
        ItemStack itemStack = ItemStackRegistry.g().q(string);
        if (itemStack == null) {
            return null;
        }
        itemStack.setAmount(n);
        return itemStack;
    }

    @Nullable
    public String getItemId(@NotNull ItemStack itemStack) {
        if (ItemStackBuilder_4.isCustomItem(itemStack)) {
            return ItemStackBuilder_4.u(itemStack);
        }
        return null;
    }

    public boolean isItemExists(@NotNull String string) {
        return ItemStackRegistry.g().f(string);
    }

    @Nullable
    public ItemStack getItem(@NotNull String string) {
        return ItemStackRegistry.g().q(string);
    }

    public boolean isSameItem(@NotNull ItemStack itemStack, @NotNull String string) {
        return ItemStackBuilder_4.b(itemStack, string);
    }
}
