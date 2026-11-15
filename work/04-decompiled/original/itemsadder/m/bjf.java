package itemsadder.m;

import itemsadder.m.biw;
import itemsadder.m.bjd;
import itemsadder.m.bji;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import itemsadder.m.bkv;
import itemsadder.m.bkx;
import java.util.ArrayList;

public final class bjf
extends bjd
implements bji,
bko {
    private final ArrayList aEY;
    private int aEZ = -1;
    private bko aFa;
    private boolean aFb = false;

    public bjf(biw biw2) {
        super(biw2);
        assert (biw2.aED);
        this.aEY = new ArrayList();
    }

    public bjf(biw biw2, int n) {
        super(biw2);
        assert (biw2.aED);
        this.aEY = new ArrayList(n);
    }

    @Override
    public void h(Object object, Object object2) {
        int n = this.aEY.size() - 1;
        if (object2 != null && object2 == this.aEY.get(n)) {
            this.aEY.set(n, object);
        }
    }

    @Override
    public boolean FY() {
        return this.aFb;
    }

    @Override
    public int a(bko bko2) {
        int n = ((biw)this.aEW).a(bko2);
        if (bkx.cF(((biw)this.aEW).Fo()) == 6) {
            this.aEZ = ((biw)this.aEW).FA();
            this.aFb = true;
        } else {
            this.aFb = false;
        }
        return n;
    }

    @Override
    public Object a(Object object, bko bko2) {
        if (this.aFb) {
            return this.aEY.get(this.aEZ);
        }
        this.aFa = bko2;
        if (object == null) {
            object = bko2.wi();
        }
        this.aEY.add(object);
        ((biw)this.aEW).a(object, (bko)this);
        return object;
    }

    @Override
    public void a(int n, bko bko2) {
        if (!this.aFb) {
            ((biw)this.aEW).cd(((biw)this.aEW).Fo());
        }
    }

    @Override
    public String aT(int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int dS(String string) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean r(Object object) {
        return true;
    }

    @Override
    public String wh() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String wg() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object wi() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class wf() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void a(bjm bjm2, Object object) {
        bko bko2 = this.aFa;
        bko2.a(this, object);
        if (!bko2.r(object)) {
            throw new bkv(object, bko2);
        }
        this.aFa = bko2;
    }

    @Override
    public void a(bjy bjy2, Object object) {
        throw new UnsupportedOperationException();
    }
}
