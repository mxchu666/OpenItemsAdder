package itemsadder.m;

import dev.lone.itemsadder.s;
import itemsadder.m.adb;
import itemsadder.m.ae;
import itemsadder.m.ii;
import itemsadder.m.ij;
import itemsadder.m.il;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class jg {
    public final Player xd;
    public final List xe = new CopyOnWriteArrayList();
    public final List xf = new CopyOnWriteArrayList();
    public final HashMap xg = new HashMap();
    public final HashMap xh = new HashMap();
    public final HashMap xi = new HashMap();
    private String xj;
    private Object xk;
    private long xl;

    public jg(Player player) {
        this.xd = player;
    }

    public ii aZ(String string) {
        return (ii)this.xg.get(string);
    }

    void a(ii ii2) {
        this.xe.add(ii2);
        this.xg.put(ii2.getNamespacedID(), ii2);
        if (ii2 instanceof ij) {
            ij ij2 = (ij)ii2;
            this.xf.add(ij2);
            this.xh.put(ii2.getNamespacedID(), ij2);
            this.xi.put(ij2.wa, ij2);
        }
    }

    public void recalculateOffsets() {
        int n = 0;
        for (int i = 0; i < this.xe.size(); ++i) {
            ii ii2 = (ii)this.xe.get(i);
            ii2.Y(n);
            if (!ii2.jL()) continue;
            n -= ii2.jJ();
        }
    }

    @Nullable
    public String kt() {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        for (ii ii2 : this.xe) {
            if (!ii2.jL()) continue;
            stringBuilder.append(ii2.jK());
            ++n;
        }
        if (n == 0) {
            return null;
        }
        stringBuilder = new StringBuilder(il.c(stringBuilder.toString(), this.ku()));
        return stringBuilder.toString();
    }

    public int ku() {
        float f = 0.0f;
        for (ii ii2 : this.xe) {
            f += (float)ii2.jJ();
        }
        return (int)f / 2;
    }

    public void kv() {
        String string = this.kt();
        if (string == null) {
            return;
        }
        if (string.equals(this.xj)) {
            if (System.currentTimeMillis() - this.xl < 1200L) {
                return;
            }
            adb.a(this.xd, this.xk);
            this.xl = System.currentTimeMillis();
            return;
        }
        this.xj = string;
        this.xk = ae.fe == null ? adb.dw(string) : adb.l(string, ae.fe);
        adb.a(this.xd, this.xk);
        this.xl = System.currentTimeMillis();
    }

    public void kw() {
        adb.bI(this.xd);
    }

    public void kx() {
        for (ii ii2 : this.xe) {
            if (!ii2.vN && !ii2.isVisible()) continue;
            ii2.setVisible(ii2.g(this.xd.getWorld()));
        }
    }

    public void ky() {
        for (ii ii2 : this.xe) {
            ii2.aa(s.a((HumanEntity)this.xd, ii2));
        }
    }

    public ij ba(String string) {
        for (ij ij2 : this.xf) {
            if (!ij2.jX().equals(string)) continue;
            return ij2;
        }
        return null;
    }
}
