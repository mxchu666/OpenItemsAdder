package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.cd;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;

final class bt
extends Record {
    private final cd awi;
    private final String awj;
    private final String awk;
    private final List awl;
    private final boolean awm;
    private final int awn;

    bt(cd cd2, String string, String string2, List list, boolean bl, int n) {
        this.awi = cd2;
        this.awj = string;
        this.awk = string2;
        this.awl = list;
        this.awm = bl;
        this.awn = n;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bt.class, "stage;resourcePath;source;lines;complete;glslVersion", "awi", "awj", "awk", "awl", "awm", "awn"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bt.class, "stage;resourcePath;source;lines;complete;glslVersion", "awi", "awj", "awk", "awl", "awm", "awn"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bt.class, "stage;resourcePath;source;lines;complete;glslVersion", "awi", "awj", "awk", "awl", "awm", "awn"}, this, object);
    }

    public cd Ai() {
        return this.awi;
    }

    public String Aj() {
        return this.awj;
    }

    public String Am() {
        return this.awk;
    }

    public List An() {
        return this.awl;
    }

    public boolean Ao() {
        return this.awm;
    }

    public int Ap() {
        return this.awn;
    }
}
