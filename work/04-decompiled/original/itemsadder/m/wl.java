package itemsadder.m;

public class wl {
    long NR;
    final String[] NS;
    final Throwable NT;

    public wl(long l) {
        this.NR = l;
        this.NT = null;
        this.NS = null;
    }

    public wl(long l, String[] stringArray) {
        this.NT = null;
        this.NR = l;
        this.NS = stringArray;
    }

    public wl(long l, Throwable throwable) {
        this.NT = throwable;
        this.NR = l;
        this.NS = null;
    }

    public long rE() {
        return this.NR;
    }

    public Throwable rF() {
        return this.NT;
    }

    public String[] rG() {
        return this.NS;
    }

    public boolean rH() {
        return this.NS != null || this.NT != null;
    }
}
