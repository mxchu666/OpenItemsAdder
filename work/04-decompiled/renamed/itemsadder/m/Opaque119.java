package itemsadder.m;

import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class Opaque119 {
    private final Map ta = new ConcurrentHashMap();

    Opaque119() {
    }

    void a(UUID uUID2, long l2, Object object) {
        this.ta.computeIfAbsent(uUID2, uUID -> new ConcurrentHashMap()).computeIfAbsent(l2, l -> ConcurrentHashMap.newKeySet()).add(object);
    }

    void b(UUID uUID, long l2, Object object) {
        ConcurrentMap concurrentMap = (ConcurrentMap)this.ta.get(uUID);
        if (concurrentMap != null) {
            concurrentMap.computeIfPresent(l2, (l, set) -> {
                set.remove(object);
                return set.isEmpty() ? null : set;
            });
        }
    }

    Set a(UUID uUID, long l) {
        Map map = (Map)this.ta.get(uUID);
        return map == null ? Set.of() : map.getOrDefault(l, Set.of());
    }

    void clear() {
        this.ta.clear();
    }
}
