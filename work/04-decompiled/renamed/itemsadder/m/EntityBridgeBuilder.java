package itemsadder.m;

import itemsadder.m.EntityBridge;
import itemsadder.m.Opaque124;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

public abstract class EntityBridgeBuilder {
    @Generated
    private String gv;
    @Generated
    private Long gw;
    @Generated
    private String gx;
    @Generated
    private Opaque124 gy;
    @Generated
    private boolean gz;

    public EntityBridgeBuilder U(String string) {
        this.gx = string;
        if (string != null && (string.startsWith("!") || string.startsWith("-"))) {
            this.gz = true;
            this.gx = string.substring(1);
        } else {
            this.gz = false;
        }
        return this.aI();
    }

    @Generated
    public EntityBridgeBuilder V(String string) {
        this.gv = string;
        return this.aI();
    }

    @Generated
    public EntityBridgeBuilder a(@Nullable Long l) {
        this.gw = l;
        return this.aI();
    }

    @Generated
    public EntityBridgeBuilder a(@Nullable Opaque124 opaque124) {
        this.gy = opaque124;
        return this.aI();
    }

    @Generated
    public EntityBridgeBuilder j(boolean bl) {
        this.gz = bl;
        return this.aI();
    }

    @Generated
    protected abstract EntityBridgeBuilder aI();

    @Generated
    public abstract EntityBridge aJ();

    @Generated
    public String toString() {
        return "AbstractEventAction.AbstractEventActionBuilder(key=" + this.gv + ", delay=" + this.gw + ", permission=" + this.gx + ", flowModifier=" + String.valueOf(this.gy) + ", permissionInverted=" + this.gz + ")";
    }
}
