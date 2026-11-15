package itemsadder.m;

import org.bukkit.Location;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public final class ClearEnum
extends Enum {
    public static final /* enum */ ClearEnum CLEAR = new ClearEnum("CLEAR", 0);
    public static final /* enum */ ClearEnum RAIN = new ClearEnum("RAIN", 1);
    public static final /* enum */ ClearEnum THUNDER = new ClearEnum("THUNDER", 2);
    public static final /* enum */ ClearEnum SNOW = new ClearEnum("SNOW", 3);
    private static final /* synthetic */ ClearEnum[] $VALUES;

    public static ClearEnum[] values() {
        return (ClearEnum[])$VALUES.clone();
    }

    public static ClearEnum valueOf(String string) {
        return Enum.valueOf(ClearEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ClearEnum() {
        void var2_-1;
        void var1_-1;
    }

    @Nullable
    public static ClearEnum p(Location location) {
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

    private static /* synthetic */ ClearEnum[] dU() {
        return new ClearEnum[]{CLEAR, RAIN, THUNDER, SNOW};
    }

    static {
        $VALUES = ClearEnum.dU();
    }
}
