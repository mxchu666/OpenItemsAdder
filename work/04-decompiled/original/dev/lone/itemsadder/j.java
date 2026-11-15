package dev.lone.itemsadder;

import dev.lone.itemsadder.l;
import dev.lone.itemsadder.m;
import java.util.function.BiConsumer;

public abstract class j {
    private final String Qa;

    protected j(String string) {
        if (string == null) {
            throw new IllegalArgumentException("chartId must not be null");
        }
        this.Qa = string;
    }

    public m a(BiConsumer biConsumer, boolean bl) {
        l l2 = new l();
        l2.x("chartId", this.Qa);
        try {
            m m2 = this.sd();
            if (m2 == null) {
                return null;
            }
            l2.a("data", m2);
        }
        catch (Throwable throwable) {
            if (bl) {
                biConsumer.accept("Failed to get data for custom chart with id " + this.Qa, throwable);
            }
            return null;
        }
        return l2.se();
    }

    protected abstract m sd();
}
