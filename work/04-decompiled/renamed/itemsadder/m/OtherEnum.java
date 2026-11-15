package itemsadder.m;

import org.jetbrains.annotations.Nullable;

public final class OtherEnum
extends Enum {
    public static final /* enum */ OtherEnum OTHER = new OtherEnum("OTHER", 0, "other");
    public static final /* enum */ OtherEnum IDLE = new OtherEnum("IDLE", 1, "idle");
    public static final /* enum */ OtherEnum IDLE_ANGRY = new OtherEnum("IDLE_ANGRY", 2, "idle_angry");
    public static final /* enum */ OtherEnum WALK = new OtherEnum("WALK", 3, "walk");
    public static final /* enum */ OtherEnum WALK_ANGRY = new OtherEnum("WALK_ANGRY", 4, "walk_angry");
    public static final /* enum */ OtherEnum JUMP = new OtherEnum("JUMP", 5, "jump");
    public static final /* enum */ OtherEnum ATTACK = new OtherEnum("ATTACK", 6, "attack");
    public static final /* enum */ OtherEnum DEATH = new OtherEnum("DEATH", 7, "death");
    public static final /* enum */ OtherEnum FLY = new OtherEnum("FLY", 8, "fly");
    public static final /* enum */ OtherEnum SNEAK = new OtherEnum("SNEAK", 9, "sneak");
    public static final /* enum */ OtherEnum SNEAK_WALK = new OtherEnum("SNEAK_WALK", 10, "sneak_walk");
    private final String str;
    private static final /* synthetic */ OtherEnum[] $VALUES;

    public static OtherEnum[] values() {
        return (OtherEnum[])$VALUES.clone();
    }

    public static OtherEnum valueOf(String string) {
        return Enum.valueOf(OtherEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OtherEnum() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.str = var3_2;
    }

    public static OtherEnum aA(@Nullable String string) {
        if (string == null) {
            return OTHER;
        }
        for (OtherEnum otherEnum : OtherEnum.values()) {
            if (!otherEnum.str.equals(string)) continue;
            return otherEnum;
        }
        return OTHER;
    }

    public String toString() {
        return this.str;
    }

    private static /* synthetic */ OtherEnum[] fS() {
        return new OtherEnum[]{OTHER, IDLE, IDLE_ANGRY, WALK, WALK_ANGRY, JUMP, ATTACK, DEATH, FLY, SNEAK, SNEAK_WALK};
    }

    static {
        $VALUES = OtherEnum.fS();
    }
}
