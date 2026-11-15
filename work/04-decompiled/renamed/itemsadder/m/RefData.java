package itemsadder.m;

import itemsadder.m.BlockBridge_11;
import itemsadder.m.MaterialBridge_5;
import itemsadder.m.VectorBridge_2;

public class RefData
extends BlockBridge_11 {
    public final VectorBridge_2 Eb;

    public RefData(MaterialBridge_5 materialBridge_5, MaterialBridge_5 materialBridge_52, VectorBridge_2 vectorBridge_2, int n, int n2, boolean bl) {
        super(materialBridge_5, materialBridge_52, n, n2, bl);
        this.Eb = vectorBridge_2;
    }
}
