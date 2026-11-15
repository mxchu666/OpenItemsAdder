package itemsadder.m;

import itemsadder.m.BuilderImpl_4;
import itemsadder.m.Builder_9;
import itemsadder.m.IntBoolData;
import lombok.Generated;

public class IntBoolDataImpl_6
extends IntBoolData {
    public final double vm;
    public final boolean vn;

    @Generated
    protected IntBoolDataImpl_6(Builder_9 builder_9) {
        super(builder_9);
        this.vm = builder_9.vm;
        this.vn = builder_9.vn;
    }

    @Generated
    public static Builder_9 iZ() {
        return new BuilderImpl_4();
    }
}
