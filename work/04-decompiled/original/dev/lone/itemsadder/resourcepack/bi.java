package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.bj;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;

final class bi
extends Record {
    private final bj avx;
    private final byte[] avy;
    private final String avz;

    bi(bj bj2, byte[] byArray, String string) {
        Objects.requireNonNull(bj2, "status");
        Objects.requireNonNull(byArray, "bytes");
        Objects.requireNonNull(string, "reason");
        this.avx = bj2;
        this.avy = byArray;
        this.avz = string;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bi.class, "status;bytes;reason", "avx", "avy", "avz"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bi.class, "status;bytes;reason", "avx", "avy", "avz"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bi.class, "status;bytes;reason", "avx", "avy", "avz"}, this, object);
    }

    public bj yv() {
        return this.avx;
    }

    public byte[] zT() {
        return this.avy;
    }

    public String xQ() {
        return this.avz;
    }
}
