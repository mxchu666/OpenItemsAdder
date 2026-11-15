package itemsadder.m;

class StringDecryptor_36 {
    int bK;

    StringDecryptor_36() {
    }

    public String toString() {
        byte[] byArray = new byte[14];
        this.bK = 1097094725;
        byArray[0] = (byte)(this.bK >>> 4);
        this.bK = 1697619257;
        byArray[1] = (byte)(this.bK >>> 24);
        this.bK = -1725013055;
        byArray[2] = (byte)(this.bK >>> 8);
        this.bK = 875296458;
        byArray[3] = (byte)(this.bK >>> 4);
        this.bK = -860682102;
        byArray[4] = (byte)(this.bK >>> 11);
        this.bK = -1639502620;
        byArray[5] = (byte)(this.bK >>> 12);
        this.bK = 241775858;
        byArray[6] = (byte)(this.bK >>> 16);
        this.bK = 1861980950;
        byArray[7] = (byte)(this.bK >>> 24);
        this.bK = -883163953;
        byArray[8] = (byte)(this.bK >>> 1);
        this.bK = -1580788376;
        byArray[9] = (byte)(this.bK >>> 23);
        this.bK = 1301993583;
        byArray[10] = (byte)(this.bK >>> 21);
        this.bK = -89169489;
        byArray[11] = (byte)(this.bK >>> 8);
        this.bK = -1279837954;
        byArray[12] = (byte)(this.bK >>> 12);
        this.bK = 1187105854;
        byArray[13] = (byte)(this.bK >>> 10);
        return new String(byArray);
    }
}
