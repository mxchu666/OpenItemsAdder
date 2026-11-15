package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import itemsadder.m.aab;
import itemsadder.m.aow;
import itemsadder.m.bce;
import itemsadder.m.bcz;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public abstract class aui {
    public static final double anD = 0.35;
    static Constructor WD;
    private static boolean anE;
    protected PacketContainer anF;
    protected bcz anG;

    @Nullable
    public static aui Z(Location location) {
        if (anE) {
            return null;
        }
        if (WD == null && (WD = aab.a(aui.class, true, Location.class)) == null) {
            anE = true;
            bce.error("Failed to get shadow constructor.");
            return null;
        }
        try {
            return (aui)WD.newInstance(location);
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            anE = true;
            bce.error("Error getting shadow constructor", reflectiveOperationException);
            return null;
        }
    }

    public abstract void B(List var1);

    public abstract void C(List var1);

    public abstract void a(double var1, double var3, double var5, List var7);

    public void a(Player player, PacketContainer packetContainer) {
        aow.a(player, packetContainer, false);
    }

    static {
        anE = false;
    }
}
