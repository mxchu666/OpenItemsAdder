package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.Material;

public final class RecordOfValue_26
extends Record {
    private final ItemStackBuilder_4 Kd;
    private final boolean Ke;
    private final Material Kf;

    public RecordOfValue_26(ItemStackBuilder_4 itemStackBuilder_4, boolean bl, Material material) {
        this.Kd = itemStackBuilder_4;
        this.Ke = bl;
        this.Kf = material;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_26.class, "item;needsToSaveBecauseEditedArmor;material", "Kd", "Ke", "Kf"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_26.class, "item;needsToSaveBecauseEditedArmor;material", "Kd", "Ke", "Kf"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_26.class, "item;needsToSaveBecauseEditedArmor;material", "Kd", "Ke", "Kf"}, this, object);
    }

    public ItemStackBuilder_4 pu() {
        return this.Kd;
    }

    public boolean pv() {
        return this.Ke;
    }

    public Material pw() {
        return this.Kf;
    }
}
