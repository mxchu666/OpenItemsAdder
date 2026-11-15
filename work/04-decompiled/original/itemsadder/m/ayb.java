package itemsadder.m;

import itemsadder.m.axy;
import itemsadder.m.aya;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.util.HashMap;
import java.util.Map;

public final class ayb
implements bko {
    private static final ayb apK = new ayb();
    private static final Map apL = new HashMap();

    public aya wr() {
        return aya.wk();
    }

    @Override
    public Class wf() {
        return aya.class;
    }

    @Override
    public String wg() {
        return aya.class.getSimpleName();
    }

    @Override
    public String wh() {
        return aya.class.getName();
    }

    @Deprecated
    public boolean a(aya aya2) {
        return true;
    }

    public void a(bjm bjm2, aya aya2) {
        int n;
        block4: while ((n = bjm2.a(this)) != 0) {
            switch (n) {
                case 1: {
                    aya2.apH = bjm2.Fw();
                    aya2.apD |= 1;
                    continue block4;
                }
                case 2: {
                    aya2.apI = (axy)bjm2.a(aya2.apI, axy.apE);
                    aya2.apD |= 2;
                    continue block4;
                }
            }
            bjm2.a(n, (bko)this);
        }
        aya2.wj();
    }

    public void a(bjy bjy2, aya aya2) {
        if ((aya2.apD & 1) == 1) {
            bjy2.d(1, aya2.apH, false);
        }
        if ((aya2.apD & 2) == 2) {
            bjy2.a(2, aya2.apI, axy.apE, false);
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "blockId";
            }
            case 2: {
                return "additionalProperties";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)apL.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wr();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((aya)object);
    }

    static {
        apL.put("blockId", 1);
        apL.put("additionalProperties", 2);
    }
}
