package itemsadder.m;

import itemsadder.m.BuilderImpl_3;
import itemsadder.m.Builder_8;
import itemsadder.m.EntityTypeBridge;
import itemsadder.m.IntBoolData;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

public class IntBoolDataImpl_5
extends IntBoolData {
    @Nullable
    public final EntityTypeBridge[] vf;
    @Nullable
    public final EntityTypeBridge[] vg;

    @Generated
    protected IntBoolDataImpl_5(Builder_8 builder_8) {
        super(builder_8);
        this.vf = builder_8.vf;
        this.vg = builder_8.vg;
    }

    @Generated
    public static Builder_8 iP() {
        return new BuilderImpl_3();
    }
}
