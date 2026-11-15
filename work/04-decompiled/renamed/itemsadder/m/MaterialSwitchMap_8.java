package itemsadder.m;

import org.bukkit.Material;

class MaterialSwitchMap_8 {
    static final /* synthetic */ int[] MA;

    static {
        MA = new int[Material.values().length];
        try {
            MaterialSwitchMap_8.MA[Material.FURNACE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            MaterialSwitchMap_8.MA[Material.BLAST_FURNACE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            MaterialSwitchMap_8.MA[Material.SMOKER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
