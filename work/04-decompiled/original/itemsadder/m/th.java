package itemsadder.m;

import itemsadder.m.bbe;
import itemsadder.m.tg;
import itemsadder.m.ti;
import itemsadder.m.tj;
import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

public class th {
    public final String Ky;
    public final String Kz;
    @Nullable
    private String Ks;
    @Nullable
    private Boolean Kt;
    @Nullable
    private Boolean Ku;
    @Nullable
    private Component Kv;
    @Nullable
    private Integer Kw;
    List Kx;

    public th(String string, String string2) {
        this.Ky = string;
        this.Kz = string2;
    }

    public th cm(@Nullable String string) {
        this.Ks = string;
        return this;
    }

    public th d(@Nullable Boolean bl) {
        this.Kt = bl;
        return this;
    }

    public th o(List list) {
        this.Kx = list;
        return this;
    }

    public void a(tj tj2) {
        if (this.Kx == null) {
            this.Kx = new ArrayList();
        }
        this.Kx.add(tj2);
    }

    public th e(Boolean bl) {
        this.Ku = bl;
        return this;
    }

    @Nullable
    public Boolean pI() {
        return this.Ku;
    }

    public th cn(String string) {
        this.Kv = string == null ? null : bbe.gK(string);
        return this;
    }

    public th i(Integer n) {
        this.Kw = n;
        return this;
    }

    public tg pJ() {
        ArrayList<ti> arrayList = new ArrayList<ti>();
        if (this.Kx != null) {
            for (tj tj2 : this.Kx) {
                arrayList.add(tj2.pV());
            }
        }
        return new tg(this.Ky, this.Kz, this.Ks, this.Kt, this.Ku, this.Kv, this.Kw, arrayList);
    }
}
