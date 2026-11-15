package itemsadder.m;

import itemsadder.m.aoc;
import itemsadder.m.bbe;
import itemsadder.m.bce;
import itemsadder.m.zw;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class aoo
implements aoc {
    private static final Pattern ajR = Pattern.compile("^[a-fA-F0-9]{40}$");

    @Override
    public void a(Player player, String string, @Nullable String string2, String string3, boolean bl, String string4) {
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        serverPlayer.connection.send((Packet)new ClientboundResourcePackPushPacket(string2 == null ? UUID.nameUUIDFromBytes(string.getBytes(StandardCharsets.UTF_8)) : UUID.fromString(string2), string, string3, bl, Optional.ofNullable(CraftChatMessage.fromStringOrNull((String)string4, (boolean)true))));
    }

    @Override
    public void a(String string, @Nullable String string2, String string3, boolean bl, net.kyori.adventure.text.Component component) {
        Object object;
        Optional<Object> optional;
        DedicatedServer dedicatedServer = (DedicatedServer)MinecraftServer.getServer();
        if (string.isEmpty()) {
            optional = Optional.empty();
        } else {
            UUID uUID;
            if (string3.isEmpty()) {
                bce.warn("You specified a resource pack without providing an hash. Pack will be updated on the client only if you change the URL of the pack.");
            } else if (!ajR.matcher(string3).matches()) {
                bce.warn("Invalid resourcepack hash: " + string3);
            }
            object = (Component)bbe.r(component);
            if (string2 == null || string2.isEmpty()) {
                uUID = UUID.nameUUIDFromBytes(string.getBytes(StandardCharsets.UTF_8));
                bce.warn("resource-pack-id missing, using default: " + String.valueOf(uUID));
            } else {
                try {
                    uUID = UUID.fromString(string2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    bce.warn(MessageFormat.format("Failed to parse \"{0}\" into UUID", string2));
                    return;
                }
            }
            optional = Optional.of(new MinecraftServer.ServerResourcePackInfo(uUID, string, string3, bl, (Component)object));
        }
        object = zw.a(dedicatedServer.getProperties().getClass(), dedicatedServer.getProperties().serverResourcePackInfo.getClass());
        ((Field)object).setAccessible(true);
        try {
            ((Field)object).set(dedicatedServer.getProperties(), optional);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public void ur() {
        DedicatedServer dedicatedServer = (DedicatedServer)MinecraftServer.getServer();
        Field field = zw.a(dedicatedServer.getProperties().getClass(), dedicatedServer.getProperties().serverResourcePackInfo.getClass());
        field.setAccessible(true);
        try {
            field.set(dedicatedServer.getProperties(), Optional.empty());
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }
}
