package itemsadder.m;

class StringDecryptor_35 {
    int bK;

    StringDecryptor_35() {
    }

    public String toString() {
        byte[] byArray = new byte[20];
        this.bK = 837970175;
        byArray[0] = (byte)(this.bK >>> 23);
        this.bK = -1686145436;
        byArray[1] = (byte)(this.bK >>> 19);
        this.bK = 229612365;
        byArray[2] = (byte)(this.bK >>> 6);
        this.bK = -1849305844;
        byArray[3] = (byte)(this.bK >>> 13);
        this.bK = 115713651;
        byArray[4] = (byte)(this.bK >>> 17);
        this.bK = 734678411;
        byArray[5] = (byte)(this.bK >>> 19);
        this.bK = -308747962;
        byArray[6] = (byte)(this.bK >>> 21);
        this.bK = 13855158;
        byArray[7] = (byte)(this.bK >>> 17);
        this.bK = -2083667564;
        byArray[8] = (byte)(this.bK >>> 13);
        this.bK = -242121447;
        byArray[9] = (byte)(this.bK >>> 10);
        this.bK = 532950711;
        byArray[10] = (byte)(this.bK >>> 5);
        this.bK = -1457800077;
        byArray[11] = (byte)(this.bK >>> 7);
        this.bK = 401682158;
        byArray[12] = (byte)(this.bK >>> 8);
        this.bK = 55165540;
        byArray[13] = (byte)(this.bK >>> 10);
        this.bK = -5755511;
        byArray[14] = (byte)(this.bK >>> 5);
        this.bK = -957679516;
        byArray[15] = (byte)(this.bK >>> 17);
        this.bK = 377444131;
        byArray[16] = (byte)(this.bK >>> 20);
        this.bK = 527280887;
        byArray[17] = (byte)(this.bK >>> 13);
        this.bK = -1117769546;
        byArray[18] = (byte)(this.bK >>> 7);
        this.bK = 1726300602;
        byArray[19] = (byte)(this.bK >>> 2);
        return new String(byArray);
    }
}
