package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LocationWrapper_2;
import itemsadder.m.NmsWrapperFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class InstanceHolder_4 {
    private final LocationWrapper_2 aof = (LocationWrapper_2)NmsWrapperFactory.n(LocationWrapper_2.class);
    public static InstanceHolder_4 aog;
    public static final AtomicBoolean aoh;

    InstanceHolder_4() {
    }

    private static InstanceHolder_4 vA() {
        if (aog == null) {
            aog = new InstanceHolder_4();
        }
        return aog;
    }

    public static LocationWrapper_2 vB() {
        return InstanceHolder_4.vA().aof;
    }

    public static void vx() {
        try {
            if (aog != null) {
                InstanceHolder_4.aog.aof.vx();
            }
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.warn("Failed to restore force-default-blockstate tree features: " + throwable.getMessage());
        }
        finally {
            aoh.set(false);
            aog = null;
        }
    }

    static {
        aoh = new AtomicBoolean();
    }
}
