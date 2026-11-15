package dev.lone.itemsadder.resourcepack;

import org.bukkit.event.player.PlayerResourcePackStatusEvent;

class ac {
    static final /* synthetic */ int[] asa;

    static {
        asa = new int[PlayerResourcePackStatusEvent.Status.values().length];
        try {
            ac.asa[PlayerResourcePackStatusEvent.Status.ACCEPTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ac.asa[PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ac.asa[PlayerResourcePackStatusEvent.Status.DECLINED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ac.asa[PlayerResourcePackStatusEvent.Status.FAILED_DOWNLOAD.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ac.asa[PlayerResourcePackStatusEvent.Status.DISCARDED.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ac.asa[PlayerResourcePackStatusEvent.Status.INVALID_URL.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            ac.asa[PlayerResourcePackStatusEvent.Status.FAILED_RELOAD.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
