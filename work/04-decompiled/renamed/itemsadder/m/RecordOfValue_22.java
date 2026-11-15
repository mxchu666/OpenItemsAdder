package itemsadder.m;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

final class RecordOfValue_22
extends Record {
    private final boolean Ek;
    private final boolean El;
    private final boolean Em;
    static final RecordOfValue_22 En = new RecordOfValue_22(false, true, true);

    RecordOfValue_22(boolean bl, boolean bl2, boolean bl3) {
        this.Ek = bl;
        this.El = bl2;
        this.Em = bl3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_22.class, "handled;allowed;consume", "Ek", "El", "Em"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_22.class, "handled;allowed;consume", "Ek", "El", "Em"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_22.class, "handled;allowed;consume", "Ek", "El", "Em"}, this, object);
    }

    public boolean mo() {
        return this.Ek;
    }

    public boolean mp() {
        return this.El;
    }

    public boolean mq() {
        return this.Em;
    }
}
