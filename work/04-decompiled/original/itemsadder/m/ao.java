package itemsadder.m;

public class ao
extends RuntimeException {
    public ao() {
    }

    public ao(String string) {
        super(string);
    }

    public ao(String string, Throwable throwable) {
        super(string, throwable);
    }

    public ao(Exception exception) {
        super(exception);
    }
}
