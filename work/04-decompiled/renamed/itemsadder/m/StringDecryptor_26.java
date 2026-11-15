package itemsadder.m;

import itemsadder.m.PluginBridge_8;

class StringDecryptor_26 {
    int bK;

    StringDecryptor_26(PluginBridge_8 pluginBridge_8) {
    }

    public String toString() {
        byte[] byArray = new byte[17];
        this.bK = 648534103;
        byArray[0] = (byte)(this.bK >>> 20);
        this.bK = 1642096153;
        byArray[1] = (byte)(this.bK >>> 4);
        this.bK = 377205584;
        byArray[2] = (byte)(this.bK >>> 11);
        this.bK = 281280237;
        byArray[3] = (byte)(this.bK >>> 17);
        this.bK = -1568794256;
        byArray[4] = (byte)(this.bK >>> 3);
        this.bK = -444211897;
        byArray[5] = (byte)(this.bK >>> 6);
        this.bK = -1541382907;
        byArray[6] = (byte)(this.bK >>> 6);
        this.bK = 436640220;
        byArray[7] = (byte)(this.bK >>> 12);
        this.bK = -1663511283;
        byArray[8] = (byte)(this.bK >>> 17);
        this.bK = 1154550692;
        byArray[9] = (byte)(this.bK >>> 6);
        this.bK = 1423789329;
        byArray[10] = (byte)(this.bK >>> 10);
        this.bK = -81873967;
        byArray[11] = (byte)(this.bK >>> 19);
        this.bK = 204815842;
        byArray[12] = (byte)(this.bK >>> 21);
        this.bK = -873407326;
        byArray[13] = (byte)(this.bK >>> 9);
        this.bK = 433822274;
        byArray[14] = (byte)(this.bK >>> 14);
        this.bK = -698409352;
        byArray[15] = (byte)(this.bK >>> 20);
        this.bK = 1927437078;
        byArray[16] = (byte)(this.bK >>> 24);
        return new String(byArray);
    }
}
