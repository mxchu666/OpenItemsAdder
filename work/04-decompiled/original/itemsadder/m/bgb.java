package itemsadder.m;

class bgb {
    int bK;

    bgb() {
    }

    public String toString() {
        byte[] byArray = new byte[3];
        this.bK = -684355423;
        byArray[0] = (byte)(this.bK >>> 10);
        this.bK = -740772264;
        byArray[1] = (byte)(this.bK >>> 4);
        this.bK = -266487770;
        byArray[2] = (byte)(this.bK >>> 14);
        return new String(byArray);
    }
}
