package itemsadder.m;

import java.util.List;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public interface PlayerNms {
    public void register();

    public void unregister();

    public Object f(NamespacedKey var1);

    public Object g(NamespacedKey var1);

    public void b(Player var1, List var2);
}
