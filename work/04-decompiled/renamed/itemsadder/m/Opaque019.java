package itemsadder.m;

import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

final class Opaque019 {
    private TextColor color;
    private boolean aAF;
    private boolean aAG;
    private boolean aAH;
    private boolean aAI;
    private boolean aAJ;

    private Opaque019(TextColor textColor) {
        this.color = textColor;
    }

    private void b(TextColor textColor) {
        this.color = textColor;
        this.Di();
    }

    private void a(TextDecoration textDecoration) {
        switch (textDecoration) {
            case BOLD: {
                this.aAF = true;
                break;
            }
            case ITALIC: {
                this.aAG = true;
                break;
            }
            case UNDERLINED: {
                this.aAH = true;
                break;
            }
            case STRIKETHROUGH: {
                this.aAI = true;
                break;
            }
            case OBFUSCATED: {
                this.aAJ = true;
            }
        }
    }

    private void c(TextColor textColor) {
        this.color = textColor;
        this.Di();
    }

    private void Di() {
        this.aAF = false;
        this.aAG = false;
        this.aAH = false;
        this.aAI = false;
        this.aAJ = false;
    }
}
