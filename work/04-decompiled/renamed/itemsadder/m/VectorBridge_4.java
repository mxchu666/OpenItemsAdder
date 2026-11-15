package itemsadder.m;

import org.bukkit.util.Vector;

public class VectorBridge_4 {
    public static double v(double d) {
        return Math.cos(d);
    }

    public static double w(double d) {
        return Math.sin(d);
    }

    public static double x(double d) {
        return Math.tan(d);
    }

    public static double y(double d) {
        return Math.acos(d);
    }

    public static double z(double d) {
        return Math.asin(d);
    }

    public static double A(double d) {
        return Math.atan(d);
    }

    public static double B(double d) {
        return Math.toRadians(d);
    }

    public static double C(double d) {
        return Math.toDegrees(d);
    }

    public static double e(double d, double d2) {
        if (d < 0.0) {
            d *= -1.0;
        }
        if (d2 < 0.0) {
            d2 *= -1.0;
        }
        if (d == 0.0 || d2 == 0.0) {
            return 0.0;
        }
        return VectorBridge_4.A(d2 / d);
    }

    public static Vector a(Vector vector, double d, double d2) {
        d = VectorBridge_4.B(d);
        d2 = VectorBridge_4.B(d2);
        vector = VectorBridge_4.a(vector, d2);
        vector = VectorBridge_4.b(vector, -d);
        return vector;
    }

    public static Vector a(Vector vector, double d) {
        double d2 = VectorBridge_4.v(d) * vector.getY() - VectorBridge_4.w(d) * vector.getZ();
        double d3 = VectorBridge_4.w(d) * vector.getY() + VectorBridge_4.v(d) * vector.getZ();
        return vector.setY(d2).setZ(d3);
    }

    public static Vector b(Vector vector, double d) {
        double d2 = VectorBridge_4.v(d) * vector.getX() + VectorBridge_4.w(d) * vector.getZ();
        double d3 = -VectorBridge_4.w(d) * vector.getX() + VectorBridge_4.v(d) * vector.getZ();
        return vector.setX(d2).setZ(d3);
    }

    public static Vector c(Vector vector, double d) {
        double d2 = VectorBridge_4.v(d) * vector.getX() - VectorBridge_4.w(d) * vector.getY();
        double d3 = VectorBridge_4.w(d) * vector.getX() + VectorBridge_4.v(d) * vector.getY();
        return vector.setX(d2).setY(d3);
    }
}
