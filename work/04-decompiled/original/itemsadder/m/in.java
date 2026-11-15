package itemsadder.m;

import itemsadder.m.fw;
import itemsadder.m.ii;
import itemsadder.m.ij;
import itemsadder.m.il;
import itemsadder.m.io;
import itemsadder.m.jg;
import java.util.List;
import lombok.Generated;

public class in
extends ij {
    final fw ww;
    final fw wx;
    final fw wy;
    final int wz;
    final int wA = 0;
    final io wB;

    public in(jg jg2, String string, String string2, String string3, io io2, fw fw2, fw fw3, fw fw4, int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2, float f3, List list) {
        super(jg2, string, string2, string3, n, bl, bl2, bl3, bl4, f, f2, f3, list);
        this.wB = io2;
        this.ww = fw2;
        this.wx = fw3;
        this.wy = fw4;
        this.wz = n2;
    }

    public in d(jg jg2) {
        in in2 = new in(jg2, this.bL, this.bM, this.wa, this.wB, this.ww, this.wx, this.wy, this.vJ, this.wz, this.vP, this.vQ, this.vR, this.vS, this.wd, this.we, this.wf, this.vI);
        in2.a(this);
        this.jM();
        return in2;
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
        if (this.ww == null || this.wx == null || this.wy == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        while ((float)n < f) {
            if ((float)n < f && n == (int)f) {
                stringBuilder.append(il.c(this.wx.if(), 0));
            } else {
                stringBuilder.append(il.c(this.ww.if(), 0));
            }
            ++n;
        }
        n = (int)f;
        while ((float)n < this.wf) {
            if (!((float)n < f) || n != (int)f) {
                stringBuilder.append(il.c(this.wy.if(), 0));
            }
            ++n;
        }
        if (this.wB == io.LEFT) {
            stringBuilder = new StringBuilder(new StringBuilder(stringBuilder.toString()).reverse().toString());
        }
        stringBuilder = new StringBuilder(il.c(stringBuilder.toString(), this.vL));
        stringBuilder = new StringBuilder(il.c(stringBuilder.toString(), this.vJ));
        this.vW = stringBuilder.toString();
        this.vZ = false;
        return this.vW;
    }

    @Override
    public int jJ() {
        if (!this.jL()) {
            return 0;
        }
        return this.wz * this.ww.getWidth();
    }

    @Generated
    public fw kc() {
        return this.ww;
    }

    @Override
    public /* synthetic */ ii a(jg jg2) {
        return this.d(jg2);
    }
}
