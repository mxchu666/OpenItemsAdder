package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.aab;
import itemsadder.m.avl;
import java.util.concurrent.TimeUnit;

public final class avn {
    public avl anZ = (avl)aab.n(avl.class);
    static avn aoa;
    public static Cache aob;

    avn() {
    }

    public static avl vv() {
        if (aoa == null || avn.aoa.anZ == null) {
            aoa = new avn();
        }
        return avn.aoa.anZ;
    }

    static {
        aob = CacheBuilder.newBuilder().expireAfterWrite(30L, TimeUnit.MINUTES).build();
    }
}
