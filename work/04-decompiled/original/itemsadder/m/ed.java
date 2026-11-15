package itemsadder.m;

import itemsadder.m.bbq;
import itemsadder.m.dt;
import itemsadder.m.ev;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.RotationOrder;
import org.bukkit.Location;

public class ed {
    public dt pL;
    public final bbq pM;
    public final bbq pN;
    public final ev pO;
    public final bbq pP;
    public final Integer pQ;

    public ed(dt dt2, bbq bbq2, bbq bbq3, bbq bbq4, String string) {
        this.pL = dt2;
        this.pM = bbq2;
        this.pN = bbq3;
        this.pP = bbq4;
        this.pQ = string.hashCode();
        double d = Location.normalizeYaw((float)bbq3.aBp);
        double d2 = Location.normalizeYaw((float)bbq3.aBq);
        double d3 = Location.normalizeYaw((float)bbq3.aBr);
        this.pO = new ev(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR, Math.toRadians(d), Math.toRadians(d2), Math.toRadians(d3));
    }
}
