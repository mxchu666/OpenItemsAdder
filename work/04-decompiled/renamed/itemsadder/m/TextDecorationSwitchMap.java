package itemsadder.m;

import net.kyori.adventure.text.format.TextDecoration;

class TextDecorationSwitchMap {
    static final /* synthetic */ int[] azp;

    static {
        azp = new int[TextDecoration.values().length];
        try {
            TextDecorationSwitchMap.azp[TextDecoration.BOLD.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            TextDecorationSwitchMap.azp[TextDecoration.ITALIC.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            TextDecorationSwitchMap.azp[TextDecoration.UNDERLINED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            TextDecorationSwitchMap.azp[TextDecoration.STRIKETHROUGH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            TextDecorationSwitchMap.azp[TextDecoration.OBFUSCATED.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
