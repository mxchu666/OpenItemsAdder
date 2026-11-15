package itemsadder.m;

import itemsadder.m.BufferLocked;
import itemsadder.m.ChunkStreamSomehow;
import itemsadder.m.IntData_2;
import java.util.HashMap;

public class Opaque030 {
    public int aBT;
    public final HashMap aBU = new HashMap();

    public Opaque030() {
    }

    public Opaque030(int n) {
        this.aBT = n;
    }

    public void bS(int n) {
        this.aBT = n;
    }

    public void a(String string, IntData_2 intData_2) {
        this.aBU.put(string, intData_2);
    }

    public IntData_2 je(String string) {
        return (IntData_2)this.aBU.get(string);
    }

    public void clear() {
        this.aBT = 0;
        this.aBU.clear();
    }

    BufferLocked DU() {
        return new BufferLocked(this, ChunkStreamSomehow.aBM, true);
    }
}
