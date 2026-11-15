package itemsadder.m;

import org.bukkit.Material;

public final class RealEnum
extends Enum {
    public static final /* enum */ RealEnum REAL = new RealEnum("REAL", 0, "REAL", new String[]{"brown_mushroom_block", "mushroom_stem", "red_mushroom_block"});
    public static final /* enum */ RealEnum REAL_NOTE = new RealEnum("REAL_NOTE", 1, "REAL_NOTE", new String[]{"note_block"});
    public static final /* enum */ RealEnum REAL_TRANSPARENT = new RealEnum("REAL_TRANSPARENT", 2, "REAL_TRANSPARENT", new String[]{"chorus_plant"});
    public static final /* enum */ RealEnum TILE = new RealEnum("TILE", 3, "TILE", new String[0]);
    public static final /* enum */ RealEnum REAL_WIRE = new RealEnum("REAL_WIRE", 4, "REAL_WIRE", new String[]{"tripwire"});
    public static final /* enum */ RealEnum FIRE = new RealEnum("FIRE", 5, "FIRE", new String[]{"fire"});
    public static final /* enum */ RealEnum ENTITY = new RealEnum("ENTITY", 6, "ENTITY", new String[0]);
    private final String text;
    private final String[] vanillaBlockstateNames;
    private static final /* synthetic */ RealEnum[] $VALUES;

    public static RealEnum[] values() {
        return (RealEnum[])$VALUES.clone();
    }

    public static RealEnum valueOf(String string) {
        return Enum.valueOf(RealEnum.class, string);
    }

    /*
     * WARNING - void declaration
     */
    private RealEnum() {
        void var4_1;
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.text = var3_2;
        this.vanillaBlockstateNames = var4_1;
    }

    public String toString() {
        return this.text;
    }

    public String[] pf() {
        return this.vanillaBlockstateNames;
    }

    public Material p(Material material) {
        return this == REAL_WIRE ? Material.STRING : material;
    }

    public boolean pg() {
        return this != ENTITY;
    }

    public static boolean q(Material material) {
        return material != null && material.isBlock() && material.isItem() && material.isSolid() && material.isOccluding() && !material.isInteractable() && !material.hasGravity();
    }

    private static /* synthetic */ RealEnum[] ph() {
        return new RealEnum[]{REAL, REAL_NOTE, REAL_TRANSPARENT, TILE, REAL_WIRE, FIRE, ENTITY};
    }

    static {
        $VALUES = RealEnum.ph();
    }
}
