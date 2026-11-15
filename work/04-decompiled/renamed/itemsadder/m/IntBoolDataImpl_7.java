package itemsadder.m;

import itemsadder.m.BuilderImpl_5;
import itemsadder.m.Builder_10;
import itemsadder.m.IntBoolData;
import java.util.function.Predicate;
import lombok.Generated;

public class IntBoolDataImpl_7
extends IntBoolData {
    public final Predicate vo;
    public final double vp;
    public final int vq;

    @Generated
    protected IntBoolDataImpl_7(Builder_10 builder_10) {
        super(builder_10);
        this.vo = builder_10.uZ;
        this.vp = builder_10.vm;
        this.vq = builder_10.vq;
    }

    @Generated
    public static Builder_10 jd() {
        return new BuilderImpl_5();
    }
}
