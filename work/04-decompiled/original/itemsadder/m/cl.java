package itemsadder.m;

import itemsadder.m.cj;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.util.Vector;

final class cl
extends Record {
    private final Vector kw;
    private final Vector kx;
    private final double ky;
    private final cj kz;
    private final long kA;

    private cl(Vector vector, Vector vector2, double d, cj cj2, long l) {
        this.kw = vector.clone();
        this.kx = vector2.clone();
        this.ky = d;
        this.kz = cj2;
        this.kA = l;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{cl.class, "lastOrigin;lastDir;lastReach;result;tick", "kw", "kx", "ky", "kz", "kA"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{cl.class, "lastOrigin;lastDir;lastReach;result;tick", "kw", "kx", "ky", "kz", "kA"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{cl.class, "lastOrigin;lastDir;lastReach;result;tick", "kw", "kx", "ky", "kz", "kA"}, this, object);
    }

    public Vector cM() {
        return this.kw;
    }

    public Vector cN() {
        return this.kx;
    }

    public double cO() {
        return this.ky;
    }

    public cj cP() {
        return this.kz;
    }

    public long cQ() {
        return this.kA;
    }
}
