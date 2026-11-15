package itemsadder.m;

import itemsadder.m.bca;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

final class bbz {
    private final int aAB;
    private final TextColor aAC;
    private final TextDecoration aAD;
    private final boolean aAE;

    private bbz(int n, TextColor textColor, TextDecoration textDecoration, boolean bl) {
        this.aAB = n;
        this.aAC = textColor;
        this.aAD = textDecoration;
        this.aAE = bl;
    }

    private static bbz a(int n, TextColor textColor) {
        return new bbz(n, textColor, null, false);
    }

    private static bbz a(int n, TextDecoration textDecoration) {
        return new bbz(n, null, textDecoration, false);
    }

    private static bbz bN(int n) {
        return new bbz(n, null, null, true);
    }

    private void a(bca bca2, TextColor textColor) {
        if (this.aAE) {
            bca2.c(textColor);
            return;
        }
        if (this.aAC != null) {
            bca2.b(this.aAC);
            return;
        }
        if (this.aAD != null) {
            bca2.a(this.aAD);
        }
    }
}
