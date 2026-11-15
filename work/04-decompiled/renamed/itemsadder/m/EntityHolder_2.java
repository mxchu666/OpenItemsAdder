package itemsadder.m;

import itemsadder.m.AFunction;
import itemsadder.m.NmsWrapperFactory;
import org.bukkit.entity.Entity;

public final class EntityHolder_2 {
    private final AFunction anU = (AFunction)NmsWrapperFactory.n(AFunction.class);
    private static EntityHolder_2 anV;

    EntityHolder_2() {
    }

    private static EntityHolder_2 vu() {
        if (anV == null) {
            anV = new EntityHolder_2();
        }
        return anV;
    }

    public static void a(Entity entity, int n) {
        EntityHolder_2.vu().anU.a(entity, n);
    }
}
