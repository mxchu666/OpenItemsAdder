package itemsadder.m;

import io.netty.channel.ChannelHandlerContext;
import itemsadder.m.ae;
import itemsadder.m.aow;
import itemsadder.m.bal;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.kyori.adventure.key.Key;

public final class bak {
    private static final String ayY = "itemsadder_http_packet_listener";
    private static long ayZ;
    private static final int aza = 65536;
    private static int azb;
    private static final Map azc;

    private bak() {
    }

    public static void Ck() {
        ayZ = (long)ae.cr * 1024L * 1024L;
        azb = ae.cq;
        aow.uN().a(ayY, Key.key((String)"itemsadder", (String)"http_packet_listener"), "timeout", bal::new);
    }

    public static void Cl() {
        aow.uN().dJ(ayY);
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
