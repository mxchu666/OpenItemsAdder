package itemsadder.m;

public final class mr
extends Enum {
    public static final /* enum */ mr BLOCKS = new mr("BLOCKS", 0);
    public static final /* enum */ mr CROPS_SEEDS = new mr("CROPS_SEEDS", 1);
    public static final /* enum */ mr BIOMES = new mr("BIOMES", 2);
    private static final /* synthetic */ mr[] $VALUES;

    public static mr[] values() {
        return (mr[])$VALUES.clone();
    }

    public static mr valueOf(String string) {
        return Enum.valueOf(mr.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private mr() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ mr[] lY() {
        return new mr[]{BLOCKS, CROPS_SEEDS, BIOMES};
    }

    static {
        $VALUES = mr.lY();
    }
}
