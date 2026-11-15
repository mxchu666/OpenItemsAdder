package dev.lone.itemsadder;

import dev.lone.itemsadder.j;
import dev.lone.itemsadder.l;
import dev.lone.itemsadder.m;
import java.util.Map;
import java.util.concurrent.Callable;

public class p
extends j {
    private final Callable Qx;

    public p(String string, Callable callable) {
        super(string);
        this.Qx = callable;
    }

    @Override
    protected m sd() {
        l l2 = new l();
        Map map = (Map)this.Qx.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            l2.a((String)entry.getKey(), new int[]{(Integer)entry.getValue()});
        }
        return new l().a("values", l2.se()).se();
    }
}
