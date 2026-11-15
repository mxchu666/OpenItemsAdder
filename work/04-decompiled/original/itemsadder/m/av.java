package itemsadder.m;

import itemsadder.m.aw;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class av
extends Record {
    private final aw gA;

    public av(aw aw2) {
        this.gA = aw2;
    }

    public static av aM() {
        return new av(aw.FAILED);
    }

    public static av aN() {
        return new av(aw.SUCCESS);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{av.class, "status", "gA"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{av.class, "status", "gA"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{av.class, "status", "gA"}, this, object);
    }

    public aw aO() {
        return this.gA;
    }
}
