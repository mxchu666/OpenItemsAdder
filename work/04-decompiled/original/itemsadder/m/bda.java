package itemsadder.m;

import org.bukkit.util.Vector;

public class bda {
    public float aBp;
    public float aBq;
    public float aBr;

    public bda(float f, float f2, float f3) {
        this.aBp = f;
        this.aBq = f2;
        this.aBr = f3;
    }

    public Vector Dv() {
        return new Vector(this.aBp, this.aBq, this.aBr);
    }

    public String toString() {
        return "VecF{x=" + this.aBp + ", y=" + this.aBq + ", z=" + this.aBr + "}";
    }

    public bda CX() {
        return new bda(this.aBp, this.aBq, this.aBr);
    }

    public int hashCode() {
        int n = 7;
        n = 79 * n + (int)(Double.doubleToLongBits(this.aBp) ^ Double.doubleToLongBits(this.aBp) >>> 32);
        n = 79 * n + (int)(Double.doubleToLongBits(this.aBq) ^ Double.doubleToLongBits(this.aBq) >>> 32);
        n = 79 * n + (int)(Double.doubleToLongBits(this.aBr) ^ Double.doubleToLongBits(this.aBr) >>> 32);
        return n;
    }
}
