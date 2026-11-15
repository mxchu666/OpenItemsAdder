package itemsadder.m;

import itemsadder.m.sd;

class qn {
    static final /* synthetic */ int[] GT;

    static {
        GT = new int[sd.values().length];
        try {
            qn.GT[sd.REAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qn.GT[sd.REAL_TRANSPARENT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qn.GT[sd.REAL_NOTE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qn.GT[sd.ENTITY.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            qn.GT[sd.TILE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
