package dev.lone.itemsadder.Core.OtherPlugins.mmoitems;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import net.Indyuce.mmoitems.MMOItems;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class MmoItemsHook {
    public static void injectMmoItem(ItemStack itemStack) {
        if (!Main.PC) {
            return;
        }
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return;
        }
        String string = MMOItems.getTypeName((ItemStack)itemStack);
        if (string == null) {
            return;
        }
        String string2 = MMOItems.getID((ItemStack)itemStack);
        if (string2 == null) {
            return;
        }
        string = string.toUpperCase();
        string2 = string2.toUpperCase();
        Component component = ItemStackBridge_2.ah(itemStack);
        try {
            LeatherArmorMeta leatherArmorMeta;
            int n = ItemStackBridge_2.C(itemStack);
            Color color = null;
            if (itemStack.getItemMeta() instanceof LeatherArmorMeta) {
                leatherArmorMeta = (LeatherArmorMeta)itemStack.getItemMeta();
                color = leatherArmorMeta.getColor();
            }
            leatherArmorMeta = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get(string), string2);
            ItemStackBridge_2.h(itemStack, (ItemStack)leatherArmorMeta);
            ItemStackBridge_2.b(itemStack, n);
            if (color != null) {
                LeatherArmorMeta leatherArmorMeta2 = (LeatherArmorMeta)itemStack.getItemMeta();
                leatherArmorMeta2.setColor(color);
                itemStack.setItemMeta((ItemMeta)leatherArmorMeta2);
            }
        }
        catch (Exception exception) {
            try {
                ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
                CommandSenderBridge_5.error("Error loading MMOItems integration for item " + itemStackBuilder_4.getNamespacedID() + ". Please check if the MMOItem of type '" + string + "' and id '" + string2 + "' exists in MMOItems plugin. File: " + itemStackBuilder_4.nh());
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
        ItemStackBridge_2.a(itemStack, component);
        ItemStackBuilder_4.D(itemStack);
    }

    public static void injectMmoItem(ItemStackBuilder_4 itemStackBuilder_4, String string, String string2, boolean bl) {
        if (Main.PC && string != null && string2 != null) {
            String string3 = itemStackBuilder_4.nb();
            string = string.toUpperCase();
            string2 = string2.toUpperCase();
            try {
                ItemStack itemStack = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get(string), string2);
                itemStackBuilder_4.r(itemStack);
                if (!bl) {
                    itemStackBuilder_4.bJ(string3);
                }
            }
            catch (NullPointerException nullPointerException) {
                CommandSenderBridge_5.error("Error loading MMOItems integration for item " + itemStackBuilder_4.getNamespacedID() + ". Please check if the MMOItem of type '" + string + "' and id '" + string2 + "' exists in MMOItems plugin. File: " + itemStackBuilder_4.nh());
            }
            catch (Throwable throwable) {
                CommandSenderBridge_5.error("Error loading MMOItems integration for item " + itemStackBuilder_4.getNamespacedID() + ". Please check if MMOItem is up to date and running. File: " + itemStackBuilder_4.nh());
            }
        }
    }
}
