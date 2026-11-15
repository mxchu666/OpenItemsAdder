package itemsadder.m;

import itemsadder.m.bbe;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

class qu {
    public final Component He;
    public final String Hf;
    public Object Hg;

    qu(String string) {
        this(string, 0xAAAAAA);
    }

    qu(String string, int n) {
        this.He = ((TranslatableComponent)Component.translatable((String)string).color(TextColor.color((int)n))).decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
        this.Hf = string;
        this.Hg = bbe.r(this.He);
    }

    public static Component f(Component component) {
        return component.color(TextColor.color((int)43520)).decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
    }
}
