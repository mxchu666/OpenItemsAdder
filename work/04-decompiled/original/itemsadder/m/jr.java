package itemsadder.m;

import itemsadder.m.ki;
import itemsadder.m.qm;
import java.util.HashSet;
import org.bukkit.block.Block;

public class jr
extends ki {
    public static final String yb = "fuel";
    public short yc;
    public HashSet yd;

    public jr(qm qm2, short s) {
        super(qm2);
        this.yc = s;
        this.yd = new HashSet();
    }

    public boolean l(Block block) {
        if (this.yd.isEmpty()) {
            return true;
        }
        return this.yd.contains(block.getType());
    }
}
