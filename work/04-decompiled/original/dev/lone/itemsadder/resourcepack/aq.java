package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.al;
import dev.lone.itemsadder.resourcepack.ap;
import dev.lone.itemsadder.resourcepack.ar;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.Nullable;

final class aq
extends Record {
    private final ar atY;
    private final al atZ;
    private final String aua;
    @Nullable
    private final ap aub;

    aq(ar ar2, al al2, String string) {
        this(ar2, al2, string, null);
    }

    aq(ar ar2, al al2, String string, @Nullable ap ap2) {
        this.atY = ar2;
        this.atZ = al2;
        this.aua = string;
        this.aub = ap2;
    }

    boolean zw() {
        return this.atY == ar.PLANNER_FATAL || this.atY == ar.VANILLA_VERSION_SELECTION_ERROR;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{aq.class, "kind;provenance;message;tree", "atY", "atZ", "aua", "aub"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{aq.class, "kind;provenance;message;tree", "atY", "atZ", "aua", "aub"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{aq.class, "kind;provenance;message;tree", "atY", "atZ", "aua", "aub"}, this, object);
    }

    public ar xU() {
        return this.atY;
    }

    public al xV() {
        return this.atZ;
    }

    public String xY() {
        return this.aua;
    }

    @Nullable
    public ap zx() {
        return this.aub;
    }
}
