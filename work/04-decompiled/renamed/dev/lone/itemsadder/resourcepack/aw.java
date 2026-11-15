package dev.lone.itemsadder.resourcepack;

import itemsadder.m.LobfileEnum;

class aw {
    static final /* synthetic */ int[] aul;

    static {
        aul = new int[LobfileEnum.values().length];
        try {
            aw.aul[LobfileEnum.LOBFILE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aw.aul[LobfileEnum.AUTO_EXTERNAL_LEGACY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aw.aul[LobfileEnum.EXTERNAL.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aw.aul[LobfileEnum.SIMPLE_SELF_HOST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aw.aul[LobfileEnum.SELF_HOST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aw.aul[LobfileEnum.NO_HOST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
