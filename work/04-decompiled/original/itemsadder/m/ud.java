package itemsadder.m;

import itemsadder.m.uj;
import itemsadder.m.ul;
import itemsadder.m.um;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Generated;

public class ud
extends ul {
    final List Lm;
    final List Ln;
    final boolean Lo;

    public ud(boolean bl) {
        this.Lo = bl;
        this.Lm = new ArrayList();
        this.Ln = new ArrayList();
    }

    public boolean qn() {
        return !this.Lm.isEmpty();
    }

    @Override
    public void a(um um2) {
        this.Lm.add(um2);
        super.a(um2);
    }

    public void a(uj uj2) {
        this.Lm.add(uj2);
        this.Ln.add(uj2);
    }

    public boolean qo() {
        return !this.Ln.isEmpty();
    }

    public Optional cu(String string) {
        if (!this.qo()) {
            return Optional.empty();
        }
        for (uj uj2 : this.Ln) {
            if (!uj2.oz.equals(string)) continue;
            return Optional.of(uj2);
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
