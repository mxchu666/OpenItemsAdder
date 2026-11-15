package itemsadder.m;

import itemsadder.m.d;
import itemsadder.m.ii;
import itemsadder.m.iq;
import itemsadder.m.jb;
import itemsadder.m.jc;
import itemsadder.m.jg;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public abstract class ij
extends ii {
    public final String wa;
    String wb;
    float wc;
    final float wd;
    final float we;
    final float wf;
    final List wg = new ArrayList();
    final List wh = new ArrayList();
    final List wi = new ArrayList();

    public ij(jg jg2, String string, String string2, String string3, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2, float f3, List list) {
        super(jg2, string, string2, n, bl, bl2, bl3, bl4, list);
        Float f4;
        this.wa = string3;
        this.wd = f;
        float f5 = f2;
        float f6 = f3;
        if (f2 > f3) {
            f5 = f3;
            f6 = f2;
        }
        this.we = f5;
        this.wf = f6;
        if (jg2 != null && (f4 = this.b(null)) == null) {
            this.k(f);
        }
    }

    public void a(jb jb2) {
        this.wg.add(jb2);
    }

    public List jT() {
        return this.wg;
    }

    public void b(Player player, int n) {
        for (jb jb2 : this.wg) {
            jb2.a(this, player, n);
        }
    }

    public void a(jc jc2) {
        this.wh.add(jc2);
    }

    public List jU() {
        return this.wh;
    }

    public void c(Player player, int n) {
        for (jc jc2 : this.wh) {
            jc2.a(this, player, n);
        }
    }

    public void a(iq iq2) {
        this.wi.add(iq2);
    }

    public List jV() {
        return this.wi;
    }

    public float k(float f2) {
        this.wc = this.jW();
        if (f2 == this.wc) {
            return f2;
        }
        if (f2 > this.jZ()) {
            f2 = this.jZ();
        }
        if (f2 < this.jY()) {
            f2 = this.jY();
        }
        assert (this.vX != null) : "Holder must not be null when getting value";
        d.g().an.a(this.vX.xd, this.wa, f2);
        if ((int)f2 != (int)this.wc) {
            this.jM();
        }
        return f2;
    }

    public float jW() {
        @Nullable Float f2 = this.b(null);
        if (f2 == null) {
            f2 = Float.valueOf(this.jY());
        }
        return f2.floatValue();
    }

    @Nullable
    public Float b(@Nullable Float f2) {
        assert (this.vX != null) : "Holder must not be null when getting value";
        return d.g().an.a(this.vX.xd, this.wa, f2);
    }

    protected void a(ij ij2) {
        for (Object object : ij2.jT()) {
            this.wg.add(object.kn());
        }
        for (Object object : ij2.jU()) {
            this.wh.add(object.ki());
        }
        for (Object object : ij2.jV()) {
            this.a((iq)object);
        }
    }

    @Generated
    public String jX() {
        return this.wa;
    }

    @Generated
    public float jY() {
        return this.we;
    }

    @Generated
    public float jZ() {
        return this.wf;
    }
}
