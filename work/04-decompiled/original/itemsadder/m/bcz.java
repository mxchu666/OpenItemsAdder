package itemsadder.m;

import org.bukkit.util.Vector;

public class bcz {
    public double akd;
    public double ake;
    public double akf;

    public bcz(double d, double d2, double d3) {
        this.akd = d;
        this.ake = d2;
        this.akf = d3;
    }

    public bcz() {
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

    public bcz Dw() {
        return new bcz(this.akd, this.ake, this.akf);
    }
}
