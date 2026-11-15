package itemsadder.m;

class vn {
    public long Nb = System.currentTimeMillis();

    public boolean rs() {
        return System.currentTimeMillis() - this.Nb < 50L;
    }
}
