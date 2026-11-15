package dev.lone.itemsadder.resourcepack;

import beer.devs.fastnbt.nms.Version;

public final class i
extends Enum {
    public static final /* enum */ i v_1_21_4_to_5 = new i("v_1_21_4_to_5", 0, "ia_overlay_1_21_4_to_5", Version.v1_21_4);
    public static final /* enum */ i v_1_21_6_plus = new i("v_1_21_6_plus", 1, "ia_overlay_1_21_6_plus", Version.v1_21_6);
    public static final /* enum */ i v_26_1_plus = new i("v_26_1_plus", 2, "ia_overlay_26_1_plus", Version.v26_1_1);
    private final String overlayKey;
    private final Version baseVersion;
    private static final /* synthetic */ i[] $VALUES;

    public static i[] values() {
        return (i[])$VALUES.clone();
    }

    public static i valueOf(String string) {
        return Enum.valueOf(i.class, string);
    }

    /*
     * WARNING - void declaration
     */
    private i() {
        void var4_1;
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.overlayKey = var3_2;
        this.baseVersion = var4_1;
    }

    String mj() {
        return this.overlayKey;
    }

    private static /* synthetic */ i[] xG() {
        return new i[]{v_1_21_4_to_5, v_1_21_6_plus, v_26_1_plus};
    }

    static {
        $VALUES = i.xG();
    }
}
