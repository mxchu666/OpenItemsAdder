package itemsadder.m;

import itemsadder.m.fy;
import lombok.Generated;

@Generated
public abstract class fz {
    @Generated
    private int uN;
    @Generated
    private boolean uO;

    @Generated
    public fz Q(int n) {
        this.uN = n;
        return this.il();
    }

    @Generated
    public fz R(boolean bl) {
        this.uO = bl;
        return this.il();
    }

    @Generated
    protected abstract fz il();

    @Generated
    public abstract fy im();

    @Generated
    public String toString() {
        return "AbstractGoal.AbstractGoalBuilder(priority=" + this.uN + ", replaceVanilla=" + this.uO + ")";
    }
}
