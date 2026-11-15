package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.ItemsAdder$Advanced$ModifierHandler;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemsAdder$Advanced$InjectedItemModifier {
    public final String owner;
    @Nullable
    public final String item;
    public final ItemsAdder$Advanced$ModifierHandler handler;

    public ItemsAdder$Advanced$InjectedItemModifier(String string, @Nullable String string2, ItemsAdder$Advanced$ModifierHandler modifierHandler) {
        this.owner = string;
        this.item = string2;
        this.handler = modifierHandler;
    }

    public void call(String string, ItemStack itemStack) {
        ItemStack itemStack2 = this.handler.call(string, itemStack);
        if (itemStack2 != null) {
            itemStack.setType(itemStack2.getType());
            itemStack.setItemMeta(itemStack2.getItemMeta());
        }
    }
}
