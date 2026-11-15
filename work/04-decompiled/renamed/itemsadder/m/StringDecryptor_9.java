package itemsadder.m;

class StringDecryptor_9 {
    int bK;

    StringDecryptor_9() {
    }

    public String toString() {
        byte[] byArray = new byte[8];
        this.bK = -1290168256;
        byArray[0] = (byte)(this.bK >>> 23);
        this.bK = 882585603;
        byArray[1] = (byte)(this.bK >>> 23);
        this.bK = -1759813049;
        byArray[2] = (byte)(this.bK >>> 11);
        this.bK = -1056756502;
        byArray[3] = (byte)(this.bK >>> 11);
        this.bK = 221848139;
        byArray[4] = (byte)(this.bK >>> 18);
        this.bK = -423457882;
        byArray[5] = (byte)(this.bK >>> 17);
        this.bK = -615199218;
        byArray[6] = (byte)(this.bK >>> 22);
        this.bK = 3642159;
        byArray[7] = (byte)(this.bK >>> 3);
        return new String(byArray);
    }
}
