package itemsadder.m;

import com.google.common.collect.ImmutableList;
import itemsadder.m.cb;
import itemsadder.m.cc;
import itemsadder.m.o;
import itemsadder.m.ug;
import lombok.Generated;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class ca
extends ug {
    @Nullable
    public final ImmutableList iv;
    @Nullable
    public final Integer iw;
    @Nullable
    public final Integer ix;
    @Nullable
    public final Integer iy;
    @Nullable
    final o iz;

    public boolean i(int n) {
        if (this.iw != null && n < this.iw) {
            return false;
        }
        return this.ix == null || n <= this.ix;
    }

    public boolean D(@Nullable String string) {
        if (this.iz == null) {
            return true;
        }
        return this.iz.D(string);
    }

    public boolean e(@Nullable Player player) {
        if (this.iz == null) {
            return true;
        }
        return this.iz.e(player);
    }

    @Generated
    protected ca(cb cb2) {
        super(cb2);
        this.iv = cb2.iv;
        this.iw = cb2.iw;
        this.ix = cb2.ix;
        this.iy = cb2.iy;
        this.iz = cb2.iz;
    }

    @Generated
    public static cb bM() {
        return new cc();
    }
}
