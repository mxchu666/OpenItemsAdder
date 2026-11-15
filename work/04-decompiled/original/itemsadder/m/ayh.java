package itemsadder.m;

import itemsadder.m.ayg;
import itemsadder.m.bjm;
import itemsadder.m.bjy;
import itemsadder.m.bko;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ayh
implements bko {
    private static final ayh apZ = new ayh();
    private static final Map aqa = new HashMap();

    public ayg wS() {
        return ayg.wP();
    }

    @Override
    public Class wf() {
        return ayg.class;
    }

    @Override
    public String wg() {
        return ayg.class.getSimpleName();
    }

    @Override
    public String wh() {
        return ayg.class.getName();
    }

    @Deprecated
    public boolean a(ayg ayg2) {
        return true;
    }

    public void a(bjm bjm2, ayg ayg2) {
        int n;
        block3: while ((n = bjm2.a(this)) != 0) {
            switch (n) {
                case 1: {
                    if (ayg2.apX == null) {
                        ayg2.apX = new ArrayList();
                    }
                    ayg2.apX.add(bjm2.FG());
                    continue block3;
                }
            }
            bjm2.a(n, (bko)this);
        }
        ayg2.wO();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bjy bjy2, ayg ayg2) {
        List list = ayg2.apX;
        synchronized (list) {
            for (String string : ayg2.apX) {
                bjy2.a(1, string, true);
            }
        }
    }

    @Override
    public String aT(int n) {
        switch (n) {
            case 1: {
                return "chunk";
            }
        }
        return null;
    }

    @Override
    public int dS(String string) {
        Integer n = (Integer)aqa.get(string);
        return n == null ? 0 : n;
    }

    @Override
    public /* synthetic */ Object wi() {
        return this.wS();
    }

    @Override
    @Deprecated
    public /* synthetic */ boolean r(Object object) {
        return this.a((ayg)object);
    }

    static {
        aqa.put("chunk", 1);
    }
}
