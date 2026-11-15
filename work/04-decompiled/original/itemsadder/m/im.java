package itemsadder.m;

import itemsadder.m.fw;
import itemsadder.m.ii;
import itemsadder.m.ij;
import itemsadder.m.il;
import itemsadder.m.jg;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class im
extends ij {
    public final List ws;
    @Nullable
    fw wt;
    float wu;
    final int wv = 0;

    public im(jg jg2, String string, String string2, String string3, List list, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2, float f3, List list2) {
        super(jg2, string, string2, string3, n, bl, bl2, bl3, bl4, f, f2, f3, list2);
        this.ws = list;
    }

    public im c(jg jg2) {
        im im2 = new im(jg2, this.bL, this.bM, this.wa, this.ws, this.vJ, this.vP, this.vQ, this.vR, this.vS, this.wd, this.we, this.wf, this.vI);
        im2.a(this);
        this.jM();
        return im2;
    }

    @Override
    public String jK() {
        if (this.vL == null) {
            return "";
        }
        float f = this.jW();
        if (this.vW != null && !this.vZ) {
            return this.vW;
        }
        fw fw2 = this.l(f);
        if (fw2 == null) {
            return "";
        }
        String string = fw2.if();
        string = il.c(string, 0);
        string = il.c(string, this.vL);
        this.vW = string = il.c(string, this.vJ);
        this.vZ = false;
        return string;
    }

    @Nullable
    public fw l(float f) {
        fw fw2;
        int n = f <= this.we ? 0 : (f >= this.we + (float)this.ws.size() - 1.0f ? this.ws.size() - 1 : (int)(f - this.we));
        this.wt = fw2 = (fw)this.ws.get(n);
        this.wu = f;
        return fw2;
    }

    @Override
    public int jJ() {
        if (!this.jL()) {
            return 0;
        }
        if (this.wt == null) {
            this.l(this.jW());
        }
        return this.wt.getWidth();
    }

    @Override
    public /* synthetic */ ii a(jg jg2) {
        return this.c(jg2);
    }
}
