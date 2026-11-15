package itemsadder.m;

public final class BlocksEnum
extends Enum {
    public static final /* enum */ BlocksEnum BLOCKS = new BlocksEnum("BLOCKS", 0);
    public static final /* enum */ BlocksEnum CROPS_SEEDS = new BlocksEnum("CROPS_SEEDS", 1);
    public static final /* enum */ BlocksEnum BIOMES = new BlocksEnum("BIOMES", 2);
    private static final /* synthetic */ BlocksEnum[] $VALUES;

    public static BlocksEnum[] values() {
        return (BlocksEnum[])$VALUES.clone();
    }

    public static BlocksEnum valueOf(String string) {
        return Enum.valueOf(BlocksEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BlocksEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ BlocksEnum[] lY() {
        return new BlocksEnum[]{BLOCKS, CROPS_SEEDS, BIOMES};
    }

    static {
        $VALUES = BlocksEnum.lY();
    }
}
