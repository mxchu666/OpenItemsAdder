package itemsadder.m;

import org.bukkit.HeightMap;

class HeightMapSwitchMap_11 {
    static final /* synthetic */ int[] VG;

    static {
        VG = new int[HeightMap.values().length];
        try {
            HeightMapSwitchMap_11.VG[HeightMap.MOTION_BLOCKING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_11.VG[HeightMap.MOTION_BLOCKING_NO_LEAVES.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_11.VG[HeightMap.OCEAN_FLOOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_11.VG[HeightMap.OCEAN_FLOOR_WG.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_11.VG[HeightMap.WORLD_SURFACE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_11.VG[HeightMap.WORLD_SURFACE_WG.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
