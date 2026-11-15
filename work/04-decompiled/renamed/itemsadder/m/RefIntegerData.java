package itemsadder.m;

import itemsadder.m.FluentBuilder_6;
import itemsadder.m.SoundCategoryBridge_2;
import itemsadder.m.VectorBridgeImpl;
import org.apache.commons.math3.geometry.euclidean.threed.RotationConvention;
import org.apache.commons.math3.geometry.euclidean.threed.RotationOrder;
import org.bukkit.Location;

public class RefIntegerData {
    public SoundCategoryBridge_2 pL;
    public final VectorBridgeImpl pM;
    public final VectorBridgeImpl pN;
    public final FluentBuilder_6 pO;
    public final VectorBridgeImpl pP;
    public final Integer pQ;

    public RefIntegerData(SoundCategoryBridge_2 soundCategoryBridge_2, VectorBridgeImpl vectorBridgeImpl, VectorBridgeImpl vectorBridgeImpl2, VectorBridgeImpl vectorBridgeImpl3, String string) {
        this.pL = soundCategoryBridge_2;
        this.pM = vectorBridgeImpl;
        this.pN = vectorBridgeImpl2;
        this.pP = vectorBridgeImpl3;
        this.pQ = string.hashCode();
        double d = Location.normalizeYaw((float)vectorBridgeImpl2.aBp);
        double d2 = Location.normalizeYaw((float)vectorBridgeImpl2.aBq);
        double d3 = Location.normalizeYaw((float)vectorBridgeImpl2.aBr);
        this.pO = new FluentBuilder_6(RotationOrder.YXZ, RotationConvention.VECTOR_OPERATOR, Math.toRadians(d), Math.toRadians(d2), Math.toRadians(d3));
    }
}
