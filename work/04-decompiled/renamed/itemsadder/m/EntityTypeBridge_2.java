package itemsadder.m;

import itemsadder.m.EntityTypeBridgeBuilderImpl;
import itemsadder.m.EntityTypeBridgeBuilder_2;
import itemsadder.m.EntityTypeRefData;
import lombok.Generated;
import org.bukkit.entity.EntityType;

public class EntityTypeBridge_2
extends EntityTypeRefData {
    public final EntityType vi;
    public final float vj;
    public final float vk;
    public final boolean vl;

    @Generated
    protected EntityTypeBridge_2(EntityTypeBridgeBuilder_2 entityTypeBridgeBuilder_2) {
        super(entityTypeBridgeBuilder_2);
        this.vi = entityTypeBridgeBuilder_2.nS;
        this.vj = entityTypeBridgeBuilder_2.vj;
        this.vk = entityTypeBridgeBuilder_2.mg;
        this.vl = entityTypeBridgeBuilder_2.vl;
    }

    @Generated
    public static EntityTypeBridgeBuilder_2 iV() {
        return new EntityTypeBridgeBuilderImpl();
    }
}
