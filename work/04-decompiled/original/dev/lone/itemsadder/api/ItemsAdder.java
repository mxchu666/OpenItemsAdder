package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.afj;
import itemsadder.m.aqp;
import itemsadder.m.bbs;
import itemsadder.m.bcu;
import itemsadder.m.d;
import itemsadder.m.kd;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.qm;
import itemsadder.m.rb;
import itemsadder.m.sd;
import itemsadder.m.ub;
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
        return d.g() != null && d.g().u;
    }

    @Deprecated
    public static boolean isCustomItem(ItemStack itemStack) {
        return qm.isCustomItem(itemStack);
    }

    @Deprecated
    public static boolean isCustomItem(String string) {
        return d.g().f(string);
    }

    @Deprecated
    public static ItemStack getCustomItem(String string) {
        return d.g().q(string);
    }

    @Deprecated
    public static void placeCustomBlock(Location location, ItemStack itemStack) {
        String string = qm.u(itemStack);
        ql ql2 = d.g().h(string);
        ql2.M(location);
    }

    @Deprecated
    public static void removeCustomBlock(Location location) {
        ms ms2 = d.g().a(location);
        if (!ms2.isCustomBlock(location.getBlock())) {
            return;
        }
        ms2.ag(location.getBlock());
    }

    @Deprecated
    public static ItemStack getCustomBlockByFaces(Material material, HashMap hashMap) {
        return d.g().a(material, hashMap);
    }

    @Deprecated
    public static boolean isCustomBlock(Block block) {
        if (ql.av(block)) {
            ms ms2 = d.g().b(block);
            return ms2.isCustomBlock(block);
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
        ms ms2 = d.g().b(block);
        if (!ms2.isCustomBlock(block)) {
            return arrayList;
        }
        ql ql2 = d.g().h(ms2.Y(block));
        if (ql2 == null) {
            return arrayList;
        }
        if (!ql2.p(itemStack)) {
            return arrayList;
        }
        List list = d.g().aq.e(block, ql2);
        if (list != null) {
            for (ub ub2 : list) {
                if (!ub2.ln().getNamespacedID().equals(ql2.getNamespacedID()) || ub2.a(itemStack, block.getType())) continue;
                arrayList.addAll(ub2.N(itemStack));
            }
        }
        if (bl && ql2.mG()) {
            arrayList.add(ql2.mP());
        }
        return arrayList;
    }

    @Deprecated
    public static void placeCustomCrop(Location location, ItemStack itemStack) {
        String string = qm.u(itemStack);
        ms ms2 = d.g().b(location.getBlock());
        ms2.b(location.getBlock(), string);
        rb rb2 = (rb)d.g().e(string);
        rb2.aw(location.getBlock());
    }

    @Deprecated
    public static boolean isCustomCrop(Block block) {
        if (rb.ax(block)) {
            ms ms2 = d.g().b(block);
            return ms2.aa(block) != null;
        }
        return false;
    }

    @Deprecated
    public static String getCustomSeedNameFromCrop(Block block) {
        ms ms2 = d.g().b(block);
        return ms2.aa(block);
    }

    @Deprecated
    @Nullable
    public static ItemStack getCustomBlock(Block block) {
        if (ql.av(block)) {
            ms ms2 = d.g().b(block);
            ql ql2 = d.g().h(ms2.Y(block));
            if (ql2 == null) {
                return null;
            }
            return ql2.mP();
        }
        return new ItemStack(block.getType());
    }

    @Deprecated
    public static boolean matchCustomItemName(ItemStack itemStack, String string) {
        return qm.b(itemStack, ItemsAdder.getCustomItem(string));
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
        if (!qm.isCustomItem(itemStack)) {
            return false;
        }
        qm qm2 = d.g().a(itemStack);
        return qm2.Ge.bm("furniture");
    }

    @Deprecated
    public static String getCustomItemName(ItemStack itemStack) {
        return qm.u(itemStack);
    }

    @Deprecated
    public static int getCustomItemUsages(ItemStack itemStack) {
        Integer n = qm.z(itemStack);
        if (n == null) {
            return 0;
        }
        return n;
    }

    @Deprecated
    public static ItemStack setCustomItemDurability(ItemStack itemStack, int n) {
        if (!qm.F(itemStack)) {
            bbs.d(itemStack, n);
            return itemStack;
        }
        qm.d(itemStack, n);
        return itemStack;
    }

    @Deprecated
    public static ItemStack setCustomItemMaxDurability(ItemStack itemStack, int n) {
        if (!qm.F(itemStack)) {
            bbs.d(itemStack, n);
            return itemStack;
        }
        qm.c(itemStack, n);
        return itemStack;
    }

    @Deprecated
    public static int getCustomItemDurability(ItemStack itemStack) {
        if (qm.F(itemStack)) {
            return bbs.al(itemStack);
        }
        return bbs.al(itemStack);
    }

    @Deprecated
    public static int getCustomItemMaxDurability(ItemStack itemStack) {
        return qm.E(itemStack);
    }

    @Deprecated
    public static List getNamespacedBlocksNamesInConfig(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (ql ql2 : d.g().S) {
            if (string != null && !string.isEmpty() && !string.equals("itemsadder") && !"itemsadder".contains(string) && !ql2.getNamespacedID().contains(string)) continue;
            arrayList.add(ql2.getNamespacedID());
        }
        return arrayList;
    }

    @Deprecated
    public static List getNamespacedBlocksNamesInConfig() {
        return ItemsAdder.getNamespacedBlocksNamesInConfig(null);
    }

    @Deprecated
    public static BlockData getCustomBlockBlockData(ItemStack itemStack, boolean bl) {
        ql ql2 = d.g().c(itemStack);
        if (ql2.Hq != sd.TILE) {
            return ql2.FD.pb();
        }
        return null;
    }

    public static boolean playTotemAnimation(Player player, String string) {
        qm qm2 = d.g().e(string);
        if (qm2 == null) {
            return false;
        }
        bcu.b(Sound.ITEM_TOTEM_USE, player, SoundCategory.PLAYERS, 20L, () -> aqp.e(player, qm2));
        return true;
    }

    @Deprecated
    public static void setLiquid(String string, Location location) {
        qm qm2 = d.g().e((String)d.g().bf.get(string));
        if (qm2 == null) {
            throw new RuntimeException("Unknown liquid bucket: " + string);
        }
        kd kd2 = (kd)qm2.Ge.bn("liquid_bucket");
        if (kd2 == null) {
            throw new RuntimeException("Custom item has lo 'liquid_bucket' behaviour: " + string);
        }
        Block block = location.getBlock();
        ms ms2 = d.g().a(block.getChunk());
        ms2.c(block, string);
        ms2.d(block, afj.a(block, Biome.PLAINS).getKey().toString());
        afj.tG().a(block, kd2.kU().getNamespace(), kd2.kU().getId());
        block.setType(Material.WATER);
    }

    @Deprecated
    @Nullable
    public static String getLiquidName(Location location) {
        Block block = location.getBlock();
        ms ms2 = d.g().a(block.getChunk());
        if (ms2.isCustomBlock(block)) {
            return ms2.ab(block);
        }
        return null;
    }

    public static boolean hasKeepOnDeath(ItemStack itemStack) {
        qm qm2 = d.g().a(itemStack);
        if (qm2 == null) {
            return false;
        }
        return qm2.Ge.bm("keep_on_death");
    }

    public static boolean hasKeepOnDeath(String string) {
        qm qm2 = d.g().e((String)d.g().bf.get(string));
        if (qm2 == null) {
            return false;
        }
        return qm2.Ge.bm("keep_on_death");
    }

    public static void applyResourcepack(Player player) {
        d.g().as.aui.cp(player);
    }

    public static List getAllItems() {
        if (!ItemsAdder.areItemsLoaded()) {
            return null;
        }
        ArrayList<CustomStack> arrayList = new ArrayList<CustomStack>();
        LinkedHashMap linkedHashMap = d.g().C;
        if (linkedHashMap == null) {
            return new ArrayList();
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(CustomStack.getInstance(((qm)entry.getValue()).getNamespacedID()));
        }
        return arrayList;
    }

    public static List getAllItems(String string) {
        if (!ItemsAdder.areItemsLoaded()) {
            return null;
        }
        ArrayList<CustomStack> arrayList = new ArrayList<CustomStack>();
        HashMap hashMap = (HashMap)d.g().M.get(string);
        if (hashMap == null) {
            return new ArrayList();
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(CustomStack.getInstance(((qm)entry.getValue()).getNamespacedID()));
        }
        return arrayList;
    }

    public static List getAllItems(Material material) {
        if (!ItemsAdder.areItemsLoaded()) {
            return null;
        }
        ArrayList<CustomStack> arrayList = new ArrayList<CustomStack>();
        List list = (List)d.g().N.get(material);
        if (list == null) {
            return new ArrayList();
        }
        for (qm qm2 : list) {
            arrayList.add(CustomStack.getInstance(qm2.getNamespacedID()));
        }
        return arrayList;
    }

    public static boolean isCustomRecipe(NamespacedKey namespacedKey) {
        return d.g().aW.cw(namespacedKey.toString());
    }

    public static boolean isCustomRecipe(String string) {
        return d.g().aW.cw(string);
    }

    @Nullable
    public static String getPackUrl(boolean bl) {
        try {
            return d.g().as.aui.Ca();
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}
