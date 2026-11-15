package itemsadder.m;

public final class ax
extends Enum {
    public static final /* enum */ ax INTERACT = new ax("INTERACT", 0, "interact");
    public static final /* enum */ ax ATTACK = new ax("ATTACK", 1, "attack");
    public static final /* enum */ ax ATTACKED = new ax("ATTACKED", 2, "attacked");
    public static final /* enum */ ax DAMAGED = new ax("DAMAGED", 3, "damaged");
    public static final /* enum */ ax DEATH = new ax("DEATH", 4, "death");
    private final String text;
    private static final /* synthetic */ ax[] $VALUES;

    public static ax[] values() {
        return (ax[])$VALUES.clone();
    }

    public static ax valueOf(String string) {
        return Enum.valueOf(ax.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ax() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    private static /* synthetic */ ax[] aQ() {
        return new ax[]{INTERACT, ATTACK, ATTACKED, DAMAGED, DEATH};
    }

    static {
        $VALUES = ax.aQ();
    }
}
