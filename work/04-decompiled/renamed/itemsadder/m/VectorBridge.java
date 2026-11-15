package itemsadder.m;

import org.bukkit.util.Vector;

public class VectorBridge {
    public double akd;
    public double ake;
    public double akf;

    public VectorBridge(double d, double d2, double d3) {
        this.akd = d;
        this.ake = d2;
        this.akf = d3;
    }

    public VectorBridge() {
    }

    public Vector Dv() {
        return new Vector(this.akd, this.ake, this.akf);
    }

    public void i(double d, double d2, double d3) {
        this.akd = d;
        this.ake = d2;
        this.akf = d3;
    }

    public String toString() {
        return "VecF{x=" + this.akd + ", y=" + this.ake + ", z=" + this.akf + "}";
    }

    public VectorBridge Dw() {
        return new VectorBridge(this.akd, this.ake, this.akf);
    }
}
