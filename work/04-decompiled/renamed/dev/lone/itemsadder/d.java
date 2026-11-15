package dev.lone.itemsadder;

import ia.sh.libby.logging.LogLevel;

class d {
    static final /* synthetic */ int[] Ph;

    static {
        Ph = new int[LogLevel.values().length];
        try {
            d.Ph[LogLevel.DEBUG.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            d.Ph[LogLevel.INFO.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            d.Ph[LogLevel.WARN.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            d.Ph[LogLevel.ERROR.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
