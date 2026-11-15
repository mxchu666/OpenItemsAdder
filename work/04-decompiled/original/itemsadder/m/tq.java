package itemsadder.m;

import itemsadder.m.bce;

public class tq
extends Exception {
    private final boolean KR;
    private final boolean KS;

    public tq(String string) {
        super(string);
        this.KR = false;
        this.KS = false;
    }

    public tq(String string, boolean bl, boolean bl2) {
        super(string);
        this.KR = bl;
        this.KS = bl2;
    }

    public tq(String string, boolean bl) {
        super(string);
        this.KR = bl;
        this.KS = false;
    }

    public tq(String string, Throwable throwable) {
        super(string, throwable);
        this.KR = false;
        this.KS = false;
    }

    public static void a(String string, tq tq2) {
        if (tq2.KS) {
            bce.b(string, tq2);
        } else {
            bce.error(string, tq2);
        }
    }

    public static void b(String string, tq tq2) {
        if (tq2.KS) {
            bce.iA(string);
        } else {
            bce.warn(string);
        }
    }

    public boolean qe() {
        return this.KR;
    }

    public boolean qf() {
        return this.KS;
    }
}
