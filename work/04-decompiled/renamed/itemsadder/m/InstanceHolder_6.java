package itemsadder.m;

import java.util.Map;
import java.util.Objects;

class InstanceHolder_6
implements Map.Entry {
    final int aCx;
    final Object aCy;
    Object LG;
    InstanceHolder_6 aCo;

    InstanceHolder_6(int n, Object object, Object object2, InstanceHolder_6 instanceHolder_6) {
        this.aCx = n;
        this.aCy = object;
        this.LG = object2;
        this.aCo = instanceHolder_6;
    }

    public final Object getKey() {
        return this.aCy;
    }

    public final Object getValue() {
        return this.LG;
    }

    public final String toString() {
        return String.valueOf(this.aCy) + "=" + String.valueOf(this.LG);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.aCy) ^ Objects.hashCode(this.LG);
    }

    public final Object setValue(Object object) {
        Object object2 = this.LG;
        this.LG = object;
        return object2;
    }

    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry)object;
            return Objects.equals(this.aCy, entry.getKey()) && Objects.equals(this.LG, entry.getValue());
        }
        return false;
    }
}
