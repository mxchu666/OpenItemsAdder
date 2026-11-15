package itemsadder.m;

import itemsadder.m.EntityBridge;
import itemsadder.m.EntityBridgeBuilder;
import itemsadder.m.EntityBridgeBuilderImpl;
import itemsadder.m.EntityBridgeImpl;
import itemsadder.m.EventBridge_2;
import itemsadder.m.StringClassBoolData;
import lombok.Generated;

@Generated
public abstract class EventBridgeBuilder_2
extends EntityBridgeBuilderImpl {
    @Generated
    private String gJ;
    @Generated
    private StringClassBoolData gK;

    @Generated
    public EventBridgeBuilder_2 Y(String string) {
        this.gJ = string;
        return this.aX();
    }

    @Generated
    public EventBridgeBuilder_2 a(StringClassBoolData stringClassBoolData) {
        this.gK = stringClassBoolData;
        return this.aX();
    }

    @Generated
    protected abstract EventBridgeBuilder_2 aX();

    @Generated
    public abstract EventBridge_2 aY();

    @Override
    @Generated
    public String toString() {
        return "RunScript.RunScriptBuilder(super=" + super.toString() + ", scriptIdentifier=" + this.gJ + ", compiled=" + String.valueOf(this.gK) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ EntityBridgeImpl aL() {
        return this.aY();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityBridgeBuilderImpl aK() {
        return this.aX();
    }

    @Override
    @Generated
    public /* synthetic */ EntityBridge aJ() {
        return this.aY();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityBridgeBuilder aI() {
        return this.aX();
    }
}
