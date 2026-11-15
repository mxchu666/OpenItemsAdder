package dev.lone.itemsadder.resourcepack;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public final class bk {
    private static final Map avA = new ConcurrentHashMap();

    private bk() {
    }

    public static void gr() {
        avA.clear();
    }

    public static void k(String string2, String string3) {
        avA.computeIfAbsent(string2, string -> ConcurrentHashMap.newKeySet()).add(string3);
    }

    static boolean isEmpty() {
        return avA.isEmpty();
    }

    static String xJ() {
        StringBuilder stringBuilder = new StringBuilder("ItemsAdder resource-pack diagnostics\n");
        new TreeMap<String, Set>(avA).forEach((string2, set) -> {
            stringBuilder.append("\n## ").append((String)string2).append(" (").append(set.size()).append(")\n");
            set.stream().sorted().forEach(string -> stringBuilder.append("\n").append((String)string).append('\n'));
        });
        return stringBuilder.toString();
    }
}
