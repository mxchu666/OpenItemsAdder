package ia.sh.customblockdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

private static final class BlockDataListener.Utils {
    private BlockDataListener.Utils() {
    }

    private static <K, V> Map<K, V> reverse(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<K> arrayList = new ArrayList<K>(map.keySet());
        Collections.reverse(arrayList);
        arrayList.forEach(object -> linkedHashMap.put(object, map.get(object)));
        return linkedHashMap;
    }

    static /* synthetic */ Map access$000(Map map) {
        return BlockDataListener.Utils.reverse(map);
    }
}
