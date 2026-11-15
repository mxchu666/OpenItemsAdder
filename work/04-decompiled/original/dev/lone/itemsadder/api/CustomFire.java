package dev.lone.itemsadder.api;

import dev.lone.itemsadder.api.CustomStack;
import itemsadder.m.bay;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.qw;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CustomFire
extends CustomStack {
    private final qw internalFire;
    private Block bukkitBlock;

    CustomFire(qw qw2, Block block) {
        super(qw2);
        this.internalFire = qw2;
        this.bukkitBlock = block;
    }

    CustomFire(qw qw2) {
        super(qw2);
        this.internalFire = qw2;
    }

    @Nullable
    private static CustomFire getOriginal(String string) {
        if (!d.g().f(string)) {
            return null;
        }
        qw qw2 = (qw)d.g().e(string);
        return new CustomFire(qw2);
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
        qw qw2 = (qw)d.g().e(string);
        if (qw2 == null) {
            return null;
        }
        qw2.M(location);
        return new CustomFire(qw2, location.getBlock());
    }

    @Nullable
    public static CustomFire byAlreadyPlaced(Block block) {
        if (block.getType() != Material.FIRE) {
            return null;
        }
        ms ms2 = d.g().b(block);
        qw qw2 = (qw)d.g().e(ms2.Y(block));
        if (qw2 == null) {
            return null;
        }
        return new CustomFire(qw2, block);
    }

    public static boolean remove(Location location) {
        location.getBlock().setType(Material.AIR, false);
        ms ms2 = d.g().a(location);
        ms2.ag(location.getBlock());
        bay.bk(location.getBlock());
        return true;
    }

    public static int getAge(@NotNull Block block) {
        if (block.getType() != Material.FIRE) {
            throw new ClassCastException("This block is not a fire block: " + String.valueOf(block.getLocation()));
        }
        return qw.getAge(block);
    }

    public static void setAge(@NotNull Block block, int n) {
        if (block.getType() != Material.FIRE) {
            throw new ClassCastException("This block is not a fire block: " + String.valueOf(block.getLocation()));
        }
        qw.setAge(block, n);
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
        return qw.getAge(this.bukkitBlock);
    }

    public void setAge(int n) {
        qw.setAge(this.bukkitBlock, n);
    }
}
