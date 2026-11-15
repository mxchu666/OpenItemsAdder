package itemsadder.m;

import itemsadder.m.ase;

class atr {
    static final /* synthetic */ int[] anm;

    static {
        anm = new int[ase.values().length];
        try {
            atr.anm[ase.CRAFTING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atr.anm[ase.SMELTING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atr.anm[ase.BLASTING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atr.anm[ase.SMOKING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atr.anm[ase.CAMPFIRE_COOKING.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atr.anm[ase.STONECUTTING.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            atr.anm[ase.SMITHING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
