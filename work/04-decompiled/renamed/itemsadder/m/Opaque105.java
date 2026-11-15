package itemsadder.m;

import itemsadder.m.BufferedEnum;
import itemsadder.m.FluentBuilder_5;
import itemsadder.m.PluginContract_16;
import java.io.OutputStream;

public class Opaque105 {
    public final FluentBuilder_5 aGB;
    protected FluentBuilder_5 aGC;
    protected int tK = 0;
    public final int aGD;
    public final OutputStream aGE;
    public final PluginContract_16 aGF;
    public final BufferedEnum aGG;

    public Opaque105(FluentBuilder_5 fluentBuilder_5) {
        this(fluentBuilder_5, 512);
    }

    public Opaque105(FluentBuilder_5 fluentBuilder_5, int n) {
        this.aGC = fluentBuilder_5;
        this.aGB = fluentBuilder_5;
        this.aGD = n;
        this.aGE = null;
        this.aGF = null;
        this.aGG = BufferedEnum.BUFFERED;
    }

    public Opaque105(FluentBuilder_5 fluentBuilder_5, OutputStream outputStream, PluginContract_16 pluginContract_16, int n) {
        this.aGC = fluentBuilder_5;
        this.aGB = fluentBuilder_5;
        this.aGD = n;
        this.aGE = outputStream;
        this.aGF = pluginContract_16;
        this.aGG = BufferedEnum.STREAMED;
        assert (outputStream != null);
    }

    public Opaque105(FluentBuilder_5 fluentBuilder_5, OutputStream outputStream) {
        this(fluentBuilder_5, outputStream, null, 512);
    }

    public void gr() {
    }

    public Opaque105 Gs() {
        this.aGC = this.aGB.Ge();
        this.tK = 0;
        return this;
    }

    public final int GD() {
        return this.tK;
    }

    public final byte[] GE() {
        FluentBuilder_5 fluentBuilder_5 = this.aGB;
        int n = 0;
        byte[] byArray = new byte[this.tK];
        do {
            int n2;
            if ((n2 = fluentBuilder_5.offset - fluentBuilder_5.aFt) <= 0) continue;
            System.arraycopy(fluentBuilder_5.aFs, fluentBuilder_5.aFt, byArray, n, n2);
            n += n2;
        } while ((fluentBuilder_5 = fluentBuilder_5.aFu) != null);
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

    protected int a(FluentBuilder_5 fluentBuilder_5, byte[] byArray, int n, int n2) {
        if (this.aGF != null) {
            return this.aGF.a(this, fluentBuilder_5, byArray, n, n2);
        }
        this.aGE.write(byArray, n, n2);
        return fluentBuilder_5.aFt;
    }
}
