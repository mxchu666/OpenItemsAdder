package itemsadder.m;

import itemsadder.m.Opaque129;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

final class Opaque128 {
    final Map Eo = new HashMap();

    Opaque128() {
    }

    void a(UUID uUID, String string) {
        this.Eo.put(uUID, new Opaque129(string));
    }

    Opaque129 b(UUID uUID, String string) {
        Opaque129 opaque129 = this.c(uUID, string);
        if (opaque129 == null) {
            opaque129 = new Opaque129(string);
            this.Eo.put(uUID, opaque129);
        }
        return opaque129;
    }

    @Nullable
    Opaque129 c(UUID uUID, String string) {
        Opaque129 opaque129 = (Opaque129)this.Eo.get(uUID);
        return opaque129 != null && opaque129.Ep.equals(string) ? opaque129 : null;
    }

    @Nullable
    Opaque129 i(UUID uUID) {
        return (Opaque129)this.Eo.remove(uUID);
    }

    void clear() {
        this.Eo.clear();
    }
}
