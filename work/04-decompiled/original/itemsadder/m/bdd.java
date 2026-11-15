package itemsadder.m;

public final class bdd
extends Enum {
    public static final /* enum */ bdd INSTALLED_IS_NEWER = new bdd("INSTALLED_IS_NEWER", 0);
    public static final /* enum */ bdd INSTALLED_IS_LOWER = new bdd("INSTALLED_IS_LOWER", 1);
    public static final /* enum */ bdd INSTALLED_IS_SAME = new bdd("INSTALLED_IS_SAME", 2);
    public static final /* enum */ bdd UNKNOWN = new bdd("UNKNOWN", 3);
    private static final /* synthetic */ bdd[] $VALUES;

    public static bdd[] values() {
        return (bdd[])$VALUES.clone();
    }

    public static bdd valueOf(String string) {
        return Enum.valueOf(bdd.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private bdd() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ bdd[] Dz() {
        return new bdd[]{INSTALLED_IS_NEWER, INSTALLED_IS_LOWER, INSTALLED_IS_SAME, UNKNOWN};
    }

    static {
        $VALUES = bdd.Dz();
    }
}
