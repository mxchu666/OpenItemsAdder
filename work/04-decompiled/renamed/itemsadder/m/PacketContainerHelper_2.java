package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.NmsWrapperFactory;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.VectorBridge;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public abstract class PacketContainerHelper_2 {
    public static final double anD = 0.35;
    static Constructor WD;
    private static boolean anE;
    protected PacketContainer anF;
    protected VectorBridge anG;

    @Nullable
    public static PacketContainerHelper_2 Z(Location location) {
        if (anE) {
            return null;
        }
        if (WD == null && (WD = NmsWrapperFactory.a(PacketContainerHelper_2.class, true, Location.class)) == null) {
            anE = true;
            CommandSenderBridge_5.error("Failed to get shadow constructor.");
            return null;
        }
        try {
            return (PacketContainerHelper_2)WD.newInstance(location);
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            anE = true;
            CommandSenderBridge_5.error("Error getting shadow constructor", reflectiveOperationException);
            return null;
        }
    }

    public abstract void B(List var1);

    public abstract void C(List var1);

    public abstract void a(double var1, double var3, double var5, List var7);

    public void a(Player player, PacketContainer packetContainer) {
        PacketListenerRegistry.a(player, packetContainer, false);
    }

    static {
        anE = false;
    }
}
