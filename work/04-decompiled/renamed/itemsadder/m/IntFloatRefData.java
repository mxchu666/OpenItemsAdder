package itemsadder.m;

import itemsadder.m.EqualEnum;
import itemsadder.m.PlayerWrapper_7;

public abstract class IntFloatRefData
implements PlayerWrapper_7 {
    public final int wI;
    public final float wJ;
    protected int wK = 0;
    final EqualEnum wL;

    public IntFloatRefData(int n, float f, EqualEnum equalEnum) {
        this.wI = n;
        this.wJ = f;
        this.wL = equalEnum;
    }
}
