package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;
import itemsadder.m.aab;
import itemsadder.m.adc;
import java.util.Objects;
import org.bukkit.entity.Player;

public final class adb {
    public static final Object Xa = adb.dw("");
    private final adc Xb = (adc)aab.n(adc.class);
    private static adb Xc;

    private static adb to() {
        if (Xc == null) {
            Xc = new adb();
        }
        return Xc;
    }

    public static adc tp() {
        return adb.to().Xb;
    }

    adb() {
    }

    public static void bI(Player player) {
        adb.to().Xb.bI(player);
    }

    public static void i(Player player, String string) {
        adb.to().Xb.i(player, string);
    }

    public static void a(Player player, Object object) {
        adb.to().Xb.a(player, object);
    }

    public static Object dw(String string) {
        return adb.to().Xb.dx(string);
    }

    public static Object l(String string, int n) {
        return adb.to().Xb.m(string, n);
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
