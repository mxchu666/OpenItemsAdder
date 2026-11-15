package itemsadder.m;

import org.bukkit.Material;

class MaterialSwitchMap_9 {
    static final /* synthetic */ int[] ME;

    static {
        ME = new int[Material.values().length];
        try {
            MaterialSwitchMap_9.ME[Material.FURNACE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            MaterialSwitchMap_9.ME[Material.BLAST_FURNACE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            MaterialSwitchMap_9.ME[Material.SMOKER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
