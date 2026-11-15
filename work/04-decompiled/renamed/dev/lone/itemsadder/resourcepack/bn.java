package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;

final class bn
extends Record {
    private final boolean avI;
    private final String avJ;
    private final List avK;

    bn(boolean bl, String string, List list) {
        this.avI = bl;
        this.avJ = string;
        this.avK = list;
    }

    static bn fP(String string) {
        return new bn(false, string, List.of());
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bn.class, "available;unavailableReason;messages", "avI", "avJ", "avK"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bn.class, "available;unavailableReason;messages", "avI", "avJ", "avK"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bn.class, "available;unavailableReason;messages", "avI", "avJ", "avK"}, this, object);
    }

    public boolean P() {
        return this.avI;
    }

    public String zV() {
        return this.avJ;
    }

    public List zW() {
        return this.avK;
    }
}
