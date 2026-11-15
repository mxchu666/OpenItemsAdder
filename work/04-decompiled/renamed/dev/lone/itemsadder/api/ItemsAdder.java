package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.BiomeHolder;
import itemsadder.m.BlockBridge_7;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ItemStackBridgeImpl;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_9;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.RealEnum;
import itemsadder.m.SoundBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemsAdder {
    @Deprecated
    public static boolean areItemsLoaded() {
        return ItemStackRegistry.g() != null && ItemStackRegistry.g().u;
    }

    @Deprecated
    public static boolean isCustomItem(ItemStack itemStack) {
        return ItemStackBuilder_4.isCustomItem(itemStack);
    }

    @Deprecated
    public static boolean isCustomItem(String string) {
        return ItemStackRegistry.g().f(string);
    }

    @Deprecated
    public static ItemStack getCustomItem(String string) {
        return ItemStackRegistry.g().q(string);
    }

    @Deprecated
    public static void placeCustomBlock(Location location, ItemStack itemStack) {
        String string = ItemStackBuilder_4.u(itemStack);
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
        locationBridgeBuilder_2.M(location);
    }

    @Deprecated
    public static void removeCustomBlock(Location location) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        if (!blockBridge_9.isCustomBlock(location.getBlock())) {
            return;
        }
        blockBridge_9.ag(location.getBlock());
    }

    @Deprecated
    public static ItemStack getCustomBlockByFaces(Material material, HashMap hashMap) {
        return ItemStackRegistry.g().a(material, hashMap);
    }

    @Deprecated
    public static boolean isCustomBlock(Block block) {
        if (LocationBridgeBuilder_2.av(block)) {
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            return blockBridge_9.isCustomBlock(block);
        }
        return false;
    }

    @Deprecated
    public static List getCustomBlockLoot(Block block, boolean bl) {
        return ItemsAdder.getCustomBlockLoot(block, new ItemStack(Material.DIAMOND_PICKAXE), bl);
    }

    @Deprecated
    public static List getCustomBlockLoot(Block block) {
        return ItemsAdder.getCustomBlockLoot(block, new ItemStack(Material.DIAMOND_PICKAXE), true);
    }

    @Deprecated
    public static List getCustomBlockLoot(Block block, ItemStack itemStack, boolean bl) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (!blockBridge_9.isCustomBlock(block)) {
            return arrayList;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
        if (locationBridgeBuilder_2 == null) {
            return arrayList;
        }
        if (!locationBridgeBuilder_2.p(itemStack)) {
            return arrayList;
        }
        List list = ItemStackRegistry.g().aq.e(block, locationBridgeBuilder_2);
        if (list != null) {
            for (ItemStackBridgeImpl itemStackBridgeImpl : list) {
                if (!itemStackBridgeImpl.ln().getNamespacedID().equals(locationBridgeBuilder_2.getNamespacedID()) || itemStackBridgeImpl.a(itemStack, block.getType())) continue;
                arrayList.addAll(itemStackBridgeImpl.N(itemStack));
            }
        }
        if (bl && locationBridgeBuilder_2.mG()) {
            arrayList.add(locationBridgeBuilder_2.mP());
        }
        return arrayList;
    }

    @Deprecated
    public static void placeCustomCrop(Location location, ItemStack itemStack) {
        String string = ItemStackBuilder_4.u(itemStack);
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(location.getBlock());
        blockBridge_9.b(location.getBlock(), string);
        MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)ItemStackRegistry.g().e(string);
        materialBridge_9.aw(location.getBlock());
    }

    @Deprecated
    public static boolean isCustomCrop(Block block) {
        if (MaterialBridge_9.ax(block)) {
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            return blockBridge_9.aa(block) != null;
        }
        return false;
    }

    @Deprecated
    public static String getCustomSeedNameFromCrop(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        return blockBridge_9.aa(block);
    }

    @Deprecated
    @Nullable
    public static ItemStack getCustomBlock(Block block) {
        if (LocationBridgeBuilder_2.av(block)) {
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
            if (locationBridgeBuilder_2 == null) {
                return null;
            }
            return locationBridgeBuilder_2.mP();
        }
        return new ItemStack(block.getType());
    }

    @Deprecated
    public static boolean matchCustomItemName(ItemStack itemStack, String string) {
        return ItemStackBuilder_4.b(itemStack, ItemsAdder.getCustomItem(string));
    }

    @Deprecated
    public static boolean isFurniture(Entity entity) {
        if (entity == null) {
            return false;
        }
        if (!(entity instanceof ArmorStand)) {
            return false;
        }
        ArmorStand armorStand = (ArmorStand)entity;
        ItemStack itemStack = armorStand.getHelmet().clone();
        if (itemStack == null) {
            return false;
        }
        if (!ItemStackBuilder_4.isCustomItem(itemStack)) {
            return false;
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        return itemStackBuilder_4.Ge.bm("furniture");
    }

    @Deprecated
    public static String getCustomItemName(ItemStack itemStack) {
        return ItemStackBuilder_4.u(itemStack);
    }

    @Deprecated
    public static int getCustomItemUsages(ItemStack itemStack) {
        Integer n = ItemStackBuilder_4.z(itemStack);
        if (n == null) {
            return 0;
        }
        return n;
    }

    @Deprecated
    public static ItemStack setCustomItemDurability(ItemStack itemStack, int n) {
        if (!ItemStackBuilder_4.F(itemStack)) {
            ItemStackBridge_2.d(itemStack, n);
            return itemStack;
        }
        ItemStackBuilder_4.d(itemStack, n);
        return itemStack;
    }

    @Deprecated
    public static ItemStack setCustomItemMaxDurability(ItemStack itemStack, int n) {
        if (!ItemStackBuilder_4.F(itemStack)) {
            ItemStackBridge_2.d(itemStack, n);
            return itemStack;
        }
        ItemStackBuilder_4.c(itemStack, n);
        return itemStack;
    }

    @Deprecated
    public static int getCustomItemDurability(ItemStack itemStack) {
        if (ItemStackBuilder_4.F(itemStack)) {
            return ItemStackBridge_2.al(itemStack);
        }
        return ItemStackBridge_2.al(itemStack);
    }

    @Deprecated
    public static int getCustomItemMaxDurability(ItemStack itemStack) {
        return ItemStackBuilder_4.E(itemStack);
    }

    @Deprecated
    public static List getNamespacedBlocksNamesInConfig(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (LocationBridgeBuilder_2 locationBridgeBuilder_2 : ItemStackRegistry.g().S) {
            if (string != null && !string.isEmpty() && !string.equals("itemsadder") && !"itemsadder".contains(string) && !locationBridgeBuilder_2.getNamespacedID().contains(string)) continue;
            arrayList.add(locationBridgeBuilder_2.getNamespacedID());
        }
        return arrayList;
    }

    @Deprecated
    public static List getNamespacedBlocksNamesInConfig() {
        return ItemsAdder.getNamespacedBlocksNamesInConfig(null);
    }

    @Deprecated
    public static BlockData getCustomBlockBlockData(ItemStack itemStack, boolean bl) {
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().c(itemStack);
        if (locationBridgeBuilder_2.Hq != RealEnum.TILE) {
            return locationBridgeBuilder_2.FD.pb();
        }
        return null;
    }

    public static boolean playTotemAnimation(Player player, String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        SoundBridge.b(Sound.ITEM_TOTEM_USE, player, SoundCategory.PLAYERS, 20L, () -> PlayerHolder_4.e(player, itemStackBuilder_4));
        return true;
    }

    @Deprecated
    public static void setLiquid(String string, Location location) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e((String)ItemStackRegistry.g().bf.get(string));
        if (itemStackBuilder_4 == null) {
            throw new RuntimeException("Unknown liquid bucket: " + string);
        }
        BlockBridge_7 blockBridge_7 = (BlockBridge_7)itemStackBuilder_4.Ge.bn("liquid_bucket");
        if (blockBridge_7 == null) {
            throw new RuntimeException("Custom item has lo 'liquid_bucket' behaviour: " + string);
        }
        Block block = location.getBlock();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(block.getChunk());
        blockBridge_9.c(block, string);
        blockBridge_9.d(block, BiomeHolder.a(block, Biome.PLAINS).getKey().toString());
        BiomeHolder.tG().a(block, blockBridge_7.kU().getNamespace(), blockBridge_7.kU().getId());
        block.setType(Material.WATER);
    }

    @Deprecated
    @Nullable
    public static String getLiquidName(Location location) {
        Block block = location.getBlock();
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(block.getChunk());
        if (blockBridge_9.isCustomBlock(block)) {
            return blockBridge_9.ab(block);
        }
        return null;
    }

    public static boolean hasKeepOnDeath(ItemStack itemStack) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return itemStackBuilder_4.Ge.bm("keep_on_death");
    }

    public static boolean hasKeepOnDeath(String string) {
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e((String)ItemStackRegistry.g().bf.get(string));
        if (itemStackBuilder_4 == null) {
            return false;
        }
        return itemStackBuilder_4.Ge.bm("keep_on_death");
    }

    public static void applyResourcepack(Player player) {
        ItemStackRegistry.g().as.aui.cp(player);
    }

    public static List getAllItems() {
        if (!ItemsAdder.areItemsLoaded()) {
            return null;
        }
        ArrayList<CustomStack> arrayList = new ArrayList<CustomStack>();
        LinkedHashMap linkedHashMap = ItemStackRegistry.g().C;
        if (linkedHashMap == null) {
            return new ArrayList();
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(CustomStack.getInstance(((ItemStackBuilder_4)entry.getValue()).getNamespacedID()));
        }
        return arrayList;
    }

    public static List getAllItems(String string) {
        if (!ItemsAdder.areItemsLoaded()) {
            return null;
        }
        ArrayList<CustomStack> arrayList = new ArrayList<CustomStack>();
        HashMap hashMap = (HashMap)ItemStackRegistry.g().M.get(string);
        if (hashMap == null) {
            return new ArrayList();
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(CustomStack.getInstance(((ItemStackBuilder_4)entry.getValue()).getNamespacedID()));
        }
        return arrayList;
    }

    public static List getAllItems(Material material) {
        if (!ItemsAdder.areItemsLoaded()) {
            return null;
        }
        ArrayList<CustomStack> arrayList = new ArrayList<CustomStack>();
        List list = (List)ItemStackRegistry.g().N.get(material);
        if (list == null) {
            return new ArrayList();
        }
        for (ItemStackBuilder_4 itemStackBuilder_4 : list) {
            arrayList.add(CustomStack.getInstance(itemStackBuilder_4.getNamespacedID()));
        }
        return arrayList;
    }

    public static boolean isCustomRecipe(NamespacedKey namespacedKey) {
        return ItemStackRegistry.g().aW.cw(namespacedKey.toString());
    }

    public static boolean isCustomRecipe(String string) {
        return ItemStackRegistry.g().aW.cw(string);
    }

    @Nullable
    public static String getPackUrl(boolean bl) {
        try {
            return ItemStackRegistry.g().as.aui.Ca();
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
