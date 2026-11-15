package itemsadder.m;

import itemsadder.m.EqualEnum;

class iwSwitchMap {
    static final /* synthetic */ int[] wH;

    static {
        wH = new int[EqualEnum.values().length];
        try {
            iwSwitchMap.wH[EqualEnum.EQUAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            iwSwitchMap.wH[EqualEnum.LESS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            iwSwitchMap.wH[EqualEnum.MORE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            iwSwitchMap.wH[EqualEnum.LESS_EQUAL.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            iwSwitchMap.wH[EqualEnum.MORE_EQUAL.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
