package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.resourcepack.al;
import dev.lone.itemsadder.resourcepack.ap;
import dev.lone.itemsadder.resourcepack.aq;
import dev.lone.itemsadder.resourcepack.ar;
import java.util.LinkedHashMap;
import java.util.List;

final class as {
    private final LinkedHashMap auc = new LinkedHashMap();

    as() {
    }

    void a(ar ar2, al al2, String string) {
        this.c(new aq(ar2, al2, string));
    }

    void a(ar ar2, al al2, ap ap2) {
        this.c(new aq(ar2, al2, ap2.xY(), ap2));
    }

    private void c(aq aq2) {
        this.auc.putIfAbsent(String.valueOf((Object)aq2.xU()) + "\u0000" + String.valueOf((Object)aq2.xV()) + "\u0000" + aq2.xY(), aq2);
    }

    void b(as as2) {
        as2.auc.values().forEach(this::c);
    }

    List zz() {
        return List.copyOf(this.auc.values());
    }

    boolean zA() {
        return this.auc.values().stream().anyMatch(aq::zw);
    }
}
