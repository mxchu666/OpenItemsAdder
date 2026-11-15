package itemsadder.m;

import itemsadder.m.qm;
import org.jetbrains.annotations.Nullable;

public class ki
implements Cloneable {
    public qm zk;

    public ki(qm qm2) {
        this.zk = qm2;
    }

    @Nullable
    public ki f(qm qm2) {
        ki ki2 = null;
        try {
            ki2 = (ki)super.clone();
            ki2.zk = qm2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
        }
        return ki2;
    }
}
