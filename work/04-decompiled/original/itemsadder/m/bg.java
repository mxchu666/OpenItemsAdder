package itemsadder.m;

import itemsadder.m.aq;
import itemsadder.m.ar;
import itemsadder.m.as;
import itemsadder.m.at;
import itemsadder.m.bf;
import itemsadder.m.wk;
import lombok.Generated;

@Generated
public abstract class bg
extends at {
    @Generated
    private String gJ;
    @Generated
    private wk gK;

    @Generated
    public bg Y(String string) {
        this.gJ = string;
        return this.aX();
    }

    @Generated
    public bg a(wk wk2) {
        this.gK = wk2;
        return this.aX();
    }

    @Generated
    protected abstract bg aX();

    @Generated
    public abstract bf aY();

    @Override
    @Generated
    public String toString() {
        return "RunScript.RunScriptBuilder(super=" + super.toString() + ", scriptIdentifier=" + this.gJ + ", compiled=" + String.valueOf(this.gK) + ")";
    }

    @Override
    @Generated
    public /* synthetic */ as aL() {
        return this.aY();
    }

    @Override
    @Generated
    protected /* synthetic */ at aK() {
        return this.aX();
    }

    @Override
    @Generated
    public /* synthetic */ aq aJ() {
        return this.aY();
    }

    @Override
    @Generated
    protected /* synthetic */ ar aI() {
        return this.aX();
    }
}
