package dev.lone.itemsadder;

import dev.lone.itemsadder.e;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public class f {
    public static final f Pn = new f();
    private boolean Pj = true;
    private boolean Pk = true;
    private boolean Pl = true;
    @Nullable
    private Set Pm = null;

    public f aD(boolean bl) {
        this.Pj = bl;
        return this;
    }

    public f aE(boolean bl) {
        this.Pk = bl;
        return this;
    }

    public f aF(boolean bl) {
        this.Pl = bl;
        return this;
    }

    public f e(@Nullable Set set) {
        this.Pm = set;
        return this;
    }

    public e rR() {
        return new e(this);
    }
}
