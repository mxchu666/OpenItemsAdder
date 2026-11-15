package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PlayerWrapper;
import java.util.Objects;
import org.bukkit.entity.Player;

public final class PacketContainerHolder {
    public static final Object Xa = PacketContainerHolder.dw("");
    private final PlayerWrapper Xb = (PlayerWrapper)NmsWrapperFactory.n(PlayerWrapper.class);
    private static PacketContainerHolder Xc;

    private static PacketContainerHolder to() {
        if (Xc == null) {
            Xc = new PacketContainerHolder();
        }
        return Xc;
    }

    public static PlayerWrapper tp() {
        return PacketContainerHolder.to().Xb;
    }

    PacketContainerHolder() {
    }

    public static void bI(Player player) {
        PacketContainerHolder.to().Xb.bI(player);
    }

    public static void i(Player player, String string) {
        PacketContainerHolder.to().Xb.i(player, string);
    }

    public static void a(Player player, Object object) {
        PacketContainerHolder.to().Xb.a(player, object);
    }

    public static Object dw(String string) {
        return PacketContainerHolder.to().Xb.dx(string);
    }

    public static Object l(String string, int n) {
        return PacketContainerHolder.to().Xb.m(string, n);
    }

    public static boolean b(PacketContainer packetContainer) {
        Boolean bl = (Boolean)packetContainer.getBooleans().readSafely(0);
        if (bl != null) {
            return bl;
        }
        return false;
    }

    public static Integer c(PacketContainer packetContainer) {
        StructureModifier structureModifier = packetContainer.getModifier();
        return Objects.hash(structureModifier.read(0) == null ? null : Integer.valueOf(structureModifier.read(0).hashCode()));
    }

    public static void a(PacketContainer packetContainer, PacketContainer packetContainer2) {
        StructureModifier structureModifier = packetContainer.getModifier();
        StructureModifier structureModifier2 = packetContainer2.getModifier();
        structureModifier2.write(0, structureModifier.read(0));
    }
}
