package itemsadder.m;

import itemsadder.m.EntityBridge;
import itemsadder.m.EntityBridgeBuilder;
import itemsadder.m.EntityBridgeBuilderImpl;
import itemsadder.m.EntityBridgeImpl;
import itemsadder.m.EventBridge;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class EventBridgeBuilder
extends EntityBridgeBuilderImpl {
    @Generated
    private String gF;
    @Generated
    private boolean gG;
    @Generated
    private boolean gH;
    @Generated
    private String gI;

    @Generated
    public EventBridgeBuilder W(String string) {
        this.gF = string;
        return this.aT();
    }

    @Generated
    public EventBridgeBuilder k(boolean bl) {
        this.gG = bl;
        return this.aT();
    }

    @Generated
    public EventBridgeBuilder l(boolean bl) {
        this.gH = bl;
        return this.aT();
    }

    @Generated
    public EventBridgeBuilder X(@Nullable String string) {
        this.gI = string;
        return this.aT();
    }

    @Generated
    protected abstract EventBridgeBuilder aT();

    @Generated
    public abstract EventBridge aU();

    @Override
    @Generated
    public String toString() {
        return "ExecuteCommand.ExecuteCommandBuilder(super=" + super.toString() + ", command=" + this.gF + ", asConsole=" + this.gG + ", silent=" + this.gH + ", flowSuccessMessageIfContains=" + this.gI + ")";
    }

    @Override
    @Generated
    public /* synthetic */ EntityBridgeImpl aL() {
        return this.aU();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityBridgeBuilderImpl aK() {
        return this.aT();
    }

    @Override
    @Generated
    public /* synthetic */ EntityBridge aJ() {
        return this.aU();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityBridgeBuilder aI() {
        return this.aT();
    }
}
