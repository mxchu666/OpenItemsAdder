package itemsadder.m;

import itemsadder.m.fy;
import itemsadder.m.ie;
import itemsadder.m.if;
import java.util.Arrays;
import lombok.Generated;
import org.bukkit.entity.EntityType;

public class id
extends fy {
    public final double vz;
    public final int vA;
    public final float vB;

    public static boolean f(EntityType entityType) {
        return Arrays.asList(id.jB()).contains(entityType);
    }

    public static EntityType[] jB() {
        return new EntityType[]{EntityType.BOGGED, EntityType.DROWNED, EntityType.ILLUSIONER, EntityType.LLAMA, EntityType.PIGLIN, EntityType.PILLAGER, EntityType.SKELETON, EntityType.SNOW_GOLEM, EntityType.STRAY, EntityType.TRADER_LLAMA, EntityType.WITCH, EntityType.WITHER, EntityType.WITHER_SKELETON};
    }

    @Generated
    protected id(ie ie2) {
        super(ie2);
        this.vz = ie2.vm;
        this.vA = ie2.vA;
        this.vB = ie2.vB;
    }

    @Generated
    public static ie jC() {
        return new if();
    }
}
