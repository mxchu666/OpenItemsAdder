package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.m;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

final class l {
    private final m arg;
    private final Set arh = new TreeSet();
    private final Map ari = new TreeMap();

    private l(m m2) {
        this.arg = m2;
    }

    private void b(String string2, List list) {
        this.ari.computeIfAbsent(string2, string -> new TreeSet<List>(Comparator.comparing(list -> String.join((CharSequence)"\u0000", list)))).add(list);
    }
}
