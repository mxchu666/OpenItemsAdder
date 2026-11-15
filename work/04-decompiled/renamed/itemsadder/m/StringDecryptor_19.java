package itemsadder.m;

import itemsadder.m.PluginBridge_8;

class StringDecryptor_19 {
    int bK;

    StringDecryptor_19(PluginBridge_8 pluginBridge_8) {
    }

    public String toString() {
        byte[] byArray = new byte[16];
        this.bK = 2104291878;
        byArray[0] = (byte)(this.bK >>> 13);
        this.bK = -1716079986;
        byArray[1] = (byte)(this.bK >>> 7);
        this.bK = 172300104;
        byArray[2] = (byte)(this.bK >>> 4);
        this.bK = -720795771;
        byArray[3] = (byte)(this.bK >>> 20);
        this.bK = -13933188;
        byArray[4] = (byte)(this.bK >>> 11);
        this.bK = -812263824;
        byArray[5] = (byte)(this.bK >>> 10);
        this.bK = 217947450;
        byArray[6] = (byte)(this.bK >>> 21);
        this.bK = 213660842;
        byArray[7] = (byte)(this.bK >>> 7);
        this.bK = 939975566;
        byArray[8] = (byte)(this.bK >>> 12);
        this.bK = 2105494917;
        byArray[9] = (byte)(this.bK >>> 8);
        this.bK = -570007141;
        byArray[10] = (byte)(this.bK >>> 8);
        this.bK = 1567547645;
        byArray[11] = (byte)(this.bK >>> 16);
        this.bK = -217434811;
        byArray[12] = (byte)(this.bK >>> 19);
        this.bK = -751246032;
        byArray[13] = (byte)(this.bK >>> 19);
        this.bK = -1248245825;
        byArray[14] = (byte)(this.bK >>> 14);
        this.bK = -416791027;
        byArray[15] = (byte)(this.bK >>> 20);
        return new String(byArray);
    }
}
