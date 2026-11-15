package itemsadder.m;

public class RuntimeError
extends RuntimeException {
    public RuntimeError() {
    }

    public RuntimeError(String string) {
        super(string);
    }

    public RuntimeError(String string, Throwable throwable) {
        super(string, throwable);
    }

    public RuntimeError(Exception exception) {
        super(exception);
    }
}
