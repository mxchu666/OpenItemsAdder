package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.LocationBridge_5;
import itemsadder.m.LocationBridge_6;
import org.bukkit.Location;

public interface LocationWrapper_3 {
    public void e(Location var1, int var2);

    public void aj(Location var1);

    public static LocationWrapper_3 El() {
        try {
            return new LocationBridge_5();
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to initialize built-in lights implementation.", throwable);
            return new LocationBridge_6();
        }
    }
}
