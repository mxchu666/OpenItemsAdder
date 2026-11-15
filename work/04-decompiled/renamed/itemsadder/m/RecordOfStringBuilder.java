package itemsadder.m;

import itemsadder.m.PluginBridge_6;
import itemsadder.m.RecordOfStringBuilder_2;
import itemsadder.m.RecordOfString_10;
import itemsadder.m.RecordOfString_9;
import java.util.ArrayList;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

public class RecordOfStringBuilder {
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

    public RecordOfStringBuilder(String string, String string2) {
        this.Ky = string;
        this.Kz = string2;
    }

    public RecordOfStringBuilder cm(@Nullable String string) {
        this.Ks = string;
        return this;
    }

    public RecordOfStringBuilder d(@Nullable Boolean bl) {
        this.Kt = bl;
        return this;
    }

    public RecordOfStringBuilder o(List list) {
        this.Kx = list;
        return this;
    }

    public void a(RecordOfStringBuilder_2 recordOfStringBuilder_2) {
        if (this.Kx == null) {
            this.Kx = new ArrayList();
        }
        this.Kx.add(recordOfStringBuilder_2);
    }

    public RecordOfStringBuilder e(Boolean bl) {
        this.Ku = bl;
        return this;
    }

    @Nullable
    public Boolean pI() {
        return this.Ku;
    }

    public RecordOfStringBuilder cn(String string) {
        this.Kv = string == null ? null : PluginBridge_6.gK(string);
        return this;
    }

    public RecordOfStringBuilder i(Integer n) {
        this.Kw = n;
        return this;
    }

    public RecordOfString_9 pJ() {
        ArrayList<RecordOfString_10> arrayList = new ArrayList<RecordOfString_10>();
        if (this.Kx != null) {
            for (RecordOfStringBuilder_2 recordOfStringBuilder_2 : this.Kx) {
                arrayList.add(recordOfStringBuilder_2.pV());
            }
        }
        return new RecordOfString_9(this.Ky, this.Kz, this.Ks, this.Kt, this.Ku, this.Kv, this.Kw, arrayList);
    }
}
