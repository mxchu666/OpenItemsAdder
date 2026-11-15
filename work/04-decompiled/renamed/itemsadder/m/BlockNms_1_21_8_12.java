package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.PlayerWrapper_3;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.VersionHelper_3;
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
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R5.util.CraftChatMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class BlockNms_1_21_8_12
implements PlayerWrapper_3 {
    private static final Pattern ajQ = Pattern.compile("^[a-fA-F0-9]{40}$");

    @Override
    public void a(Player player, String string, @Nullable String string2, String string3, boolean bl, String string4) {
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        entityPlayer.g.b((Packet)new ClientboundResourcePackPushPacket(string2 == null ? UUID.nameUUIDFromBytes(string.getBytes(StandardCharsets.UTF_8)) : UUID.fromString(string2), string, string3, bl, Optional.ofNullable(CraftChatMessage.fromStringOrNull((String)string4, (boolean)true))));
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
                CommandSenderBridge_5.warn("You specified a resource pack without providing an hash. Pack will be updated on the client only if you change the URL of the pack.");
            } else if (!ajQ.matcher(string3).matches()) {
                CommandSenderBridge_5.warn("Invalid resourcepack hash: " + string3);
            }
            object = (IChatBaseComponent)PluginBridge_6.r(component);
            if (string2 == null || string2.isEmpty()) {
                uUID = UUID.nameUUIDFromBytes(string.getBytes(StandardCharsets.UTF_8));
                CommandSenderBridge_5.warn("resource-pack-id missing, using default: " + String.valueOf(uUID));
            } else {
                try {
                    uUID = UUID.fromString(string2);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    CommandSenderBridge_5.warn(MessageFormat.format("Failed to parse \"{0}\" into UUID", string2));
                    return;
                }
            }
            optional = Optional.of(new MinecraftServer.ServerResourcePackInfo(uUID, string, string3, bl, (IChatBaseComponent)object));
        }
        object = VersionHelper_3.a(dedicatedServer.a().getClass(), dedicatedServer.a().T.getClass());
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
        Field field = VersionHelper_3.a(dedicatedServer.a().getClass(), dedicatedServer.a().T.getClass());
        field.setAccessible(true);
        try {
            field.set(dedicatedServer.a(), Optional.empty());
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }
}
