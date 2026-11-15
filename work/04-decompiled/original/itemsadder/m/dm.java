package itemsadder.m;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public final class dm
extends Enum {
    public static final /* enum */ dm CLEAR = new dm("CLEAR", 0);
    public static final /* enum */ dm RAIN = new dm("RAIN", 1);
    public static final /* enum */ dm THUNDER = new dm("THUNDER", 2);
    public static final /* enum */ dm SNOW = new dm("SNOW", 3);
    private static final /* synthetic */ dm[] $VALUES;

    public static dm[] values() {
        return (dm[])$VALUES.clone();
    }

    public static dm valueOf(String string) {
        return Enum.valueOf(dm.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private dm() {
        void var2_-1;
        void var1_-1;
    }

    @Nullable
    public static dm p(Location location) {
        World world = location.getWorld();
        if (world == null) {
            return null;
        }
        if (world.isThundering()) {
            return THUNDER;
        }
        if (world.isClearWeather()) {
            return CLEAR;
        }
        return location.getBlock().getTemperature() < (double)0.15f ? SNOW : RAIN;
    }

    private static /* synthetic */ dm[] dU() {
        return new dm[]{CLEAR, RAIN, THUNDER, SNOW};
    }

    static {
        $VALUES = dm.dU();
    }
}
