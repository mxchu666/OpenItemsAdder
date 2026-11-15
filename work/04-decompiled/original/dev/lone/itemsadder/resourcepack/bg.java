package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;

final class bg
extends Record {
    private final List avs;
    private final int avt;
    private final int avu;
    private final boolean avv;

    private bg(List list, int n, int n2, boolean bl) {
        this.avs = list;
        this.avt = n;
        this.avu = n2;
        this.avv = bl;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bg.class, "chunks;idatBytes;expectedInflatedBytes;marked", "avs", "avt", "avu", "avv"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bg.class, "chunks;idatBytes;expectedInflatedBytes;marked", "avs", "avt", "avu", "avv"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bg.class, "chunks;idatBytes;expectedInflatedBytes;marked", "avs", "avt", "avu", "avv"}, this, object);
    }

    public List zP() {
        return this.avs;
    }

    public int zQ() {
        return this.avt;
    }

    public int zR() {
        return this.avu;
    }

    public boolean zS() {
        return this.avv;
    }
}
