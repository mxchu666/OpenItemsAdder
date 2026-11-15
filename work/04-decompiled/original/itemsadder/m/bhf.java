package itemsadder.m;

class bhf {
    int bK;

    bhf() {
    }

    public String toString() {
        byte[] byArray = new byte[10];
        this.bK = 353154566;
        byArray[0] = (byte)(this.bK >>> 7);
        this.bK = 2032259494;
        byArray[1] = (byte)(this.bK >>> 2);
        this.bK = -1554058824;
        byArray[2] = (byte)(this.bK >>> 2);
        this.bK = -763521414;
        byArray[3] = (byte)(this.bK >>> 10);
        this.bK = -1627526856;
        byArray[4] = (byte)(this.bK >>> 2);
        this.bK = -1364596157;
        byArray[5] = (byte)(this.bK >>> 21);
        this.bK = 1572238111;
        byArray[6] = (byte)(this.bK >>> 18);
        this.bK = 784604510;
        byArray[7] = (byte)(this.bK >>> 17);
        this.bK = -1604953452;
        byArray[8] = (byte)(this.bK >>> 12);
        this.bK = -2038531637;
        byArray[9] = (byte)(this.bK >>> 2);
        return new String(byArray);
    }
}
