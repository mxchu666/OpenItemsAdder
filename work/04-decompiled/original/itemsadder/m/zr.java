package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.BlockPosition;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class zr {
    private final Player Uv;
    private final List Uw;
    private BiPredicate Ux;
    private boolean Uy;
    private Consumer Uz;

    zr(Player player, List list) {
        this.Uv = player;
        this.Uw = list;
    }

    void b(Consumer consumer) {
        this.Uz = consumer;
    }

    public zr sS() {
        this.Uy = true;
        return this;
    }

    public zr a(BiPredicate biPredicate) {
        this.Ux = biPredicate;
        return this;
    }

    public void sT() {
        Location location = this.Uv.getLocation();
        location.setY((double)(location.getBlockY() - 4));
        this.Uv.sendBlockChange(location, Material.OAK_SIGN.createBlockData());
        this.Uv.sendSignChange(location, (String[])null);
        BlockPosition blockPosition = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        PacketContainer packetContainer = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.OPEN_SIGN_EDITOR);
        packetContainer.getBlockPositionModifier().write(0, (Object)blockPosition);
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(this.Uv, packetContainer);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.Uz.accept(blockPosition);
    }

    private String dq(String string) {
        return ChatColor.translateAlternateColorCodes((char)'&', (String)string);
    }
}
