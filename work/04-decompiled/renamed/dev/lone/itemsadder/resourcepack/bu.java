package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class bu
extends Record {
    private final int awo;
    private final int awp;
    private final String awq;
    private final boolean awr;
    private final boolean aws;

    private bu(int n, int n2, String string, boolean bl, boolean bl2) {
        this.awo = n;
        this.awp = n2;
        this.awq = string;
        this.awr = bl;
        this.aws = bl2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bu.class, "line;column;target;relative;valid", "awo", "awp", "awq", "awr", "aws"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bu.class, "line;column;target;relative;valid", "awo", "awp", "awq", "awr", "aws"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bu.class, "line;column;target;relative;valid", "awo", "awp", "awq", "awr", "aws"}, this, object);
    }

    public int Ad() {
        return this.awo;
    }

    public int Ae() {
        return this.awp;
    }

    public String Aq() {
        return this.awq;
    }

    public boolean Ar() {
        return this.awr;
    }

    public boolean As() {
        return this.aws;
    }
}
