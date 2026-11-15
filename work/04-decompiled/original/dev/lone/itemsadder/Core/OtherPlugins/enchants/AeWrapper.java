package dev.lone.itemsadder.Core.OtherPlugins.enchants;

import beer.devs.fastnbt.nms.nbt.NItem;
import itemsadder.m.qm;
import net.advancedplugins.ae.api.AEAPI;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AeWrapper {
    @Nullable
    public static String applyEnchant(ItemStack itemStack, String string, int n) {
        try {
            NItem nItem = new NItem(itemStack);
            nItem.merge(AEAPI.applyEnchant((String)string, (int)n, (ItemStack)itemStack));
            nItem.save();
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
        return null;
    }

    public static void applyEnchant(qm qm2, String string, int n) {
        try {
            qm2.mQ().merge(AEAPI.applyEnchant((String)string, (int)n, (ItemStack)qm2));
            qm2.na();
        }
        catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static boolean isCustomEnchant(String string) {
        return AEAPI.isAnEnchantment((String)string);
    }
}
