package itemsadder.m;

public final class bfp
extends Enum {
    public static final /* enum */ bfp ENTITY_AND_BLOCK = new bfp("ENTITY_AND_BLOCK", 0, "ENTITY_AND_BLOCK", 0);
    public static final /* enum */ bfp ENTITY = new bfp("ENTITY", 1, "ENTITY", 1);
    public static final /* enum */ bfp BLOCK = new bfp("BLOCK", 2, "BLOCK", 2);
    private static final /* synthetic */ bfp[] $VALUES;

    public static bfp[] values() {
        return (bfp[])$VALUES.clone();
    }

    public static bfp valueOf(String string) {
        return Enum.valueOf(bfp.class, string);
    }

    private static /* synthetic */ bfp[] EL() {
        return new bfp[]{ENTITY_AND_BLOCK, ENTITY, BLOCK};
    }

    static {
        $VALUES = bfp.EL();
    }
}
