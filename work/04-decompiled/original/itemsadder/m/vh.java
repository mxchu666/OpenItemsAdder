package itemsadder.m;

import org.bukkit.Material;

class vh {
    static final /* synthetic */ int[] ME;

    static {
        ME = new int[Material.values().length];
        try {
            vh.ME[Material.FURNACE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            vh.ME[Material.BLAST_FURNACE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            vh.ME[Material.SMOKER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
