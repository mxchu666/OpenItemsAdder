package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class ce
extends Record {
    private final String awM;
    private final int awN;
    private final int awO;
    private final boolean awP;

    private ce(String string, int n, int n2, boolean bl) {
        this.awM = string;
        this.awN = n;
        this.awO = n2;
        this.awP = bl;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ce.class, "value;line;column;identifier", "awM", "awN", "awO", "awP"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ce.class, "value;line;column;identifier", "awM", "awN", "awO", "awP"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ce.class, "value;line;column;identifier", "awM", "awN", "awO", "awP"}, this, object);
    }

    public String AK() {
        return this.awM;
    }

    public int Ad() {
        return this.awN;
    }

    public int Ae() {
        return this.awO;
    }

    public boolean AL() {
        return this.awP;
    }
}
