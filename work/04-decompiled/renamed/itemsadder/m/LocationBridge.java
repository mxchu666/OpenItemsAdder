package itemsadder.m;

import itemsadder.m.FluentBuilder_6;
import math.fast.SpeedyMath;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.bukkit.Location;

public final class LocationBridge {
    static final float azX = (float)Math.PI;
    static final float azY = 1.5707964f;
    static final float azZ = -1.5707964f;
    private static final int aAa = Integer.MAX_VALUE;
    private static final long aAb = Long.MAX_VALUE;

    public static double c(double d, double d2) {
        if (d2 == 0.0) {
            if (d > 0.0) {
                return 1.5707963705062866;
            }
            if (d == 0.0) {
                return 0.0;
            }
            return -1.5707963705062866;
        }
        double d3 = d / d2;
        if (Math.abs(d3) < 1.0) {
            double d4 = d3 / (1.0 + (double)0.28f * d3 * d3);
            if (d2 < 0.0) {
                return d < 0.0 ? d4 - 3.1415927410125732 : d4 + 3.1415927410125732;
            }
            return d4;
        }
        double d5 = 1.5707963705062866 - d3 / (d3 * d3 + (double)0.28f);
        return d < 0.0 ? d5 - 3.1415927410125732 : d5;
    }

    public static double p(double d) {
        return SpeedyMath.asin((double)d);
    }

    public static float e(float f, float f2) {
        double d = f + f2;
        if (d > 3.1415927410125732) {
            d -= 6.2831854820251465;
        }
        if (d < -3.1415927410125732) {
            d += 6.2831854820251465;
        }
        return (float)d;
    }

    public static double d(double d, double d2) {
        if (d2 > d) {
            return d2 - d > 3.1415927410125732 ? (double)((float)(d + 6.2831854820251465 - d2)) : d2 - d;
        }
        return d - d2 > 3.1415927410125732 ? (double)((float)(d2 + 6.2831854820251465 - d)) : d - d2;
    }

    public static float A(float f) {
        return Float.intBitsToFloat(Integer.MAX_VALUE & Float.floatToRawIntBits(f));
    }

    public static double q(double d) {
        return Double.longBitsToDouble(Long.MAX_VALUE & Double.doubleToRawLongBits(d));
    }

    public static Location e(Location location, Location location2) {
        Location location3 = location.clone();
        double d = location2.getX() - location3.getX();
        double d2 = location2.getY() - location3.getY();
        double d3 = location2.getZ() - location3.getZ();
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f = (float)Math.toDegrees(Math.atan2(-d, d3));
        float f2 = (float)Math.toDegrees(-Math.atan2(d2, d4));
        location3.setYaw(f);
        location3.setPitch(f2);
        return location3;
    }

    public static double e(double d, double d2, double d3) {
        double d4;
        if (d3 <= 0.0) {
            return d;
        }
        if (d3 >= 1.0) {
            return d2;
        }
        double d5 = LocationBridge.d(d, d2);
        if (d5 < 0.0) {
            d5 += Math.PI * 2;
        }
        if ((d4 = Math.sin(d5 / 2.0)) == 0.0) {
            return d;
        }
        double d6 = Math.sin((1.0 - d3) * d5 / 2.0) / d4;
        double d7 = Math.sin(d3 * d5 / 2.0) / d4;
        return d * d6 + d2 * d7;
    }

    public static double r(double d) {
        double d2 = (float)(d % (Math.PI * 2));
        if (d2 >= Math.PI) {
            d2 -= Math.PI * 2;
        }
        if (d2 < -Math.PI) {
            d2 += Math.PI * 2;
        }
        return d2;
    }

    public static double f(double d, double d2, double d3) {
        double d4 = LocationBridge.r(d2 - d);
        return LocationBridge.r(d + d4 * d3);
    }

    public float a(double d, double d2, double d3, double d4) {
        float f = (float)Math.toDegrees(Math.atan2(d4 - d2, d3 - d));
        if (f < 0.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static double g(double d, double d2, double d3) {
        return d + d3 * (d2 - d);
    }

    public static float d(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static void a(double[] dArray, FluentBuilder_6 fluentBuilder_6, double d, double d2, double d3) {
        double d4 = dArray[0] - d;
        double d5 = dArray[1] - d2;
        double d6 = dArray[2] - d3;
        Vector3D vector3D = new Vector3D(d4, d5, d6);
        Vector3D vector3D2 = fluentBuilder_6.a(vector3D);
        dArray[0] = vector3D2.getX() + d;
        dArray[1] = vector3D2.getY() + d2;
        dArray[2] = vector3D2.getZ() + d3;
    }

    public static void a(double[] dArray, double d, double d2, double d3, double d4, double d5) {
        if (d4 != 0.0) {
            LocationBridge.b(dArray, d2, d3, d4);
        }
        if (d5 != 0.0) {
            LocationBridge.a(dArray, d, d3, d5);
        }
    }

    public static void b(double[] dArray, double d, double d2, double d3, double d4, double d5) {
        if (d5 != 0.0) {
            LocationBridge.a(dArray, d, d3, d5);
        }
        if (d4 != 0.0) {
            LocationBridge.b(dArray, d2, d3, d4);
        }
    }

    public static void a(double[] dArray, double d, double d2, double d3) {
        double d4 = Math.sin(d3);
        double d5 = Math.cos(d3);
        dArray[0] = dArray[0] - d;
        dArray[2] = dArray[2] - d2;
        double d6 = dArray[0] * d5 - dArray[2] * d4;
        double d7 = dArray[0] * d4 + dArray[2] * d5;
        dArray[0] = d6 + d;
        dArray[2] = d7 + d2;
    }

    public static void b(double[] dArray, double d, double d2, double d3) {
        double d4 = Math.sin(d3);
        double d5 = Math.cos(d3);
        dArray[1] = dArray[1] - d;
        dArray[2] = dArray[2] - d2;
        double d6 = dArray[1] * d5 - dArray[2] * d4;
        double d7 = dArray[1] * d4 + dArray[2] * d5;
        dArray[1] = d6 + d;
        dArray[2] = d7 + d2;
    }

    public static boolean h(double d, double d2, double d3) {
        return Math.abs(d - d2) <= d3;
    }

    public static boolean b(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return !LocationBridge.h(d, d4, d7) || !LocationBridge.h(d2, d5, d7) || !LocationBridge.h(d3, d6, d7);
    }
}
