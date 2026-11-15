package itemsadder.m;

import itemsadder.m.BuilderImpl_7;
import itemsadder.m.Builder_12;
import itemsadder.m.IntBoolData;
import lombok.Generated;

public class IntBoolDataImpl_11
extends IntBoolData {
    public final int vu;
    public final int vv;

    @Generated
    protected IntBoolDataImpl_11(Builder_12 builder_12) {
        super(builder_12);
        this.vu = builder_12.vu;
        this.vv = builder_12.vv;
    }

    @Generated
    public static Builder_12 jt() {
        return new BuilderImpl_7();
    }
}
