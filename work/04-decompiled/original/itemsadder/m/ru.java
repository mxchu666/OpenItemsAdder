package itemsadder.m;

import itemsadder.m.np;
import itemsadder.m.rv;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public final class ru
extends Record {
    private final List IH;
    private final float II;

    public ru(List list, float f) {
        this.IH = list;
        this.II = f;
    }

    public void e(@Nullable Player player, Location location) {
        double d = Math.random();
        if (d * 100.0 > (double)this.II) {
            return;
        }
        this.IH.forEach(rw2 -> {
            String string = np.e(player, rw2.IJ);
            if (rw2.IK) {
                rv.a(string, rw2);
            } else if (player != null) {
                player.performCommand(string);
            }
        });
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ru.class, "commands;chance", "IH", "II"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ru.class, "commands;chance", "IH", "II"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ru.class, "commands;chance", "IH", "II"}, this, object);
    }

    public List oJ() {
        return this.IH;
    }

    public float dB() {
        return this.II;
    }
}
