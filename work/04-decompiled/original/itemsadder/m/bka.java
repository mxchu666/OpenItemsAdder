package itemsadder.m;

import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bjz;
import itemsadder.m.bko;

public abstract class bka
implements bko {
    public final bko aFz;

    public bka(bko bko2) {
        this.aFz = bko2;
    }

    @Override
    public String aT(int n) {
        return this.aFz.aT(n);
    }

    @Override
    public int dS(String string) {
        return this.aFz.dS(string);
    }

    public boolean a(bjz bjz2) {
        return true;
    }

    @Override
    public String wh() {
        return this.aFz.wh();
    }

    @Override
    public String wg() {
        return this.aFz.wg();
    }

    public bjz Gh() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class wf() {
        throw new UnsupportedOperationException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void a(bjy bjy2, bjz bjz2) {
        if (bjz2.aEX == null) {
            bjz2.aEX = bjy2;
            bjm bjm2 = bjz2.a(this);
            if (bjm2 == null) {
                bjz2.aEX = null;
                bjz2.a(this, bjm2, true);
                return;
            }
            bjz2.aEW = bjm2;
            boolean bl = false;
            try {
                this.a(bjz2, bjm2, bjy2);
                bl = true;
                bjz2.a(this, bjm2, !bl);
            }
            catch (Throwable throwable) {
                bjz2.a(this, bjm2, !bl);
                throw throwable;
            }
            return;
        }
        bjz2.aEW.a(bjz2, (bko)this);
    }

    public final void a(bjm bjm2, bjz bjz2) {
        this.a(bjz2, bjm2, bjz2.aEX);
    }

    protected abstract void a(bjz var1, bjm var2, bjy var3);

    @Override
    public /* synthetic */ Object wi() {
        return this.Gh();
    }

    @Override
    public /* synthetic */ boolean r(Object object) {
        return this.a((bjz)object);
    }
}
