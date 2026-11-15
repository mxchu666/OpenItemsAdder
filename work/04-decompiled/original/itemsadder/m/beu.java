package itemsadder.m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.WeakHashMap;

public class beu
extends ArrayList {
    public beu(Collection collection) {
        super(collection);
    }

    public static beu s(Class clazz) {
        return new beu((Collection)Collections.newSetFromMap(new WeakHashMap()));
    }

    public static beu t(Class clazz) {
        return new beu((Collection)Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap())));
    }
}
