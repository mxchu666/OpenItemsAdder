package itemsadder.m;

import itemsadder.m.PacketTypeHelper_2;

public class PacketTypeHelperImpl
extends PacketTypeHelper_2 {
    @Override
    public int sC() {
        return (Integer)this.alU.getIntegers().read(2);
    }

    @Override
    public void aO(int n) {
        this.alU.getIntegers().write(2, (Object)n);
    }
}
