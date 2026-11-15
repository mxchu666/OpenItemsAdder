package itemsadder.m;

public final class ag
extends Enum {
    public static final /* enum */ ag LOBFILE = new ag("LOBFILE", 0);
    public static final /* enum */ ag AUTO_EXTERNAL_LEGACY = new ag("AUTO_EXTERNAL_LEGACY", 1);
    public static final /* enum */ ag EXTERNAL = new ag("EXTERNAL", 2);
    public static final /* enum */ ag SIMPLE_SELF_HOST = new ag("SIMPLE_SELF_HOST", 3);
    public static final /* enum */ ag SELF_HOST = new ag("SELF_HOST", 4);
    public static final /* enum */ ag NO_HOST = new ag("NO_HOST", 5);
    public static final /* enum */ ag UNKNOWN = new ag("UNKNOWN", 6);
    private static final /* synthetic */ ag[] $VALUES;

    public static ag[] values() {
        return (ag[])$VALUES.clone();
    }

    public static ag valueOf(String string) {
        return Enum.valueOf(ag.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ag() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ag[] as() {
        return new ag[]{LOBFILE, AUTO_EXTERNAL_LEGACY, EXTERNAL, SIMPLE_SELF_HOST, SELF_HOST, NO_HOST, UNKNOWN};
    }

    static {
        $VALUES = ag.as();
    }
}
