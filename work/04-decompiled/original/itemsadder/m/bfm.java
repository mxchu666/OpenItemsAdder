package itemsadder.m;

import itemsadder.m.bfn;
import java.util.concurrent.atomic.AtomicInteger;

public class bfm {
    private final AtomicInteger aDd = new AtomicInteger();

    public boolean Eo() {
        int n = this.aDd.getAndDecrement();
        if (n == bfn.RUNNING_GOT_TASKS.ordinal()) {
            return true;
        }
        if (n == bfn.RUNNING_NO_TASKS.ordinal()) {
            return false;
        }
        throw new AssertionError();
    }

    public boolean Ep() {
        if (this.aDd.get() == bfn.RUNNING_GOT_TASKS.ordinal()) {
            return false;
        }
        int n = this.aDd.getAndSet(bfn.RUNNING_GOT_TASKS.ordinal());
        return n == bfn.WAITING.ordinal();
    }
}
