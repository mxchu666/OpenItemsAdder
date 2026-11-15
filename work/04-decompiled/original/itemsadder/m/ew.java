package itemsadder.m;

import itemsadder.m.ev;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.RotationOrder;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.util.FastMath;

public class ew
extends ev {
    private ew ro;
    private ew rp;
    private ew rq;
    private final Vector3D rr;
    private final Vector3D rs;
    private final Vector3D rt;
    private final RotationConvention ru;

    public ew(RotationOrder rotationOrder, RotationConvention rotationConvention, double d, double d2, double d3) {
        super(1.0, 0.0, 0.0, 0.0, false);
        this.rr = rotationOrder.getA1();
        this.rs = rotationOrder.getA2();
        this.rt = rotationOrder.getA3();
        this.ru = rotationConvention;
        this.ro = new ew(1.0, 0.0, 0.0, 0.0, false);
        this.rp = new ew(1.0, 0.0, 0.0, 0.0, false);
        this.rq = new ew(1.0, 0.0, 0.0, 0.0, false);
        this.b(d, d2, d3);
    }

    private ew(double d, double d2, double d3, double d4, boolean bl) {
        super(d, d2, d3, d4, bl);
        this.rr = null;
        this.rs = null;
        this.rt = null;
        this.ru = RotationConvention.VECTOR_OPERATOR;
    }

    public void b(double d, double d2, double d3) {
        this.ro.a(this.rr, d, this.ru);
        this.rp.a(this.rs, d2, this.ru);
        this.rq.a(this.rt, d3, this.ru);
        this.rp.b(this.rq, this.ru);
        this.ro.b(this.rq, this.ru);
        this.rk = this.rq.rk;
        this.rl = this.rq.rl;
        this.rm = this.rq.rm;
        this.rn = this.rq.rn;
    }

    private void a(Vector3D vector3D, double d, RotationConvention rotationConvention) {
        double d2 = vector3D.getNorm();
        if (d2 == 0.0) {
            this.rk = 1.0;
            this.rl = 0.0;
            this.rm = 0.0;
            this.rn = 0.0;
        } else {
            double d3 = rotationConvention == RotationConvention.VECTOR_OPERATOR ? -0.5 * d : 0.5 * d;
            double d4 = FastMath.sin((double)d3) / d2;
            this.rk = FastMath.cos((double)d3);
            this.rl = d4 * vector3D.getX();
            this.rm = d4 * vector3D.getY();
            this.rn = d4 * vector3D.getZ();
        }
    }
}
