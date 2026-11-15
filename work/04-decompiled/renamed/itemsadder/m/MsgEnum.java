package itemsadder.m;

final class MsgEnum
extends Enum {
    public static final /* enum */ MsgEnum MSG = new MsgEnum("MSG", 0);
    public static final /* enum */ MsgEnum CANCEL = new MsgEnum("CANCEL", 1);
    public static final /* enum */ MsgEnum CREATIVE_ALLOW = new MsgEnum("CREATIVE_ALLOW", 2);
    public static final /* enum */ MsgEnum WRONG_BUT_DO_NOTHING = new MsgEnum("WRONG_BUT_DO_NOTHING", 3);
    public static final /* enum */ MsgEnum RIGHT_TOOL = new MsgEnum("RIGHT_TOOL", 4);
    private static final /* synthetic */ MsgEnum[] $VALUES;

    public static MsgEnum[] values() {
        return (MsgEnum[])$VALUES.clone();
    }

    public static MsgEnum valueOf(String string) {
        return Enum.valueOf(MsgEnum.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MsgEnum() {
        void var2_-1;
        void var1_-1;
    }

    private static /* synthetic */ MsgEnum[] lE() {
        return new MsgEnum[]{MSG, CANCEL, CREATIVE_ALLOW, WRONG_BUT_DO_NOTHING, RIGHT_TOOL};
    }

    static {
        $VALUES = MsgEnum.lE();
    }
}
