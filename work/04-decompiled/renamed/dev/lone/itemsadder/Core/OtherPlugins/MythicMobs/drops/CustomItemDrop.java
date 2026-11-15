package dev.lone.itemsadder.Core.OtherPlugins.MythicMobs.drops;

import io.lumine.mythic.api.adapters.AbstractItemStack;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.drops.DropMetadata;
import io.lumine.mythic.api.drops.IItemDrop;
import io.lumine.mythic.bukkit.adapters.item.ItemComponentBukkitItemStack;
import itemsadder.m.ItemStackBuilder_4;
import org.bukkit.inventory.ItemStack;

public class CustomItemDrop
implements IItemDrop {
    private final ItemStackBuilder_4 customItem;

    public CustomItemDrop(MythicLineConfig mythicLineConfig, String string, ItemStackBuilder_4 itemStackBuilder_4) {
        this.customItem = itemStackBuilder_4;
    }

    public AbstractItemStack getDrop(DropMetadata dropMetadata, double d) {
        int n = (int)d;
        if (n > 0) {
            ItemStack itemStack = this.customItem.mP();
            itemStack.setAmount(n);
            return new ItemComponentBukkitItemStack(itemStack);
        }
        return null;
    }
}
