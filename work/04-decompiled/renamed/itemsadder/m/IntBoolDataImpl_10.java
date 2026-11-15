package itemsadder.m;

import itemsadder.m.BuilderImpl_6;
import itemsadder.m.Builder_11;
import itemsadder.m.IntBoolData;
import lombok.Generated;

public class IntBoolDataImpl_10
extends IntBoolData {
    public final boolean vs;
    public final float vt;

    @Generated
    protected IntBoolDataImpl_10(Builder_11 builder_11) {
        super(builder_11);
        this.vs = builder_11.uU;
        this.vt = builder_11.mg;
    }

    @Generated
    public static Builder_11 jp() {
        return new BuilderImpl_6();
    }
}
