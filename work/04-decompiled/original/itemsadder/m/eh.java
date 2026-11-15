package itemsadder.m;

import itemsadder.m.dn;
import itemsadder.m.do;
import itemsadder.m.dt;
import itemsadder.m.dw;
import itemsadder.m.ee;
import itemsadder.m.eg;
import itemsadder.m.ei;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class eh {
    public final dn pZ;
    private Map qa;
    @Nullable
    public dt qb;
    public List qc;
    public dt qd;
    @Nullable
    private Runnable qe;
    public boolean qf;
    private int qg;
    public int qh;
    public long qi;
    public boolean qj;
    AtomicBoolean qk = new AtomicBoolean(false);
    boolean ql;
    boolean qm = false;

    public eh(dn dn2, @NotNull dt dt2) {
        this.pZ = dn2;
        this.qb = dt2;
        dn2.a(this);
        this.gj();
        this.qf = true;
    }

    private void gj() {
        this.qa = Collections.synchronizedMap(new HashMap());
        new LinkedHashMap<String, dt>(this.pZ.et().pB).forEach((string, dt2) -> this.qa.put(dt2, dt2.l(this.pZ)));
        this.gq();
    }

    public void gk() {
        this.qm = false;
        if (this.qc == null) {
            return;
        }
        this.pZ.ex();
        Location location = this.pZ.getLocation();
        int n = this.qc.size();
        for (int i = 0; i < n; ++i) {
            List list;
            List list2;
            if (this.qk.get() || this.qb == null) {
                this.qk.set(false);
                return;
            }
            if (this.qc.size() == 0) {
                return;
            }
            if (this.qd != null && this.qg <= 0 && this.n(this.qd)) {
                if (this.qe != null) {
                    this.qe.run();
                }
                this.go();
                return;
            }
            if (this.qh + 1 >= this.qb.oE) {
                --this.qg;
                if (this.qg > 0) {
                    this.qd = this.qb;
                    this.go();
                    return;
                }
            }
            Object object = (ei)this.qc.get(i);
            if (!this.qm && !this.qb.oC && this.gs()) {
                this.qf = false;
                if (this.qe != null) {
                    this.qe.run();
                    this.qm = true;
                }
            } else if (this.qf) {
                ((ei)object).c(this);
            }
            ((ei)object).a(location, this);
            if (this.qb == null || this.qh >= this.qb.oI.size() || (list2 = (List)this.qb.oI.get(this.qh)).size() <= 0 || (list = this.pZ.ea()).size() <= 0) continue;
            double[] dArray = ((ei)object).qp.qw.tv();
            block1: for (int j = 0; j < list.size(); ++j) {
                do do_ = (do)list.get(j);
                for (ee ee2 : list2) {
                    if (!((ei)object).qp.qx.equals(ee2.pR)) continue;
                    ee2.a(do_.iW, dArray[0], dArray[1], dArray[2]);
                    continue block1;
                }
            }
        }
        if (this.qb != null && this.qb.fI() && this.qh < this.qb.oH.size()) {
            for (Object object : (List)this.qb.oH.get(this.qh)) {
                ((eg)object).t(location);
            }
        }
        this.gn();
    }

    public void gl() {
        this.pZ.ex();
        Location location = this.pZ.getLocation();
        int n = this.qc.size();
        for (int i = 0; i < n; ++i) {
            if (this.qk.get() || this.qb == null) {
                this.qk.set(false);
                return;
            }
            if (this.qc.size() == 0) {
                return;
            }
            ei ei2 = (ei)this.qc.get(i);
            ei2.a(location, this);
        }
    }

    public void gm() {
        this.qf = false;
    }

    public void e(boolean bl, boolean bl2) {
        if (bl2) {
            this.gm();
        }
        this.ql = true;
        if (bl && !this.qm && this.qe != null) {
            this.qe.run();
            this.qm = true;
        }
    }

    private void gn() {
        if (this.qb == null) {
            return;
        }
        ++this.qi;
        this.qh = this.qh + 1 > this.qb.oE - 1 ? 0 : ++this.qh;
    }

    public void b(dt dt2, int n, @Nullable Runnable runnable) {
        this.qh = 0;
        this.qf = true;
        this.qg = n;
        if (this.qb == dt2) {
            this.gr();
        } else {
            this.qb = dt2;
            this.gq();
            this.gk();
        }
        this.qb = dt2;
        this.qe = runnable;
    }

    private void go() {
        if (this.qd == null) {
            return;
        }
        dt dt2 = this.qd;
        this.qd = null;
        this.b(dt2, this.qg, null);
    }

    public void gp() {
        this.qd = null;
    }

    public void m(dt dt2) {
        this.qd = dt2;
        if (!this.qf) {
            this.go();
        }
    }

    private void gq() {
        List list = (List)this.qa.get(this.qb);
        if (list != null) {
            this.N(false);
            this.qc = list;
            this.qk.set(true);
        }
    }

    public void N(boolean bl) {
        if (bl && this.qc != null) {
            this.qc.forEach(ei2 -> {
                if (this.qi > 0L || this.qh > 0) {
                    ei2.qp.gx();
                }
            });
        }
        this.qh = 0;
        this.qi = 0L;
    }

    public void gr() {
        this.N(true);
    }

    public boolean gs() {
        return this.qb != null && this.qi >= this.qb.oD;
    }

    public boolean gt() {
        if (this.qb.oC && this.gs()) {
            return true;
        }
        return !this.qb.oC;
    }

    public boolean n(dt dt2) {
        if (this.qb == null) {
            return true;
        }
        if (this.gs()) {
            if (this.qb.oC && dt2.oB == dw.IDLE) {
                return this.qb.oB != dw.OTHER;
            }
            return true;
        }
        return this.qb.oB == dw.IDLE;
    }

    public boolean aL(String string) {
        if (this.qb == null) {
            return false;
        }
        return string.equals(this.qb.oz);
    }

    public boolean o(dt dt2) {
        if (this.qb == null) {
            return false;
        }
        return this.qb.equals(dt2);
    }

    public String aM(String string) {
        if (this.qb == null) {
            return string;
        }
        return this.qb.oz;
    }

    public boolean gu() {
        return this.qf && this.qb != null && !this.qb.oC;
    }

    public void O() {
        this.gm();
        this.qb = null;
        if (this.qc != null) {
            this.qc.clear();
        }
        if (this.qa != null) {
            this.qa.clear();
        }
    }
}
