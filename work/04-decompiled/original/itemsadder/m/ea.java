package itemsadder.m;

import itemsadder.m.dt;
import itemsadder.m.dx;
import itemsadder.m.ed;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class ea {
    public final dt px;
    public final dx py;
    private final List pz;

    public ea(dt dt2, dx dx2, List list) {
        this.px = dt2;
        this.py = dx2;
        this.pz = list;
    }

    @Nullable
    public ed n(int n) {
        if (n < 0 || n >= this.pz.size()) {
            return null;
        }
        return (ed)this.pz.get(n);
    }

    public int gh() {
        return this.pz.size();
    }
}
