package itemsadder.m;

public final class PublicEnum
extends Enum {
    public static final /* enum */ PublicEnum PUBLIC = new PublicEnum("PUBLIC", 0);
    public static final /* enum */ PublicEnum PROTECTED = new PublicEnum("PROTECTED", 1);
    public static final /* enum */ PublicEnum PRIVATE = new PublicEnum("PRIVATE", 2);
    public static final /* enum */ PublicEnum PACKAGE_PRIVATE = new PublicEnum("PACKAGE_PRIVATE", 3);
    private static final /* synthetic */ PublicEnum[] $VALUES;

    public static PublicEnum[] values() {
        return (PublicEnum[])$VALUES.clone();
    }

    public static PublicEnum valueOf(String string) {
        return Enum.valueOf(PublicEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PublicEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ PublicEnum[] tb() {
        return new PublicEnum[]{PUBLIC, PROTECTED, PRIVATE, PACKAGE_PRIVATE};
    }

    static {
        $VALUES = PublicEnum.tb();
    }
}
