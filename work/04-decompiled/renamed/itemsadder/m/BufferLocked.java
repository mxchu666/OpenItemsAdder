package itemsadder.m;

import itemsadder.m.ChunkStreamSomehow;
import itemsadder.m.IntData_2;
import itemsadder.m.Opaque030;
import itemsadder.m.Opaque031;
import itemsadder.m.Opaque034;
import java.io.IOException;

public class BufferLocked
extends Opaque034 {
    private final Opaque030 aBV;
    private boolean aBW;

    public BufferLocked(Opaque030 opaque030, int n, boolean bl) {
        super(n);
        this.aBV = opaque030;
        if (bl) {
            this.init();
        }
    }

    void init() {
        this.write(ChunkStreamSomehow.aBJ);
        this.bV(4);
    }

    void c(String string, int n, int n2) {
        if (this.aBW) {
            throw new IOException("This buffer is locked!");
        }
        byte[] byArray = string.getBytes();
        this.write(Opaque031.bT(byArray.length));
        this.write(byArray);
        this.write(Opaque031.bT(n));
        this.write(Opaque031.bT(n2));
        this.aBV.bS(this.size());
        this.aBV.a(string, new IntData_2(n, n2));
    }

    public void DV() {
        this.d(Opaque031.bT(this.size()), ChunkStreamSomehow.aBJ.length);
        this.aBW = true;
    }
}
