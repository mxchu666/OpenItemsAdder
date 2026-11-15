package itemsadder.m;

import itemsadder.m.ayk;
import itemsadder.m.ayl;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ayn
implements bko {
    private static final ayn aqk = new ayn();
    private static final Map aql = new HashMap();

    public ayk xj() {
        return ayk.wZ();
    }

    @Override
    public Class wf() {
        return ayk.class;
    }

    @Override
    public String wg() {
        return ayk.class.getSimpleName();
    }

    @Override
    public String wh() {
        return ayk.class.getName();
    }

    @Deprecated
    public boolean d(ayk ayk2) {
        return true;
    }

    public void a(bjm bjm2, ayk ayk2) {
        int n;
        block3: while ((n = bjm2.a(this)) != 0) {
            switch (n) {
                case 1: {
                    if (ayk2.Ee == null) {
                        ayk2.Ee = new ConcurrentHashMap();
                    }
                    ayl ayl2 = (ayl)bjm2.a(null, ayl.aqh);
                    ayk2.Ee.put(ayl2.xe(), ayl2.xg());
                    continue block3;
                }
            }
            bjm2.a(n, (bko)this);
        }
        ayk2.wY();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bjy bjy2, ayk ayk2) {
        Map map = ayk2.Ee;
        synchronized (map) {
            for (Map.Entry entry : ayk2.Ee.entrySet()) {
                ayl ayl2 = ayl.xd().aX((Integer)entry.getKey()).ea((String)entry.getValue());
                bjy2.a(1, ayl2, ayl.aqh, true);
            }
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "data";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)aql.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.xj();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.d((ayk)object);
    }

    static {
        aql.put("data", 1);
    }
}
