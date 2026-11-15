package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Set;

final class ca
extends Record {
    private final List awC;
    private final List awD;
    private final boolean awE;
    private final int awF;
    private final int awG;
    private final Set awH;
    private final List awI;

    private ca(List list, List list2, boolean bl, int n, int n2, Set set, List list3) {
        this.awC = list;
        this.awD = list2;
        this.awE = bl;
        this.awF = n;
        this.awG = n2;
        this.awH = set;
        this.awI = list3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ca.class, "diagnostics;imports;hasMain;versions;glslVersion;versionLines;tokens", "awC", "awD", "awE", "awF", "awG", "awH", "awI"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ca.class, "diagnostics;imports;hasMain;versions;glslVersion;versionLines;tokens", "awC", "awD", "awE", "awF", "awG", "awH", "awI"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ca.class, "diagnostics;imports;hasMain;versions;glslVersion;versionLines;tokens", "awC", "awD", "awE", "awF", "awG", "awH", "awI"}, this, object);
    }

    public List AB() {
        return this.awC;
    }

    public List AC() {
        return this.awD;
    }

    public boolean AD() {
        return this.awE;
    }

    public int AE() {
        return this.awF;
    }

    public int Ap() {
        return this.awG;
    }

    public Set AF() {
        return this.awH;
    }

    public List AG() {
        return this.awI;
    }
}
