package itemsadder.m;

import itemsadder.m.bbz;
import itemsadder.m.bca;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

public final class bbx {
    public static Component iv(String string) {
        return bbx.a(string, null, true);
    }

    public static Component a(String string, TextColor textColor) {
        return bbx.a(string, textColor, true);
    }

    public static Component a(String string, TextColor textColor, boolean bl) {
        if (string == null || string.isEmpty()) {
            return Component.empty();
        }
        TextComponent textComponent = Component.empty();
        StringBuilder stringBuilder = new StringBuilder();
        bca bca2 = new bca(textColor);
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            bbz bbz2 = bbx.u(string, i);
            if (bbz2 != null) {
                textComponent = bbx.a((Component)textComponent, stringBuilder, bca2);
                bbz2.a(bca2, textColor);
                i += bbz2.aAB - 1;
                continue;
            }
            if (bl && c == '#' && bbx.b(string, i + 1, 6)) {
                textComponent = bbx.a((Component)textComponent, stringBuilder, bca2);
                bca2.b(bbx.iw(string.substring(i, i + 7)));
                i += 6;
                continue;
            }
            stringBuilder.append(c);
        }
        return bbx.a((Component)textComponent, stringBuilder, bca2);
    }

    private static Component a(Component component, StringBuilder stringBuilder, bca bca2) {
        if (stringBuilder.length() == 0) {
            return component;
        }
        TextComponent textComponent = Component.text((String)stringBuilder.toString());
        if (bca2.color != null) {
            textComponent = textComponent.color(bca2.color);
        }
        textComponent = textComponent.decoration(TextDecoration.BOLD, bbx.ba(bca2.aAF));
        textComponent = textComponent.decoration(TextDecoration.ITALIC, bbx.ba(bca2.aAG));
        textComponent = textComponent.decoration(TextDecoration.UNDERLINED, bbx.ba(bca2.aAH));
        textComponent = textComponent.decoration(TextDecoration.STRIKETHROUGH, bbx.ba(bca2.aAI));
        textComponent = textComponent.decoration(TextDecoration.OBFUSCATED, bbx.ba(bca2.aAJ));
        stringBuilder.setLength(0);
        return component.append((Component)textComponent);
    }

    private static bbz u(String string, int n) {
        if (n + 1 >= string.length()) {
            return null;
        }
        char c = string.charAt(n);
        if (!bbx.h(c)) {
            return null;
        }
        char c2 = Character.toLowerCase(string.charAt(n + 1));
        if (c2 == '#') {
            if (n + 7 < string.length() && bbx.b(string, n + 2, 6)) {
                String string2 = "#" + string.substring(n + 2, n + 8);
                return bbz.a(8, bbx.iw(string2));
            }
            return null;
        }
        if (c2 == 'x') {
            TextColor textColor = bbx.v(string, n);
            if (textColor != null) {
                return bbz.a(14, textColor);
            }
            return null;
        }
        TextColor textColor = bbx.j(c2);
        if (textColor != null) {
            return bbz.a(2, textColor);
        }
        TextDecoration textDecoration = bbx.k(c2);
        if (textDecoration != null) {
            return bbz.a(2, textDecoration);
        }
        if (c2 == 'r') {
            return bbz.bN(2);
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
            if (!bbx.h(string.charAt(n2))) {
                return null;
            }
            char c = string.charAt(n3);
            if (!bbx.i(c)) {
                return null;
            }
            stringBuilder.append(c);
        }
        return bbx.iw(stringBuilder.toString());
    }

    private static boolean h(char c) {
        return c == '&' || c == '\u00a7';
    }

    private static boolean b(String string, int n, int n2) {
        if (n + n2 > string.length()) {
            return false;
        }
        for (int i = n; i < n + n2; ++i) {
            if (bbx.i(string.charAt(i))) continue;
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
