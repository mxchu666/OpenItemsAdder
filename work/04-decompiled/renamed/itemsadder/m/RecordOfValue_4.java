package itemsadder.m;

import itemsadder.m.SuccessEnum;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class RecordOfValue_4
extends Record {
    private final SuccessEnum gA;

    public RecordOfValue_4(SuccessEnum successEnum) {
        this.gA = successEnum;
    }

    public static RecordOfValue_4 aM() {
        return new RecordOfValue_4(SuccessEnum.FAILED);
    }

    public static RecordOfValue_4 aN() {
        return new RecordOfValue_4(SuccessEnum.SUCCESS);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfValue_4.class, "status", "gA"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfValue_4.class, "status", "gA"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfValue_4.class, "status", "gA"}, this, object);
    }

    public SuccessEnum aO() {
        return this.gA;
    }
}
