package itemsadder.m;

import itemsadder.m.IntBoolData;
import lombok.Generated;

@Generated
public abstract class IntBoolDataBuilder {
    @Generated
    private int uN;
    @Generated
    private boolean uO;

    @Generated
    public IntBoolDataBuilder Q(int n) {
        this.uN = n;
        return this.il();
    }

    @Generated
    public IntBoolDataBuilder R(boolean bl) {
        this.uO = bl;
        return this.il();
    }

    @Generated
    protected abstract IntBoolDataBuilder il();

    @Generated
    public abstract IntBoolData im();

    @Generated
    public String toString() {
        return "AbstractGoal.AbstractGoalBuilder(priority=" + this.uN + ", replaceVanilla=" + this.uO + ")";
    }
}
