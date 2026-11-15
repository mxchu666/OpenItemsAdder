package itemsadder.m;

import itemsadder.m.arl;

public class arm
extends arl {
    @Override
    public int sC() {
        return (Integer)this.alU.getIntegers().read(2);
    }

    @Override
    public void aO(int n) {
        this.alU.getIntegers().write(2, (Object)n);
    }
}
