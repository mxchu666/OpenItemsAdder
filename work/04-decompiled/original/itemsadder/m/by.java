package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public final class by
extends Record {
    private final ItemStack hZ;
    @Nullable
    private final ItemStack ia;
    @Nullable
    private final Float ib;
    @Nullable
    private final Float ic;
    @Nullable
    private final Float ie;

    public by(ItemStack itemStack, @Nullable ItemStack itemStack2, @Nullable Float f, @Nullable Float f2, @Nullable Float f3) {
        this.hZ = itemStack;
        this.ia = itemStack2;
        this.ib = f;
        this.ic = f2;
        this.ie = f3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{by.class, "item;billboardItem;hitboxOverrideWidth;hitboxOverrideLength;hitboxOverrideHeight", "hZ", "ia", "ib", "ic", "ie"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{by.class, "item;billboardItem;hitboxOverrideWidth;hitboxOverrideLength;hitboxOverrideHeight", "hZ", "ia", "ib", "ic", "ie"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{by.class, "item;billboardItem;hitboxOverrideWidth;hitboxOverrideLength;hitboxOverrideHeight", "hZ", "ia", "ib", "ic", "ie"}, this, object);
    }

    public ItemStack bG() {
        return this.hZ;
    }

    @Nullable
    public ItemStack bH() {
        return this.ia;
    }

    @Nullable
    public Float bI() {
        return this.ib;
    }

    @Nullable
    public Float bJ() {
        return this.ic;
    }

    @Nullable
    public Float bK() {
        return this.ie;
    }
}
