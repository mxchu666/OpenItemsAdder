package itemsadder.m;

import org.bukkit.event.player.PlayerFishEvent;

class PlayerFishEventSwitchMap {
    static final /* synthetic */ int[] Et;

    static {
        Et = new int[PlayerFishEvent.State.values().length];
        try {
            PlayerFishEventSwitchMap.Et[PlayerFishEvent.State.FISHING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerFishEventSwitchMap.Et[PlayerFishEvent.State.CAUGHT_ENTITY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerFishEventSwitchMap.Et[PlayerFishEvent.State.CAUGHT_FISH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerFishEventSwitchMap.Et[PlayerFishEvent.State.FAILED_ATTEMPT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerFishEventSwitchMap.Et[PlayerFishEvent.State.REEL_IN.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerFishEventSwitchMap.Et[PlayerFishEvent.State.BITE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            PlayerFishEventSwitchMap.Et[PlayerFishEvent.State.IN_GROUND.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
