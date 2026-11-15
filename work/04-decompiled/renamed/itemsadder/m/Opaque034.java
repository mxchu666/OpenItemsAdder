package itemsadder.m;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.OutputStream;

public class Opaque034
extends ByteArrayOutputStream {
    public Opaque034() {
    }

    public Opaque034(int n) {
        super(n);
    }

    public byte[] DW() {
        return this.buf;
    }

    public void d(byte[] byArray, int n) {
        System.arraycopy(byArray, 0, this.buf, n, byArray.length);
    }

    public void bV(int n) {
        this.count += n;
    }

    public void a(DataOutput dataOutput) {
        dataOutput.write(this.DW(), 0, this.size());
    }

    public void a(OutputStream outputStream) {
        outputStream.write(this.DW(), 0, this.size());
    }

    public ByteArrayInputStream DX() {
        return new ByteArrayInputStream(this.DW(), 0, this.size());
    }

    public Opaque034 l(byte[] byArray) {
        System.arraycopy(byArray, 0, this.buf, 0, byArray.length);
        return this;
    }
}
