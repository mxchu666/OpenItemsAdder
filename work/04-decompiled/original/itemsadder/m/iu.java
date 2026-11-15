package itemsadder.m;

import itemsadder.m.iw;

class iu {
    static final /* synthetic */ int[] wH;

    static {
        wH = new int[iw.values().length];
        try {
            iu.wH[iw.EQUAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            iu.wH[iw.LESS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            iu.wH[iw.MORE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            iu.wH[iw.LESS_EQUAL.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            iu.wH[iw.MORE_EQUAL.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
