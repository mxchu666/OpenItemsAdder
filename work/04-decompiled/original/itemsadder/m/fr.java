package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class fr
extends Record {
    private final short[] tW;
    private final int[] tX;
    private final byte[] tY;
    private final byte[] tZ;

    private fr(short[] sArray, int[] nArray, byte[] byArray, byte[] byArray2) {
        this.tW = sArray;
        this.tX = nArray;
        this.tY = byArray;
        this.tZ = byArray2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{fr.class, "positions;modelIds;faceMasks;kinds", "tW", "tX", "tY", "tZ"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{fr.class, "positions;modelIds;faceMasks;kinds", "tW", "tX", "tY", "tZ"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{fr.class, "positions;modelIds;faceMasks;kinds", "tW", "tX", "tY", "tZ"}, this, object);
    }

    public short[] hP() {
        return this.tW;
    }

    public int[] hQ() {
        return this.tX;
    }

    public byte[] hR() {
        return this.tY;
    }

    public byte[] hS() {
        return this.tZ;
    }
}
