package itemsadder.m;

import itemsadder.m.bco;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.jetbrains.annotations.Nullable;

public class bcn {
    public static void a(HashMap hashMap, Object object) {
        hashMap.merge(object, 1, Integer::sum);
    }

    public static Object a(HashMap hashMap, Object object2, Object object3, Function function) {
        return hashMap.computeIfAbsent(object2, object -> new HashMap()).computeIfAbsent(object3, function);
    }

    public static String[] l(String ... stringArray) {
        return stringArray;
    }

    @SafeVarargs
    public static List a(Object ... objectArray) {
        return Arrays.asList(objectArray);
    }

    @SafeVarargs
    public static List b(Object ... objectArray) {
        return new ArrayList<Object>(Arrays.asList(objectArray));
    }

    public static List a(boolean ... blArray) {
        return new ArrayList(bcn.b(blArray));
    }

    @SafeVarargs
    public static List a(boolean bl, Object ... objectArray) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object : objectArray) {
            if (object == null) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    public static List b(List arrayList, Object object) {
        if (arrayList == null) {
            arrayList = new ArrayList<Object>();
        }
        arrayList.add(object);
        return arrayList;
    }

    public static boolean c(List list, Object object) {
        if (list == null) {
            return false;
        }
        return list.contains(object);
    }

    @Nullable
    public static Object b(Map map, Object object) {
        for (Map.Entry entry : map.entrySet()) {
            if (!entry.getValue().equals(object)) continue;
            return entry.getKey();
        }
        return null;
    }

    public static boolean a(Object object, bco bco2) {
        if (object != null) {
            return (Boolean)bco2.call(object);
        }
        return false;
    }

    public static Object a(Object object, bco bco2, Object object2) {
        if (object != null) {
            return bco2.call(object);
        }
        return object2;
    }

    public static int b(boolean ... blArray) {
        int n = 0;
        for (boolean bl : blArray) {
            if (!bl) continue;
            ++n;
        }
        return n;
    }
}
