package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ListenerBridge;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PlayerWrapper_3;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public final class PlayerHolder_3
implements Listener {
    private final PlayerWrapper_3 ajF = (PlayerWrapper_3)NmsWrapperFactory.n(PlayerWrapper_3.class);
    private static PlayerHolder_3 ajG;

    PlayerHolder_3() {
        ListenerBridge.b(this, (Plugin)Main.rS());
    }

    public static PlayerWrapper_3 us() {
        if (ajG == null) {
            ajG = new PlayerHolder_3();
        }
        return PlayerHolder_3.ajG.ajF;
    }

    public static void a(Player player, String string, @Nullable String string2, String string3, boolean bl, String string4) {
        PlayerHolder_3.us().a(player, string, string2, string3, bl, string4);
    }
}
