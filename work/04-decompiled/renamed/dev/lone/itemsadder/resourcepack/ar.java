package dev.lone.itemsadder.resourcepack;

final class ar
extends Enum {
    public static final /* enum */ ar PLANNER_FATAL = new ar("PLANNER_FATAL", 0);
    public static final /* enum */ ar PRE_EXISTING_WARNING = new ar("PRE_EXISTING_WARNING", 1);
    public static final /* enum */ ar VANILLA_VERSION_SELECTION_ERROR = new ar("VANILLA_VERSION_SELECTION_ERROR", 2);
    public static final /* enum */ ar INTENTIONAL_MISSING_FALLBACK = new ar("INTENTIONAL_MISSING_FALLBACK", 3);
    private static final /* synthetic */ ar[] $VALUES;

    public static ar[] values() {
        return (ar[])$VALUES.clone();
    }

    public static ar valueOf(String string) {
        return Enum.valueOf(ar.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ar() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ ar[] zy() {
        return new ar[]{PLANNER_FATAL, PRE_EXISTING_WARNING, VANILLA_VERSION_SELECTION_ERROR, INTENTIONAL_MISSING_FALLBACK};
    }

    static {
        $VALUES = ar.zy();
    }
}
