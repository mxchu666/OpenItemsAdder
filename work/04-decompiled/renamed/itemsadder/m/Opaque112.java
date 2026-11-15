package itemsadder.m;

import itemsadder.m.LivingEntityBuilder;
import itemsadder.m.LocationBridge_10;
import itemsadder.m.LocationBridge_11;
import itemsadder.m.LocationBridge_9;
import itemsadder.m.OtherEnum;
import itemsadder.m.PlayerBridge_7;
import itemsadder.m.SoundCategoryBridge_2;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Opaque112 {
    public final LivingEntityBuilder pZ;
    private Map qa;
    @Nullable
    public SoundCategoryBridge_2 qb;
    public List qc;
    public SoundCategoryBridge_2 qd;
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

    public Opaque112(LivingEntityBuilder livingEntityBuilder, @NotNull SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.pZ = livingEntityBuilder;
        this.qb = soundCategoryBridge_2;
        livingEntityBuilder.a(this);
        this.gj();
        this.qf = true;
    }

    private void gj() {
        this.qa = Collections.synchronizedMap(new HashMap());
        new LinkedHashMap<String, SoundCategoryBridge_2>(this.pZ.et().pB).forEach((string, soundCategoryBridge_2) -> this.qa.put(soundCategoryBridge_2, soundCategoryBridge_2.l(this.pZ)));
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
            Object object = (LocationBridge_11)this.qc.get(i);
            if (!this.qm && !this.qb.oC && this.gs()) {
                this.qf = false;
                if (this.qe != null) {
                    this.qe.run();
                    this.qm = true;
                }
            } else if (this.qf) {
                ((LocationBridge_11)object).c(this);
            }
            ((LocationBridge_11)object).a(location, this);
            if (this.qb == null || this.qh >= this.qb.oI.size() || (list2 = (List)this.qb.oI.get(this.qh)).size() <= 0 || (list = this.pZ.ea()).size() <= 0) continue;
            double[] dArray = ((LocationBridge_11)object).qp.qw.tv();
            block1: for (int j = 0; j < list.size(); ++j) {
                PlayerBridge_7 playerBridge_7 = (PlayerBridge_7)list.get(j);
                for (LocationBridge_9 locationBridge_9 : list2) {
                    if (!((LocationBridge_11)object).qp.qx.equals(locationBridge_9.pR)) continue;
                    locationBridge_9.a(playerBridge_7.iW, dArray[0], dArray[1], dArray[2]);
                    continue block1;
                }
            }
        }
        if (this.qb != null && this.qb.fI() && this.qh < this.qb.oH.size()) {
            for (Object object : (List)this.qb.oH.get(this.qh)) {
                ((LocationBridge_10)object).t(location);
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
            LocationBridge_11 locationBridge_11 = (LocationBridge_11)this.qc.get(i);
            locationBridge_11.a(location, this);
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

    public void b(SoundCategoryBridge_2 soundCategoryBridge_2, int n, @Nullable Runnable runnable) {
        this.qh = 0;
        this.qf = true;
        this.qg = n;
        if (this.qb == soundCategoryBridge_2) {
            this.gr();
        } else {
            this.qb = soundCategoryBridge_2;
            this.gq();
            this.gk();
        }
        this.qb = soundCategoryBridge_2;
        this.qe = runnable;
    }

    private void go() {
        if (this.qd == null) {
            return;
        }
        SoundCategoryBridge_2 soundCategoryBridge_2 = this.qd;
        this.qd = null;
        this.b(soundCategoryBridge_2, this.qg, null);
    }

    public void gp() {
        this.qd = null;
    }

    public void m(SoundCategoryBridge_2 soundCategoryBridge_2) {
        this.qd = soundCategoryBridge_2;
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
            this.qc.forEach(locationBridge_11 -> {
                if (this.qi > 0L || this.qh > 0) {
                    locationBridge_11.qp.gx();
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

    public boolean n(SoundCategoryBridge_2 soundCategoryBridge_2) {
        if (this.qb == null) {
            return true;
        }
        if (this.gs()) {
            if (this.qb.oC && soundCategoryBridge_2.oB == OtherEnum.IDLE) {
                return this.qb.oB != OtherEnum.OTHER;
            }
            return true;
        }
        return this.qb.oB == OtherEnum.IDLE;
    }

    public boolean aL(String string) {
        if (this.qb == null) {
            return false;
        }
        return string.equals(this.qb.oz);
    }

    public boolean o(SoundCategoryBridge_2 soundCategoryBridge_2) {
        if (this.qb == null) {
            return false;
        }
        return this.qb.equals(soundCategoryBridge_2);
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
