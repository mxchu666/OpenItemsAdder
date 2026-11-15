package itemsadder.m;

import itemsadder.m.NamespacedKeyItemStackHolder;
import itemsadder.m.PluginFileConfigurationHolder;
import org.bukkit.inventory.ItemStack;

public class ItemStackBridge_34
extends NamespacedKeyItemStackHolder {
    public ItemStack Mq;
    public ItemStack Mr;

    public ItemStackBridge_34(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, ItemStack itemStack, ItemStack itemStack2) {
        super(pluginFileConfigurationHolder, string, string2, itemStack);
        this.Mq = itemStack;
        this.Mr = itemStack2;
        this.Mc = 2;
    }

    public ItemStack rb() {
        return this.Mq;
    }

    public ItemStack rc() {
        return this.Mr;
    }

    public boolean O(ItemStack itemStack) {
        return this.Mr.isSimilar(itemStack);
    }

    @Override
    public boolean qS() {
        return this.Mq != null && this.Mr != null;
    }
}
