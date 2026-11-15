package dev.lone.itemsadder.api.scriptinginternal;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

public class ItemsUtils {
    public static boolean isCustom(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack.getType() == Material.AIR) {
            return false;
        }
        return ItemStackRegistry.g().isCustomItem(itemStack);
    }

    @Nullable
    public static CustomStack customStack(String string) {
        return ItemsUtils.customStack(string, 1);
    }

    @Nullable
    public static CustomStack customStack(String string, int n) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_4 == null) {
            return null;
        }
        CustomStack customStack = CustomStack.fromInternal(itemStackBuilder_4);
        customStack.getItemStack().setAmount(n);
        return customStack;
    }

    public static ItemStack newStack(Material material) {
        return ItemsUtils.newStack(material, 1);
    }

    public static ItemStack newStack(Material material, int n) {
        ItemStack itemStack = new ItemStack(material);
        itemStack.setAmount(n);
        return itemStack;
    }

    public static boolean hasData(ItemStack itemStack, String string, String string2) {
        return itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(string, string2));
    }

    public static void removeData(ItemStack itemStack, String string, String string2) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        if (persistentDataContainer.has(new NamespacedKey(string, string2))) {
            persistentDataContainer.remove(new NamespacedKey(string, string2));
            itemStack.setItemMeta(itemMeta);
        }
    }

    public static byte getDataByte(ItemStack itemStack, String string, String string2, byte by) {
        return (Byte)itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(string, string2), PersistentDataType.BYTE, (Object)by);
    }

    public static void setDataByte(ItemStack itemStack, String string, String string2, byte by) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(string, string2), PersistentDataType.BYTE, (Object)by);
        itemStack.setItemMeta(itemMeta);
    }

    public static short getDataShort(ItemStack itemStack, String string, String string2, short s) {
        return (Short)itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(string, string2), PersistentDataType.SHORT, (Object)s);
    }

    public static void setDataShort(ItemStack itemStack, String string, String string2, short s) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(string, string2), PersistentDataType.SHORT, (Object)s);
        itemStack.setItemMeta(itemMeta);
    }

    public static int getDataInt(ItemStack itemStack, String string, String string2, int n) {
        return (Integer)itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(string, string2), PersistentDataType.INTEGER, (Object)n);
    }

    public static void setDataInt(ItemStack itemStack, String string, String string2, int n) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(string, string2), PersistentDataType.INTEGER, (Object)n);
        itemStack.setItemMeta(itemMeta);
    }

    public static long getDataLong(ItemStack itemStack, String string, String string2, long l) {
        return (Long)itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(string, string2), PersistentDataType.LONG, (Object)l);
    }

    public static void setDataLong(ItemStack itemStack, String string, String string2, long l) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(string, string2), PersistentDataType.LONG, (Object)l);
        itemStack.setItemMeta(itemMeta);
    }

    public static float getDataFloat(ItemStack itemStack, String string, String string2, float f) {
        return ((Float)itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(string, string2), PersistentDataType.FLOAT, (Object)Float.valueOf(f))).floatValue();
    }

    public static void setDataFloat(ItemStack itemStack, String string, String string2, float f) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(string, string2), PersistentDataType.FLOAT, (Object)Float.valueOf(f));
        itemStack.setItemMeta(itemMeta);
    }

    public static double getDataDouble(ItemStack itemStack, String string, String string2, double d) {
        return (Double)itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(string, string2), PersistentDataType.DOUBLE, (Object)d);
    }

    public static void setDataDouble(ItemStack itemStack, String string, String string2, double d) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(string, string2), PersistentDataType.DOUBLE, (Object)d);
        itemStack.setItemMeta(itemMeta);
    }

    public static boolean getDataBool(ItemStack itemStack, String string, String string2, boolean bl) {
        return (Boolean)itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(string, string2), PersistentDataType.BOOLEAN, (Object)bl);
    }

    public static void setDataBool(ItemStack itemStack, String string, String string2, boolean bl) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(string, string2), PersistentDataType.BOOLEAN, (Object)bl);
        itemStack.setItemMeta(itemMeta);
    }

    public static String getDataString(ItemStack itemStack, String string, String string2, String string3) {
        return (String)itemStack.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(string, string2), PersistentDataType.STRING, (Object)string3);
    }

    public static void setDataString(ItemStack itemStack, String string, String string2, String string3) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(string, string2), PersistentDataType.STRING, (Object)string3);
        itemStack.setItemMeta(itemMeta);
    }

    public static boolean hasData(CustomStack customStack, String string, String string2) {
        return ItemsUtils.hasData(customStack.getItemStack(), string, string2);
    }

    public static byte getDataByte(CustomStack customStack, String string, String string2, byte by) {
        return ItemsUtils.getDataByte(customStack.getItemStack(), string, string2, by);
    }

    public static void setDataByte(CustomStack customStack, String string, String string2, byte by) {
        ItemsUtils.setDataByte(customStack.getItemStack(), string, string2, by);
    }

    public static short getDataShort(CustomStack customStack, String string, String string2, short s) {
        return ItemsUtils.getDataShort(customStack.getItemStack(), string, string2, s);
    }

    public static void setDataShort(CustomStack customStack, String string, String string2, short s) {
        ItemsUtils.setDataShort(customStack.getItemStack(), string, string2, s);
    }

    public static int getDataInt(CustomStack customStack, String string, String string2, int n) {
        return ItemsUtils.getDataInt(customStack.getItemStack(), string, string2, n);
    }

    public static void setDataInt(CustomStack customStack, String string, String string2, int n) {
        ItemsUtils.setDataInt(customStack.getItemStack(), string, string2, n);
    }

    public static long getDataLong(CustomStack customStack, String string, String string2, long l) {
        return ItemsUtils.getDataLong(customStack.getItemStack(), string, string2, l);
    }

    public static void setDataLong(CustomStack customStack, String string, String string2, long l) {
        ItemsUtils.setDataLong(customStack.getItemStack(), string, string2, l);
    }

    public static float getDataFloat(CustomStack customStack, String string, String string2, float f) {
        return ItemsUtils.getDataFloat(customStack.getItemStack(), string, string2, f);
    }

    public static void setDataFloat(CustomStack customStack, String string, String string2, float f) {
        ItemsUtils.setDataFloat(customStack.getItemStack(), string, string2, f);
    }

    public static double getDataDouble(CustomStack customStack, String string, String string2, double d) {
        return ItemsUtils.getDataDouble(customStack.getItemStack(), string, string2, d);
    }

    public static void setDataDouble(CustomStack customStack, String string, String string2, double d) {
        ItemsUtils.setDataDouble(customStack.getItemStack(), string, string2, d);
    }

    public static boolean getDataBool(CustomStack customStack, String string, String string2, boolean bl) {
        return ItemsUtils.getDataBool(customStack.getItemStack(), string, string2, bl);
    }

    public static void setDataBool(CustomStack customStack, String string, String string2, boolean bl) {
        ItemsUtils.setDataBool(customStack.getItemStack(), string, string2, bl);
    }

    public static String getDataString(CustomStack customStack, String string, String string2, String string3) {
        return ItemsUtils.getDataString(customStack.getItemStack(), string, string2, string3);
    }

    public static void setDataString(CustomStack customStack, String string, String string2, String string3) {
        ItemsUtils.setDataString(customStack.getItemStack(), string, string2, string3);
    }
}
