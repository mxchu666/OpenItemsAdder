package itemsadder.m;

public final class AirEnum
extends Enum {
    public static final /* enum */ AirEnum AIR = new AirEnum("AIR", 0);
    public static final /* enum */ AirEnum STRUCTURE_VOID = new AirEnum("STRUCTURE_VOID", 1);
    public static final /* enum */ AirEnum PORTAL = new AirEnum("PORTAL", 2);
    public static final /* enum */ AirEnum WOOL = new AirEnum("WOOL", 3);
    public static final /* enum */ AirEnum PLANT = new AirEnum("PLANT", 4);
    public static final /* enum */ AirEnum WATER_PLANT = new AirEnum("WATER_PLANT", 5);
    public static final /* enum */ AirEnum REPLACEABLE_PLANT = new AirEnum("REPLACEABLE_PLANT", 6);
    public static final /* enum */ AirEnum h = new AirEnum("h", 7);
    public static final /* enum */ AirEnum REPLACEABLE_WATER_PLANT = new AirEnum("REPLACEABLE_WATER_PLANT", 8);
    public static final /* enum */ AirEnum WATER = new AirEnum("WATER", 9);
    public static final /* enum */ AirEnum BUBBLE_COLUMN = new AirEnum("BUBBLE_COLUMN", 10);
    public static final /* enum */ AirEnum LAVA = new AirEnum("LAVA", 11);
    public static final /* enum */ AirEnum PACKED_ICE = new AirEnum("PACKED_ICE", 12);
    public static final /* enum */ AirEnum FIRE = new AirEnum("FIRE", 13);
    public static final /* enum */ AirEnum ORIENTABLE = new AirEnum("ORIENTABLE", 14);
    public static final /* enum */ AirEnum WEB = new AirEnum("WEB", 15);
    public static final /* enum */ AirEnum BUILDABLE_GLASS = new AirEnum("BUILDABLE_GLASS", 16);
    public static final /* enum */ AirEnum CLAY = new AirEnum("CLAY", 17);
    public static final /* enum */ AirEnum EARTH = new AirEnum("EARTH", 18);
    public static final /* enum */ AirEnum GRASS = new AirEnum("GRASS", 19);
    public static final /* enum */ AirEnum SNOW_LAYER = new AirEnum("SNOW_LAYER", 20);
    public static final /* enum */ AirEnum SAND = new AirEnum("SAND", 21);
    public static final /* enum */ AirEnum SPONGE = new AirEnum("SPONGE", 22);
    public static final /* enum */ AirEnum SHULKER_SHELL = new AirEnum("SHULKER_SHELL", 23);
    public static final /* enum */ AirEnum WOOD = new AirEnum("WOOD", 24);
    public static final /* enum */ AirEnum NETHER_WOOD = new AirEnum("NETHER_WOOD", 25);
    public static final /* enum */ AirEnum BAMBOO_SAPLING = new AirEnum("BAMBOO_SAPLING", 26);
    public static final /* enum */ AirEnum BAMBOO = new AirEnum("BAMBOO", 27);
    public static final /* enum */ AirEnum CLOTH = new AirEnum("CLOTH", 28);
    public static final /* enum */ AirEnum TNT = new AirEnum("TNT", 29);
    public static final /* enum */ AirEnum LEAVES = new AirEnum("LEAVES", 30);
    public static final /* enum */ AirEnum SHATTERABLE = new AirEnum("SHATTERABLE", 31);
    public static final /* enum */ AirEnum ICE = new AirEnum("ICE", 32);
    public static final /* enum */ AirEnum CACTUS = new AirEnum("CACTUS", 33);
    public static final /* enum */ AirEnum STONE = new AirEnum("STONE", 34);
    public static final /* enum */ AirEnum ORE = new AirEnum("ORE", 35);
    public static final /* enum */ AirEnum SNOW_BLOCK = new AirEnum("SNOW_BLOCK", 36);
    public static final /* enum */ AirEnum HEAVY = new AirEnum("HEAVY", 37);
    public static final /* enum */ AirEnum BANNER = new AirEnum("BANNER", 38);
    public static final /* enum */ AirEnum PISTON = new AirEnum("PISTON", 39);
    public static final /* enum */ AirEnum CORAL = new AirEnum("CORAL", 40);
    public static final /* enum */ AirEnum PUMPKIN = new AirEnum("PUMPKIN", 41);
    public static final /* enum */ AirEnum DRAGON_EGG = new AirEnum("DRAGON_EGG", 42);
    public static final /* enum */ AirEnum CAKE = new AirEnum("CAKE", 43);
    private static final /* synthetic */ AirEnum[] $VALUES;

    public static AirEnum[] values() {
        return (AirEnum[])$VALUES.clone();
    }

    public static AirEnum valueOf(String string) {
        return Enum.valueOf(AirEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AirEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ AirEnum[] ti() {
        return new AirEnum[]{AIR, STRUCTURE_VOID, PORTAL, WOOL, PLANT, WATER_PLANT, REPLACEABLE_PLANT, h, REPLACEABLE_WATER_PLANT, WATER, BUBBLE_COLUMN, LAVA, PACKED_ICE, FIRE, ORIENTABLE, WEB, BUILDABLE_GLASS, CLAY, EARTH, GRASS, SNOW_LAYER, SAND, SPONGE, SHULKER_SHELL, WOOD, NETHER_WOOD, BAMBOO_SAPLING, BAMBOO, CLOTH, TNT, LEAVES, SHATTERABLE, ICE, CACTUS, STONE, ORE, SNOW_BLOCK, HEAVY, BANNER, PISTON, CORAL, PUMPKIN, DRAGON_EGG, CAKE};
    }

    static {
        $VALUES = AirEnum.ti();
    }
}
