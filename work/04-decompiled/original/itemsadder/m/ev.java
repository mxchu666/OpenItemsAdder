package itemsadder.m;

import itemsadder.m.bbk;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.threed.CardanEulerSingularityException;
import org.apache.commons.math3.geometry.euclidean.threed.NotARotationMatrixException;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.RotationOrder;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class ev
implements Serializable {
    public static final ev ri = new ev(1.0, 0.0, 0.0, 0.0, false);
    public static final double rj = 1.0E-6;
    private static final long serialVersionUID = -2153622329907944313L;
    double rk;
    double rl;
    double rm;
    double rn;

    public ev(double d, double d2, double d3, double d4, boolean bl) {
        if (bl) {
            double d5 = 1.0 / FastMath.sqrt((double)(d * d + d2 * d2 + d3 * d3 + d4 * d4));
            d *= d5;
            d2 *= d5;
            d3 *= d5;
            d4 *= d5;
        }
        this.rk = d;
        this.rl = d2;
        this.rm = d3;
        this.rn = d4;
    }

    @Deprecated
    public ev(Vector3D vector3D, double d) {
        this(vector3D, d, RotationConvention.VECTOR_OPERATOR);
    }

    public ev(Vector3D vector3D, double d, RotationConvention rotationConvention) {
        double d2 = vector3D.getNorm();
        if (d2 == 0.0) {
            throw new MathIllegalArgumentException((Localizable)LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
        }
        double d3 = rotationConvention == RotationConvention.VECTOR_OPERATOR ? -0.5 * d : 0.5 * d;
        double d4 = FastMath.sin((double)d3) / d2;
        this.rk = FastMath.cos((double)d3);
        this.rl = d4 * vector3D.getX();
        this.rm = d4 * vector3D.getY();
        this.rn = d4 * vector3D.getZ();
    }

    public ev(double[][] dArray, double d) {
        double[][] dArray2;
        if (dArray.length == 3 && dArray[0].length == 3 && dArray[1].length == 3 && dArray[2].length == 3) {
            dArray2 = this.a(dArray, d);
            double d2 = dArray2[0][0] * (dArray2[1][1] * dArray2[2][2] - dArray2[2][1] * dArray2[1][2]) - dArray2[1][0] * (dArray2[0][1] * dArray2[2][2] - dArray2[2][1] * dArray2[0][2]) + dArray2[2][0] * (dArray2[0][1] * dArray2[1][2] - dArray2[1][1] * dArray2[0][2]);
            if (d2 < 0.0) {
                throw new NotARotationMatrixException((Localizable)LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, new Object[]{d2});
            }
        } else {
            throw new NotARotationMatrixException((Localizable)LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, new Object[]{dArray.length, dArray[0].length});
        }
        double[] dArray3 = ev.a(dArray2);
        this.rk = dArray3[0];
        this.rl = dArray3[1];
        this.rm = dArray3[2];
        this.rn = dArray3[3];
    }

    public ev(Vector3D vector3D, Vector3D vector3D2, Vector3D vector3D3, Vector3D vector3D4) {
        Vector3D vector3D5 = vector3D.crossProduct((Vector)vector3D2).normalize();
        vector3D2 = vector3D5.crossProduct((Vector)vector3D).normalize();
        vector3D = vector3D.normalize();
        Vector3D vector3D6 = vector3D3.crossProduct((Vector)vector3D4).normalize();
        vector3D4 = vector3D6.crossProduct((Vector)vector3D3).normalize();
        vector3D3 = vector3D3.normalize();
        double[][] dArrayArray = new double[][]{{MathArrays.linearCombination((double)vector3D.getX(), (double)vector3D3.getX(), (double)vector3D2.getX(), (double)vector3D4.getX(), (double)vector3D5.getX(), (double)vector3D6.getX()), MathArrays.linearCombination((double)vector3D.getY(), (double)vector3D3.getX(), (double)vector3D2.getY(), (double)vector3D4.getX(), (double)vector3D5.getY(), (double)vector3D6.getX()), MathArrays.linearCombination((double)vector3D.getZ(), (double)vector3D3.getX(), (double)vector3D2.getZ(), (double)vector3D4.getX(), (double)vector3D5.getZ(), (double)vector3D6.getX())}, {MathArrays.linearCombination((double)vector3D.getX(), (double)vector3D3.getY(), (double)vector3D2.getX(), (double)vector3D4.getY(), (double)vector3D5.getX(), (double)vector3D6.getY()), MathArrays.linearCombination((double)vector3D.getY(), (double)vector3D3.getY(), (double)vector3D2.getY(), (double)vector3D4.getY(), (double)vector3D5.getY(), (double)vector3D6.getY()), MathArrays.linearCombination((double)vector3D.getZ(), (double)vector3D3.getY(), (double)vector3D2.getZ(), (double)vector3D4.getY(), (double)vector3D5.getZ(), (double)vector3D6.getY())}, {MathArrays.linearCombination((double)vector3D.getX(), (double)vector3D3.getZ(), (double)vector3D2.getX(), (double)vector3D4.getZ(), (double)vector3D5.getX(), (double)vector3D6.getZ()), MathArrays.linearCombination((double)vector3D.getY(), (double)vector3D3.getZ(), (double)vector3D2.getY(), (double)vector3D4.getZ(), (double)vector3D5.getY(), (double)vector3D6.getZ()), MathArrays.linearCombination((double)vector3D.getZ(), (double)vector3D3.getZ(), (double)vector3D2.getZ(), (double)vector3D4.getZ(), (double)vector3D5.getZ(), (double)vector3D6.getZ())}};
        double[] dArray = ev.a(dArrayArray);
        this.rk = dArray[0];
        this.rl = dArray[1];
        this.rm = dArray[2];
        this.rn = dArray[3];
    }

    public ev(Vector3D vector3D, Vector3D vector3D2) {
        double d = vector3D.getNorm() * vector3D2.getNorm();
        if (d == 0.0) {
            throw new MathArithmeticException((Localizable)LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
        }
        double d2 = vector3D.dotProduct((Vector)vector3D2);
        if (d2 < -0.999999999999998 * d) {
            Vector3D vector3D3 = vector3D.orthogonal();
            this.rk = 0.0;
            this.rl = -vector3D3.getX();
            this.rm = -vector3D3.getY();
            this.rn = -vector3D3.getZ();
        } else {
            this.rk = FastMath.sqrt((double)(0.5 * (1.0 + d2 / d)));
            double d3 = 1.0 / (2.0 * this.rk * d);
            Vector3D vector3D4 = vector3D2.crossProduct((Vector)vector3D);
            this.rl = d3 * vector3D4.getX();
            this.rm = d3 * vector3D4.getY();
            this.rn = d3 * vector3D4.getZ();
        }
    }

    @Deprecated
    public ev(RotationOrder rotationOrder, double d, double d2, double d3) {
        this(rotationOrder, RotationConvention.VECTOR_OPERATOR, d, d2, d3);
    }

    public ev(RotationOrder rotationOrder, RotationConvention rotationConvention, double d, double d2, double d3) {
        ev ev2 = new ev(rotationOrder.getA1(), d, rotationConvention);
        ev ev3 = new ev(rotationOrder.getA2(), d2, rotationConvention);
        ev ev4 = new ev(rotationOrder.getA3(), d3, rotationConvention);
        ev3.b(ev4, rotationConvention);
        ev2.b(ev4, rotationConvention);
        this.rk = ev4.rk;
        this.rl = ev4.rl;
        this.rm = ev4.rm;
        this.rn = ev4.rn;
    }

    private static double[] a(double[][] dArray) {
        double[] dArray2 = new double[4];
        double d = dArray[0][0] + dArray[1][1] + dArray[2][2];
        if (d > -0.19) {
            dArray2[0] = 0.5 * FastMath.sqrt((double)(d + 1.0));
            double d2 = 0.25 / dArray2[0];
            dArray2[1] = d2 * (dArray[1][2] - dArray[2][1]);
            dArray2[2] = d2 * (dArray[2][0] - dArray[0][2]);
            dArray2[3] = d2 * (dArray[0][1] - dArray[1][0]);
        } else {
            d = dArray[0][0] - dArray[1][1] - dArray[2][2];
            if (d > -0.19) {
                dArray2[1] = 0.5 * FastMath.sqrt((double)(d + 1.0));
                double d3 = 0.25 / dArray2[1];
                dArray2[0] = d3 * (dArray[1][2] - dArray[2][1]);
                dArray2[2] = d3 * (dArray[0][1] + dArray[1][0]);
                dArray2[3] = d3 * (dArray[0][2] + dArray[2][0]);
            } else {
                d = dArray[1][1] - dArray[0][0] - dArray[2][2];
                if (d > -0.19) {
                    dArray2[2] = 0.5 * FastMath.sqrt((double)(d + 1.0));
                    double d4 = 0.25 / dArray2[2];
                    dArray2[0] = d4 * (dArray[2][0] - dArray[0][2]);
                    dArray2[1] = d4 * (dArray[0][1] + dArray[1][0]);
                    dArray2[3] = d4 * (dArray[2][1] + dArray[1][2]);
                } else {
                    d = dArray[2][2] - dArray[0][0] - dArray[1][1];
                    dArray2[3] = 0.5 * FastMath.sqrt((double)(d + 1.0));
                    double d5 = 0.25 / dArray2[3];
                    dArray2[0] = d5 * (dArray[0][1] - dArray[1][0]);
                    dArray2[1] = d5 * (dArray[0][2] + dArray[2][0]);
                    dArray2[2] = d5 * (dArray[2][1] + dArray[1][2]);
                }
            }
        }
        return dArray2;
    }

    public static ev a(ev ev2, ev ev3, double d) {
        double d2 = ev2.rk * ev3.rk + ev2.rl * ev3.rl + ev2.rm * ev3.rm + ev2.rn * ev3.rn;
        if (d2 < 0.0) {
            ev3 = new ev(-ev3.rk, -ev3.rl, -ev3.rm, -ev3.rn, false);
            d2 = -d2;
        }
        if (d2 > 0.999999) {
            return new ev(ev2.rk + d * (ev3.rk - ev2.rk), ev2.rl + d * (ev3.rl - ev2.rl), ev2.rm + d * (ev3.rm - ev2.rm), ev2.rn + d * (ev3.rn - ev2.rn), true);
        }
        double d3 = FastMath.acos((double)d2);
        double d4 = FastMath.sqrt((double)(1.0 - d2 * d2));
        double d5 = 1.0 / d4;
        double d6 = FastMath.sin((double)((1.0 - d) * d3)) * d5;
        double d7 = FastMath.sin((double)(d * d3)) * d5;
        return new ev(d6 * ev2.gV() + d7 * ev3.gV(), d6 * ev2.gW() + d7 * ev3.gW(), d6 * ev2.gX() + d7 * ev3.gX(), d6 * ev2.gY() + d7 * ev3.gY(), false);
    }

    public ev gU() {
        return new ev(-this.rk, this.rl, this.rm, this.rn, false);
    }

    public double gV() {
        return this.rk;
    }

    public double gW() {
        return this.rl;
    }

    public double gX() {
        return this.rm;
    }

    public double gY() {
        return this.rn;
    }

    @Deprecated
    public Vector3D gZ() {
        return this.a(RotationConvention.VECTOR_OPERATOR);
    }

    public Vector3D a(RotationConvention rotationConvention) {
        double d;
        double d2 = this.rl * this.rl + this.rm * this.rm + this.rn * this.rn;
        if (d2 == 0.0) {
            return rotationConvention == RotationConvention.VECTOR_OPERATOR ? Vector3D.PLUS_I : Vector3D.MINUS_I;
        }
        double d3 = d = rotationConvention == RotationConvention.VECTOR_OPERATOR ? 1.0 : -1.0;
        if (this.rk < 0.0) {
            double d4 = d / FastMath.sqrt((double)d2);
            return new Vector3D(this.rl * d4, this.rm * d4, this.rn * d4);
        }
        double d5 = -d / FastMath.sqrt((double)d2);
        return new Vector3D(this.rl * d5, this.rm * d5, this.rn * d5);
    }

    public double ha() {
        if (!(this.rk < -0.1) && !(this.rk > 0.1)) {
            return this.rk < 0.0 ? 2.0 * FastMath.acos((double)(-this.rk)) : 2.0 * FastMath.acos((double)this.rk);
        }
        return 2.0 * bbk.p(FastMath.sqrt((double)(this.rl * this.rl + this.rm * this.rm + this.rn * this.rn)));
    }

    @Deprecated
    public double[] a(RotationOrder rotationOrder) {
        return this.b(rotationOrder, RotationConvention.VECTOR_OPERATOR);
    }

    public double[] a(RotationOrder rotationOrder, RotationConvention rotationConvention) {
        double[] dArray = this.b(rotationOrder, rotationConvention);
        dArray[0] = Math.toDegrees(dArray[0]);
        dArray[1] = Math.toDegrees(dArray[1]);
        dArray[2] = Math.toDegrees(dArray[2]);
        return dArray;
    }

    public double[] b(RotationOrder rotationOrder, RotationConvention rotationConvention) {
        if (rotationConvention == RotationConvention.VECTOR_OPERATOR) {
            if (rotationOrder == RotationOrder.XYZ) {
                Vector3D vector3D = this.a(Vector3D.PLUS_K);
                Vector3D vector3D2 = this.b(Vector3D.PLUS_I);
                if (!(vector3D2.getZ() < -0.9999999999) && !(vector3D2.getZ() > 0.9999999999)) {
                    return new double[]{bbk.c(-vector3D.getY(), vector3D.getZ()), bbk.p(vector3D2.getZ()), bbk.c(-vector3D2.getY(), vector3D2.getX())};
                }
                throw new CardanEulerSingularityException(true);
            }
            if (rotationOrder == RotationOrder.XZY) {
                Vector3D vector3D = this.a(Vector3D.PLUS_J);
                Vector3D vector3D3 = this.b(Vector3D.PLUS_I);
                if (!(vector3D3.getY() < -0.9999999999) && !(vector3D3.getY() > 0.9999999999)) {
                    return new double[]{bbk.c(vector3D.getZ(), vector3D.getY()), -bbk.p(vector3D3.getY()), bbk.c(vector3D3.getZ(), vector3D3.getX())};
                }
                throw new CardanEulerSingularityException(true);
            }
            if (rotationOrder == RotationOrder.YXZ) {
                Vector3D vector3D = this.a(Vector3D.PLUS_K);
                Vector3D vector3D4 = this.b(Vector3D.PLUS_J);
                return new double[]{bbk.c(vector3D.getX(), vector3D.getZ()), -bbk.p(vector3D4.getZ()), bbk.c(vector3D4.getX(), vector3D4.getY())};
            }
            if (rotationOrder == RotationOrder.YZX) {
                Vector3D vector3D = this.a(Vector3D.PLUS_I);
                Vector3D vector3D5 = this.b(Vector3D.PLUS_J);
                if (!(vector3D5.getX() < -0.9999999999) && !(vector3D5.getX() > 0.9999999999)) {
                    return new double[]{bbk.c(-vector3D.getZ(), vector3D.getX()), bbk.p(vector3D5.getX()), bbk.c(-vector3D5.getZ(), vector3D5.getY())};
                }
                throw new CardanEulerSingularityException(true);
            }
            if (rotationOrder == RotationOrder.ZXY) {
                Vector3D vector3D = this.a(Vector3D.PLUS_J);
                Vector3D vector3D6 = this.b(Vector3D.PLUS_K);
                if (!(vector3D6.getY() < -0.9999999999) && !(vector3D6.getY() > 0.9999999999)) {
                    return new double[]{bbk.c(-vector3D.getX(), vector3D.getY()), bbk.p(vector3D6.getY()), bbk.c(-vector3D6.getX(), vector3D6.getZ())};
                }
                throw new CardanEulerSingularityException(true);
            }
            if (rotationOrder == RotationOrder.ZYX) {
                Vector3D vector3D = this.a(Vector3D.PLUS_I);
                Vector3D vector3D7 = this.b(Vector3D.PLUS_K);
                if (!(vector3D7.getX() < -0.9999999999) && !(vector3D7.getX() > 0.9999999999)) {
                    return new double[]{bbk.c(vector3D.getY(), vector3D.getX()), -bbk.p(vector3D7.getX()), bbk.c(vector3D7.getY(), vector3D7.getZ())};
                }
                throw new CardanEulerSingularityException(true);
            }
            if (rotationOrder == RotationOrder.XYX) {
                Vector3D vector3D = this.a(Vector3D.PLUS_I);
                Vector3D vector3D8 = this.b(Vector3D.PLUS_I);
                if (!(vector3D8.getX() < -0.9999999999) && !(vector3D8.getX() > 0.9999999999)) {
                    return new double[]{bbk.c(vector3D.getY(), -vector3D.getZ()), FastMath.acos((double)vector3D8.getX()), bbk.c(vector3D8.getY(), vector3D8.getZ())};
                }
                throw new CardanEulerSingularityException(false);
            }
            if (rotationOrder == RotationOrder.XZX) {
                Vector3D vector3D = this.a(Vector3D.PLUS_I);
                Vector3D vector3D9 = this.b(Vector3D.PLUS_I);
                if (!(vector3D9.getX() < -0.9999999999) && !(vector3D9.getX() > 0.9999999999)) {
                    return new double[]{bbk.c(vector3D.getZ(), vector3D.getY()), FastMath.acos((double)vector3D9.getX()), bbk.c(vector3D9.getZ(), -vector3D9.getY())};
                }
                throw new CardanEulerSingularityException(false);
            }
            if (rotationOrder == RotationOrder.YXY) {
                Vector3D vector3D = this.a(Vector3D.PLUS_J);
                Vector3D vector3D10 = this.b(Vector3D.PLUS_J);
                if (!(vector3D10.getY() < -0.9999999999) && !(vector3D10.getY() > 0.9999999999)) {
                    return new double[]{bbk.c(vector3D.getX(), vector3D.getZ()), FastMath.acos((double)vector3D10.getY()), bbk.c(vector3D10.getX(), -vector3D10.getZ())};
                }
                throw new CardanEulerSingularityException(false);
            }
            if (rotationOrder == RotationOrder.YZY) {
                Vector3D vector3D = this.a(Vector3D.PLUS_J);
                Vector3D vector3D11 = this.b(Vector3D.PLUS_J);
                if (!(vector3D11.getY() < -0.9999999999) && !(vector3D11.getY() > 0.9999999999)) {
                    return new double[]{bbk.c(vector3D.getZ(), -vector3D.getX()), FastMath.acos((double)vector3D11.getY()), bbk.c(vector3D11.getZ(), vector3D11.getX())};
                }
                throw new CardanEulerSingularityException(false);
            }
            if (rotationOrder == RotationOrder.ZXZ) {
                Vector3D vector3D = this.a(Vector3D.PLUS_K);
                Vector3D vector3D12 = this.b(Vector3D.PLUS_K);
                if (!(vector3D12.getZ() < -0.9999999999) && !(vector3D12.getZ() > 0.9999999999)) {
                    return new double[]{bbk.c(vector3D.getX(), -vector3D.getY()), FastMath.acos((double)vector3D12.getZ()), bbk.c(vector3D12.getX(), vector3D12.getY())};
                }
                throw new CardanEulerSingularityException(false);
            }
            Vector3D vector3D = this.a(Vector3D.PLUS_K);
            Vector3D vector3D13 = this.b(Vector3D.PLUS_K);
            if (!(vector3D13.getZ() < -0.9999999999) && !(vector3D13.getZ() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D.getY(), vector3D.getX()), FastMath.acos((double)vector3D13.getZ()), bbk.c(vector3D13.getY(), -vector3D13.getX())};
            }
            throw new CardanEulerSingularityException(false);
        }
        if (rotationOrder == RotationOrder.XYZ) {
            Vector3D vector3D = this.a(Vector3D.PLUS_I);
            Vector3D vector3D14 = this.b(Vector3D.PLUS_K);
            if (!(vector3D14.getX() < -0.9999999999) && !(vector3D14.getX() > 0.9999999999)) {
                return new double[]{bbk.c(-vector3D14.getY(), vector3D14.getZ()), bbk.p(vector3D14.getX()), bbk.c(-vector3D.getY(), vector3D.getX())};
            }
            throw new CardanEulerSingularityException(true);
        }
        if (rotationOrder == RotationOrder.XZY) {
            Vector3D vector3D = this.a(Vector3D.PLUS_I);
            Vector3D vector3D15 = this.b(Vector3D.PLUS_J);
            if (!(vector3D15.getX() < -0.9999999999) && !(vector3D15.getX() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D15.getZ(), vector3D15.getY()), -bbk.p(vector3D15.getX()), bbk.c(vector3D.getZ(), vector3D.getX())};
            }
            throw new CardanEulerSingularityException(true);
        }
        if (rotationOrder == RotationOrder.YXZ) {
            Vector3D vector3D = this.a(Vector3D.PLUS_J);
            Vector3D vector3D16 = this.b(Vector3D.PLUS_K);
            if (!(vector3D16.getY() < -0.9999999999) && !(vector3D16.getY() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D16.getX(), vector3D16.getZ()), -bbk.p(vector3D16.getY()), bbk.c(vector3D.getX(), vector3D.getY())};
            }
            throw new CardanEulerSingularityException(true);
        }
        if (rotationOrder == RotationOrder.YZX) {
            Vector3D vector3D = this.a(Vector3D.PLUS_J);
            Vector3D vector3D17 = this.b(Vector3D.PLUS_I);
            if (!(vector3D17.getY() < -0.9999999999) && !(vector3D17.getY() > 0.9999999999)) {
                return new double[]{bbk.c(-vector3D17.getZ(), vector3D17.getX()), bbk.p(vector3D17.getY()), bbk.c(-vector3D.getZ(), vector3D.getY())};
            }
            throw new CardanEulerSingularityException(true);
        }
        if (rotationOrder == RotationOrder.ZXY) {
            Vector3D vector3D = this.a(Vector3D.PLUS_K);
            Vector3D vector3D18 = this.b(Vector3D.PLUS_J);
            if (!(vector3D18.getZ() < -0.9999999999) && !(vector3D18.getZ() > 0.9999999999)) {
                return new double[]{bbk.c(-vector3D18.getX(), vector3D18.getY()), bbk.p(vector3D18.getZ()), bbk.c(-vector3D.getX(), vector3D.getZ())};
            }
            throw new CardanEulerSingularityException(true);
        }
        if (rotationOrder == RotationOrder.ZYX) {
            Vector3D vector3D = this.a(Vector3D.PLUS_K);
            Vector3D vector3D19 = this.b(Vector3D.PLUS_I);
            if (!(vector3D19.getZ() < -0.9999999999) && !(vector3D19.getZ() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D19.getY(), vector3D19.getX()), -bbk.p(vector3D19.getZ()), bbk.c(vector3D.getY(), vector3D.getZ())};
            }
            throw new CardanEulerSingularityException(true);
        }
        if (rotationOrder == RotationOrder.XYX) {
            Vector3D vector3D = this.a(Vector3D.PLUS_I);
            Vector3D vector3D20 = this.b(Vector3D.PLUS_I);
            if (!(vector3D20.getX() < -0.9999999999) && !(vector3D20.getX() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D20.getY(), -vector3D20.getZ()), FastMath.acos((double)vector3D20.getX()), bbk.c(vector3D.getY(), vector3D.getZ())};
            }
            throw new CardanEulerSingularityException(false);
        }
        if (rotationOrder == RotationOrder.XZX) {
            Vector3D vector3D = this.a(Vector3D.PLUS_I);
            Vector3D vector3D21 = this.b(Vector3D.PLUS_I);
            if (!(vector3D21.getX() < -0.9999999999) && !(vector3D21.getX() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D21.getZ(), vector3D21.getY()), FastMath.acos((double)vector3D21.getX()), bbk.c(vector3D.getZ(), -vector3D.getY())};
            }
            throw new CardanEulerSingularityException(false);
        }
        if (rotationOrder == RotationOrder.YXY) {
            Vector3D vector3D = this.a(Vector3D.PLUS_J);
            Vector3D vector3D22 = this.b(Vector3D.PLUS_J);
            if (!(vector3D22.getY() < -0.9999999999) && !(vector3D22.getY() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D22.getX(), vector3D22.getZ()), FastMath.acos((double)vector3D22.getY()), bbk.c(vector3D.getX(), -vector3D.getZ())};
            }
            throw new CardanEulerSingularityException(false);
        }
        if (rotationOrder == RotationOrder.YZY) {
            Vector3D vector3D = this.a(Vector3D.PLUS_J);
            Vector3D vector3D23 = this.b(Vector3D.PLUS_J);
            if (!(vector3D23.getY() < -0.9999999999) && !(vector3D23.getY() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D23.getZ(), -vector3D23.getX()), FastMath.acos((double)vector3D23.getY()), bbk.c(vector3D.getZ(), vector3D.getX())};
            }
            throw new CardanEulerSingularityException(false);
        }
        if (rotationOrder == RotationOrder.ZXZ) {
            Vector3D vector3D = this.a(Vector3D.PLUS_K);
            Vector3D vector3D24 = this.b(Vector3D.PLUS_K);
            if (!(vector3D24.getZ() < -0.9999999999) && !(vector3D24.getZ() > 0.9999999999)) {
                return new double[]{bbk.c(vector3D24.getX(), -vector3D24.getY()), FastMath.acos((double)vector3D24.getZ()), bbk.c(vector3D.getX(), vector3D.getY())};
            }
            throw new CardanEulerSingularityException(false);
        }
        Vector3D vector3D = this.a(Vector3D.PLUS_K);
        Vector3D vector3D25 = this.b(Vector3D.PLUS_K);
        if (!(vector3D25.getZ() < -0.9999999999) && !(vector3D25.getZ() > 0.9999999999)) {
            return new double[]{bbk.c(vector3D25.getY(), vector3D25.getX()), FastMath.acos((double)vector3D25.getZ()), bbk.c(vector3D.getY(), -vector3D.getX())};
        }
        throw new CardanEulerSingularityException(false);
    }

    public double[][] hb() {
        double d = this.rk * this.rk;
        double d2 = this.rk * this.rl;
        double d3 = this.rk * this.rm;
        double d4 = this.rk * this.rn;
        double d5 = this.rl * this.rl;
        double d6 = this.rl * this.rm;
        double d7 = this.rl * this.rn;
        double d8 = this.rm * this.rm;
        double d9 = this.rm * this.rn;
        double d10 = this.rn * this.rn;
        double[][] dArrayArray = new double[][]{new double[3], new double[3], new double[3]};
        dArrayArray[0][0] = 2.0 * (d + d5) - 1.0;
        dArrayArray[1][0] = 2.0 * (d6 - d4);
        dArrayArray[2][0] = 2.0 * (d7 + d3);
        dArrayArray[0][1] = 2.0 * (d6 + d4);
        dArrayArray[1][1] = 2.0 * (d + d8) - 1.0;
        dArrayArray[2][1] = 2.0 * (d9 - d2);
        dArrayArray[0][2] = 2.0 * (d7 - d3);
        dArrayArray[1][2] = 2.0 * (d9 + d2);
        dArrayArray[2][2] = 2.0 * (d + d10) - 1.0;
        return dArrayArray;
    }

    public Vector3D a(Vector3D vector3D) {
        double d = vector3D.getX();
        double d2 = vector3D.getY();
        double d3 = vector3D.getZ();
        double d4 = this.rl * d + this.rm * d2 + this.rn * d3;
        return new Vector3D(2.0 * (this.rk * (d * this.rk - (this.rm * d3 - this.rn * d2)) + d4 * this.rl) - d, 2.0 * (this.rk * (d2 * this.rk - (this.rn * d - this.rl * d3)) + d4 * this.rm) - d2, 2.0 * (this.rk * (d3 * this.rk - (this.rl * d2 - this.rm * d)) + d4 * this.rn) - d3);
    }

    public void a(double[] dArray, double[] dArray2) {
        double d = dArray[0];
        double d2 = dArray[1];
        double d3 = dArray[2];
        double d4 = this.rl * d + this.rm * d2 + this.rn * d3;
        dArray2[0] = 2.0 * (this.rk * (d * this.rk - (this.rm * d3 - this.rn * d2)) + d4 * this.rl) - d;
        dArray2[1] = 2.0 * (this.rk * (d2 * this.rk - (this.rn * d - this.rl * d3)) + d4 * this.rm) - d2;
        dArray2[2] = 2.0 * (this.rk * (d3 * this.rk - (this.rl * d2 - this.rm * d)) + d4 * this.rn) - d3;
    }

    public Vector3D b(Vector3D vector3D) {
        double d = vector3D.getX();
        double d2 = vector3D.getY();
        double d3 = vector3D.getZ();
        double d4 = this.rl * d + this.rm * d2 + this.rn * d3;
        double d5 = -this.rk;
        return new Vector3D(2.0 * (d5 * (d * d5 - (this.rm * d3 - this.rn * d2)) + d4 * this.rl) - d, 2.0 * (d5 * (d2 * d5 - (this.rn * d - this.rl * d3)) + d4 * this.rm) - d2, 2.0 * (d5 * (d3 * d5 - (this.rl * d2 - this.rm * d)) + d4 * this.rn) - d3);
    }

    public void b(double[] dArray, double[] dArray2) {
        double d = dArray[0];
        double d2 = dArray[1];
        double d3 = dArray[2];
        double d4 = this.rl * d + this.rm * d2 + this.rn * d3;
        double d5 = -this.rk;
        dArray2[0] = 2.0 * (d5 * (d * d5 - (this.rm * d3 - this.rn * d2)) + d4 * this.rl) - d;
        dArray2[1] = 2.0 * (d5 * (d2 * d5 - (this.rn * d - this.rl * d3)) + d4 * this.rm) - d2;
        dArray2[2] = 2.0 * (d5 * (d3 * d5 - (this.rl * d2 - this.rm * d)) + d4 * this.rn) - d3;
    }

    public ev a(ev ev2) {
        return this.a(ev2, RotationConvention.VECTOR_OPERATOR);
    }

    public ev a(ev ev2, RotationConvention rotationConvention) {
        return rotationConvention == RotationConvention.VECTOR_OPERATOR ? this.b(ev2) : ev2.b(this);
    }

    private ev b(ev ev2) {
        return new ev(ev2.rk * this.rk - (ev2.rl * this.rl + ev2.rm * this.rm + ev2.rn * this.rn), ev2.rl * this.rk + ev2.rk * this.rl + (ev2.rm * this.rn - ev2.rn * this.rm), ev2.rm * this.rk + ev2.rk * this.rm + (ev2.rn * this.rl - ev2.rl * this.rn), ev2.rn * this.rk + ev2.rk * this.rn + (ev2.rl * this.rm - ev2.rm * this.rl), false);
    }

    public void c(ev ev2) {
        this.b(ev2, RotationConvention.VECTOR_OPERATOR);
    }

    public void b(ev ev2, RotationConvention rotationConvention) {
        if (rotationConvention == RotationConvention.VECTOR_OPERATOR) {
            this.d(ev2);
        } else {
            ev2.d(this);
        }
    }

    private void d(ev ev2) {
        double d = ev2.rk * this.rk - (ev2.rl * this.rl + ev2.rm * this.rm + ev2.rn * this.rn);
        double d2 = ev2.rl * this.rk + ev2.rk * this.rl + (ev2.rm * this.rn - ev2.rn * this.rm);
        double d3 = ev2.rm * this.rk + ev2.rk * this.rm + (ev2.rn * this.rl - ev2.rl * this.rn);
        double d4 = ev2.rn * this.rk + ev2.rk * this.rn + (ev2.rl * this.rm - ev2.rm * this.rl);
        ev2.rk = d;
        ev2.rl = d2;
        ev2.rm = d3;
        ev2.rn = d4;
    }

    public ev e(ev ev2) {
        return this.c(ev2, RotationConvention.VECTOR_OPERATOR);
    }

    public ev c(ev ev2, RotationConvention rotationConvention) {
        return rotationConvention == RotationConvention.VECTOR_OPERATOR ? this.f(ev2) : ev2.b(this.gU());
    }

    private ev f(ev ev2) {
        return new ev(-ev2.rk * this.rk - (ev2.rl * this.rl + ev2.rm * this.rm + ev2.rn * this.rn), -ev2.rl * this.rk + ev2.rk * this.rl + (ev2.rm * this.rn - ev2.rn * this.rm), -ev2.rm * this.rk + ev2.rk * this.rm + (ev2.rn * this.rl - ev2.rl * this.rn), -ev2.rn * this.rk + ev2.rk * this.rn + (ev2.rl * this.rm - ev2.rm * this.rl), false);
    }

    private double[][] a(double[][] dArray, double d) {
        double[] dArray2 = dArray[0];
        double[] dArray3 = dArray[1];
        double[] dArray4 = dArray[2];
        double d2 = dArray2[0];
        double d3 = dArray2[1];
        double d4 = dArray2[2];
        double d5 = dArray3[0];
        double d6 = dArray3[1];
        double d7 = dArray3[2];
        double d8 = dArray4[0];
        double d9 = dArray4[1];
        double d10 = dArray4[2];
        double d11 = 0.0;
        double[][] dArray5 = new double[3][3];
        double[] dArray6 = dArray5[0];
        double[] dArray7 = dArray5[1];
        double[] dArray8 = dArray5[2];
        int n = 0;
        while (true) {
            if (++n >= 11) {
                throw new NotARotationMatrixException((Localizable)LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX, new Object[]{n - 1});
            }
            double d12 = dArray2[0] * d2 + dArray3[0] * d5 + dArray4[0] * d8;
            double d13 = dArray2[1] * d2 + dArray3[1] * d5 + dArray4[1] * d8;
            double d14 = dArray2[2] * d2 + dArray3[2] * d5 + dArray4[2] * d8;
            double d15 = dArray2[0] * d3 + dArray3[0] * d6 + dArray4[0] * d9;
            double d16 = dArray2[1] * d3 + dArray3[1] * d6 + dArray4[1] * d9;
            double d17 = dArray2[2] * d3 + dArray3[2] * d6 + dArray4[2] * d9;
            double d18 = dArray2[0] * d4 + dArray3[0] * d7 + dArray4[0] * d10;
            double d19 = dArray2[1] * d4 + dArray3[1] * d7 + dArray4[1] * d10;
            double d20 = dArray2[2] * d4 + dArray3[2] * d7 + dArray4[2] * d10;
            dArray6[0] = d2 - 0.5 * (d2 * d12 + d3 * d13 + d4 * d14 - dArray2[0]);
            dArray6[1] = d3 - 0.5 * (d2 * d15 + d3 * d16 + d4 * d17 - dArray2[1]);
            dArray6[2] = d4 - 0.5 * (d2 * d18 + d3 * d19 + d4 * d20 - dArray2[2]);
            dArray7[0] = d5 - 0.5 * (d5 * d12 + d6 * d13 + d7 * d14 - dArray3[0]);
            dArray7[1] = d6 - 0.5 * (d5 * d15 + d6 * d16 + d7 * d17 - dArray3[1]);
            dArray7[2] = d7 - 0.5 * (d5 * d18 + d6 * d19 + d7 * d20 - dArray3[2]);
            dArray8[0] = d8 - 0.5 * (d8 * d12 + d9 * d13 + d10 * d14 - dArray4[0]);
            dArray8[1] = d9 - 0.5 * (d8 * d15 + d9 * d16 + d10 * d17 - dArray4[1]);
            dArray8[2] = d10 - 0.5 * (d8 * d18 + d9 * d19 + d10 * d20 - dArray4[2]);
            double d21 = dArray6[0] - dArray2[0];
            double d22 = dArray6[1] - dArray2[1];
            double d23 = dArray6[2] - dArray2[2];
            double d24 = dArray7[0] - dArray3[0];
            double d25 = dArray7[1] - dArray3[1];
            double d26 = dArray7[2] - dArray3[2];
            double d27 = dArray8[0] - dArray4[0];
            double d28 = dArray8[1] - dArray4[1];
            double d29 = dArray8[2] - dArray4[2];
            double d30 = d21 * d21 + d22 * d22 + d23 * d23 + d24 * d24 + d25 * d25 + d26 * d26 + d27 * d27 + d28 * d28 + d29 * d29;
            if (FastMath.abs((double)(d30 - d11)) <= d) {
                return dArray5;
            }
            d2 = dArray6[0];
            d3 = dArray6[1];
            d4 = dArray6[2];
            d5 = dArray7[0];
            d6 = dArray7[1];
            d7 = dArray7[2];
            d8 = dArray8[0];
            d9 = dArray8[1];
            d10 = dArray8[2];
            d11 = d30;
        }
    }

    public static double a(ev ev2, ev ev3) {
        return ev2.f(ev3).ha();
    }

    public ev hc() {
        return new ev(this.rk, this.rl, this.rm, this.rn, false);
    }

    public void g(ev ev2) {
        if (this != ev2) {
            this.rk = ev2.rk;
            this.rl = ev2.rl;
            this.rm = ev2.rm;
            this.rn = ev2.rn;
        } else {
            this.rk = 1.0;
            this.rl = 0.0;
            this.rm = 0.0;
            this.rn = 0.0;
        }
    }
}
