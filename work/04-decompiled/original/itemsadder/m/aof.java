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
import net.kyori.adventure.text.Component;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R1.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class aof
implements aoc {
    private static final Pattern ajI = Pattern.compile("^[a-fA-F0-9]{40}$");

    @Override
    public void a(Player player, String string, @Nullable String string2, String string3, boolean bl, String string4) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.c.b((Packet)new ClientboundResourcePackPushPacket(string2 == null ? UUID.nameUUIDFromBytes(string.getBytes(StandardCharsets.UTF_8)) : UUID.fromString(string2), string, string3, bl, Optional.ofNullable(CraftChatMessage.fromStringOrNull((String)string4, (boolean)true))));
    }

    @Override
    public void a(String string, @Nullable String string2, String string3, boolean bl, Component component) {
        Object object;
        Optional<Object> optional;
        DedicatedServer dedicatedServer = (DedicatedServer)MinecraftServer.getServer();
        if (string.isEmpty()) {
            optional = Optional.empty();
        } else {
            UUID uUID;
            if (string3.isEmpty()) {
                bce.warn("You specified a resource pack without providing an hash. Pack will be updated on the client only if you change the URL of the pack.");
            } else if (!ajI.matcher(string3).matches()) {
                bce.warn("Invalid resourcepack hash: " + string3);
            }
            object = (IChatBaseComponent)bbe.r(component);
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
            optional = Optional.of(new MinecraftServer.ServerResourcePackInfo(uUID, string, string3, bl, (IChatBaseComponent)object));
        }
        object = zw.a(dedicatedServer.a().getClass(), dedicatedServer.a().U.getClass());
        ((Field)object).setAccessible(true);
        try {
            ((Field)object).set(dedicatedServer.a(), optional);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    @Override
    public void ur() {
        DedicatedServer dedicatedServer = (DedicatedServer)MinecraftServer.getServer();
        Field field = zw.a(dedicatedServer.a().getClass(), dedicatedServer.a().U.getClass());
        field.setAccessible(true);
        try {
            field.set(dedicatedServer.a(), Optional.empty());
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }
}
