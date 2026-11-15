package itemsadder.m;

import itemsadder.m.EntityTypeBridgeBuilderImpl_2;
import itemsadder.m.EntityTypeBridgeBuilder_3;
import itemsadder.m.IntBoolData;
import java.util.Arrays;
import lombok.Generated;
import org.bukkit.entity.EntityType;

public class EntityTypeBridge_3
extends IntBoolData {
    public final double vz;
    public final int vA;
    public final float vB;

    public static boolean f(EntityType entityType) {
        return Arrays.asList(EntityTypeBridge_3.jB()).contains(entityType);
    }

    public static EntityType[] jB() {
        return new EntityType[]{EntityType.BOGGED, EntityType.DROWNED, EntityType.ILLUSIONER, EntityType.LLAMA, EntityType.PIGLIN, EntityType.PILLAGER, EntityType.SKELETON, EntityType.SNOW_GOLEM, EntityType.STRAY, EntityType.TRADER_LLAMA, EntityType.WITCH, EntityType.WITHER, EntityType.WITHER_SKELETON};
    }

    @Generated
    protected EntityTypeBridge_3(EntityTypeBridgeBuilder_3 entityTypeBridgeBuilder_3) {
        super(entityTypeBridgeBuilder_3);
        this.vz = entityTypeBridgeBuilder_3.vm;
        this.vA = entityTypeBridgeBuilder_3.vA;
        this.vB = entityTypeBridgeBuilder_3.vB;
    }

    @Generated
    public static EntityTypeBridgeBuilder_3 jC() {
        return new EntityTypeBridgeBuilderImpl_2();
    }
}
