package itemsadder.m;

public final class RegexEnum
extends Enum {
    public static final /* enum */ RegexEnum REGEX = new RegexEnum("REGEX", 0);
    public static final /* enum */ RegexEnum WILDCARD = new RegexEnum("WILDCARD", 1);
    public static final /* enum */ RegexEnum EXACT = new RegexEnum("EXACT", 2);
    private static final /* synthetic */ RegexEnum[] $VALUES;

    public static RegexEnum[] values() {
        return (RegexEnum[])$VALUES.clone();
    }

    public static RegexEnum valueOf(String string) {
        return Enum.valueOf(RegexEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RegexEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ RegexEnum[] Y() {
        return new RegexEnum[]{REGEX, WILDCARD, EXACT};
    }

    static {
        $VALUES = RegexEnum.Y();
    }
}
