package itemsadder.m;

import itemsadder.m.InstanceRegistry_10;
import itemsadder.m.RefIntegerData;
import itemsadder.m.SoundCategoryBridge_2;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class Opaque111 {
    public final SoundCategoryBridge_2 px;
    public final InstanceRegistry_10 py;
    private final List pz;

    public Opaque111(SoundCategoryBridge_2 soundCategoryBridge_2, InstanceRegistry_10 instanceRegistry_10, List list) {
        this.px = soundCategoryBridge_2;
        this.py = instanceRegistry_10;
        this.pz = list;
    }

    @Nullable
    public RefIntegerData n(int n) {
        if (n < 0 || n >= this.pz.size()) {
            return null;
        }
        return (RefIntegerData)this.pz.get(n);
    }

    public int gh() {
        return this.pz.size();
    }
}
