package itemsadder.m;

public final class BlockEnum
extends Enum {
    public static final /* enum */ BlockEnum BLOCK = new BlockEnum("BLOCK", 0, "BLOCK");
    public static final /* enum */ BlockEnum ITEM = new BlockEnum("ITEM", 1, "ITEM");
    public static final /* enum */ BlockEnum VANILLA = new BlockEnum("VANILLA", 2, "VANILLA");
    private final String text;
    private static final /* synthetic */ BlockEnum[] $VALUES;

    public static BlockEnum[] values() {
        return (BlockEnum[])$VALUES.clone();
    }

    public static BlockEnum valueOf(String string) {
        return Enum.valueOf(BlockEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BlockEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    private static /* synthetic */ BlockEnum[] nR() {
        return new BlockEnum[]{BLOCK, ITEM, VANILLA};
    }

    static {
        $VALUES = BlockEnum.nR();
    }
}
