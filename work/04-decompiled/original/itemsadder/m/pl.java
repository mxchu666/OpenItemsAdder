package itemsadder.m;

final class pl {
    final String Ep;
    int Eq;
    int Er;
    double Es;

    pl(String string) {
        this.Ep = string;
    }

    int a(int n, double d) {
        double d2 = (double)n * d + this.Es;
        int n2 = Math.max(0, (int)Math.floor(d2));
        this.Es = d2 - (double)n2;
        return n2;
    }
}
