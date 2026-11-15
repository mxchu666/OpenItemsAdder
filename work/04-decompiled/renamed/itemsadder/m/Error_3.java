package itemsadder.m;

import itemsadder.m.CommandSenderBridge_5;

public class Error_3
extends Exception {
    private final boolean KR;
    private final boolean KS;

    public Error_3(String string) {
        super(string);
        this.KR = false;
        this.KS = false;
    }

    public Error_3(String string, boolean bl, boolean bl2) {
        super(string);
        this.KR = bl;
        this.KS = bl2;
    }

    public Error_3(String string, boolean bl) {
        super(string);
        this.KR = bl;
        this.KS = false;
    }

    public Error_3(String string, Throwable throwable) {
        super(string, throwable);
        this.KR = false;
        this.KS = false;
    }

    public static void a(String string, Error_3 error_3) {
        if (error_3.KS) {
            CommandSenderBridge_5.b(string, error_3);
        } else {
            CommandSenderBridge_5.error(string, error_3);
        }
    }

    public static void b(String string, Error_3 error_3) {
        if (error_3.KS) {
            CommandSenderBridge_5.iA(string);
        } else {
            CommandSenderBridge_5.warn(string);
        }
    }

    public boolean qe() {
        return this.KR;
    }

    public boolean qf() {
        return this.KS;
    }
}
