package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class afl
extends Record {
    private final String abl;
    private final String abm;
    private final int abn;

    public afl(String string, String string2, int n) {
        this.abl = string;
        this.abm = string2;
        this.abn = n;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{afl.class, "namespace;id;waterColor", "abl", "abm", "abn"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{afl.class, "namespace;id;waterColor", "abl", "abm", "abn"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{afl.class, "namespace;id;waterColor", "abl", "abm", "abn"}, this, object);
    }

    public String pD() {
        return this.abl;
    }

    public String tH() {
        return this.abm;
    }

    public int tI() {
        return this.abn;
    }
}
