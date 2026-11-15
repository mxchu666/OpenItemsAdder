package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2d;

public final class ads
extends Record {
    private final Vector2d Yq;
    private final Vector2d Yr;

    public ads(Vector2d vector2d, Vector2d vector2d2) {
        this.Yq = vector2d;
        this.Yr = vector2d2;
    }

    @NotNull
    public static ads a(Vector2d vector2d, Vector2d vector2d2) {
        return new ads(vector2d, vector2d2);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ads.class, "from;size", "Yq", "Yr"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ads.class, "from;size", "Yq", "Yr"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ads.class, "from;size", "Yq", "Yr"}, this, object);
    }

    public Vector2d tB() {
        return this.Yq;
    }

    public Vector2d tC() {
        return this.Yr;
    }
}
