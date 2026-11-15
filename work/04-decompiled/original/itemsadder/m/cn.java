package itemsadder.m;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

final class cn
implements ThreadFactory {
    private final String kJ;
    private final AtomicInteger kK = new AtomicInteger();

    cn(String string) {
        this.kJ = string;
    }

    @Override
    public Thread newThread(@NotNull Runnable runnable) {
        Thread thread = new Thread(runnable, this.kJ + "-" + this.kK.incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
