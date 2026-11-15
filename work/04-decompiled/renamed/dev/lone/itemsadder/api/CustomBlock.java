package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ItemStackBridgeImpl;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
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
    private final LocationBridgeBuilder_2 internalBlock;
    private Block bukkitBlock;

    CustomBlock(LocationBridgeBuilder_2 locationBridgeBuilder_2, Block block) {
        super(locationBridgeBuilder_2);
        this.internalBlock = locationBridgeBuilder_2;
        this.bukkitBlock = block;
    }

    CustomBlock(LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        super(locationBridgeBuilder_2);
        this.internalBlock = locationBridgeBuilder_2;
    }

    public static Set getNamespacedIdsInRegistry() {
        return ItemStackRegistry.g().T.keySet();
    }

    public static boolean isInRegistry(String string) {
        return ItemStackRegistry.g().T.containsKey(string);
    }

    @Nullable
    private static CustomBlock getOriginal(String string) {
        if (!ItemStackRegistry.g().f(string)) {
            return null;
        }
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
        CustomBlock customBlock = new CustomBlock(locationBridgeBuilder_2);
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
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().c(itemStack);
        if (locationBridgeBuilder_2 == null) {
            return null;
        }
        return new CustomBlock(locationBridgeBuilder_2);
    }

    @Nullable
    public static CustomBlock place(String string, Location location) {
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
        if (locationBridgeBuilder_2 == null) {
            return null;
        }
        locationBridgeBuilder_2.M(location);
        return new CustomBlock(locationBridgeBuilder_2, location.getBlock());
    }

    @Nullable
    public static CustomBlock byAlreadyPlaced(Block block) {
        if (!LocationBridgeBuilder_2.av(block)) {
            return null;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(blockBridge_9.Y(block));
        if (locationBridgeBuilder_2 == null) {
            return null;
        }
        return new CustomBlock(locationBridgeBuilder_2, block);
    }

    public static boolean remove(Location location) {
        location.getBlock().setType(Material.AIR, false);
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        if (!blockBridge_9.isCustomBlock(location.getBlock())) {
            return false;
        }
        blockBridge_9.ag(location.getBlock());
        BlockBridge_2.bk(location.getBlock());
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
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
        if (locationBridgeBuilder_2 == null) {
            return null;
        }
        if (locationBridgeBuilder_2.FD != null) {
            return locationBridgeBuilder_2.FD.pb();
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

    private static boolean playBreakEffect(Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        if (locationBridgeBuilder_2 != null && locationBridgeBuilder_2.FD != null) {
            locationBridgeBuilder_2.FD.T(block.getLocation());
            locationBridgeBuilder_2.xu.HP.a(block.getLocation(), SoundCategory.BLOCKS);
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

    private static boolean playBreakSound(Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        if (locationBridgeBuilder_2 != null && locationBridgeBuilder_2.FD != null) {
            locationBridgeBuilder_2.xu.HP.a(block.getLocation(), SoundCategory.BLOCKS);
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

    private static boolean playBreakParticles(Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        if (locationBridgeBuilder_2 != null && locationBridgeBuilder_2.FD != null) {
            locationBridgeBuilder_2.FD.T(block.getLocation());
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

    private static boolean playPlaceSound(Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2) {
        if (locationBridgeBuilder_2 != null && locationBridgeBuilder_2.FD != null) {
            locationBridgeBuilder_2.xu.HQ.a(block.getLocation(), SoundCategory.BLOCKS);
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
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (!blockBridge_9.isCustomBlock(block)) {
            return arrayList;
        }
        String string = blockBridge_9.Y(block);
        LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string);
        return CustomBlock.getLoot(block, locationBridgeBuilder_2, itemStack, bl);
    }

    static List getLoot(Block block, LocationBridgeBuilder_2 locationBridgeBuilder_2, @Nullable ItemStack itemStack, boolean bl) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        if (!locationBridgeBuilder_2.p(itemStack)) {
            return arrayList;
        }
        List list = ItemStackRegistry.g().aq.e(block, locationBridgeBuilder_2);
        if (list != null) {
            for (ItemStackBridgeImpl itemStackBridgeImpl : list) {
                if (!itemStackBridgeImpl.ln().getNamespacedID().equals(locationBridgeBuilder_2.getNamespacedID()) || itemStack != null && itemStackBridgeImpl.a(itemStack, block.getType())) continue;
                arrayList.addAll(itemStackBridgeImpl.N(itemStack));
            }
        }
        if (bl && locationBridgeBuilder_2.mG()) {
            arrayList.add(locationBridgeBuilder_2.mP());
        }
        return arrayList;
    }

    public int getOriginalLightLevel() {
        return this.internalBlock.kH();
    }

    public void setCurrentLightLevel(int n) {
        BlockBridge_2.d(this.bukkitBlock, n);
    }

    @Nullable
    private static LocationBridgeBuilder_2 getInternalBlock(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (!blockBridge_9.isCustomBlock(block)) {
            return null;
        }
        String string = blockBridge_9.Y(block);
        return ItemStackRegistry.g().h(string);
    }
}
