package itemsadder.m;

import itemsadder.m.bjq;
import itemsadder.m.blg;
import itemsadder.m.blh;
import java.io.OutputStream;

public class blf {
    public final bjq aGB;
    protected bjq aGC;
    protected int tK = 0;
    public final int aGD;
    public final OutputStream aGE;
    public final blg aGF;
    public final blh aGG;

    public blf(bjq bjq2) {
        this(bjq2, 512);
    }

    public blf(bjq bjq2, int n) {
        this.aGC = bjq2;
        this.aGB = bjq2;
        this.aGD = n;
        this.aGE = null;
        this.aGF = null;
        this.aGG = blh.BUFFERED;
    }

    public blf(bjq bjq2, OutputStream outputStream, blg blg2, int n) {
        this.aGC = bjq2;
        this.aGB = bjq2;
        this.aGD = n;
        this.aGE = outputStream;
        this.aGF = blg2;
        this.aGG = blh.STREAMED;
        assert (outputStream != null);
    }

    public blf(bjq bjq2, OutputStream outputStream) {
        this(bjq2, outputStream, null, 512);
    }

    public void gr() {
    }

    public blf Gs() {
        this.aGC = this.aGB.Ge();
        this.tK = 0;
        return this;
    }

    public final int GD() {
        return this.tK;
    }

    public final byte[] GE() {
        bjq bjq2 = this.aGB;
        int n = 0;
        byte[] byArray = new byte[this.tK];
        do {
            int n2;
            if ((n2 = bjq2.offset - bjq2.aFt) <= 0) continue;
            System.arraycopy(bjq2.aFs, bjq2.aFt, byArray, n, n2);
            n += n2;
        } while ((bjq2 = bjq2.aFu) != null);
        return byArray;
    }

    protected int m(byte[] byArray, int n, int n2) {
        if (this.aGF != null) {
            return this.aGF.a(this, byArray, n, n2);
        }
        this.aGE.write(byArray, n, n2);
        return n;
    }

    protected int b(byte[] byArray, int n, int n2, byte[] byArray2, int n3, int n4) {
        if (this.aGF != null) {
            return this.aGF.a(this, byArray, n, n2, byArray2, n3, n4);
        }
        this.aGE.write(byArray, n, n2);
        this.aGE.write(byArray2, n3, n4);
        return n;
    }

    protected int a(bjq bjq2, byte[] byArray, int n, int n2) {
        if (this.aGF != null) {
            return this.aGF.a(this, bjq2, byArray, n, n2);
        }
        this.aGE.write(byArray, n, n2);
        return bjq2.aFt;
    }
}
