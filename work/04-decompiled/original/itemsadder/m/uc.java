package itemsadder.m;

import itemsadder.m.ud;
import lombok.Generated;

public class uc
extends ud {
    String namespacedId;

    public uc(String string, boolean bl) {
        super(bl);
        this.namespacedId = string;
    }

    @Generated
    public String nL() {
        return this.namespacedId;
    }
}
