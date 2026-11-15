package itemsadder.m;

public final class MonsterEnum
extends Enum {
    public static final /* enum */ MonsterEnum MONSTER = new MonsterEnum("MONSTER", 0);
    public static final /* enum */ MonsterEnum CREATURE = new MonsterEnum("CREATURE", 1);
    public static final /* enum */ MonsterEnum AMBIENT = new MonsterEnum("AMBIENT", 2);
    public static final /* enum */ MonsterEnum AXOLOTLS = new MonsterEnum("AXOLOTLS", 3);
    public static final /* enum */ MonsterEnum UNDERGROUND_WATER_CREATURE = new MonsterEnum("UNDERGROUND_WATER_CREATURE", 4);
    public static final /* enum */ MonsterEnum WATER_CREATURE = new MonsterEnum("WATER_CREATURE", 5);
    public static final /* enum */ MonsterEnum WATER_AMBIENT = new MonsterEnum("WATER_AMBIENT", 6);
    public static final /* enum */ MonsterEnum MISC = new MonsterEnum("MISC", 7);
    private static final /* synthetic */ MonsterEnum[] $VALUES;

    public static MonsterEnum[] values() {
        return (MonsterEnum[])$VALUES.clone();
    }

    public static MonsterEnum valueOf(String string) {
        return Enum.valueOf(MonsterEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MonsterEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ MonsterEnum[] tL() {
        return new MonsterEnum[]{MONSTER, CREATURE, AMBIENT, AXOLOTLS, UNDERGROUND_WATER_CREATURE, WATER_CREATURE, WATER_AMBIENT, MISC};
    }

    static {
        $VALUES = MonsterEnum.tL();
    }
}
