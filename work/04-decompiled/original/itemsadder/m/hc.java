package itemsadder.m;

import itemsadder.m.gc;
import itemsadder.m.hb;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

@Generated
public class hc {
    @Generated
    private EntityType vh;
    @Generated
    private gc uS;

    @Generated
    hc() {
    }

    @Generated
    public hc d(EntityType entityType) {
        this.vh = entityType;
        return this;
    }

    @Generated
    public hc b(@Nullable gc gc2) {
        this.uS = gc2;
        return this;
    }

    @Generated
    public hb iR() {
        return new hb(this.vh, this.uS);
    }

    @Generated
    public String toString() {
        return "HurtByTargetGoal.Entry.EntryBuilder(type=" + String.valueOf(this.vh) + ", selector=" + String.valueOf(this.uS) + ")";
    }
}
