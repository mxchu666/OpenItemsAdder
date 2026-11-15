package dev.lone.itemsadder.resourcepack;

final class cd
extends Enum {
    public static final /* enum */ cd VERTEX = new cd("VERTEX", 0, "vertex");
    public static final /* enum */ cd FRAGMENT = new cd("FRAGMENT", 1, "fragment");
    public static final /* enum */ cd INCLUDE = new cd("INCLUDE", 2, "include");
    public static final /* enum */ cd PROGRAM = new cd("PROGRAM", 3, "program");
    public static final /* enum */ cd NONE = new cd("NONE", 4, "none");
    private final String text;
    private static final /* synthetic */ cd[] $VALUES;

    public static cd[] values() {
        return (cd[])$VALUES.clone();
    }

    public static cd valueOf(String string) {
        return Enum.valueOf(cd.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private cd() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    private static /* synthetic */ cd[] AJ() {
        return new cd[]{VERTEX, FRAGMENT, INCLUDE, PROGRAM, NONE};
    }

    static {
        $VALUES = cd.AJ();
    }
}
