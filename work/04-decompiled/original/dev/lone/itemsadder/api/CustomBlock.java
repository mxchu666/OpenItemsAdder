package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.bay;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.ub;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CustomBlock
extends CustomStack {
    private final ql internalBlock;
    private Block bukkitBlock;

    CustomBlock(ql ql2, Block block) {
        super(ql2);
        this.internalBlock = ql2;
        this.bukkitBlock = block;
    }

    CustomBlock(ql ql2) {
        super(ql2);
        this.internalBlock = ql2;
    }

    public static Set getNamespacedIdsInRegistry() {
        return d.g().T.keySet();
    }

    public static boolean isInRegistry(String string) {
        return d.g().T.containsKey(string);
    }

    @Nullable
    private static CustomBlock getOriginal(String string) {
        if (!d.g().f(string)) {
            return null;
        }
        ql ql2 = d.g().h(string);
        CustomBlock customBlock = new CustomBlock(ql2);
        return customBlock;
    }

    @Nullable
    public static CustomBlock getInstance(String string) {
        CustomBlock customBlock = CustomBlock.getOriginal(string);
        if (customBlock != null) {
            customBlock.itemStack = customBlock.internalItem.mP();
        }
        return customBlock;
    }

    @Nullable
    public static CustomBlock byItemStack(ItemStack itemStack) {
        ql ql2 = d.g().c(itemStack);
        if (ql2 == null) {
            return null;
        }
        return new CustomBlock(ql2);
    }

    @Nullable
    public static CustomBlock place(String string, Location location) {
        ql ql2 = d.g().h(string);
        if (ql2 == null) {
            return null;
        }
        ql2.M(location);
        return new CustomBlock(ql2, location.getBlock());
    }

    @Nullable
    public static CustomBlock byAlreadyPlaced(Block block) {
        if (!ql.av(block)) {
            return null;
        }
        ms ms2 = d.g().b(block);
        ql ql2 = d.g().h(ms2.Y(block));
        if (ql2 == null) {
            return null;
        }
        return new CustomBlock(ql2, block);
    }

    public static boolean remove(Location location) {
        location.getBlock().setType(Material.AIR, false);
        ms ms2 = d.g().a(location);
        if (!ms2.isCustomBlock(location.getBlock())) {
            return false;
        }
        ms2.ag(location.getBlock());
        bay.bk(location.getBlock());
        return true;
    }

    @Deprecated
    @Nullable
    public BlockData generateBlockData() {
        return this.internalBlock.FD.pb();
    }

    @Nullable
    public BlockData getBaseBlockData() {
        return this.internalBlock.FD.pb();
    }

    @Nullable
    public static BlockData getBaseBlockData(String string) {
        ql ql2 = d.g().h(string);
        if (ql2 == null) {
            return null;
        }
        if (ql2.FD != null) {
            return ql2.FD.pb();
        }
        return null;
    }

    @Nullable
    public Block getBlock() {
        return this.bukkitBlock;
    }

    public boolean isPlaced() {
        return this.bukkitBlock != null;
    }

    public CustomBlock place(Location location) {
        this.bukkitBlock = location.getBlock();
        this.internalBlock.M(location);
        return this;
    }

    public boolean remove() {
        if (CustomBlock.remove(this.bukkitBlock.getLocation())) {
            this.bukkitBlock = null;
            return true;
        }
        return false;
    }

    public boolean playBreakEffect() {
        return CustomBlock.playBreakEffect(this.bukkitBlock, this.internalBlock);
    }

    public static boolean playBreakEffect(Block block) {
        return CustomBlock.playBreakEffect(block, CustomBlock.getInternalBlock(block));
    }

    private static boolean playBreakEffect(Block block, ql ql2) {
        if (ql2 != null && ql2.FD != null) {
            ql2.FD.T(block.getLocation());
            ql2.xu.HP.a(block.getLocation(), SoundCategory.BLOCKS);
            return true;
        }
        return false;
    }

    public boolean playBreakSound() {
        return CustomBlock.playBreakSound(this.bukkitBlock, this.internalBlock);
    }

    public static boolean playBreakSound(Block block) {
        return CustomBlock.playBreakSound(block, CustomBlock.getInternalBlock(block));
    }

    private static boolean playBreakSound(Block block, ql ql2) {
        if (ql2 != null && ql2.FD != null) {
            ql2.xu.HP.a(block.getLocation(), SoundCategory.BLOCKS);
            return true;
        }
        return false;
    }

    public boolean playBreakParticles() {
        return CustomBlock.playBreakParticles(this.bukkitBlock, this.internalBlock);
    }

    public static boolean playBreakParticles(Block block) {
        return CustomBlock.playBreakParticles(block, CustomBlock.getInternalBlock(block));
    }

    private static boolean playBreakParticles(Block block, ql ql2) {
        if (ql2 != null && ql2.FD != null) {
            ql2.FD.T(block.getLocation());
            return true;
        }
        return false;
    }

    public boolean playPlaceSound() {
        return CustomBlock.playPlaceSound(this.bukkitBlock, this.internalBlock);
    }

    public static boolean playPlaceSound(Block block) {
        return CustomBlock.playPlaceSound(block, CustomBlock.getInternalBlock(block));
    }

    private static boolean playPlaceSound(Block block, ql ql2) {
        if (ql2 != null && ql2.FD != null) {
            ql2.xu.HQ.a(block.getLocation(), SoundCategory.BLOCKS);
            return true;
        }
        return false;
    }

    public List getLoot(boolean bl) {
        return this.getLoot(null, bl);
    }

    public List getLoot() {
        return this.getLoot(null, true);
    }

    public List getLoot(@Nullable ItemStack itemStack, boolean bl) {
        return CustomBlock.getLoot(this.bukkitBlock, this.internalBlock, itemStack, bl);
    }

    public static List getLoot(Block block, @Nullable ItemStack itemStack, boolean bl) {
        ArrayList arrayList = new ArrayList();
        ms ms2 = d.g().b(block);
        if (!ms2.isCustomBlock(block)) {
            return arrayList;
        }
        String string = ms2.Y(block);
        ql ql2 = d.g().h(string);
        return CustomBlock.getLoot(block, ql2, itemStack, bl);
    }

    static List getLoot(Block block, ql ql2, @Nullable ItemStack itemStack, boolean bl) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        if (!ql2.p(itemStack)) {
            return arrayList;
        }
        List list = d.g().aq.e(block, ql2);
        if (list != null) {
            for (ub ub2 : list) {
                if (!ub2.ln().getNamespacedID().equals(ql2.getNamespacedID()) || itemStack != null && ub2.a(itemStack, block.getType())) continue;
                arrayList.addAll(ub2.N(itemStack));
            }
        }
        if (bl && ql2.mG()) {
            arrayList.add(ql2.mP());
        }
        return arrayList;
    }

    public int getOriginalLightLevel() {
        return this.internalBlock.kH();
    }

    public void setCurrentLightLevel(int n) {
        bay.d(this.bukkitBlock, n);
    }

    @Nullable
    private static ql getInternalBlock(Block block) {
        ms ms2 = d.g().b(block);
        if (!ms2.isCustomBlock(block)) {
            return null;
        }
        String string = ms2.Y(block);
        return d.g().h(string);
    }
}
