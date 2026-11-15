package dev.lone.itemsadder;

import dev.lone.itemsadder.j;
import dev.lone.itemsadder.l;
import dev.lone.itemsadder.m;
import java.util.Map;
import java.util.concurrent.Callable;

public class k
extends j {
    private final Callable Qb;

    public k(String string, Callable callable) {
        super(string);
        this.Qb = callable;
    }

    @Override
    public m sd() {
        l l2 = new l();
        Map map = (Map)this.Qb.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        boolean bl = true;
        for (Map.Entry entry : map.entrySet()) {
            l l3 = new l();
            boolean bl2 = true;
            for (Map.Entry entry2 : ((Map)map.get(entry.getKey())).entrySet()) {
                l3.h((String)entry2.getKey(), (Integer)entry2.getValue());
                bl2 = false;
            }
            if (bl2) continue;
            bl = false;
            l2.a((String)entry.getKey(), l3.se());
        }
        if (bl) {
            return null;
        }
        return new l().a("values", l2.se()).se();
    }
}
