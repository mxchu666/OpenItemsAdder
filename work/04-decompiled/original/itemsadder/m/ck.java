package itemsadder.m;

import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ck {
    public double kq;
    public double kr;
    public double ks;
    public double kt;
    public double ku;
    public double kv;

    public ck(double d, double d2, double d3, double d4, double d5, double d6) {
        this.kq = d;
        this.kr = d2;
        this.ks = d3;
        this.kt = d4;
        this.ku = d5;
        this.kv = d6;
    }

    @NotNull
    public static ck a(@NotNull Vector vector, @NotNull Vector vector2) {
        return new ck(vector.getX(), vector.getY(), vector.getZ(), vector2.getX(), vector2.getY(), vector2.getZ());
    }

    public BoundingBox cJ() {
        return new BoundingBox(this.kq, this.kr, this.ks, this.kt, this.ku, this.kv);
    }

    public float cK() {
        return (float)(this.ku - this.kr);
    }

    public float cL() {
        return (float)(this.kv - this.ks);
    }

    public ck c(double d) {
        return new ck(this.kq - d, this.kr - d, this.ks - d, this.kt + d, this.ku + d, this.kv + d);
    }

    @Nullable
    public Vector b(Vector vector, Vector vector2) {
        Vector vector3 = new Vector(this.kq, this.kr, this.ks);
        Vector vector4 = new Vector(this.kt, this.ku, this.kv);
        double d = Double.NEGATIVE_INFINITY;
        double d2 = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 3; ++i) {
            double d3;
            double d4;
            double d5;
            double d6;
            double d7 = i == 0 ? vector.getX() : (d6 = i == 1 ? vector.getY() : vector.getZ());
            double d8 = i == 0 ? vector2.getX() : (d5 = i == 1 ? vector2.getY() : vector2.getZ());
            double d9 = i == 0 ? vector3.getX() : (d4 = i == 1 ? vector3.getY() : vector3.getZ());
            double d10 = i == 0 ? vector4.getX() : (d3 = i == 1 ? vector4.getY() : vector4.getZ());
            if (Math.abs(d5) < 1.0E-6) {
                if (!(d6 < d4) && !(d6 > d3)) continue;
                return null;
            }
            double d11 = (d4 - d6) / d5;
            double d12 = (d3 - d6) / d5;
            if (d11 > d12) {
                double d13 = d11;
                d11 = d12;
                d12 = d13;
            }
            if (!((d = Math.max(d, d11)) > (d2 = Math.min(d2, d12)))) continue;
            return null;
        }
        if (d < 0.0) {
            if (d2 < 0.0) {
                return null;
            }
            return vector.clone().add(vector2.clone().multiply(d2));
        }
        return vector.clone().add(vector2.clone().multiply(d));
    }

    @Nullable
    Vector a(Vector vector, Vector vector2, double d) {
        Vector vector3 = this.b(vector, vector2);
        return vector3 != null && vector3.distanceSquared(vector) <= d ? vector3 : null;
    }
}
