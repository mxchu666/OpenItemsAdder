package itemsadder.m;

public class bdq {
    long aBD = System.nanoTime();
    long aBE = System.nanoTime();
    long aBF;

    public void init() {
        this.aBD = System.nanoTime();
        this.aBE = System.nanoTime();
    }

    public long DJ() {
        long l = this.m(this.aBD);
        this.aBE = System.nanoTime();
        return l;
    }

    public long DK() {
        long l = this.m(this.aBE);
        this.aBE = System.nanoTime();
        return l;
    }

    long m(long l) {
        return (System.nanoTime() - l) / 1000000L;
    }

    public static long DL() {
        return System.nanoTime();
    }

    public void save() {
        this.aBF = this.DJ();
    }

    public long DM() {
        return this.aBF;
    }
}
