package dev.lone.itemsadder.resourcepack;

public final class ak
extends Enum {
    public static final /* enum */ ak TEXTURES = new ak("TEXTURES", 0, "textures");
    public static final /* enum */ ak MODELS = new ak("MODELS", 1, "models");
    private final String str;
    private static final /* synthetic */ ak[] $VALUES;

    public static ak[] values() {
        return (ak[])$VALUES.clone();
    }

    public static ak valueOf(String string) {
        return Enum.valueOf(ak.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ak() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.str = var3_2;
    }

    private static /* synthetic */ ak[] zg() {
        return new ak[]{TEXTURES, MODELS};
    }

    static {
        $VALUES = ak.zg();
    }
}
