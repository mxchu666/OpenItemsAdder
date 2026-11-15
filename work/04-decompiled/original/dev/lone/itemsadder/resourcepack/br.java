package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class br
extends Record {
    private final char avW;
    private final int avX;
    private final int avY;

    private br(char c, int n, int n2) {
        this.avW = c;
        this.avX = n;
        this.avY = n2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{br.class, "value;line;column", "avW", "avX", "avY"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{br.class, "value;line;column", "avW", "avX", "avY"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{br.class, "value;line;column", "avW", "avX", "avY"}, this, object);
    }

    public char Ac() {
        return this.avW;
    }

    public int Ad() {
        return this.avX;
    }

    public int Ae() {
        return this.avY;
    }
}
