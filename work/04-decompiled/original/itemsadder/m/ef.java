package itemsadder.m;

import itemsadder.m.bcy;
import itemsadder.m.ec;

public class ef
extends ec {
    public ef(String string, String string2) {
        super(string, string2);
        this.pD = true;
    }

    @Override
    public String aJ(String string) {
        String string2 = bcy.iR(string);
        string2 = bcy.aF(string2, "/.player_advanced_animations");
        string2 = bcy.iS(string2);
        return string2;
    }
}
