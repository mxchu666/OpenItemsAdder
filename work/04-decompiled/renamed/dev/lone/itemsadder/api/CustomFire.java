package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.BlockBridge_12;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ItemStackRegistry;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomFire
extends CustomStack {
    private final BlockBridge_12 internalFire;
    private Block bukkitBlock;

    CustomFire(BlockBridge_12 blockBridge_12, Block block) {
        super(blockBridge_12);
        this.internalFire = blockBridge_12;
        this.bukkitBlock = block;
    }

    CustomFire(BlockBridge_12 blockBridge_12) {
        super(blockBridge_12);
        this.internalFire = blockBridge_12;
    }

    @Nullable
    private static CustomFire getOriginal(String string) {
        if (!ItemStackRegistry.g().f(string)) {
            return null;
        }
        BlockBridge_12 blockBridge_12 = (BlockBridge_12)ItemStackRegistry.g().e(string);
        return new CustomFire(blockBridge_12);
    }

    @Nullable
    public static CustomFire getInstance(String string) {
        CustomFire customFire = CustomFire.getOriginal(string);
        if (customFire != null) {
            customFire.itemStack = customFire.internalItem.mP();
        }
        return customFire;
    }

    @Nullable
    public static CustomFire byItemStack(ItemStack itemStack) {
        return (CustomFire)CustomStack.byItemStack(itemStack);
    }

    @Nullable
    public static CustomFire place(String string, Location location) {
        BlockBridge_12 blockBridge_12 = (BlockBridge_12)ItemStackRegistry.g().e(string);
        if (blockBridge_12 == null) {
            return null;
        }
        blockBridge_12.M(location);
        return new CustomFire(blockBridge_12, location.getBlock());
    }

    @Nullable
    public static CustomFire byAlreadyPlaced(Block block) {
        if (block.getType() != Material.FIRE) {
            return null;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        BlockBridge_12 blockBridge_12 = (BlockBridge_12)ItemStackRegistry.g().e(blockBridge_9.Y(block));
        if (blockBridge_12 == null) {
            return null;
        }
        return new CustomFire(blockBridge_12, block);
    }

    public static boolean remove(Location location) {
        location.getBlock().setType(Material.AIR, false);
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(location);
        blockBridge_9.ag(location.getBlock());
        BlockBridge_2.bk(location.getBlock());
        return true;
    }

    public static int getAge(@NotNull Block block) {
        if (block.getType() != Material.FIRE) {
            throw new ClassCastException("This block is not a fire block: " + String.valueOf(block.getLocation()));
        }
        return BlockBridge_12.getAge(block);
    }

    public static void setAge(@NotNull Block block, int n) {
        if (block.getType() != Material.FIRE) {
            throw new ClassCastException("This block is not a fire block: " + String.valueOf(block.getLocation()));
        }
        BlockBridge_12.setAge(block, n);
    }

    @Nullable
    public Location getLocation() {
        if (this.bukkitBlock == null) {
            return null;
        }
        return this.bukkitBlock.getLocation();
    }

    public boolean isPlaced() {
        return this.bukkitBlock != null;
    }

    public CustomFire place(Location location) {
        this.bukkitBlock = location.getBlock();
        this.internalFire.M(location);
        return this;
    }

    public boolean remove() {
        if (CustomFire.remove(this.bukkitBlock.getLocation())) {
            this.bukkitBlock = null;
            return true;
        }
        return false;
    }

    public int getAge() {
        return BlockBridge_12.getAge(this.bukkitBlock);
    }

    public void setAge(int n) {
        BlockBridge_12.setAge(this.bukkitBlock, n);
    }
}
