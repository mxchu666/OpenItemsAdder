package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.Hitbox;

public class HitboxImpl
extends Hitbox {
    public HitboxImpl(String string, String string2) {
        super(string, string2);
        this.pD = true;
    }

    @Override
    public String aJ(String string) {
        String string2 = ColorBridge.iR(string);
        string2 = ColorBridge.aF(string2, "/.player_advanced_animations");
        string2 = ColorBridge.iS(string2);
        return string2;
    }
}
