package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.tp;

public abstract class to
implements tp {
    protected final bbf KO;
    protected final String KP;
    protected final bbg KQ;

    public to(bbf bbf2, String string, bbg bbg2) {
        this.KO = bbf2;
        this.KP = string;
        this.KQ = bbg2;
    }

    @Override
    public String qc() {
        return this.KP;
    }

    protected String qd() {
        return this.KO.nh();
    }
}
