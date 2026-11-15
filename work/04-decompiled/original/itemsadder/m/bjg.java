package itemsadder.m;

import itemsadder.m.biz;
import itemsadder.m.bjd;
import itemsadder.m.bji;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import itemsadder.m.bkv;
import itemsadder.m.bkx;
import java.util.ArrayList;

public final class bjg
extends bjd
implements bji,
bko {
    private final ArrayList aFd;
    private int aEZ = -1;
    private bko aFa;
    private boolean aFb = false;

    public bjg(biz biz2) {
        super(biz2);
        assert (biz2.aER);
        this.aFd = new ArrayList();
    }

    public bjg(biz biz2, int n) {
        super(biz2);
        assert (biz2.aER);
        this.aFd = new ArrayList(n);
    }

    @Override
    public void h(Object object, Object object2) {
        int n = this.aFd.size() - 1;
        if (object2 != null && object2 == this.aFd.get(n)) {
            this.aFd.set(n, object);
        }
    }

    @Override
    public boolean FY() {
        return this.aFb;
    }

    @Override
    public int a(bko bko2) {
        int n = ((biz)this.aEW).a(bko2);
        if (bkx.cF(((biz)this.aEW).Fo()) == 6) {
            this.aEZ = ((biz)this.aEW).FA();
            this.aFb = true;
        } else {
            this.aFb = false;
        }
        return n;
    }

    @Override
    public Object a(Object object, bko bko2) {
        if (this.aFb) {
            return this.aFd.get(this.aEZ);
        }
        this.aFa = bko2;
        if (object == null) {
            object = bko2.wi();
        }
        this.aFd.add(object);
        ((biz)this.aEW).a(object, (bko)this);
        return object;
    }

    @Override
    public void a(int n, bko bko2) {
        if (!this.aFb) {
            ((biz)this.aEW).cd(((biz)this.aEW).Fo());
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
