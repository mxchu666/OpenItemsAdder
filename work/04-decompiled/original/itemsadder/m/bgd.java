package itemsadder.m;

class bgd {
    int bK;

    bgd() {
    }

    public String toString() {
        byte[] byArray = new byte[1];
        this.bK = -904355031;
        byArray[0] = (byte)(this.bK >>> 14);
        return new String(byArray);
    }
}
