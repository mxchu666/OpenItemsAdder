package itemsadder.m;

import itemsadder.m.EntityTypeRefDataBuilder;
import itemsadder.m.IntBoolData;
import itemsadder.m.Predicate_2;
import lombok.Generated;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.Nullable;

public abstract class EntityTypeRefData
extends IntBoolData {
    public final EntityType uP;
    @Nullable
    public final Predicate_2 uQ;

    @Generated
    protected EntityTypeRefData(EntityTypeRefDataBuilder entityTypeRefDataBuilder) {
        super(entityTypeRefDataBuilder);
        this.uP = entityTypeRefDataBuilder.nS;
        this.uQ = entityTypeRefDataBuilder.uQ;
    }
}
