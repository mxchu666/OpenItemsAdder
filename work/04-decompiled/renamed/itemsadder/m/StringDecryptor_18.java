package itemsadder.m;

import itemsadder.m.PluginBridge_8;

class StringDecryptor_18 {
    int bK;

    StringDecryptor_18(PluginBridge_8 pluginBridge_8) {
    }

    public String toString() {
        byte[] byArray = new byte[9];
        this.bK = -21665862;
        byArray[0] = (byte)(this.bK >>> 8);
        this.bK = 935342742;
        byArray[1] = (byte)(this.bK >>> 7);
        this.bK = 1775337482;
        byArray[2] = (byte)(this.bK >>> 18);
        this.bK = -1417341618;
        byArray[3] = (byte)(this.bK >>> 2);
        this.bK = -601806039;
        byArray[4] = (byte)(this.bK >>> 3);
        this.bK = 112577190;
        byArray[5] = (byte)(this.bK >>> 10);
        this.bK = 993906467;
        byArray[6] = (byte)(this.bK >>> 23);
        this.bK = 1497714380;
        byArray[7] = (byte)(this.bK >>> 22);
        this.bK = -130478731;
        byArray[8] = (byte)(this.bK >>> 15);
        return new String(byArray);
    }
}
