package itemsadder.m;

import itemsadder.m.ItemStackBuilder_4;
import org.jetbrains.annotations.Nullable;

public class Opaque126
implements Cloneable {
    public ItemStackBuilder_4 zk;

    public Opaque126(ItemStackBuilder_4 itemStackBuilder_4) {
        this.zk = itemStackBuilder_4;
    }

    @Nullable
    public Opaque126 f(ItemStackBuilder_4 itemStackBuilder_4) {
        Opaque126 opaque126 = null;
        try {
            opaque126 = (Opaque126)super.clone();
            opaque126.zk = itemStackBuilder_4;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
        }
        return opaque126;
    }
}
