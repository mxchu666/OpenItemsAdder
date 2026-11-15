package itemsadder.m;

import itemsadder.m.aya;
import itemsadder.m.ayd;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.util.HashMap;
import java.util.Map;

public final class aye
implements bko {
    private static final aye apT = new aye();
    private static final Map apU = new HashMap();

    public ayd wM() {
        return ayd.wG();
    }

    @Override
    public Class wf() {
        return ayd.class;
    }

    @Override
    public String wg() {
        return ayd.class.getSimpleName();
    }

    @Override
    public String wh() {
        return ayd.class.getName();
    }

    @Deprecated
    public boolean a(ayd ayd2) {
        return true;
    }

    public void a(bjm bjm2, ayd ayd2) {
        int n;
        block4: while ((n = bjm2.a(this)) != 0) {
            switch (n) {
                case 1: {
                    ayd2.gv = bjm2.FG();
                    ayd2.apD |= 1;
                    continue block4;
                }
                case 2: {
                    ayd2.apR = (aya)bjm2.a(ayd2.apR, aya.apJ);
                    ayd2.apD |= 2;
                    continue block4;
                }
            }
            bjm2.a(n, (bko)this);
        }
        ayd2.wF();
    }

    public void a(bjy bjy2, ayd ayd2) {
        if ((ayd2.apD & 1) == 1) {
            bjy2.a(1, ayd2.gv, false);
        }
        if ((ayd2.apD & 2) == 2) {
            bjy2.a(2, ayd2.apR, aya.apJ, false);
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "key";
            }
            case 2: {
                return "value";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)apU.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wM();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((ayd)object);
    }

    static {
        apU.put("key", 1);
        apU.put("value", 2);
    }
}
