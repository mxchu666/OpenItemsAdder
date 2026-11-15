package itemsadder.m;

import itemsadder.m.bcp;
import itemsadder.m.bev;
import org.bukkit.event.Listener;

public interface ai
extends Listener {
    public static boolean a(ai ai2) {
        if (ai2 != null) {
            ai2.unregister();
            return true;
        }
        return true;
    }

    default public void unregister() {
        bev.b(this);
        bcp.r(this.getClass());
    }

    default public void at() {
    }
}
