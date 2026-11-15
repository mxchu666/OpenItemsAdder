package itemsadder.m;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PacketEventWrapper;
import java.util.concurrent.TimeUnit;

public final class InstanceHolder_3 {
    public PacketEventWrapper anZ = (PacketEventWrapper)NmsWrapperFactory.n(PacketEventWrapper.class);
    static InstanceHolder_3 aoa;
    public static Cache aob;

    InstanceHolder_3() {
    }

    public static PacketEventWrapper vv() {
        if (aoa == null || InstanceHolder_3.aoa.anZ == null) {
            aoa = new InstanceHolder_3();
        }
        return InstanceHolder_3.aoa.anZ;
    }

    static {
        aob = CacheBuilder.newBuilder().expireAfterWrite(30L, TimeUnit.MINUTES).build();
    }
}
