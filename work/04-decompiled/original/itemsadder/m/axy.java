package itemsadder.m;

import itemsadder.m.axz;
import itemsadder.m.ayi;
import itemsadder.m.bjv;
import itemsadder.m.bko;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Objects;

public final class axy
implements bjv {
    private ayi apv;
    private int apw;
    private boolean apx;
    private int apy;
    private String apz;
    private int apA;
    private int apB;
    private boolean apC;
    private int apD;
    public static final bko apE = axz.apF;

    private axy vD() {
        return this;
    }

    public static axy vE() {
        return axy.aI(true);
    }

    public static axy aI(boolean bl) {
        return bl ? new axy().vD() : new axy();
    }

    public ayi vF() {
        if ((this.apD & 1) == 0) {
            return null;
        }
        return this.apv;
    }

    public axy a(ayi ayi2) {
        this.apv = ayi2;
        this.apD |= 1;
        return this;
    }

    public axy vG() {
        this.apv = null;
        this.apD &= 0xFFFFFFFE;
        return this;
    }

    public boolean vH() {
        return (this.apD & 1) == 1;
    }

    public int vI() {
        if ((this.apD & 2) == 0) {
            return 0;
        }
        return this.apw;
    }

    public axy aP(int n) {
        this.apw = n;
        this.apD |= 2;
        return this;
    }

    public axy vJ() {
        this.apw = 0;
        this.apD &= 0xFFFFFFFD;
        return this;
    }

    public boolean vK() {
        return (this.apD & 2) == 2;
    }

    public boolean vL() {
        if ((this.apD & 4) == 0) {
            return false;
        }
        return this.apx;
    }

    public axy aJ(boolean bl) {
        this.apx = bl;
        this.apD |= 4;
        return this;
    }

    public axy vM() {
        this.apx = false;
        this.apD &= 0xFFFFFFFB;
        return this;
    }

    public boolean vN() {
        return (this.apD & 4) == 4;
    }

    public int vO() {
        if ((this.apD & 8) == 0) {
            return 0;
        }
        return this.apy;
    }

    public axy aQ(int n) {
        this.apy = n;
        this.apD |= 8;
        return this;
    }

    public axy vP() {
        this.apy = 0;
        this.apD &= 0xFFFFFFF7;
        return this;
    }

    public boolean vQ() {
        return (this.apD & 8) == 8;
    }

    public String vR() {
        if ((this.apD & 0x10) == 0) {
            return null;
        }
        return this.apz;
    }

    public axy dR(String string) {
        this.apz = string;
        this.apD |= 0x10;
        return this;
    }

    public axy vS() {
        this.apz = null;
        this.apD &= 0xFFFFFFEF;
        return this;
    }

    public boolean vT() {
        return (this.apD & 0x10) == 16;
    }

    public int vU() {
        if ((this.apD & 0x20) == 0) {
            return 0;
        }
        return this.apA;
    }

    public axy aR(int n) {
        this.apA = n;
        this.apD |= 0x20;
        return this;
    }

    public axy vV() {
        this.apA = 0;
        this.apD &= 0xFFFFFFDF;
        return this;
    }

    public boolean vW() {
        return (this.apD & 0x20) == 32;
    }

    public int vX() {
        if ((this.apD & 0x40) == 0) {
            return 0;
        }
        return this.apB;
    }

    public axy aS(int n) {
        this.apB = n;
        this.apD |= 0x40;
        return this;
    }

    public axy vY() {
        this.apB = 0;
        this.apD &= 0xFFFFFFBF;
        return this;
    }

    public boolean vZ() {
        return (this.apD & 0x40) == 64;
    }

    public boolean wa() {
        if ((this.apD & 0x80) == 0) {
            return false;
        }
        return this.apC;
    }

    public axy aK(boolean bl) {
        this.apC = bl;
        this.apD |= 0x80;
        return this;
    }

    public axy wb() {
        this.apC = false;
        this.apD &= 0xFFFFFF7F;
        return this;
    }

    public boolean wc() {
        return (this.apD & 0x80) == 128;
    }

    @Override
    public bko wd() {
        return axz.apF;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        axy axy2 = (axy)object;
        if (!Objects.equals(this.apv, axy2.apv)) {
            return false;
        }
        if (!Objects.equals(this.apw, axy2.apw)) {
            return false;
        }
        if (!Objects.equals(this.apx, axy2.apx)) {
            return false;
        }
        if (!Objects.equals(this.apy, axy2.apy)) {
            return false;
        }
        if (!Objects.equals(this.apz, axy2.apz)) {
            return false;
        }
        if (!Objects.equals(this.apA, axy2.apA)) {
            return false;
        }
        if (!Objects.equals(this.apB, axy2.apB)) {
            return false;
        }
        return Objects.equals(this.apC, axy2.apC);
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.apv == null ? 0 : this.apv.hashCode());
        n = 31 * n + Integer.hashCode(this.apw);
        n = 31 * n + Boolean.hashCode(this.apx);
        n = 31 * n + Integer.hashCode(this.apy);
        n = 31 * n + (this.apz == null ? 0 : this.apz.hashCode());
        n = 31 * n + Integer.hashCode(this.apA);
        n = 31 * n + Integer.hashCode(this.apB);
        n = 31 * n + Boolean.hashCode(this.apC);
        return n;
    }

    public String toString() {
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        if (this.vH()) {
            arrayList.add((CallSite)((Object)("inventory=" + String.valueOf(this.vF()))));
        }
        if (this.vK()) {
            arrayList.add((CallSite)((Object)("cropSeedId=" + this.vI())));
        }
        if (this.vN()) {
            arrayList.add((CallSite)((Object)("isLiquid=" + this.vL())));
        }
        if (this.vQ()) {
            arrayList.add((CallSite)((Object)("realBiomeId=" + this.vO())));
        }
        if (this.vT()) {
            arrayList.add((CallSite)((Object)("song=" + this.vR())));
        }
        if (this.vW()) {
            arrayList.add((CallSite)((Object)("instrument=" + this.vU())));
        }
        if (this.vZ()) {
            arrayList.add((CallSite)((Object)("fireAge=" + this.vX())));
        }
        if (this.wc()) {
            arrayList.add((CallSite)((Object)("isOtherPluginCustomBlock=" + this.wa())));
        }
        return "PAdditionalAttributes{" + String.join((CharSequence)", ", arrayList) + "}";
    }
}
