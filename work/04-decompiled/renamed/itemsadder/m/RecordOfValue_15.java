package itemsadder.m;

import itemsadder.m.ReplaceEnum;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;

public final class RecordOfValue_15
extends Record {
    private final ReplaceEnum mw;
    private final List mx;

    public RecordOfValue_15(ReplaceEnum replaceEnum, List list) {
        this.mw = replaceEnum;
        this.mx = list;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_15.class, "method;types", "mw", "mx"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_15.class, "method;types", "mw", "mx"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_15.class, "method;types", "mw", "mx"}, this, object);
    }

    public ReplaceEnum dQ() {
        return this.mw;
    }

    public List dR() {
        return this.mx;
    }
}
