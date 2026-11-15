package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.UUID;

public final class aot
extends Record {
    private final int aka;
    private final UUID akb;

    public aot(int n, UUID uUID) {
        this.aka = n;
        this.akb = uUID;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{aot.class, "entityId;uuid", "aka", "akb"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{aot.class, "entityId;uuid", "aka", "akb"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{aot.class, "entityId;uuid", "aka", "akb"}, this, object);
    }

    public int ux() {
        return this.aka;
    }

    public UUID uy() {
        return this.akb;
    }
}
