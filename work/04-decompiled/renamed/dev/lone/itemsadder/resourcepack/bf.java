package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class bf
extends Record {
    private final int avo;
    private final int avp;
    private final int avq;
    private final int avr;

    private bf(int n, int n2, int n3, int n4) {
        this.avo = n;
        this.avp = n2;
        this.avq = n3;
        this.avr = n4;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bf.class, "type;dataOffset;length;crcOffset", "avo", "avp", "avq", "avr"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bf.class, "type;dataOffset;length;crcOffset", "avo", "avp", "avq", "avr"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bf.class, "type;dataOffset;length;crcOffset", "avo", "avp", "avq", "avr"}, this, object);
    }

    public int zL() {
        return this.avo;
    }

    public int zM() {
        return this.avp;
    }

    public int zN() {
        return this.avq;
    }

    public int zO() {
        return this.avr;
    }
}
