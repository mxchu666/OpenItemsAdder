package itemsadder.m;

import itemsadder.m.fw;
import itemsadder.m.ii;
import itemsadder.m.ij;
import itemsadder.m.il;
import itemsadder.m.jg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class ik
extends ij {
    final List wk = Collections.synchronizedList(new ArrayList());
    final int wl = 0;
    float wm;

    public ik(jg jg2, String string, String string2, String string3, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2, float f3, List list) {
        super(jg2, string, string2, string3, n, bl, bl2, bl3, bl4, f, f2, f3, list);
    }

    public ik b(jg jg2) {
        ik ik2 = new ik(jg2, this.bL, this.bM, this.wa, this.vJ, this.vP, this.vQ, this.vR, this.vS, this.wd, this.we, this.wf, this.vI);
        ik2.a(this);
        this.jM();
        return ik2;
    }

    @Override
    public float k(float f) {
        if (this.wm == f) {
            return this.wm;
        }
        this.wm = f;
        return this.wm;
    }

    @Override
    public float jW() {
        return this.wm;
    }

    @Override
    @Nullable
    public Float b(@Nullable Float f) {
        return Float.valueOf(this.jW());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int jJ() {
        if (!this.jL()) {
            return 0;
        }
        List list = this.wk;
        synchronized (list) {
            int n = 0;
            for (int i = 0; i < this.wk.size(); ++i) {
                fw fw2 = (fw)this.wk.get(i);
                n += fw2.getWidth();
            }
            return n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String jK() {
        if (this.vL == null) {
            return "";
        }
        if (this.vW != null && !this.vZ) {
            return this.vW;
        }
        List list = this.wk;
        synchronized (list) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.wk.size(); ++i) {
                fw fw2 = (fw)this.wk.get(i);
                stringBuilder.append(fw2.if());
            }
            stringBuilder = new StringBuilder(il.c(stringBuilder.toString(), 0));
            stringBuilder = new StringBuilder(il.c(stringBuilder.toString(), this.vL));
            stringBuilder = new StringBuilder(il.c(stringBuilder.toString(), this.vJ));
            this.vW = stringBuilder.toString();
            this.vZ = false;
            return this.vW;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(fw fw2) {
        this.jM();
        List list = this.wk;
        synchronized (list) {
            this.wk.add(fw2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(int n, fw fw2) {
        this.jM();
        List list = this.wk;
        synchronized (list) {
            this.wk.add(n, fw2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void Z(int n) {
        this.jM();
        List list = this.wk;
        synchronized (list) {
            this.wk.remove(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ka() {
        this.jM();
        List list = this.wk;
        synchronized (list) {
            this.wk.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int kb() {
        List list = this.wk;
        synchronized (list) {
            return this.wk.size();
        }
    }

    @Override
    public /* synthetic */ ii a(jg jg2) {
        return this.b(jg2);
    }
}
