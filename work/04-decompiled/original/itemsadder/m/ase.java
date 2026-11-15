package itemsadder.m;

public final class ase
extends Enum {
    public static final /* enum */ ase CRAFTING = new ase("CRAFTING", 0);
    public static final /* enum */ ase SMELTING = new ase("SMELTING", 1);
    public static final /* enum */ ase BLASTING = new ase("BLASTING", 2);
    public static final /* enum */ ase SMOKING = new ase("SMOKING", 3);
    public static final /* enum */ ase CAMPFIRE_COOKING = new ase("CAMPFIRE_COOKING", 4);
    public static final /* enum */ ase STONECUTTING = new ase("STONECUTTING", 5);
    public static final /* enum */ ase SMITHING = new ase("SMITHING", 6);
    private static final /* synthetic */ ase[] $VALUES;

    public static ase[] values() {
        return (ase[])$VALUES.clone();
    }

    public static ase valueOf(String string) {
        return Enum.valueOf(ase.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ase() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ase[] vj() {
        return new ase[]{CRAFTING, SMELTING, BLASTING, SMOKING, CAMPFIRE_COOKING, STONECUTTING, SMITHING};
    }

    static {
        $VALUES = ase.vj();
    }
}
