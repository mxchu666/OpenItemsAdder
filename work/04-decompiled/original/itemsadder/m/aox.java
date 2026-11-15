package itemsadder.m;

import com.comphenix.protocol.PacketType;
import itemsadder.m.aow;

public final class aox {
    public static final int aku = aox.uQ();
    public static final int akv = aox.uR();

    public static int uQ() {
        Integer n = aow.uN().a(PacketType.Play.Server.ENTITY_TELEPORT);
        if (n == null) {
            throw new RuntimeException("Failed to get packet ID for ENTITY_TELEPORT");
        }
        return n;
    }

    public static int uR() {
        Integer n = aow.uN().a(PacketType.Play.Server.ENTITY_METADATA);
        if (n == null) {
            throw new RuntimeException("Failed to get packet ID for ENTITY_METADATA");
        }
        return n;
    }
}
