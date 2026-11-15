package itemsadder.m;

import org.bukkit.Material;

class me {
    static final /* synthetic */ int[] Bu;

    static {
        Bu = new int[Material.values().length];
        try {
            me.Bu[Material.BROWN_MUSHROOM_BLOCK.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            me.Bu[Material.RED_MUSHROOM_BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            me.Bu[Material.MUSHROOM_STEM.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            me.Bu[Material.CHORUS_PLANT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
