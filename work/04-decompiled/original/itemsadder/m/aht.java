package itemsadder.m;

import org.bukkit.GameMode;

class aht {
    static final /* synthetic */ int[] acp;

    static {
        acp = new int[GameMode.values().length];
        try {
            aht.acp[GameMode.SURVIVAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aht.acp[GameMode.CREATIVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aht.acp[GameMode.ADVENTURE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            aht.acp[GameMode.SPECTATOR.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
