package itemsadder.m;

public final class CraftingEnum
extends Enum {
    public static final /* enum */ CraftingEnum CRAFTING = new CraftingEnum("CRAFTING", 0);
    public static final /* enum */ CraftingEnum SMELTING = new CraftingEnum("SMELTING", 1);
    public static final /* enum */ CraftingEnum BLASTING = new CraftingEnum("BLASTING", 2);
    public static final /* enum */ CraftingEnum SMOKING = new CraftingEnum("SMOKING", 3);
    public static final /* enum */ CraftingEnum CAMPFIRE_COOKING = new CraftingEnum("CAMPFIRE_COOKING", 4);
    public static final /* enum */ CraftingEnum STONECUTTING = new CraftingEnum("STONECUTTING", 5);
    public static final /* enum */ CraftingEnum SMITHING = new CraftingEnum("SMITHING", 6);
    private static final /* synthetic */ CraftingEnum[] $VALUES;

    public static CraftingEnum[] values() {
        return (CraftingEnum[])$VALUES.clone();
    }

    public static CraftingEnum valueOf(String string) {
        return Enum.valueOf(CraftingEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CraftingEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ CraftingEnum[] vj() {
        return new CraftingEnum[]{CRAFTING, SMELTING, BLASTING, SMOKING, CAMPFIRE_COOKING, STONECUTTING, SMITHING};
    }

    static {
        $VALUES = CraftingEnum.vj();
    }
}
