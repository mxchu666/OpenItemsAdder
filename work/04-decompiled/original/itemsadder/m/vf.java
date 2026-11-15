package itemsadder.m;

import org.bukkit.Material;

class vf {
    static final /* synthetic */ int[] MA;

    static {
        MA = new int[Material.values().length];
        try {
            vf.MA[Material.FURNACE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            vf.MA[Material.BLAST_FURNACE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            vf.MA[Material.SMOKER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
