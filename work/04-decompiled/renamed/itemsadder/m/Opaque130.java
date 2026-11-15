package itemsadder.m;

import itemsadder.m.PluginBridge_6;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

class Opaque130 {
    public final Component He;
    public final String Hf;
    public Object Hg;

    Opaque130(String string) {
        this(string, 0xAAAAAA);
    }

    Opaque130(String string, int n) {
        this.He = ((TranslatableComponent)Component.translatable((String)string).color(TextColor.color((int)n))).decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
        this.Hf = string;
        this.Hg = PluginBridge_6.r(this.He);
    }

    public static Component f(Component component) {
        return component.color(TextColor.color((int)43520)).decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
    }
}
