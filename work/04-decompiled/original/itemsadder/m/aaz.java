package itemsadder.m;

import org.bukkit.HeightMap;

class aaz {
    static final /* synthetic */ int[] VD;

    static {
        VD = new int[HeightMap.values().length];
        try {
            aaz.VD[HeightMap.MOTION_BLOCKING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aaz.VD[HeightMap.MOTION_BLOCKING_NO_LEAVES.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aaz.VD[HeightMap.OCEAN_FLOOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aaz.VD[HeightMap.OCEAN_FLOOR_WG.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aaz.VD[HeightMap.WORLD_SURFACE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aaz.VD[HeightMap.WORLD_SURFACE_WG.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
