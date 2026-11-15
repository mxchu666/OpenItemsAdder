package itemsadder.m;

import itemsadder.m.ayl;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.util.HashMap;
import java.util.Map;

public final class aym
implements bko {
    private static final aym aqi = new aym();
    private static final Map aqj = new HashMap();

    public ayl xi() {
        return ayl.xd();
    }

    @Override
    public Class wf() {
        return ayl.class;
    }

    @Override
    public String wg() {
        return ayl.class.getSimpleName();
    }

    @Override
    public String wh() {
        return ayl.class.getName();
    }

    @Deprecated
    public boolean a(ayl ayl2) {
        return true;
    }

    public void a(bjm bjm2, ayl ayl2) {
        int n;
        block4: while ((n = bjm2.a(this)) != 0) {
            switch (n) {
                case 1: {
                    ayl2.aqg = bjm2.Fw();
                    ayl2.apD |= 1;
                    continue block4;
                }
                case 2: {
                    ayl2.Qe = bjm2.FG();
                    ayl2.apD |= 2;
                    continue block4;
                }
            }
            bjm2.a(n, (bko)this);
        }
        ayl2.xc();
    }

    public void a(bjy bjy2, ayl ayl2) {
        if ((ayl2.apD & 1) == 1) {
            bjy2.d(1, ayl2.aqg, false);
        }
        if ((ayl2.apD & 2) == 2) {
            bjy2.a(2, ayl2.Qe, false);
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
        Integer n = (Integer)aqj.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.xi();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((ayl)object);
    }

    static {
        aqj.put("key", 1);
        aqj.put("value", 2);
    }
}
