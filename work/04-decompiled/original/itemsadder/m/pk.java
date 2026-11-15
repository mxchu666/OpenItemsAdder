package itemsadder.m;

import itemsadder.m.pl;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

final class pk {
    final Map Eo = new HashMap();

    pk() {
    }

    void a(UUID uUID, String string) {
        this.Eo.put(uUID, new pl(string));
    }

    pl b(UUID uUID, String string) {
        pl pl2 = this.c(uUID, string);
        if (pl2 == null) {
            pl2 = new pl(string);
            this.Eo.put(uUID, pl2);
        }
        return pl2;
    }

    @Nullable
    pl c(UUID uUID, String string) {
        pl pl2 = (pl)this.Eo.get(uUID);
        return pl2 != null && pl2.Ep.equals(string) ? pl2 : null;
    }

    @Nullable
    pl i(UUID uUID) {
        return (pl)this.Eo.remove(uUID);
    }

    void clear() {
        this.Eo.clear();
    }
}
