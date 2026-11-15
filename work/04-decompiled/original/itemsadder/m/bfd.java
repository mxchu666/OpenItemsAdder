package itemsadder.m;

import itemsadder.m.bce;
import itemsadder.m.bfe;
import itemsadder.m.bff;
import org.bukkit.Location;

public interface bfd {
    public void e(Location var1, int var2);

    public void aj(Location var1);

    public static bfd El() {
        try {
            return new bfe();
        }
        catch (Throwable throwable) {
            bce.error("Failed to initialize built-in lights implementation.", throwable);
            return new bff();
        }
    }
}
