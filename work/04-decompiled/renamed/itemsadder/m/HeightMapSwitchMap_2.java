package itemsadder.m;

import org.bukkit.HeightMap;

class HeightMapSwitchMap_2 {
    static final /* synthetic */ int[] Vx;

    static {
        Vx = new int[HeightMap.values().length];
        try {
            HeightMapSwitchMap_2.Vx[HeightMap.MOTION_BLOCKING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_2.Vx[HeightMap.MOTION_BLOCKING_NO_LEAVES.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_2.Vx[HeightMap.OCEAN_FLOOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_2.Vx[HeightMap.OCEAN_FLOOR_WG.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_2.Vx[HeightMap.WORLD_SURFACE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            HeightMapSwitchMap_2.Vx[HeightMap.WORLD_SURFACE_WG.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
