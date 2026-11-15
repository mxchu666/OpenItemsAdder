package itemsadder.m;

import itemsadder.m.SavedEnum;

class mtSwitchMap {
    static final /* synthetic */ int[] BE;

    static {
        BE = new int[SavedEnum.values().length];
        try {
            mtSwitchMap.BE[SavedEnum.SAVED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            mtSwitchMap.BE[SavedEnum.SAVED_CHUNK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
