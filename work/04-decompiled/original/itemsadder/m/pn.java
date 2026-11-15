package itemsadder.m;

import org.bukkit.event.player.PlayerFishEvent;

class pn {
    static final /* synthetic */ int[] Et;

    static {
        Et = new int[PlayerFishEvent.State.values().length];
        try {
            pn.Et[PlayerFishEvent.State.FISHING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            pn.Et[PlayerFishEvent.State.CAUGHT_ENTITY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            pn.Et[PlayerFishEvent.State.CAUGHT_FISH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            pn.Et[PlayerFishEvent.State.FAILED_ATTEMPT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            pn.Et[PlayerFishEvent.State.REEL_IN.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            pn.Et[PlayerFishEvent.State.BITE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            pn.Et[PlayerFishEvent.State.IN_GROUND.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
