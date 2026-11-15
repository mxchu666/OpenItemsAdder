package itemsadder.m;

import itemsadder.m.ItemDisplayLocationHolder;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.bukkit.util.Vector;

final class RecordOfVector
extends Record {
    private final Vector kw;
    private final Vector kx;
    private final double ky;
    private final ItemDisplayLocationHolder kz;
    private final long kA;

    private RecordOfVector(Vector vector, Vector vector2, double d, ItemDisplayLocationHolder itemDisplayLocationHolder, long l) {
        this.kw = vector.clone();
        this.kx = vector2.clone();
        this.ky = d;
        this.kz = itemDisplayLocationHolder;
        this.kA = l;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfVector.class, "lastOrigin;lastDir;lastReach;result;tick", "kw", "kx", "ky", "kz", "kA"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfVector.class, "lastOrigin;lastDir;lastReach;result;tick", "kw", "kx", "ky", "kz", "kA"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfVector.class, "lastOrigin;lastDir;lastReach;result;tick", "kw", "kx", "ky", "kz", "kA"}, this, object);
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

    public ItemDisplayLocationHolder cP() {
        return this.kz;
    }

    public long cQ() {
        return this.kA;
    }
}
