package itemsadder.m;

import itemsadder.m.BuilderImpl_2;
import itemsadder.m.Builder_7;
import itemsadder.m.EntityTypeRefData;
import lombok.Generated;

public class EntityTypeRefDataImpl_2
extends EntityTypeRefData {
    public final float uW;
    public final double uX;
    public final double uY;

    @Generated
    protected EntityTypeRefDataImpl_2(Builder_7 builder_7) {
        super(builder_7);
        this.uW = builder_7.uW;
        this.uX = builder_7.uX;
        this.uY = builder_7.uY;
    }

    @Generated
    public static Builder_7 iv() {
        return new BuilderImpl_2();
    }
}
