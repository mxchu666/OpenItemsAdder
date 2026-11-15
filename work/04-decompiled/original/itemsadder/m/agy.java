package itemsadder.m;

import net.minecraft.world.entity.MobCategory;

class agy {
    static final /* synthetic */ int[] abI;

    static {
        abI = new int[MobCategory.values().length];
        try {
            agy.abI[MobCategory.MONSTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            agy.abI[MobCategory.CREATURE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            agy.abI[MobCategory.AMBIENT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            agy.abI[MobCategory.AXOLOTLS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            agy.abI[MobCategory.UNDERGROUND_WATER_CREATURE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            agy.abI[MobCategory.WATER_CREATURE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            agy.abI[MobCategory.WATER_AMBIENT.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
