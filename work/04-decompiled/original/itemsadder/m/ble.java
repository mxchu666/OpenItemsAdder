package itemsadder.m;

import itemsadder.m.biy;

public enum ble {
    INT((Object)0),
    LONG((Object)0L),
    FLOAT((Object)Float.valueOf(0.0f)),
    DOUBLE((Object)0.0),
    BOOLEAN((Object)false),
    STRING((Object)""),
    BYTE_STRING((Object)biy.aEJ),
    ENUM(null),
    MESSAGE(null);

    private final Object defaultDefault;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ble() {
        void var3_2;
        this.defaultDefault = var3_2;
    }

    Object GC() {
        return this.defaultDefault;
    }
}
