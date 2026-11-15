package itemsadder.m;

import itemsadder.m.InstanceRegistry;
import itemsadder.m.PluginContractBuilder_2;
import itemsadder.m.PluginContract_14;
import itemsadder.m.WdFunction;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Objects;

public final class Builder
implements WdFunction {
    private PluginContractBuilder_2 apv;
    private int apw;
    private boolean apx;
    private int apy;
    private String apz;
    private int apA;
    private int apB;
    private boolean apC;
    private int apD;
    public static final PluginContract_14 apE = InstanceRegistry.apF;

    private Builder vD() {
        return this;
    }

    public static Builder vE() {
        return Builder.aI(true);
    }

    public static Builder aI(boolean bl) {
        return bl ? new Builder().vD() : new Builder();
    }

    public PluginContractBuilder_2 vF() {
        if ((this.apD & 1) == 0) {
            return null;
        }
        return this.apv;
    }

    public Builder a(PluginContractBuilder_2 pluginContractBuilder_2) {
        this.apv = pluginContractBuilder_2;
        this.apD |= 1;
        return this;
    }

    public Builder vG() {
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

    public Builder aP(int n) {
        this.apw = n;
        this.apD |= 2;
        return this;
    }

    public Builder vJ() {
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

    public Builder aJ(boolean bl) {
        this.apx = bl;
        this.apD |= 4;
        return this;
    }

    public Builder vM() {
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

    public Builder aQ(int n) {
        this.apy = n;
        this.apD |= 8;
        return this;
    }

    public Builder vP() {
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

    public Builder dR(String string) {
        this.apz = string;
        this.apD |= 0x10;
        return this;
    }

    public Builder vS() {
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

    public Builder aR(int n) {
        this.apA = n;
        this.apD |= 0x20;
        return this;
    }

    public Builder vV() {
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

    public Builder aS(int n) {
        this.apB = n;
        this.apD |= 0x40;
        return this;
    }

    public Builder vY() {
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

    public Builder aK(boolean bl) {
        this.apC = bl;
        this.apD |= 0x80;
        return this;
    }

    public Builder wb() {
        this.apC = false;
        this.apD &= 0xFFFFFF7F;
        return this;
    }

    public boolean wc() {
        return (this.apD & 0x80) == 128;
    }

    @Override
    public PluginContract_14 wd() {
        return InstanceRegistry.apF;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Builder builder = (Builder)object;
        if (!Objects.equals(this.apv, builder.apv)) {
            return false;
        }
        if (!Objects.equals(this.apw, builder.apw)) {
            return false;
        }
        if (!Objects.equals(this.apx, builder.apx)) {
            return false;
        }
        if (!Objects.equals(this.apy, builder.apy)) {
            return false;
        }
        if (!Objects.equals(this.apz, builder.apz)) {
            return false;
        }
        if (!Objects.equals(this.apA, builder.apA)) {
            return false;
        }
        if (!Objects.equals(this.apB, builder.apB)) {
            return false;
        }
        return Objects.equals(this.apC, builder.apC);
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
