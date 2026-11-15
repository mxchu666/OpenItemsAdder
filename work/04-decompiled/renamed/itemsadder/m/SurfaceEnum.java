package itemsadder.m;

public final class SurfaceEnum
extends Enum {
    public static final /* enum */ SurfaceEnum SURFACE = new SurfaceEnum("SURFACE", 0);
    public static final /* enum */ SurfaceEnum CEILING = new SurfaceEnum("CEILING", 1);
    private static final /* synthetic */ SurfaceEnum[] $VALUES;

    public static SurfaceEnum[] values() {
        return (SurfaceEnum[])$VALUES.clone();
    }

    public static SurfaceEnum valueOf(String string) {
        return Enum.valueOf(SurfaceEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SurfaceEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ SurfaceEnum[] rO() {
        return new SurfaceEnum[]{SURFACE, CEILING};
    }

    static {
        $VALUES = SurfaceEnum.rO();
    }
}
