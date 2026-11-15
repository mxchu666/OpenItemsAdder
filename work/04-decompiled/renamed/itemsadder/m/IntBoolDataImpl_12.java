package itemsadder.m;

import itemsadder.m.BuilderImpl_8;
import itemsadder.m.Builder_13;
import itemsadder.m.IntBoolData;
import lombok.Generated;

public class IntBoolDataImpl_12
extends IntBoolData {
    public final double vw;
    public final int vx;
    public final boolean vy;

    @Generated
    protected IntBoolDataImpl_12(Builder_13 builder_13) {
        super(builder_13);
        this.vw = builder_13.vm;
        this.vx = builder_13.uT;
        this.vy = builder_13.vy;
    }

    @Generated
    public static Builder_13 jx() {
        return new BuilderImpl_8();
    }
}
