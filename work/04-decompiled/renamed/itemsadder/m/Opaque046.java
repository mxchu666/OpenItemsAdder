package itemsadder.m;

import it.unimi.dsi.fastutil.objects.ObjectArrays;
import java.util.ArrayList;
import java.util.Objects;

@Deprecated
public class Opaque046
extends ArrayList {
    @Override
    public int hashCode() {
        Object[] objectArray = this.toArray(new Object[0]);
        ObjectArrays.quickSort((Object[])objectArray);
        int n = 1;
        for (Object object : objectArray) {
            n = 31 * n + (object == null ? 0 : object.hashCode());
        }
        return Objects.hash(n, this.size());
    }
}
