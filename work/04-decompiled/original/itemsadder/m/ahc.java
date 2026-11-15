package itemsadder.m;

import net.minecraft.world.entity.MobCategory;

class ahc {
    static final /* synthetic */ int[] abK;

    static {
        abK = new int[MobCategory.values().length];
        try {
            ahc.abK[MobCategory.MONSTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ahc.abK[MobCategory.CREATURE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ahc.abK[MobCategory.AMBIENT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ahc.abK[MobCategory.AXOLOTLS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ahc.abK[MobCategory.UNDERGROUND_WATER_CREATURE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ahc.abK[MobCategory.WATER_CREATURE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ahc.abK[MobCategory.WATER_AMBIENT.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
