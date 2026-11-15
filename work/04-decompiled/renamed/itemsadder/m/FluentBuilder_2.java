package itemsadder.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.WeakHashMap;

public class FluentBuilder_2
extends ArrayList {
    public FluentBuilder_2(Collection collection) {
        super(collection);
    }

    public static FluentBuilder_2 s(Class clazz) {
        return new FluentBuilder_2((Collection)Collections.newSetFromMap(new WeakHashMap()));
    }

    public static FluentBuilder_2 t(Class clazz) {
        return new FluentBuilder_2((Collection)Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap())));
    }
}
