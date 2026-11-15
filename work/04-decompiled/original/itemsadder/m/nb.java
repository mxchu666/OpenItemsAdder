package itemsadder.m;

import itemsadder.m.rl;

class nb {
    static final /* synthetic */ int[] Cp;

    static {
        Cp = new int[rl.values().length];
        try {
            nb.Cp[rl.HIDDEN.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nb.Cp[rl.VANILLA.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nb.Cp[rl.TITLE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nb.Cp[rl.HUD.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            nb.Cp[rl.BOSSBAR.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
