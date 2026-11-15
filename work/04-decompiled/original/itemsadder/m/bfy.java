package itemsadder.m;

class bfy {
    int bK;

    bfy() {
    }

    public String toString() {
        byte[] byArray = new byte[10];
        this.bK = 1831312202;
        byArray[0] = (byte)(this.bK >>> 24);
        this.bK = 1395445431;
        byArray[1] = (byte)(this.bK >>> 19);
        this.bK = -1690066039;
        byArray[2] = (byte)(this.bK >>> 11);
        this.bK = 341458873;
        byArray[3] = (byte)(this.bK >>> 14);
        this.bK = 156121057;
        byArray[4] = (byte)(this.bK >>> 7);
        this.bK = 1319313769;
        byArray[5] = (byte)(this.bK >>> 11);
        this.bK = 73574876;
        byArray[6] = (byte)(this.bK >>> 5);
        this.bK = -814344700;
        byArray[7] = (byte)(this.bK >>> 12);
        this.bK = 1556757354;
        byArray[8] = (byte)(this.bK >>> 3);
        this.bK = -323948345;
        byArray[9] = (byte)(this.bK >>> 21);
        return new String(byArray);
    }
}
