package itemsadder.m;

import itemsadder.m.IntBoolDataBuilder;
import lombok.Generated;

public abstract class IntBoolData {
    public final int uN;
    public final boolean uO;

    @Generated
    protected IntBoolData(IntBoolDataBuilder intBoolDataBuilder) {
        this.uN = intBoolDataBuilder.uN;
        this.uO = intBoolDataBuilder.uO;
    }
}
