package itemsadder.m;

import itemsadder.m.aq;
import itemsadder.m.ar;
import itemsadder.m.as;
import itemsadder.m.at;
import itemsadder.m.bi;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class bj
extends at {
    @Generated
    private String gL;
    @Generated
    private EntityType gM;
    @Generated
    private Integer gN;

    @Generated
    public bj aa(@Nullable String string) {
        this.gL = string;
        return this.bb();
    }

    @Generated
    public bj a(@Nullable EntityType entityType) {
        this.gM = entityType;
        return this.bb();
    }

    @Generated
    public bj a(@Nullable Integer n) {
        this.gN = n;
        return this.bb();
    }

    @Generated
    protected abstract bj bb();

    @Generated
    public abstract bi bc();

    @Override
    @Generated
    public String toString() {
        return "SummonEntity.SummonEntityBuilder(super=" + super.toString() + ", customEntityId=" + this.gL + ", bukkitEntityType=" + String.valueOf(this.gM) + ", maxPerChunk=" + this.gN + ")";
    }

    @Override
    @Generated
    public /* synthetic */ as aL() {
        return this.bc();
    }

    @Override
    @Generated
    protected /* synthetic */ at aK() {
        return this.bb();
    }

    @Override
    @Generated
    public /* synthetic */ aq aJ() {
        return this.bc();
    }

    @Override
    @Generated
    protected /* synthetic */ ar aI() {
        return this.bb();
    }
}
