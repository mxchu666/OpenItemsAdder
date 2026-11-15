package itemsadder.m;

public final class EntityAndBlockEnum
extends Enum {
    public static final /* enum */ EntityAndBlockEnum ENTITY_AND_BLOCK = new EntityAndBlockEnum("ENTITY_AND_BLOCK", 0, "ENTITY_AND_BLOCK", 0);
    public static final /* enum */ EntityAndBlockEnum ENTITY = new EntityAndBlockEnum("ENTITY", 1, "ENTITY", 1);
    public static final /* enum */ EntityAndBlockEnum BLOCK = new EntityAndBlockEnum("BLOCK", 2, "BLOCK", 2);
    private static final /* synthetic */ EntityAndBlockEnum[] $VALUES;

    public static EntityAndBlockEnum[] values() {
        return (EntityAndBlockEnum[])$VALUES.clone();
    }

    public static EntityAndBlockEnum valueOf(String string) {
        return Enum.valueOf(EntityAndBlockEnum.class, string);
    }

    private static /* synthetic */ EntityAndBlockEnum[] EL() {
        return new EntityAndBlockEnum[]{ENTITY_AND_BLOCK, ENTITY, BLOCK};
    }

    static {
        $VALUES = EntityAndBlockEnum.EL();
    }
}
