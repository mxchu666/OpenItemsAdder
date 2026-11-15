package itemsadder.m;

import itemsadder.m.ayi;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ayj
implements bko {
    private static final ayj aqd = new ayj();
    private static final Map aqe = new HashMap();

    public ayi wX() {
        return ayi.wU();
    }

    @Override
    public Class wf() {
        return ayi.class;
    }

    @Override
    public String wg() {
        return ayi.class.getSimpleName();
    }

    @Override
    public String wh() {
        return ayi.class.getName();
    }

    @Deprecated
    public boolean b(ayi ayi2) {
        return true;
    }

    public void a(bjm bjm2, ayi ayi2) {
        int n;
        block3: while ((n = bjm2.a(this)) != 0) {
            switch (n) {
                case 1: {
                    if (ayi2.aqb == null) {
                        ayi2.aqb = new ArrayList();
                    }
                    ayi2.aqb.add(bjm2.FG());
                    continue block3;
                }
            }
            bjm2.a(n, (bko)this);
        }
        ayi2.wT();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bjy bjy2, ayi ayi2) {
        List list = ayi2.aqb;
        synchronized (list) {
            for (String string : ayi2.aqb) {
                bjy2.a(1, string, true);
            }
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "item";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)aqe.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wX();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.b((ayi)object);
    }

    static {
        aqe.put("item", 1);
    }
}
