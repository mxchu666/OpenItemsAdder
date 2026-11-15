package itemsadder.m;

public final class InteractEnum
extends Enum {
    public static final /* enum */ InteractEnum INTERACT = new InteractEnum("INTERACT", 0, "interact");
    public static final /* enum */ InteractEnum ATTACK = new InteractEnum("ATTACK", 1, "attack");
    public static final /* enum */ InteractEnum ATTACKED = new InteractEnum("ATTACKED", 2, "attacked");
    public static final /* enum */ InteractEnum DAMAGED = new InteractEnum("DAMAGED", 3, "damaged");
    public static final /* enum */ InteractEnum DEATH = new InteractEnum("DEATH", 4, "death");
    private final String text;
    private static final /* synthetic */ InteractEnum[] $VALUES;

    public static InteractEnum[] values() {
        return (InteractEnum[])$VALUES.clone();
    }

    public static InteractEnum valueOf(String string) {
        return Enum.valueOf(InteractEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private InteractEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
    }

    public String toString() {
        return this.text;
    }

    private static /* synthetic */ InteractEnum[] aQ() {
        return new InteractEnum[]{INTERACT, ATTACK, ATTACKED, DAMAGED, DEATH};
    }

    static {
        $VALUES = InteractEnum.aQ();
    }
}
