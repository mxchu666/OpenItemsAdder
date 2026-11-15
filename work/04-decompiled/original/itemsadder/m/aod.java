package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.aab;
import itemsadder.m.aoc;
import itemsadder.m.bev;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public final class aod
implements Listener {
    private final aoc ajF = (aoc)aab.n(aoc.class);
    private static aod ajG;

    aod() {
        bev.b(this, (Plugin)Main.rS());
    }

    public static aoc us() {
        if (ajG == null) {
            ajG = new aod();
        }
        return aod.ajG.ajF;
    }

    public static void a(Player player, String string, @Nullable String string2, String string3, boolean bl, String string4) {
        aod.us().a(player, string, string2, string3, bl, string4);
    }
}
