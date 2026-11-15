package itemsadder.m;

import itemsadder.m.IntBoolData;
import itemsadder.m.IntBoolDataBuilderImpl_5;
import itemsadder.m.IntBoolDataBuilderImpl_6;
import java.util.function.Predicate;
import lombok.Generated;

public class IntBoolDataImpl_3
extends IntBoolData {
    public final Predicate uZ;

    @Generated
    protected IntBoolDataImpl_3(IntBoolDataBuilderImpl_5 intBoolDataBuilderImpl_5) {
        super(intBoolDataBuilderImpl_5);
        this.uZ = intBoolDataBuilderImpl_5.uZ;
    }

    @Generated
    public static IntBoolDataBuilderImpl_5 iH() {
        return new IntBoolDataBuilderImpl_6();
    }
}
