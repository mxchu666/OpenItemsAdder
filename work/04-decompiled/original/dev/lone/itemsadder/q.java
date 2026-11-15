package dev.lone.itemsadder;

import dev.lone.itemsadder.j;
import dev.lone.itemsadder.l;
import dev.lone.itemsadder.m;
import java.util.concurrent.Callable;

public class q
extends j {
    private final Callable Qy;

    public q(String string, Callable callable) {
        super(string);
        this.Qy = callable;
    }

    @Override
    protected m sd() {
        String string = (String)this.Qy.call();
        if (string == null || string.isEmpty()) {
            return null;
        }
        return new l().x("value", string).se();
    }
}
