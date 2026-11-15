package itemsadder.m;

import itemsadder.m.ItemStackBridge_16;
import itemsadder.m.Opaque132;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public final class RecordOfList_2
extends Record {
    private final List IH;
    private final float II;

    public RecordOfList_2(List list, float f) {
        this.IH = list;
        this.II = f;
    }

    public void e(@Nullable Player player, Location location) {
        double d = Math.random();
        if (d * 100.0 > (double)this.II) {
            return;
        }
        this.IH.forEach(recordOfString_8 -> {
            String string = ItemStackBridge_16.e(player, recordOfString_8.IJ);
            if (recordOfString_8.IK) {
                Opaque132.a(string, recordOfString_8);
            } else if (player != null) {
                player.performCommand(string);
            }
        });
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfList_2.class, "commands;chance", "IH", "II"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfList_2.class, "commands;chance", "IH", "II"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfList_2.class, "commands;chance", "IH", "II"}, this, object);
    }

    public List oJ() {
        return this.IH;
    }

    public float dB() {
        return this.II;
    }
}
