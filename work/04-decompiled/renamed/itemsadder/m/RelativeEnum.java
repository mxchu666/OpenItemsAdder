package itemsadder.m;

public final class RelativeEnum
extends Enum {
    public static final /* enum */ RelativeEnum RELATIVE = new RelativeEnum("RELATIVE", 0);
    public static final /* enum */ RelativeEnum CLICKED = new RelativeEnum("CLICKED", 1);
    private static final /* synthetic */ RelativeEnum[] $VALUES;

    public static RelativeEnum[] values() {
        return (RelativeEnum[])$VALUES.clone();
    }

    public static RelativeEnum valueOf(String string) {
        return Enum.valueOf(RelativeEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RelativeEnum() {
        void var2_-1;
        void var1_-1;
    }

    public static RelativeEnum bv(String string) {
        switch (string) {
            case "RELATIVE": {
                return RELATIVE;
            }
            case "CLICKED": {
                return CLICKED;
            }
        }
        return CLICKED;
    }

    private static /* synthetic */ RelativeEnum[] mg() {
        return new RelativeEnum[]{RELATIVE, CLICKED};
    }

    static {
        $VALUES = RelativeEnum.mg();
    }
}
