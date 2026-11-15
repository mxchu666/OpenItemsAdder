package itemsadder.m;

import itemsadder.m.RecordOfValueBuilder_3;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

public final class RecordOfValue_23
extends Record {
    private final int HU;
    private final float HV;
    private final boolean HW;
    private final int HX;
    @Nullable
    private final String HY;
    @Nullable
    private final String HZ;
    @Nullable
    private final Boolean Ia;
    @Nullable
    private final List Ib;

    public RecordOfValue_23(int n, float f, boolean bl, int n2, @Nullable String string, @Nullable String string2, @Nullable Boolean bl2, @Nullable List list) {
        this.HU = n;
        this.HV = f;
        this.HW = bl;
        this.HX = n2;
        this.HY = string;
        this.HZ = string2;
        this.Ia = bl2;
        this.Ib = list;
    }

    @Generated
    public static RecordOfValueBuilder_3 nS() {
        return new RecordOfValueBuilder_3();
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_23.class, "nutrition;saturation;canAlwaysEat;consumeSeconds;animation;sound;particles;effects", "HU", "HV", "HW", "HX", "HY", "HZ", "Ia", "Ib"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_23.class, "nutrition;saturation;canAlwaysEat;consumeSeconds;animation;sound;particles;effects", "HU", "HV", "HW", "HX", "HY", "HZ", "Ia", "Ib"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_23.class, "nutrition;saturation;canAlwaysEat;consumeSeconds;animation;sound;particles;effects", "HU", "HV", "HW", "HX", "HY", "HZ", "Ia", "Ib"}, this, object);
    }

    public int nT() {
        return this.HU;
    }

    public float nU() {
        return this.HV;
    }

    public boolean nV() {
        return this.HW;
    }

    public int nW() {
        return this.HX;
    }

    @Nullable
    public String nX() {
        return this.HY;
    }

    @Nullable
    public String fB() {
        return this.HZ;
    }

    @Nullable
    public Boolean nY() {
        return this.Ia;
    }

    @Nullable
    public List nZ() {
        return this.Ib;
    }
}
