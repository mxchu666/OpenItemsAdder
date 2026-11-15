package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.google.common.base.Objects;
import org.bukkit.entity.Player;

public abstract class are {
    protected PacketContainer alU;

    protected are(PacketContainer packetContainer, PacketType packetType) {
        if (packetContainer == null) {
            throw new IllegalArgumentException("Packet handle cannot be NULL.");
        }
        if (!Objects.equal(packetContainer.getType(), packetType)) {
            throw new IllegalArgumentException(String.valueOf(packetContainer.getHandle()) + " is not a packet of type " + String.valueOf(packetType));
        }
        this.alU = packetContainer;
    }

    public PacketContainer uX() {
        return this.alU;
    }

    public void cc(Player player) {
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, this.uX());
        }
        catch (Exception exception) {
            throw new RuntimeException("Cannot send packet.", exception);
        }
    }

    public void uY() {
        ProtocolLibrary.getProtocolManager().broadcastServerPacket(this.uX());
    }

    @Deprecated
    public void cd(Player player) {
        try {
            ProtocolLibrary.getProtocolManager().receiveClientPacket(player, this.uX());
        }
        catch (Exception exception) {
            throw new RuntimeException("Cannot recieve packet.", exception);
        }
    }

    public void ce(Player player) {
        try {
            ProtocolLibrary.getProtocolManager().receiveClientPacket(player, this.uX());
        }
        catch (Exception exception) {
            throw new RuntimeException("Cannot receive packet.", exception);
        }
    }
}
