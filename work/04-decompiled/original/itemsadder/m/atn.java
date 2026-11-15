package itemsadder.m;

import itemsadder.m.ase;

class atn {
    static final /* synthetic */ int[] ani;

    static {
        ani = new int[ase.values().length];
        try {
            atn.ani[ase.CRAFTING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atn.ani[ase.SMELTING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atn.ani[ase.BLASTING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atn.ani[ase.SMOKING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atn.ani[ase.CAMPFIRE_COOKING.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atn.ani[ase.STONECUTTING.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atn.ani[ase.SMITHING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
