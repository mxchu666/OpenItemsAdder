package dev.lone.itemsadder;

import dev.lone.itemsadder.j;
import dev.lone.itemsadder.l;
import dev.lone.itemsadder.m;
import java.util.Map;
import java.util.concurrent.Callable;

public class h
extends j {
    private final Callable PY;

    public h(String string, Callable callable) {
        super(string);
        this.PY = callable;
    }

    @Override
    protected m sd() {
        l l2 = new l();
        Map map = (Map)this.PY.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        boolean bl = true;
        for (Map.Entry entry : map.entrySet()) {
            if (((int[])entry.getValue()).length == 0) continue;
            bl = false;
            l2.a((String)entry.getKey(), (int[])entry.getValue());
        }
        if (bl) {
            return null;
        }
        return new l().a("values", l2.se()).se();
    }
}
