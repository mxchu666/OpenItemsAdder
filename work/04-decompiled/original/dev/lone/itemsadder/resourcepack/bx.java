package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.cb;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class bx
extends Record {
    private final cb awv;
    private final int aww;
    private final int awx;
    private final String awy;

    private bx(cb cb2, int n, int n2, String string) {
        this.awv = cb2;
        this.aww = n;
        this.awx = n2;
        this.awy = string;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bx.class, "severity;line;column;message", "awv", "aww", "awx", "awy"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bx.class, "severity;line;column;message", "awv", "aww", "awx", "awy"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bx.class, "severity;line;column;message", "awv", "aww", "awx", "awy"}, this, object);
    }

    public cb Ag() {
        return this.awv;
    }

    public int Ad() {
        return this.aww;
    }

    public int Ae() {
        return this.awx;
    }

    public String xY() {
        return this.awy;
    }
}
