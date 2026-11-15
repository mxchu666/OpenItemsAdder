package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PlayerWrapper_2;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public final class PlayerHolder {
    public final PlayerWrapper_2 acn = (PlayerWrapper_2)NmsWrapperFactory.n(PlayerWrapper_2.class);
    private static PlayerHolder aco;

    PlayerHolder() {
    }

    private static PlayerHolder tO() {
        if (aco == null) {
            aco = new PlayerHolder();
        }
        return aco;
    }

    public static PlayerWrapper_2 tP() {
        return PlayerHolder.tO().acn;
    }

    public static void bO(Player player) {
        if (player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        PlayerHolder.tO().acn.a(player, GameMode.SPECTATOR);
    }

    public static void bP(Player player) {
        if (player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        PlayerHolder.tO().acn.bR(player);
        BukkitTaskBridge.c(() -> PlayerHolder.tO().acn.bS(player), 5L);
    }

    public static float a(GameMode gameMode) {
        return switch (gameMode) {
            default -> throw new MatchException(null, null);
            case GameMode.SURVIVAL -> 0.0f;
            case GameMode.CREATIVE -> 1.0f;
            case GameMode.ADVENTURE -> 2.0f;
            case GameMode.SPECTATOR -> 3.0f;
        };
    }

    @Deprecated
    private static void b(Player player, float f) {
        PacketContainer packetContainer = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.ABILITIES);
        packetContainer.getFloat().write(0, (Object)Float.valueOf(f));
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static boolean b(Player player, PacketContainer packetContainer) {
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer);
        }
        catch (Exception exception) {
            return false;
        }
        return true;
    }
}
