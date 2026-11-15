package itemsadder.m;

import itemsadder.m.EntityBridgeBuilder;
import itemsadder.m.Opaque124;
import lombok.Generated;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

public abstract class EntityBridge {
    final String gv;
    @Nullable
    final Long gw;
    final String gx;
    @Nullable
    final Opaque124 gy;
    final boolean gz;

    public boolean aD() {
        return this.gw != null && this.gw > 0L;
    }

    public boolean aE() {
        return this.gx != null;
    }

    public boolean c(Entity entity) {
        if (this.gx == null) {
            return true;
        }
        if (this.gz) {
            return !entity.hasPermission(this.gx);
        }
        return entity.hasPermission(this.gx);
    }

    @Generated
    protected EntityBridge(EntityBridgeBuilder entityBridgeBuilder) {
        this.gv = entityBridgeBuilder.gv;
        this.gw = entityBridgeBuilder.gw;
        this.gx = entityBridgeBuilder.gx;
        this.gy = entityBridgeBuilder.gy;
        this.gz = entityBridgeBuilder.gz;
    }

    @Generated
    public String aF() {
        return this.gv;
    }

    @Nullable
    @Generated
    public Long aG() {
        return this.gw;
    }

    @Generated
    public String getPermission() {
        return this.gx;
    }

    @Nullable
    @Generated
    public Opaque124 aH() {
        return this.gy;
    }
}
