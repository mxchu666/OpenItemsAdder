package itemsadder.m;

import itemsadder.m.aya;
import itemsadder.m.ayc;
import itemsadder.m.ayd;
import itemsadder.m.ayk;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ayf
implements bko {
    private static final ayf apV = new ayf();
    private static final Map apW = new HashMap();

    public ayc wN() {
        return ayc.wt();
    }

    @Override
    public Class wf() {
        return ayc.class;
    }

    @Override
    public String wg() {
        return ayc.class.getSimpleName();
    }

    @Override
    public String wh() {
        return ayc.class.getName();
    }

    @Deprecated
    public boolean c(ayc ayc2) {
        return true;
    }

    public void a(bjm bjm2, ayc ayc2) {
        int n;
        block6: while ((n = bjm2.a(this)) != 0) {
            switch (n) {
                case 1: {
                    if (ayc2.apM == null) {
                        ayc2.apM = new ConcurrentHashMap();
                    }
                    ayd ayd2 = (ayd)bjm2.a(null, ayd.apS);
                    ayc2.apM.put(ayd2.aF(), ayd2.wJ());
                    continue block6;
                }
                case 2: {
                    ayc2.apN = (ayk)bjm2.a(ayc2.apN, ayk.aqf);
                    ayc2.apD |= 2;
                    continue block6;
                }
                case 3: {
                    ayc2.apO = (ayk)bjm2.a(ayc2.apO, ayk.aqf);
                    ayc2.apD |= 4;
                    continue block6;
                }
                case 4: {
                    ayc2.apP = (ayk)bjm2.a(ayc2.apP, ayk.aqf);
                    ayc2.apD |= 8;
                    continue block6;
                }
            }
            bjm2.a(n, (bko)this);
        }
        ayc2.ws();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bjy bjy2, ayc ayc2) {
        Map map = ayc2.apM;
        synchronized (map) {
            for (Map.Entry entry : ayc2.apM.entrySet()) {
                ayd ayd2 = ayd.wG().dW((String)entry.getKey()).c((aya)entry.getValue());
                bjy2.a(1, ayd2, ayd.apS, true);
            }
        }
        if ((ayc2.apD & 2) == 2) {
            bjy2.a(2, ayc2.apN, ayk.aqf, false);
        }
        if ((ayc2.apD & 4) == 4) {
            bjy2.a(3, ayc2.apO, ayk.aqf, false);
        }
        if ((ayc2.apD & 8) == 8) {
            bjy2.a(4, ayc2.apP, ayk.aqf, false);
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "block";
            }
            case 2: {
                return "blocksPalette";
            }
            case 3: {
                return "biomesPalette";
            }
            case 4: {
                return "cropsSeedsPalette";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)apW.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wN();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.c((ayc)object);
    }

    static {
        apW.put("block", 1);
        apW.put("blocksPalette", 2);
        apW.put("biomesPalette", 3);
        apW.put("cropsSeedsPalette", 4);
    }
}
