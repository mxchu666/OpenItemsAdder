package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class bp
extends Record {
    private final String avL;
    private final int avM;
    private final boolean avN;
    private final String avO;

    bp(String string, int n, boolean bl, String string2) {
        this.avL = string;
        this.avM = n;
        this.avN = bl;
        this.avO = string2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bp.class, "kind;stageIndex;success;log", "avL", "avM", "avN", "avO"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bp.class, "kind;stageIndex;success;log", "avL", "avM", "avN", "avO"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bp.class, "kind;stageIndex;success;log", "avL", "avM", "avN", "avO"}, this, object);
    }

    public String zX() {
        return this.avL;
    }

    public int zY() {
        return this.avM;
    }

    public boolean rC() {
        return this.avN;
    }

    public String zZ() {
        return this.avO;
    }
}
