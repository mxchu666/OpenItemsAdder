package itemsadder.m;

import itemsadder.m.awe;
import itemsadder.m.awf;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public final class awd {
    private final Map aoc = new LinkedHashMap();

    public void a(Object object, Object object2, Object object4) {
        this.aoc.compute(object, (object3, awf2) -> new awf(awf2 == null ? object2 : awf2.aod, object4));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Function function, awe awe2) {
        Exception exception = null;
        ArrayList arrayList = new ArrayList(this.aoc.entrySet());
        try {
            for (int i = arrayList.size() - 1; i >= 0; --i) {
                Map.Entry entry = (Map.Entry)arrayList.get(i);
                awf awf2 = (awf)entry.getValue();
                try {
                    if (function.apply(entry.getKey()) != awf2.aoe) continue;
                    awe2.replace(entry.getKey(), awf2.aod);
                    continue;
                }
                catch (Exception exception2) {
                    if (exception == null) {
                        exception = exception2;
                        continue;
                    }
                    exception.addSuppressed(exception2);
                }
            }
        }
        finally {
            this.aoc.clear();
        }
        if (exception != null) {
            throw exception;
        }
    }

    public void clear() {
        this.aoc.clear();
    }
}
