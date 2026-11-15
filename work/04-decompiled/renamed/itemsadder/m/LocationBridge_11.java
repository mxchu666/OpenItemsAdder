package itemsadder.m;

import itemsadder.m.LocationHolder_2;
import itemsadder.m.Opaque111;
import itemsadder.m.Opaque112;
import itemsadder.m.RefIntegerData;
import itemsadder.m.SoundCategoryBridge_2;
import org.bukkit.Location;

public class LocationBridge_11 {
    public final SoundCategoryBridge_2 qn;
    public final Opaque111 qo;
    public final LocationHolder_2 qp;
    public final RefIntegerData qq;

    public LocationBridge_11(Opaque111 opaque111, LocationHolder_2 locationHolder_2) {
        this.qn = opaque111.px;
        this.qo = opaque111;
        this.qp = locationHolder_2;
        this.qq = opaque111.n(0);
    }

    public RefIntegerData b(Opaque112 opaque112) {
        return this.qo.n(opaque112.qh);
    }

    public void c(Opaque112 opaque112) {
        if (this.qn.fJ()) {
            if (opaque112.ql) {
                if (opaque112.qj) {
                    opaque112.qj = false;
                } else if (opaque112.qh >= 0 && opaque112.qh < this.qn.oF.pe) {
                    opaque112.e(true, true);
                }
            } else if (opaque112.qh > this.qn.oF.pf) {
                opaque112.qj = true;
                opaque112.qh = this.qn.oF.pe;
            } else if (opaque112.qh > this.qn.oF.pe && !opaque112.qj) {
                opaque112.qj = true;
                opaque112.qh = this.qn.oF.pe;
            }
        } else if (opaque112.ql) {
            opaque112.e(true, true);
        }
    }

    public void a(Location location, Opaque112 opaque112) {
        RefIntegerData refIntegerData = this.b(opaque112);
        if (refIntegerData == null) {
            if (opaque112.qh == 0) {
                return;
            }
            int n = opaque112.qh - 1;
            while (refIntegerData == null && n > 0) {
                refIntegerData = this.qo.n(--n);
            }
        }
        this.a(location, refIntegerData);
    }

    public void a(Location location, RefIntegerData refIntegerData) {
        this.qp.a(location, refIntegerData);
    }
}
