package itemsadder.m;

import itemsadder.m.WaitingEnum;
import java.util.concurrent.atomic.AtomicInteger;

public class Opaque053 {
    private final AtomicInteger aDd = new AtomicInteger();

    public boolean Eo() {
        int n = this.aDd.getAndDecrement();
        if (n == WaitingEnum.RUNNING_GOT_TASKS.ordinal()) {
            return true;
        }
        if (n == WaitingEnum.RUNNING_NO_TASKS.ordinal()) {
            return false;
        }
        throw new AssertionError();
    }

    public boolean Ep() {
        if (this.aDd.get() == WaitingEnum.RUNNING_GOT_TASKS.ordinal()) {
            return false;
        }
        int n = this.aDd.getAndSet(WaitingEnum.RUNNING_GOT_TASKS.ordinal());
        return n == WaitingEnum.WAITING.ordinal();
    }
}
