package itemsadder.m;

import itemsadder.m.PluginBridge_8;

class StringDecryptor_20 {
    int bK;

    StringDecryptor_20(PluginBridge_8 pluginBridge_8) {
    }

    public String toString() {
        byte[] byArray = new byte[13];
        this.bK = -916903667;
        byArray[0] = (byte)(this.bK >>> 14);
        this.bK = 139965626;
        byArray[1] = (byte)(this.bK >>> 7);
        this.bK = -1779115802;
        byArray[2] = (byte)(this.bK >>> 1);
        this.bK = 271266181;
        byArray[3] = (byte)(this.bK >>> 2);
        this.bK = 1656861403;
        byArray[4] = (byte)(this.bK >>> 24);
        this.bK = 365795156;
        byArray[5] = (byte)(this.bK >>> 13);
        this.bK = 424289401;
        byArray[6] = (byte)(this.bK >>> 22);
        this.bK = -635278015;
        byArray[7] = (byte)(this.bK >>> 2);
        this.bK = 1374869702;
        byArray[8] = (byte)(this.bK >>> 9);
        this.bK = -1002919465;
        byArray[9] = (byte)(this.bK >>> 2);
        this.bK = -1444515113;
        byArray[10] = (byte)(this.bK >>> 12);
        this.bK = 834065406;
        byArray[11] = (byte)(this.bK >>> 9);
        this.bK = -283698758;
        byArray[12] = (byte)(this.bK >>> 2);
        return new String(byArray);
    }
}
