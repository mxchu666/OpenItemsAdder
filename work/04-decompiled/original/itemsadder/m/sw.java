package itemsadder.m;

import itemsadder.m.rl;

class sw {
    static final /* synthetic */ int[] Kc;

    static {
        Kc = new int[rl.values().length];
        try {
            sw.Kc[rl.HUD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            sw.Kc[rl.BOSSBAR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
