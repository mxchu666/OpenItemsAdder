package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.MinecraftKey;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import itemsadder.m.aow;
import java.nio.charset.StandardCharsets;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class arf {
    private static final MinecraftKey alV = new MinecraftKey("debug/game_test_add_marker");
    private static final MinecraftKey alW = new MinecraftKey("debug/game_test_clear");

    public static void a(Player player, Location location, int n, String string) {
        arf.a(player, location, n, 999999999, string);
    }

    public static void a(Player player, Location location, int n, int n2, String string) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.CUSTOM_PAYLOAD);
        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeLong(arf.Y(location));
        byteBuf.writeInt(n);
        arf.a(byteBuf, string);
        byteBuf.writeInt(n2);
        packetContainer.getMinecraftKeys().write(0, (Object)alV);
        packetContainer.getModifier().withType(ByteBuf.class).write(0, arf.a(byteBuf));
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer);
        }
        catch (Exception exception) {
            throw new RuntimeException("Cannot send packet " + String.valueOf(packetContainer), exception);
        }
    }

    public static void cf(Player player) {
        PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.CUSTOM_PAYLOAD);
        packetContainer.getMinecraftKeys().write(0, (Object)alW);
        packetContainer.getModifier().write(1, arf.a(Unpooled.wrappedBuffer((byte[])new byte[0])));
        aow.a(player, packetContainer);
    }

    private static Object a(ByteBuf byteBuf) {
        return MinecraftReflection.getPacketDataSerializer((Object)byteBuf);
    }

    private static long Y(Location location) {
        int n = location.getBlockX();
        int n2 = location.getBlockY();
        int n3 = location.getBlockZ();
        return ((long)n & 0x3FFFFFFL) << 38 | (long)n2 & 0xFFFL | ((long)n3 & 0x3FFFFFFL) << 12;
    }

    private static void a(ByteBuf byteBuf, String string) {
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        int n = byArray.length;
        while ((n & 0xFFFFFF80) != 0) {
            byteBuf.writeByte(n & 0x7F | 0x80);
            n >>>= 7;
        }
        byteBuf.writeByte(n);
        byteBuf.writeBytes(byArray);
    }
}
