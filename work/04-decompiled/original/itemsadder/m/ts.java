package itemsadder.m;

import itemsadder.m.ae;
import itemsadder.m.bbf;
import itemsadder.m.bbg;
import itemsadder.m.tn;
import itemsadder.m.tq;
import itemsadder.m.tr;
import itemsadder.m.tt;
import itemsadder.m.tv;
import itemsadder.m.tw;
import java.util.List;

public class ts {
    private final bbf KV;
    private final List KW;

    public ts(bbf bbf2, List list) {
        this.KV = bbf2;
        this.KW = list;
    }

    public tr qk() {
        tr tr2 = new tr(this.KV);
        for (String string : this.KW) {
            bbg bbg2 = this.KV.hj("items." + string);
            if (bbg2 == null || !bbg2.C("enabled", true)) continue;
            this.a(tr2, string, bbg2);
            this.b(tr2, string, bbg2);
            this.c(tr2, string, bbg2);
        }
        return tr2;
    }

    private void a(tr tr2, String string, bbg bbg2) {
        block4: {
            if (!ae.fB) {
                return;
            }
            tt tt2 = new tt(this.KV, string, bbg2);
            try {
                if (!tt2.pY()) {
                    return;
                }
                tr2.a(tt2);
            }
            catch (tq tq2) {
                if (tq2.qe()) break block4;
                tq.a("[Converter] " + tq2.getMessage() + " File: " + this.KV.nh(), tq2);
            }
        }
    }

    private void b(tr tr2, String string, bbg bbg2) {
        if (!ae.fO) {
            return;
        }
        tw tw2 = new tw(this.KV, string, bbg2);
        try {
            if (!tw2.pY()) {
                return;
            }
            tr2.a(tw2);
        }
        catch (tq tq2) {
            if (tq2.qe()) {
                tq.b("[Converter] " + tq2.getMessage() + " File: " + this.KV.nh(), tq2);
            }
            tq.a("[Converter] " + tq2.getMessage() + " File: " + this.KV.nh(), tq2);
        }
    }

    private void c(tr tr2, String string, bbg bbg2) {
        block11: {
            if (ae.fL) {
                tn tn2 = new tn(this.KV, string, bbg2);
                try {
                    if (!tn2.pY()) {
                        return;
                    }
                    tr2.a(tn2);
                }
                catch (tq tq2) {
                    if (tq2.qe()) {
                        tq.b("[Converter] " + tq2.getMessage() + " File: " + this.KV.nh(), tq2);
                        break block11;
                    }
                    tq.a("[Converter] " + tq2.getMessage() + " File: " + this.KV.nh(), tq2);
                }
            } else if (ae.fM) {
                tv tv2 = new tv(this.KV, string, bbg2);
                try {
                    if (!tv2.pY()) {
                        return;
                    }
                    tr2.a(tv2);
                }
                catch (tq tq3) {
                    if (tq3.qe()) {
                        tq.b("[Converter] " + tq3.getMessage() + " File: " + this.KV.nh(), tq3);
                    }
                    tq.a("[Converter] " + tq3.getMessage() + " File: " + this.KV.nh(), tq3);
                }
            }
        }
    }
}
