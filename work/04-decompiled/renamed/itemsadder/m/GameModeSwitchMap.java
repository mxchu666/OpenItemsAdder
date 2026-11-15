package itemsadder.m;

import org.bukkit.GameMode;

class GameModeSwitchMap {
    static final /* synthetic */ int[] acp;

    static {
        acp = new int[GameMode.values().length];
        try {
            GameModeSwitchMap.acp[GameMode.SURVIVAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            GameModeSwitchMap.acp[GameMode.CREATIVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            GameModeSwitchMap.acp[GameMode.ADVENTURE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            GameModeSwitchMap.acp[GameMode.SPECTATOR.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
