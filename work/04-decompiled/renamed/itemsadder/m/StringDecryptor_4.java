package itemsadder.m;

import itemsadder.m.PluginBridge_8;

class StringDecryptor_4 {
    int bK;

    StringDecryptor_4(PluginBridge_8 pluginBridge_8) {
    }

    public String toString() {
        byte[] byArray = new byte[8];
        this.bK = -1106558534;
        byArray[0] = (byte)(this.bK >>> 2);
        this.bK = -92923543;
        byArray[1] = (byte)(this.bK >>> 6);
        this.bK = 831173574;
        byArray[2] = (byte)(this.bK >>> 3);
        this.bK = -2103768855;
        byArray[3] = (byte)(this.bK >>> 1);
        this.bK = 1285697831;
        byArray[4] = (byte)(this.bK >>> 24);
        this.bK = 538860243;
        byArray[5] = (byte)(this.bK >>> 1);
        this.bK = 1747302968;
        byArray[6] = (byte)(this.bK >>> 10);
        this.bK = 2066384013;
        byArray[7] = (byte)(this.bK >>> 19);
        return new String(byArray);
    }
}
