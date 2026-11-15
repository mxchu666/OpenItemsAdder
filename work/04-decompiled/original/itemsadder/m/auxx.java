package itemsadder.m;

import itemsadder.m.aab;
import itemsadder.m.auw;
import org.bukkit.entity.Entity;

public final class auxx {
    private final auw anU = (auw)aab.n(auw.class);
    private static auxx anV;

    auxx() {
    }

    private static auxx vu() {
        if (anV == null) {
            anV = new auxx();
        }
        return anV;
    }

    public static void a(Entity entity, int n) {
        auxx.vu().anU.a(entity, n);
    }
}
