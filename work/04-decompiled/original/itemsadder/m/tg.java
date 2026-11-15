package itemsadder.m;

import itemsadder.m.bbe;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Collections;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

public final class tg
extends Record {
    private final String Kq;
    private final String Kr;
    @Nullable
    private final String Ks;
    @Nullable
    private final Boolean Kt;
    @Nullable
    private final Boolean Ku;
    @Nullable
    private final Component Kv;
    @Nullable
    private final Integer Kw;
    private final List Kx;

    public tg(String string, String string2, @Nullable String string3, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Component component, @Nullable Integer n, List list) {
        this.Kq = string;
        this.Kr = string2;
        this.Ks = string3;
        this.Kt = bl;
        this.Ku = bl2;
        this.Kv = component;
        this.Kw = n;
        this.Kx = list;
    }

    public String bj() {
        return this.Kq + ":" + this.Kr;
    }

    public Component pB() {
        if (this.Kv == null) {
            return bbe.gF("Music Disc");
        }
        return this.Kv;
    }

    public List pC() {
        return this.Kx == null ? List.of() : Collections.unmodifiableList(this.Kx);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{tg.class, "namespace;name;subtitle;replace;isJukeboxPlayable;jukeboxDescription;comparatorOutput;variants", "Kq", "Kr", "Ks", "Kt", "Ku", "Kv", "Kw", "Kx"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{tg.class, "namespace;name;subtitle;replace;isJukeboxPlayable;jukeboxDescription;comparatorOutput;variants", "Kq", "Kr", "Ks", "Kt", "Ku", "Kv", "Kw", "Kx"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{tg.class, "namespace;name;subtitle;replace;isJukeboxPlayable;jukeboxDescription;comparatorOutput;variants", "Kq", "Kr", "Ks", "Kt", "Ku", "Kv", "Kw", "Kx"}, this, object);
    }

    public String pD() {
        return this.Kq;
    }

    public String fN() {
        return this.Kr;
    }

    @Nullable
    public String pE() {
        return this.Ks;
    }

    @Nullable
    public Boolean pF() {
        return this.Kt;
    }

    @Nullable
    public Boolean pG() {
        return this.Ku;
    }

    @Nullable
    public Integer pH() {
        return this.Kw;
    }
}
