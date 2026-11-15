package itemsadder.m;

import itemsadder.m.dt;
import itemsadder.m.ea;
import itemsadder.m.ed;
import itemsadder.m.eh;
import itemsadder.m.ej;
import org.bukkit.Location;

public class ei {
    public final dt qn;
    public final ea qo;
    public final ej qp;
    public final ed qq;

    public ei(ea ea2, ej ej2) {
        this.qn = ea2.px;
        this.qo = ea2;
        this.qp = ej2;
        this.qq = ea2.n(0);
    }

    public ed b(eh eh2) {
        return this.qo.n(eh2.qh);
    }

    public void c(eh eh2) {
        if (this.qn.fJ()) {
            if (eh2.ql) {
                if (eh2.qj) {
                    eh2.qj = false;
                } else if (eh2.qh >= 0 && eh2.qh < this.qn.oF.pe) {
                    eh2.e(true, true);
                }
            } else if (eh2.qh > this.qn.oF.pf) {
                eh2.qj = true;
                eh2.qh = this.qn.oF.pe;
            } else if (eh2.qh > this.qn.oF.pe && !eh2.qj) {
                eh2.qj = true;
                eh2.qh = this.qn.oF.pe;
            }
        } else if (eh2.ql) {
            eh2.e(true, true);
        }
    }

    public void a(Location location, eh eh2) {
        ed ed2 = this.b(eh2);
        if (ed2 == null) {
            if (eh2.qh == 0) {
                return;
            }
            int n = eh2.qh - 1;
            while (ed2 == null && n > 0) {
                ed2 = this.qo.n(--n);
            }
        }
        this.a(location, ed2);
    }

    public void a(Location location, ed ed2) {
        this.qp.a(location, ed2);
    }
}
