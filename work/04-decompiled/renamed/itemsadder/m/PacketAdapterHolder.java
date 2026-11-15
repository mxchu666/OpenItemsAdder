package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_55;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PacketAdapterHolder
implements Listener {
    PacketAdapter LS;
    private static PacketAdapterHolder LT;

    public static void i(boolean bl) {
        if (bl) {
            PacketAdapterHolder.register();
        } else {
            PacketAdapterHolder.unregister();
        }
    }

    public static void register() {
        if (LT == null) {
            LT = new PacketAdapterHolder();
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
        this.LS = new PacketListener_55(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.SCOREBOARD_SCORE}));
        PacketListenerRegistry.b((PacketListener)this.LS);
        ListenerBridge.b(this, (Plugin)Main.rS());
    }

    private void av() {
        PacketListenerRegistry.c((PacketListener)this.LS);
    }
}
