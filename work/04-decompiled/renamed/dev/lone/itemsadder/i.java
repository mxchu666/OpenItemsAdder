package dev.lone.itemsadder;

import dev.lone.itemsadder.j;
import dev.lone.itemsadder.l;
import dev.lone.itemsadder.m;
import java.util.Map;
import java.util.concurrent.Callable;

public class i
extends j {
    private final Callable PZ;

    public i(String string, Callable callable) {
        super(string);
        this.PZ = callable;
    }

    @Override
    protected m sd() {
        l l2 = new l();
        Map map = (Map)this.PZ.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        boolean bl = true;
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer)entry.getValue() == 0) continue;
            bl = false;
            l2.h((String)entry.getKey(), (Integer)entry.getValue());
        }
        if (bl) {
            return null;
        }
        return new l().a("values", l2.se()).se();
    }
}
