package itemsadder.m;

import itemsadder.m.q;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class p
extends Record {
    private final q bH;
    private final String pattern;

    public p(q q2, String string) {
        this.bH = q2;
        this.pattern = string;
    }

    public static p E(String string) {
        if (string.startsWith("*") || string.startsWith("?") || string.endsWith("*") || string.endsWith("?")) {
            return new p(q.WILDCARD, string);
        }
        if (string.matches("[a-zA-Z0-9_:-]+") && string.chars().filter(n -> n == 58).count() <= 1L) {
            return new p(q.EXACT, string);
        }
        return new p(q.REGEX, string);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{p.class, "type;pattern", "bH", "pattern"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{p.class, "type;pattern", "bH", "pattern"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{p.class, "type;pattern", "bH", "pattern"}, this, object);
    }

    public q W() {
        return this.bH;
    }

    public String X() {
        return this.pattern;
    }
}
