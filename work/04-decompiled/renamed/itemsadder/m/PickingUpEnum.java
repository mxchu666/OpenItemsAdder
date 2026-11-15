package itemsadder.m;

final class PickingUpEnum
extends Enum {
    public static final /* enum */ PickingUpEnum PICKING_UP = new PickingUpEnum("PICKING_UP", 0);
    public static final /* enum */ PickingUpEnum LOYAL_PICKING_UP = new PickingUpEnum("LOYAL_PICKING_UP", 1);
    public static final /* enum */ PickingUpEnum NONE = new PickingUpEnum("NONE", 2);
    private static final /* synthetic */ PickingUpEnum[] $VALUES;

    public static PickingUpEnum[] values() {
        return (PickingUpEnum[])$VALUES.clone();
    }

    public static PickingUpEnum valueOf(String string) {
        return Enum.valueOf(PickingUpEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PickingUpEnum() {
        void var2_-1;
        void var1_-1;
    }

    public boolean mz() {
        return this == PICKING_UP || this == LOYAL_PICKING_UP;
    }

    private static /* synthetic */ PickingUpEnum[] mA() {
        return new PickingUpEnum[]{PICKING_UP, LOYAL_PICKING_UP, NONE};
    }

    static {
        $VALUES = PickingUpEnum.mA();
    }
}
