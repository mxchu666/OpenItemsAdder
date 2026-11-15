package itemsadder.m;

import itemsadder.m.mt;

class ml {
    static final /* synthetic */ int[] BE;

    static {
        BE = new int[mt.values().length];
        try {
            ml.BE[mt.SAVED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ml.BE[mt.SAVED_CHUNK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
