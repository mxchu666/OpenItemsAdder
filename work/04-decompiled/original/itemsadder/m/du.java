package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.SoundCategory;

public final class du
extends Record {
    private final String oZ;
    private final SoundCategory pa;
    private final float pb;
    private final float pc;
    private final float pd;

    public du(String string, SoundCategory soundCategory, float f, float f2, float f3) {
        this.oZ = string;
        this.pa = soundCategory;
        this.pb = f;
        this.pc = f2;
        this.pd = f3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{du.class, "name;category;volume;pitch;repeatIntervalSeconds", "oZ", "pa", "pb", "pc", "pd"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{du.class, "name;category;volume;pitch;repeatIntervalSeconds", "oZ", "pa", "pb", "pc", "pd"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{du.class, "name;category;volume;pitch;repeatIntervalSeconds", "oZ", "pa", "pb", "pc", "pd"}, this, object);
    }

    public String fN() {
        return this.oZ;
    }

    public SoundCategory fO() {
        return this.pa;
    }

    public float fP() {
        return this.pb;
    }

    public float fQ() {
        return this.pc;
    }

    public float fR() {
        return this.pd;
    }
}
