package itemsadder.m;

import itemsadder.m.RecordOfObject;
import itemsadder.m.ReplaceFunction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public final class Opaque008 {
    private final Map aoc = new LinkedHashMap();

    public void a(Object object, Object object2, Object object4) {
        this.aoc.compute(object, (object3, recordOfObject) -> new RecordOfObject(recordOfObject == null ? object2 : recordOfObject.aod, object4));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(Function function, ReplaceFunction replaceFunction) {
        Exception exception = null;
        ArrayList arrayList = new ArrayList(this.aoc.entrySet());
        try {
            for (int i = arrayList.size() - 1; i >= 0; --i) {
                Map.Entry entry = (Map.Entry)arrayList.get(i);
                RecordOfObject recordOfObject = (RecordOfObject)entry.getValue();
                try {
                    if (function.apply(entry.getKey()) != recordOfObject.aoe) continue;
                    replaceFunction.replace(entry.getKey(), recordOfObject.aod);
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
