package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import itemsadder.m.aow;
import itemsadder.m.bev;
import itemsadder.m.ut;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class us
implements Listener {
    PacketAdapter LS;
    private static us LT;

    public static void i(boolean bl) {
        if (bl) {
            us.register();
        } else {
            us.unregister();
        }
    }

    public static void register() {
        if (LT == null) {
            LT = new us();
            LT.au();
        }
    }

    public static void unregister() {
        if (LT != null) {
            LT.av();
            LT = null;
        }
    }

    private void au() {
        this.LS = new ut(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.SCOREBOARD_SCORE}));
        aow.b((PacketListener)this.LS);
        bev.b(this, (Plugin)Main.rS());
    }

    private void av() {
        aow.c((PacketListener)this.LS);
    }
}
