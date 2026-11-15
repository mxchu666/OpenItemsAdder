package dev.lone.itemsadder.resourcepack;

import beer.devs.fastnbt.nms.Version;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Map;

final class bw
extends Record {
    private final Version awt;
    private final Map awu;

    private bw(Version version, Map map) {
        this.awt = version;
        this.awu = map;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{bw.class, "version;paths", "awt", "awu"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{bw.class, "version;paths", "awt", "awu"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{bw.class, "version;paths", "awt", "awu"}, this, object);
    }

    public Version Aw() {
        return this.awt;
    }

    public Map Ax() {
        return this.awu;
    }
}
