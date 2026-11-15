package itemsadder.m;

import itemsadder.m.Opaque019;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

final class FluentBuilder {
    private final int aAB;
    private final TextColor aAC;
    private final TextDecoration aAD;
    private final boolean aAE;

    private FluentBuilder(int n, TextColor textColor, TextDecoration textDecoration, boolean bl) {
        this.aAB = n;
        this.aAC = textColor;
        this.aAD = textDecoration;
        this.aAE = bl;
    }

    private static FluentBuilder a(int n, TextColor textColor) {
        return new FluentBuilder(n, textColor, null, false);
    }

    private static FluentBuilder a(int n, TextDecoration textDecoration) {
        return new FluentBuilder(n, null, textDecoration, false);
    }

    private static FluentBuilder bN(int n) {
        return new FluentBuilder(n, null, null, true);
    }

    private void a(Opaque019 opaque019, TextColor textColor) {
        if (this.aAE) {
            opaque019.c(textColor);
            return;
        }
        if (this.aAC != null) {
            opaque019.b(this.aAC);
            return;
        }
        if (this.aAD != null) {
            opaque019.a(this.aAD);
        }
    }
}
