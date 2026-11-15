package itemsadder.m;

import itemsadder.m.aab;
import itemsadder.m.awc;
import itemsadder.m.bce;
import java.util.concurrent.atomic.AtomicBoolean;

public class awg {
    private final awc aof = (awc)aab.n(awc.class);
    public static awg aog;
    public static final AtomicBoolean aoh;

    awg() {
    }

    private static awg vA() {
        if (aog == null) {
            aog = new awg();
        }
        return aog;
    }

    public static awc vB() {
        return awg.vA().aof;
    }

    public static void vx() {
        try {
            if (aog != null) {
                awg.aog.aof.vx();
            }
        }
        catch (Throwable throwable) {
            bce.warn("Failed to restore force-default-blockstate tree features: " + throwable.getMessage());
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
