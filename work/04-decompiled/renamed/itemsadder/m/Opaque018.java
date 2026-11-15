package itemsadder.m;

import itemsadder.m.FluentBuilder;
import itemsadder.m.Opaque019;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

public final class Opaque018 {
    public static Component iv(String string) {
        return Opaque018.a(string, null, true);
    }

    public static Component a(String string, TextColor textColor) {
        return Opaque018.a(string, textColor, true);
    }

    public static Component a(String string, TextColor textColor, boolean bl) {
        if (string == null || string.isEmpty()) {
            return Component.empty();
        }
        TextComponent textComponent = Component.empty();
        StringBuilder stringBuilder = new StringBuilder();
        Opaque019 opaque019 = new Opaque019(textColor);
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            FluentBuilder fluentBuilder = Opaque018.u(string, i);
            if (fluentBuilder != null) {
                textComponent = Opaque018.a((Component)textComponent, stringBuilder, opaque019);
                fluentBuilder.a(opaque019, textColor);
                i += fluentBuilder.aAB - 1;
                continue;
            }
            if (bl && c == '#' && Opaque018.b(string, i + 1, 6)) {
                textComponent = Opaque018.a((Component)textComponent, stringBuilder, opaque019);
                opaque019.b(Opaque018.iw(string.substring(i, i + 7)));
                i += 6;
                continue;
            }
            stringBuilder.append(c);
        }
        return Opaque018.a((Component)textComponent, stringBuilder, opaque019);
    }

    private static Component a(Component component, StringBuilder stringBuilder, Opaque019 opaque019) {
        if (stringBuilder.length() == 0) {
            return component;
        }
        TextComponent textComponent = Component.text((String)stringBuilder.toString());
        if (opaque019.color != null) {
            textComponent = textComponent.color(opaque019.color);
        }
        textComponent = textComponent.decoration(TextDecoration.BOLD, Opaque018.ba(opaque019.aAF));
        textComponent = textComponent.decoration(TextDecoration.ITALIC, Opaque018.ba(opaque019.aAG));
        textComponent = textComponent.decoration(TextDecoration.UNDERLINED, Opaque018.ba(opaque019.aAH));
        textComponent = textComponent.decoration(TextDecoration.STRIKETHROUGH, Opaque018.ba(opaque019.aAI));
        textComponent = textComponent.decoration(TextDecoration.OBFUSCATED, Opaque018.ba(opaque019.aAJ));
        stringBuilder.setLength(0);
        return component.append((Component)textComponent);
    }

    private static FluentBuilder u(String string, int n) {
        if (n + 1 >= string.length()) {
            return null;
        }
        char c = string.charAt(n);
        if (!Opaque018.h(c)) {
            return null;
        }
        char c2 = Character.toLowerCase(string.charAt(n + 1));
        if (c2 == '#') {
            if (n + 7 < string.length() && Opaque018.b(string, n + 2, 6)) {
                String string2 = "#" + string.substring(n + 2, n + 8);
                return FluentBuilder.a(8, Opaque018.iw(string2));
            }
            return null;
        }
        if (c2 == 'x') {
            TextColor textColor = Opaque018.v(string, n);
            if (textColor != null) {
                return FluentBuilder.a(14, textColor);
            }
            return null;
        }
        TextColor textColor = Opaque018.j(c2);
        if (textColor != null) {
            return FluentBuilder.a(2, textColor);
        }
        TextDecoration textDecoration = Opaque018.k(c2);
        if (textDecoration != null) {
            return FluentBuilder.a(2, textDecoration);
        }
        if (c2 == 'r') {
            return FluentBuilder.bN(2);
        }
        return null;
    }

    private static TextColor v(String string, int n) {
        if (n + 13 >= string.length()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("#");
        for (int i = 0; i < 6; ++i) {
            int n2 = n + 2 + i * 2;
            int n3 = n2 + 1;
            if (!Opaque018.h(string.charAt(n2))) {
                return null;
            }
            char c = string.charAt(n3);
            if (!Opaque018.i(c)) {
                return null;
            }
            stringBuilder.append(c);
        }
        return Opaque018.iw(stringBuilder.toString());
    }

    private static boolean h(char c) {
        return c == '&' || c == '\u00a7';
    }

    private static boolean b(String string, int n, int n2) {
        if (n + n2 > string.length()) {
            return false;
        }
        for (int i = n; i < n + n2; ++i) {
            if (Opaque018.i(string.charAt(i))) continue;
            return false;
        }
        return true;
    }

    private static boolean i(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F';
    }

    private static TextColor iw(String string) {
        return TextColor.color((int)Integer.parseInt(string.substring(1), 16));
    }

    private static TextColor j(char c) {
        switch (c) {
            case '0': {
                return NamedTextColor.BLACK;
            }
            case '1': {
                return NamedTextColor.DARK_BLUE;
            }
            case '2': {
                return NamedTextColor.DARK_GREEN;
            }
            case '3': {
                return NamedTextColor.DARK_AQUA;
            }
            case '4': {
                return NamedTextColor.DARK_RED;
            }
            case '5': {
                return NamedTextColor.DARK_PURPLE;
            }
            case '6': {
                return NamedTextColor.GOLD;
            }
            case '7': {
                return NamedTextColor.GRAY;
            }
            case '8': {
                return NamedTextColor.DARK_GRAY;
            }
            case '9': {
                return NamedTextColor.BLUE;
            }
            case 'a': {
                return NamedTextColor.GREEN;
            }
            case 'b': {
                return NamedTextColor.AQUA;
            }
            case 'c': {
                return NamedTextColor.RED;
            }
            case 'd': {
                return NamedTextColor.LIGHT_PURPLE;
            }
            case 'e': {
                return NamedTextColor.YELLOW;
            }
            case 'f': {
                return NamedTextColor.WHITE;
            }
        }
        return null;
    }

    private static TextDecoration k(char c) {
        switch (c) {
            case 'k': {
                return TextDecoration.OBFUSCATED;
            }
            case 'l': {
                return TextDecoration.BOLD;
            }
            case 'm': {
                return TextDecoration.STRIKETHROUGH;
            }
            case 'n': {
                return TextDecoration.UNDERLINED;
            }
            case 'o': {
                return TextDecoration.ITALIC;
            }
        }
        return null;
    }

    private static TextDecoration.State ba(boolean bl) {
        return bl ? TextDecoration.State.TRUE : TextDecoration.State.FALSE;
    }
}
