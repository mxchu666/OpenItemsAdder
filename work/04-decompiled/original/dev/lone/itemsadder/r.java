package dev.lone.itemsadder;

import dev.lone.itemsadder.j;
import dev.lone.itemsadder.l;
import dev.lone.itemsadder.m;
import java.util.concurrent.Callable;

public class r
extends j {
    private final Callable Qz;

    public r(String string, Callable callable) {
        super(string);
        this.Qz = callable;
    }

    @Override
    protected m sd() {
        int n = (Integer)this.Qz.call();
        if (n == 0) {
            return null;
        }
        return new l().h("value", n).se();
    }
}
