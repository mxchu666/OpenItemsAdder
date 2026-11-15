package itemsadder.m;

import itemsadder.m.sd;

class azi {
    static final /* synthetic */ int[] axQ;

    static {
        axQ = new int[sd.values().length];
        try {
            azi.axQ[sd.REAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            azi.axQ[sd.REAL_TRANSPARENT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            azi.axQ[sd.REAL_NOTE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            azi.axQ[sd.REAL_WIRE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            azi.axQ[sd.ENTITY.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            azi.axQ[sd.TILE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            azi.axQ[sd.FIRE.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
