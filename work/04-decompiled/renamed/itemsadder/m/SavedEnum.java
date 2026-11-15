package itemsadder.m;

public final class SavedEnum
extends Enum {
    public static final /* enum */ SavedEnum SAVED = new SavedEnum("SAVED", 0);
    public static final /* enum */ SavedEnum SAVED_CHUNK = new SavedEnum("SAVED_CHUNK", 1);
    private static final /* synthetic */ SavedEnum[] $VALUES;

    public static SavedEnum[] values() {
        return (SavedEnum[])$VALUES.clone();
    }

    public static SavedEnum valueOf(String string) {
        return Enum.valueOf(SavedEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SavedEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ SavedEnum[] lZ() {
        return new SavedEnum[]{SAVED, SAVED_CHUNK};
    }

    static {
        $VALUES = SavedEnum.lZ();
    }
}
