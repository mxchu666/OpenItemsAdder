package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBridge_9;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CustomCrop {
    private final Block block;
    private final CustomStack seed_customStack;

    private CustomCrop(Block block, CustomStack customStack) {
        this.block = block;
        this.seed_customStack = customStack;
    }

    @Nullable
    public static CustomCrop place(String string, Location location) {
        MaterialBridge_9 materialBridge_9 = (MaterialBridge_9)ItemStackRegistry.g().e(string);
        if (materialBridge_9 == null) {
            return null;
        }
        CustomCrop customCrop = new CustomCrop(location.getBlock(), new CustomStack(materialBridge_9));
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(customCrop.block);
        blockBridge_9.b(customCrop.block, string);
        materialBridge_9.aw(location.getBlock());
        return customCrop;
    }

    @Nullable
    public static CustomCrop byAlreadyPlaced(Block block) {
        if (!MaterialBridge_9.ax(block)) {
            return null;
        }
        MaterialBridge_9 materialBridge_9 = CustomCrop.get(block);
        if (materialBridge_9 == null) {
            return null;
        }
        return new CustomCrop(block, new CustomStack(materialBridge_9));
    }

    public static boolean isSeed(ItemStack itemStack) {
        return ItemStackRegistry.g().d(itemStack);
    }

    @Nullable
    public static List getLoot(Block block, @Nullable ItemStack itemStack) {
        MaterialBridge_9 materialBridge_9 = CustomCrop.get(block);
        if (materialBridge_9 == null) {
            return null;
        }
        return materialBridge_9.L(itemStack);
    }

    @Nullable
    public static List getLoot(Block block) {
        return CustomCrop.getLoot(block, null);
    }

    public CustomStack getSeed() {
        return this.seed_customStack;
    }

    @Nullable
    public List getLoot(@Nullable ItemStack itemStack) {
        if (this.block == null) {
            return null;
        }
        return CustomCrop.getLoot(this.block, itemStack);
    }

    @Nullable
    public List getLoot() {
        return CustomCrop.getLoot(this.block, null);
    }

    public int getAge() {
        return BlockBridge_2.getAge(this.block);
    }

    public void setAge(int n) {
        BlockBridge_2.setAge(this.block, n);
    }

    public boolean isFullyGrown() {
        return BlockBridge_2.bn(this.block);
    }

    public int getMaxAge() {
        return BlockBridge_2.bo(this.block);
    }

    public void setFullyGrown() {
        this.setAge(this.getMaxAge());
    }

    public void incrementAge() {
        this.setAge(this.getAge() + 1);
    }

    @Nullable
    private static MaterialBridge_9 get(Block block) {
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        String string = blockBridge_9.aa(block);
        if (string == null) {
            return null;
        }
        return (MaterialBridge_9)ItemStackRegistry.g().e(string);
    }
}
