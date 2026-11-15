package itemsadder.m;

import itemsadder.m.aq;
import itemsadder.m.ar;
import itemsadder.m.as;
import itemsadder.m.at;
import itemsadder.m.ba;
import lombok.Generated;
import org.jetbrains.annotations.Nullable;

@Generated
public abstract class bc
extends at {
    @Generated
    private String gF;
    @Generated
    private boolean gG;
    @Generated
    private boolean gH;
    @Generated
    private String gI;

    @Generated
    public bc W(String string) {
        this.gF = string;
        return this.aT();
    }

    @Generated
    public bc k(boolean bl) {
        this.gG = bl;
        return this.aT();
    }

    @Generated
    public bc l(boolean bl) {
        this.gH = bl;
        return this.aT();
    }

    @Generated
    public bc X(@Nullable String string) {
        this.gI = string;
        return this.aT();
    }

    @Generated
    protected abstract bc aT();

    @Generated
    public abstract ba aU();

    @Override
    @Generated
    public String toString() {
        return "ExecuteCommand.ExecuteCommandBuilder(super=" + super.toString() + ", command=" + this.gF + ", asConsole=" + this.gG + ", silent=" + this.gH + ", flowSuccessMessageIfContains=" + this.gI + ")";
    }

    @Override
    @Generated
    public /* synthetic */ as aL() {
        return this.aU();
    }

    @Override
    @Generated
    protected /* synthetic */ at aK() {
        return this.aT();
    }

    @Override
    @Generated
    public /* synthetic */ aq aJ() {
        return this.aU();
    }

    @Override
    @Generated
    protected /* synthetic */ ar aI() {
        return this.aT();
    }
}
