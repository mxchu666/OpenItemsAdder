package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class fp
extends Record {
    private final int tL;
    private final int tM;
    private final int tN;

    private fp(int n, int n2, int n3) {
        this.tL = n;
        this.tM = n2;
        this.tN = n3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{fp.class, "chunkX;chunkZ;sectionY", "tL", "tM", "tN"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{fp.class, "chunkX;chunkZ;sectionY", "tL", "tM", "tN"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{fp.class, "chunkX;chunkZ;sectionY", "tL", "tM", "tN"}, this, object);
    }

    public int hG() {
        return this.tL;
    }

    public int hH() {
        return this.tM;
    }

    public int hN() {
        return this.tN;
    }
}
