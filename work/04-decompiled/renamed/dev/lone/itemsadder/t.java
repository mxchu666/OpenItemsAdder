package dev.lone.itemsadder;

public final class t
extends Enum {
    public static final /* enum */ t TRIGGERS = new t("TRIGGERS", 0);
    public static final /* enum */ t COMMANDS = new t("COMMANDS", 1);
    public static final /* enum */ t API = new t("API", 2);
    private static final /* synthetic */ t[] $VALUES;

    public static t[] values() {
        return (t[])$VALUES.clone();
    }

    public static t valueOf(String string) {
        return Enum.valueOf(t.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private t() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ t[] si() {
        return new t[]{TRIGGERS, COMMANDS, API};
    }

    static {
        $VALUES = t.si();
    }
}
