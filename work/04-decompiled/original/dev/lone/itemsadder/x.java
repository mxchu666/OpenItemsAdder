package dev.lone.itemsadder;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class x
extends Record {
    private final String version;
    private final String RZ;
    private final long Sa;
    private final int Sb;
    private final int Sc;

    public x(String string, String string2, long l, int n, int n2) {
        this.version = string;
        this.RZ = string2;
        this.Sa = l;
        this.Sb = n;
        this.Sc = n2;
    }

    public String sn() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.Sa * 1000L));
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{x.class, "version;title;time;updateId;counterOlderVersions", "version", "RZ", "Sa", "Sb", "Sc"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{x.class, "version;title;time;updateId;counterOlderVersions", "version", "RZ", "Sa", "Sb", "Sc"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{x.class, "version;title;time;updateId;counterOlderVersions", "version", "RZ", "Sa", "Sb", "Sc"}, this, object);
    }

    public String so() {
        return this.version;
    }

    public String sp() {
        return this.RZ;
    }

    public long rB() {
        return this.Sa;
    }

    public int sq() {
        return this.Sb;
    }

    public int sr() {
        return this.Sc;
    }
}
