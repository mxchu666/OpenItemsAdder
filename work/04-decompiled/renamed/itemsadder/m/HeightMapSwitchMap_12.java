package itemsadder.m;

import org.bukkit.HeightMap;

class HeightMapSwitchMap_12 {
    static final /* synthetic */ int[] VH;

    static {
        VH = new int[HeightMap.values().length];
        try {
            HeightMapSwitchMap_12.VH[HeightMap.MOTION_BLOCKING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_12.VH[HeightMap.MOTION_BLOCKING_NO_LEAVES.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_12.VH[HeightMap.OCEAN_FLOOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_12.VH[HeightMap.OCEAN_FLOOR_WG.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_12.VH[HeightMap.WORLD_SURFACE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_12.VH[HeightMap.WORLD_SURFACE_WG.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
