package itemsadder.m;

import itemsadder.m.qm;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.Material;

public final class ta
extends Record {
    private final qm Kd;
    private final boolean Ke;
    private final Material Kf;

    public ta(qm qm2, boolean bl, Material material) {
        this.Kd = qm2;
        this.Ke = bl;
        this.Kf = material;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ta.class, "item;needsToSaveBecauseEditedArmor;material", "Kd", "Ke", "Kf"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ta.class, "item;needsToSaveBecauseEditedArmor;material", "Kd", "Ke", "Kf"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ta.class, "item;needsToSaveBecauseEditedArmor;material", "Kd", "Ke", "Kf"}, this, object);
    }

    public qm pu() {
        return this.Kd;
    }

    public boolean pv() {
        return this.Ke;
    }

    public Material pw() {
        return this.Kf;
    }
}
