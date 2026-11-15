package itemsadder.m;

import itemsadder.m.EntityBridge_4;
import itemsadder.m.EntityBridge_5;
import itemsadder.m.LocationBridgeImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Generated;

public class Opaque136
extends LocationBridgeImpl {
    final List Lm;
    final List Ln;
    final boolean Lo;

    public Opaque136(boolean bl) {
        this.Lo = bl;
        this.Lm = new ArrayList();
        this.Ln = new ArrayList();
    }

    public boolean qn() {
        return !this.Lm.isEmpty();
    }

    @Override
    public void a(EntityBridge_5 entityBridge_5) {
        this.Lm.add(entityBridge_5);
        super.a(entityBridge_5);
    }

    public void a(EntityBridge_4 entityBridge_4) {
        this.Lm.add(entityBridge_4);
        this.Ln.add(entityBridge_4);
    }

    public boolean qo() {
        return !this.Ln.isEmpty();
    }

    public Optional cu(String string) {
        if (!this.qo()) {
            return Optional.empty();
        }
        for (EntityBridge_4 entityBridge_4 : this.Ln) {
            if (!entityBridge_4.oz.equals(string)) continue;
            return Optional.of(entityBridge_4);
        }
        return Optional.empty();
    }

    @Generated
    public List qp() {
        return this.Lm;
    }

    @Generated
    public boolean qq() {
        return this.Lo;
    }
}
