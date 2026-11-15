package itemsadder.m;

import itemsadder.m.EntityBridge;
import itemsadder.m.EntityBridgeBuilder;
import itemsadder.m.EntityBridgeBuilderImpl;
import itemsadder.m.EntityBridgeImpl;
import itemsadder.m.EventBridge_3;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class EventBridgeBuilder_3
extends EntityBridgeBuilderImpl {
    @Generated
    private String gL;
    @Generated
    private EntityType gM;
    @Generated
    private Integer gN;

    @Generated
    public EventBridgeBuilder_3 aa(@Nullable String string) {
        this.gL = string;
        return this.bb();
    }

    @Generated
    public EventBridgeBuilder_3 a(@Nullable EntityType entityType) {
        this.gM = entityType;
        return this.bb();
    }

    @Generated
    public EventBridgeBuilder_3 a(@Nullable Integer n) {
        this.gN = n;
        return this.bb();
    }

    @Generated
    protected abstract EventBridgeBuilder_3 bb();

    @Generated
    public abstract EventBridge_3 bc();

    @Override
    @Generated
    public String toString() {
        return "SummonEntity.SummonEntityBuilder(super=" + super.toString() + ", customEntityId=" + this.gL + ", bukkitEntityType=" + String.valueOf(this.gM) + ", maxPerChunk=" + this.gN + ")";
    }

    @Override
    @Generated
    public /* synthetic */ EntityBridgeImpl aL() {
        return this.bc();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityBridgeBuilderImpl aK() {
        return this.bb();
    }

    @Override
    @Generated
    public /* synthetic */ EntityBridge aJ() {
        return this.bc();
    }

    @Override
    @Generated
    protected /* synthetic */ EntityBridgeBuilder aI() {
        return this.bb();
    }
}
