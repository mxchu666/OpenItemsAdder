package dev.lone.itemsadder.resourcepack;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.regex.Pattern;

final class s
extends Record {
    private final Pattern arL;
    private final Pattern arM;

    private s(Pattern pattern, Pattern pattern2) {
        this.arL = pattern;
        this.arM = pattern2;
    }

    boolean eE(String string) {
        int n = string.indexOf(58);
        return this.arL.matcher(string.substring(0, n)).matches() && this.arM.matcher(string.substring(n + 1)).matches();
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{s.class, "namespace;path", "arL", "arM"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{s.class, "namespace;path", "arL", "arM"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{s.class, "namespace;path", "arL", "arM"}, this, object);
    }

    public Pattern yn() {
        return this.arL;
    }

    public Pattern yo() {
        return this.arM;
    }
}
