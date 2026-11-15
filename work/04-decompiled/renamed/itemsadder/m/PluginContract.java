package itemsadder.m;

import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.ListenerBridge;
import org.bukkit.event.Listener;

public interface PluginContract
extends Listener {
    public static boolean a(PluginContract pluginContract) {
        if (pluginContract != null) {
            pluginContract.unregister();
            return true;
        }
        return true;
    }

    default public void unregister() {
        ListenerBridge.b(this);
        BukkitTaskBridge.r(this.getClass());
    }

    default public void at() {
    }
}
