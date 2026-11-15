package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.t;
import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.Nullable;

final class z
extends Record {
    private final String arU;
    private final t arV;
    @Nullable
    private final File arW;

    private z(String string, t t2, @Nullable File file) {
        this.arU = string;
        this.arV = t2;
        this.arW = file;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{z.class, "path;origin;source", "arU", "arV", "arW"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{z.class, "path;origin;source", "arU", "arV", "arW"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{z.class, "path;origin;source", "arU", "arV", "arW"}, this, object);
    }

    public String pK() {
        return this.arU;
    }

    public t yw() {
        return this.arV;
    }

    @Nullable
    public File yx() {
        return this.arW;
    }
}
