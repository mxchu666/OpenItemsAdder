package itemsadder.m;

import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;

public abstract class bja
implements bko {
    protected final bko aEV;

    public bja(bko bko2) {
        this.aEV = bko2;
    }

    @Override
    public String aT(int n) {
        return this.aEV.aT(n);
    }

    @Override
    public int dS(String string) {
        return this.aEV.dS(string);
    }

    @Override
    public boolean r(Object object) {
        return this.aEV.r(object);
    }

    @Override
    public void a(bjm bjm2, Object object) {
        this.aEV.a(bjm2, object);
    }

    @Override
    public String wh() {
        return this.aEV.wh();
    }

    @Override
    public String wg() {
        return this.aEV.wg();
    }

    @Override
    public Object wi() {
        return this.aEV.wi();
    }

    @Override
    public Class wf() {
        return this.aEV.wf();
    }

    @Override
    public void a(bjy bjy2, Object object) {
        this.aEV.a(bjy2, object);
    }
}
