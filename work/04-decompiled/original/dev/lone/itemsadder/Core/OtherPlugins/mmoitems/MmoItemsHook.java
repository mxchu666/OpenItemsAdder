package dev.lone.itemsadder.Core.OtherPlugins.mmoitems;

import dev.lone.itemsadder.Main;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.qm;
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
        if (!qm.isCustomItem(itemStack)) {
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
        Component component = bbs.ah(itemStack);
        try {
            LeatherArmorMeta leatherArmorMeta;
            int n = bbs.C(itemStack);
            Color color = null;
            if (itemStack.getItemMeta() instanceof LeatherArmorMeta) {
                leatherArmorMeta = (LeatherArmorMeta)itemStack.getItemMeta();
                color = leatherArmorMeta.getColor();
            }
            leatherArmorMeta = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get(string), string2);
            bbs.h(itemStack, (ItemStack)leatherArmorMeta);
            bbs.b(itemStack, n);
            if (color != null) {
                LeatherArmorMeta leatherArmorMeta2 = (LeatherArmorMeta)itemStack.getItemMeta();
                leatherArmorMeta2.setColor(color);
                itemStack.setItemMeta((ItemMeta)leatherArmorMeta2);
            }
        }
        catch (Exception exception) {
            try {
                qm qm2 = d.g().a(itemStack);
                bce.error("Error loading MMOItems integration for item " + qm2.getNamespacedID() + ". Please check if the MMOItem of type '" + string + "' and id '" + string2 + "' exists in MMOItems plugin. File: " + qm2.nh());
            }
            catch (Exception exception2) {
                exception2.printStackTrace();
            }
        }
        bbs.a(itemStack, component);
        qm.D(itemStack);
    }

    public static void injectMmoItem(qm qm2, String string, String string2, boolean bl) {
        if (Main.PC && string != null && string2 != null) {
            String string3 = qm2.nb();
            string = string.toUpperCase();
            string2 = string2.toUpperCase();
            try {
                ItemStack itemStack = MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get(string), string2);
                qm2.r(itemStack);
                if (!bl) {
                    qm2.bJ(string3);
                }
            }
            catch (NullPointerException nullPointerException) {
                bce.error("Error loading MMOItems integration for item " + qm2.getNamespacedID() + ". Please check if the MMOItem of type '" + string + "' and id '" + string2 + "' exists in MMOItems plugin. File: " + qm2.nh());
            }
            catch (Throwable throwable) {
                bce.error("Error loading MMOItems integration for item " + qm2.getNamespacedID() + ". Please check if MMOItem is up to date and running. File: " + qm2.nh());
            }
        }
    }
}
