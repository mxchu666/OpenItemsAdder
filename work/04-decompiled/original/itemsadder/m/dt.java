package itemsadder.m;

import itemsadder.m.dn;
import itemsadder.m.du;
import itemsadder.m.dv;
import itemsadder.m.dw;
import itemsadder.m.ea;
import itemsadder.m.ei;
import itemsadder.m.ej;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import lombok.Generated;
import org.bukkit.SoundCategory;
import org.jetbrains.annotations.Nullable;

public class dt {
    public final String oz;
    public final String oA;
    public final dw oB;
    public final boolean oC;
    public final long oD;
    public final int oE;
    @Nullable
    public final dv oF;
    private List oG;
    public LinkedList oH;
    public LinkedList oI;
    public boolean oJ = false;
    public boolean oK = false;
    public boolean oL = false;
    public boolean oM = true;
    public boolean oN = false;
    boolean oO = true;
    boolean oP = true;
    public boolean oQ = true;
    public boolean oR = true;
    public boolean oS = true;
    public boolean oT = true;
    public boolean oU = false;
    public boolean oV = false;
    @Nullable
    public Float oW;
    @Nullable
    public Float oX;
    @Nullable
    private du oY;

    public dt(String string, String string2, boolean bl, String string3, double d, double d2, double d3) {
        int n;
        int n2;
        this.oz = string;
        this.oM = bl;
        dw dw2 = dw.aA(string3);
        if (dw2 == dw.OTHER) {
            dw2 = dw.aA(string);
        }
        this.oB = dw2;
        if (this.oB == dw.DEATH && string2.equals("loop")) {
            this.oA = "once";
            this.oC = false;
        } else {
            this.oA = string2;
            this.oC = string2.equals("loop");
        }
        double d4 = d * 20.0;
        if (d4 - (double)((int)d4) > 0.0) {
            d4 = (int)d4 + 1;
        }
        this.oD = (long)d4;
        this.oE = (int)this.oD;
        if (this.oC) {
            n2 = d2 > 0.0 ? (int)(d2 * 20.0) : -1;
            n = d3 > 0.0 ? (int)(d3 * 20.0) : -1;
        } else {
            n2 = -1;
            n = -1;
        }
        this.oF = this.oC && n2 > 0 && n > 0 ? new dv(n2, n) : null;
    }

    public List fG() {
        return this.oG;
    }

    public List l(dn dn2) {
        List<ei> list = Collections.synchronizedList(new ArrayList());
        for (int i = 0; i < this.oG.size(); ++i) {
            ea ea2 = (ea)this.oG.get(i);
            ej ej2 = dn2.an(ea2.py.getId());
            if (ej2 == null) continue;
            list.add(new ei(ea2, ej2));
        }
        return list;
    }

    public void h(List list) {
        this.oG = list;
    }

    public ea az(String string) {
        for (ea ea2 : this.oG) {
            if (!ea2.py.getId().equals(string)) continue;
            return ea2;
        }
        return null;
    }

    public void a(LinkedList linkedList, LinkedList linkedList2) {
        this.oH = linkedList;
        this.oI = linkedList2;
    }

    public boolean fH() {
        return !this.oI.isEmpty();
    }

    public boolean fI() {
        return !this.oH.isEmpty();
    }

    public boolean fJ() {
        return this.oF != null;
    }

    public void c(boolean bl, boolean bl2, boolean bl3) {
        this.oJ = bl;
        this.oK = bl2;
        this.oL = bl3;
    }

    public void H(boolean bl) {
        this.oM = bl;
    }

    public void a(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.oQ = bl;
        this.oR = bl2;
        this.oS = bl3;
        this.oT = bl4;
    }

    public void I(boolean bl) {
        this.oU = bl;
    }

    public void J(boolean bl) {
        this.oV = bl;
    }

    public void a(@Nullable Float f, @Nullable Float f2) {
        this.oW = f;
        this.oX = f2;
    }

    public void a(@Nullable String string, SoundCategory soundCategory, float f, float f2, float f3) {
        this.oY = string == null ? null : new du(string, soundCategory, f, f2, f3);
    }

    @Generated
    public void K(boolean bl) {
        this.oN = bl;
    }

    @Generated
    public void L(boolean bl) {
        this.oO = bl;
    }

    @Generated
    public boolean fK() {
        return this.oO;
    }

    @Generated
    public void M(boolean bl) {
        this.oP = bl;
    }

    @Generated
    public boolean fL() {
        return this.oP;
    }

    @Nullable
    @Generated
    public du fM() {
        return this.oY;
    }
}
