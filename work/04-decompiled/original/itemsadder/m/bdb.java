package itemsadder.m;

import org.bukkit.util.Vector;
import org.joml.Vector3f;

public class bdb {
    public int ha;
    public int gW;
    public int hc;

    public bdb(int n, int n2, int n3) {
        this.ha = n;
        this.gW = n2;
        this.hc = n3;
    }

    public Vector Dv() {
        return new Vector(this.ha, this.gW, this.hc);
    }

    public String toString() {
        return "VecF{x=" + this.ha + ", y=" + this.gW + ", z=" + this.hc + "}";
    }

    public bdb Dx() {
        return new bdb(this.ha, this.gW, this.hc);
    }

    public boolean Bc() {
        return this.ha == 0 && this.gW == 0 && this.hc == 0;
    }

    public Vector3f Dy() {
        return new Vector3f((float)this.ha, (float)this.gW, (float)this.hc);
    }
}
