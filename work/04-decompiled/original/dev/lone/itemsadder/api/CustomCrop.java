package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.bay;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.rb;
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
        rb rb2 = (rb)d.g().e(string);
        if (rb2 == null) {
            return null;
        }
        CustomCrop customCrop = new CustomCrop(location.getBlock(), new CustomStack(rb2));
        ms ms2 = d.g().b(customCrop.block);
        ms2.b(customCrop.block, string);
        rb2.aw(location.getBlock());
        return customCrop;
    }

    @Nullable
    public static CustomCrop byAlreadyPlaced(Block block) {
        if (!rb.ax(block)) {
            return null;
        }
        rb rb2 = CustomCrop.get(block);
        if (rb2 == null) {
            return null;
        }
        return new CustomCrop(block, new CustomStack(rb2));
    }

    public static boolean isSeed(ItemStack itemStack) {
        return d.g().d(itemStack);
    }

    @Nullable
    public static List getLoot(Block block, @Nullable ItemStack itemStack) {
        rb rb2 = CustomCrop.get(block);
        if (rb2 == null) {
            return null;
        }
        return rb2.L(itemStack);
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
        return bay.getAge(this.block);
    }

    public void setAge(int n) {
        bay.setAge(this.block, n);
    }

    public boolean isFullyGrown() {
        return bay.bn(this.block);
    }

    public int getMaxAge() {
        return bay.bo(this.block);
    }

    public void setFullyGrown() {
        this.setAge(this.getMaxAge());
    }

    public void incrementAge() {
        this.setAge(this.getAge() + 1);
    }

    @Nullable
    private static rb get(Block block) {
        ms ms2 = d.g().b(block);
        String string = ms2.aa(block);
        if (string == null) {
            return null;
        }
        return (rb)d.g().e(string);
    }
}
