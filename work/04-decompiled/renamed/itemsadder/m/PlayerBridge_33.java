package itemsadder.m;

import itemsadder.m.PluginBridge_6;
import java.util.WeakHashMap;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class PlayerBridge_33 {
    private static final WeakHashMap UN = new WeakHashMap();

    public static void a(Player player, Component component) {
        UN.put(player, component);
    }

    @Nullable
    public static Object bA(Player player) {
        Component component = (Component)UN.get(player);
        if (component == null) {
            return null;
        }
        return PluginBridge_6.r(component);
    }

    public static void bB(Player player) {
        UN.remove(player);
    }
}
