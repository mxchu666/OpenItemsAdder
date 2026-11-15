package itemsadder.m;

import org.jetbrains.annotations.Nullable;

public final class dw
extends Enum {
    public static final /* enum */ dw OTHER = new dw("OTHER", 0, "other");
    public static final /* enum */ dw IDLE = new dw("IDLE", 1, "idle");
    public static final /* enum */ dw IDLE_ANGRY = new dw("IDLE_ANGRY", 2, "idle_angry");
    public static final /* enum */ dw WALK = new dw("WALK", 3, "walk");
    public static final /* enum */ dw WALK_ANGRY = new dw("WALK_ANGRY", 4, "walk_angry");
    public static final /* enum */ dw JUMP = new dw("JUMP", 5, "jump");
    public static final /* enum */ dw ATTACK = new dw("ATTACK", 6, "attack");
    public static final /* enum */ dw DEATH = new dw("DEATH", 7, "death");
    public static final /* enum */ dw FLY = new dw("FLY", 8, "fly");
    public static final /* enum */ dw SNEAK = new dw("SNEAK", 9, "sneak");
    public static final /* enum */ dw SNEAK_WALK = new dw("SNEAK_WALK", 10, "sneak_walk");
    private final String str;
    private static final /* synthetic */ dw[] $VALUES;

    public static dw[] values() {
        return (dw[])$VALUES.clone();
    }

    public static dw valueOf(String string) {
        return Enum.valueOf(dw.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private dw() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.str = var3_2;
    }

    public static dw aA(@Nullable String string) {
        if (string == null) {
            return OTHER;
        }
        for (dw dw2 : dw.values()) {
            if (!dw2.str.equals(string)) continue;
            return dw2;
        }
        return OTHER;
    }

    public String toString() {
        return this.str;
    }

    private static /* synthetic */ dw[] fS() {
        return new dw[]{OTHER, IDLE, IDLE_ANGRY, WALK, WALK_ANGRY, JUMP, ATTACK, DEATH, FLY, SNEAK, SNEAK_WALK};
    }

    static {
        $VALUES = dw.fS();
    }
}
