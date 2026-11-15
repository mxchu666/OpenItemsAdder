package dev.lone.itemsadder.resourcepack;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

final class e {
    private e() {
    }

    static int a(Collection collection, int n, int n2, int ... nArray) {
        if (n > n2) {
            return -1;
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (Object e2 : collection) {
            if (!(e2 instanceof Number)) continue;
            Number number = (Number)e2;
            hashSet.add(number.intValue());
        }
        int n3 = n;
        while (true) {
            boolean bl = hashSet.contains(n3);
            for (Object object : (Number)nArray) {
                bl |= n3 == object;
            }
            if (!bl) {
                return n3;
            }
            if (n3 == n2) {
                return -1;
            }
            ++n3;
        }
    }

    public static void i(String[] stringArray) {
        assert (e.a(Set.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)), 1, 5, new int[0]) == 3);
        assert (e.a(Set.of(Integer.valueOf(1), Integer.valueOf(3)), 1, 3, 2) == -1);
        assert (e.a(Set.of(Integer.valueOf(Integer.MAX_VALUE)), Integer.MAX_VALUE, Integer.MAX_VALUE, new int[0]) == -1);
        assert (e.a(Set.of(), 2, 1, new int[0]) == -1);
    }
}
