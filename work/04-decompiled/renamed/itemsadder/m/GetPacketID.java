package itemsadder.m;

import com.comphenix.protocol.PacketType;
import itemsadder.m.PacketListenerRegistry;

public final class GetPacketID {
    public static final int aku = GetPacketID.uQ();
    public static final int akv = GetPacketID.uR();

    public static int uQ() {
        Integer n = PacketListenerRegistry.uN().a(PacketType.Play.Server.ENTITY_TELEPORT);
        if (n == null) {
            throw new RuntimeException("Failed to get packet ID for ENTITY_TELEPORT");
        }
        return n;
    }

    public static int uR() {
        Integer n = PacketListenerRegistry.uN().a(PacketType.Play.Server.ENTITY_METADATA);
        if (n == null) {
            throw new RuntimeException("Failed to get packet ID for ENTITY_METADATA");
        }
        return n;
    }
}
