package itemsadder.m;

import org.bukkit.HeightMap;

class HeightMapSwitchMap_7 {
    static final /* synthetic */ int[] VC;

    static {
        VC = new int[HeightMap.values().length];
        try {
            HeightMapSwitchMap_7.VC[HeightMap.MOTION_BLOCKING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_7.VC[HeightMap.MOTION_BLOCKING_NO_LEAVES.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_7.VC[HeightMap.OCEAN_FLOOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_7.VC[HeightMap.OCEAN_FLOOR_WG.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_7.VC[HeightMap.WORLD_SURFACE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_7.VC[HeightMap.WORLD_SURFACE_WG.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
