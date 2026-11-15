package itemsadder.m;

import io.netty.channel.ChannelHandlerContext;
import itemsadder.m.ItemsadderHttpCodec;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketListenerRegistry;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.kyori.adventure.key.Key;

public final class ItemsadderHttpPacket {
    private static final String ayY = "itemsadder_http_packet_listener";
    private static long ayZ;
    private static final int aza = 65536;
    private static int azb;
    private static final Map azc;

    private ItemsadderHttpPacket() {
    }

    public static void Ck() {
        ayZ = (long)MaterialBarColorHolder.cr * 1024L * 1024L;
        azb = MaterialBarColorHolder.cq;
        PacketListenerRegistry.uN().a(ayY, Key.key((String)"itemsadder", (String)"http_packet_listener"), "timeout", ItemsadderHttpCodec::new);
    }

    public static void Cl() {
        PacketListenerRegistry.uN().dJ(ayY);
    }

    private static String a(ChannelHandlerContext channelHandlerContext) {
        Serializable serializable = channelHandlerContext.channel().remoteAddress();
        if (!(serializable instanceof InetSocketAddress)) {
            return "unknown";
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress)serializable;
        serializable = inetSocketAddress.getAddress();
        if (serializable == null) {
            return inetSocketAddress.getHostString();
        }
        return ((InetAddress)serializable).getHostAddress();
    }

    static {
        azc = new ConcurrentHashMap();
    }
}
