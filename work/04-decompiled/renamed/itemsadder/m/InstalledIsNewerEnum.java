package itemsadder.m;

public final class InstalledIsNewerEnum
extends Enum {
    public static final /* enum */ InstalledIsNewerEnum INSTALLED_IS_NEWER = new InstalledIsNewerEnum("INSTALLED_IS_NEWER", 0);
    public static final /* enum */ InstalledIsNewerEnum INSTALLED_IS_LOWER = new InstalledIsNewerEnum("INSTALLED_IS_LOWER", 1);
    public static final /* enum */ InstalledIsNewerEnum INSTALLED_IS_SAME = new InstalledIsNewerEnum("INSTALLED_IS_SAME", 2);
    public static final /* enum */ InstalledIsNewerEnum UNKNOWN = new InstalledIsNewerEnum("UNKNOWN", 3);
    private static final /* synthetic */ InstalledIsNewerEnum[] $VALUES;

    public static InstalledIsNewerEnum[] values() {
        return (InstalledIsNewerEnum[])$VALUES.clone();
    }

    public static InstalledIsNewerEnum valueOf(String string) {
        return Enum.valueOf(InstalledIsNewerEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private InstalledIsNewerEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ InstalledIsNewerEnum[] Dz() {
        return new InstalledIsNewerEnum[]{INSTALLED_IS_NEWER, INSTALLED_IS_LOWER, INSTALLED_IS_SAME, UNKNOWN};
    }

    static {
        $VALUES = InstalledIsNewerEnum.Dz();
    }
}
