package itemsadder.m;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;

class bbc {
    static final /* synthetic */ int[] azt;
    static final /* synthetic */ int[] azu;

    static {
        azu = new int[HoverEvent.Action.values().length];
        try {
            bbc.azu[HoverEvent.Action.SHOW_TEXT.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            bbc.azu[HoverEvent.Action.SHOW_ITEM.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            bbc.azu[HoverEvent.Action.SHOW_ENTITY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            bbc.azu[HoverEvent.Action.SHOW_ACHIEVEMENT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        azt = new int[ClickEvent.Action.values().length];
        try {
            bbc.azt[ClickEvent.Action.OPEN_URL.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            bbc.azt[ClickEvent.Action.OPEN_FILE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            bbc.azt[ClickEvent.Action.RUN_COMMAND.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            bbc.azt[ClickEvent.Action.SUGGEST_COMMAND.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            bbc.azt[ClickEvent.Action.CHANGE_PAGE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            bbc.azt[ClickEvent.Action.COPY_TO_CLIPBOARD.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
