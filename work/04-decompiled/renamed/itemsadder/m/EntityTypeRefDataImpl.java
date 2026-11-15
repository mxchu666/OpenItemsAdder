package itemsadder.m;

import itemsadder.m.BuilderImpl;
import itemsadder.m.Builder_6;
import itemsadder.m.EntityTypeRefData;
import lombok.Generated;

public class EntityTypeRefDataImpl
extends EntityTypeRefData {
    public final int uT;
    public final boolean uU;
    public final boolean uV;

    @Generated
    protected EntityTypeRefDataImpl(Builder_6 builder_6) {
        super(builder_6);
        this.uT = builder_6.uT;
        this.uU = builder_6.uU;
        this.uV = builder_6.uV;
    }

    @Generated
    public static Builder_6 ir() {
        return new BuilderImpl();
    }
}
