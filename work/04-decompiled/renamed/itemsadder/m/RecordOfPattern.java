package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.function.Function;
import java.util.regex.Pattern;

final class RecordOfPattern
extends Record {
    private final Pattern NU;
    private final Function NV;

    private RecordOfPattern(Pattern pattern, Function function) {
        this.NU = pattern;
        this.NV = function;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfPattern.class, "pattern;replacement", "NU", "NV"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfPattern.class, "pattern;replacement", "NU", "NV"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfPattern.class, "pattern;replacement", "NU", "NV"}, this, object);
    }

    public Pattern rJ() {
        return this.NU;
    }

    public Function rK() {
        return this.NV;
    }
}
