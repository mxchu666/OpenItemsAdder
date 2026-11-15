package itemsadder.m;

import java.io.IOException;

public class IOError
extends IOException {
    private static final long serialVersionUID = 3969366848110070516L;

    public IOError() {
    }

    public IOError(String string) {
        super(string);
    }

    public IOError(String string, Throwable throwable) {
        super(string, throwable);
    }

    public IOError(Throwable throwable) {
        super(throwable);
    }
}
