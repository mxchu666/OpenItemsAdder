package itemsadder.m;

final class fs {
    private final short[] ua = new short[7];
    private final byte[] ub = new byte[7];
    private int tK;

    private fs() {
    }

    private void a(short s, byte by) {
        this.ua[this.tK] = s;
        this.ub[this.tK++] = by;
    }
}
