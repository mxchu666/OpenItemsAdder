package itemsadder.m;

import itemsadder.m.ItemStackRegistry;
import itemsadder.m.KfFunction;
import itemsadder.m.PlayerBridge_15;
import itemsadder.m.PlayerWrapper_6;
import itemsadder.m.PlayerWrapper_7;
import itemsadder.m.WorldBridge_4;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public abstract class PlayerBridge_8
extends WorldBridge_4 {
    public final String wa;
    String wb;
    float wc;
    final float wd;
    final float we;
    final float wf;
    final List wg = new ArrayList();
    final List wh = new ArrayList();
    final List wi = new ArrayList();

    public PlayerBridge_8(PlayerBridge_15 playerBridge_15, String string, String string2, String string3, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2, float f3, List list) {
        super(playerBridge_15, string, string2, n, bl, bl2, bl3, bl4, list);
        Float f4;
        this.wa = string3;
        this.wd = f;
        float f5 = f2;
        float f6 = f3;
        if (f2 > f3) {
            f5 = f3;
            f6 = f2;
        }
        this.we = f5;
        this.wf = f6;
        if (playerBridge_15 != null && (f4 = this.b(null)) == null) {
            this.k(f);
        }
    }

    public void a(PlayerWrapper_6 playerWrapper_6) {
        this.wg.add(playerWrapper_6);
    }

    public List jT() {
        return this.wg;
    }

    public void b(Player player, int n) {
        for (PlayerWrapper_6 playerWrapper_6 : this.wg) {
            playerWrapper_6.a(this, player, n);
        }
    }

    public void a(PlayerWrapper_7 playerWrapper_7) {
        this.wh.add(playerWrapper_7);
    }

    public List jU() {
        return this.wh;
    }

    public void c(Player player, int n) {
        for (PlayerWrapper_7 playerWrapper_7 : this.wh) {
            playerWrapper_7.a(this, player, n);
        }
    }

    public void a(KfFunction kfFunction) {
        this.wi.add(kfFunction);
    }

    public List jV() {
        return this.wi;
    }

    public float k(float f) {
        this.wc = this.jW();
        if (f == this.wc) {
            return f;
        }
        if (f > this.jZ()) {
            f = this.jZ();
        }
        if (f < this.jY()) {
            f = this.jY();
        }
        assert (this.vX != null) : "Holder must not be null when getting value";
        ItemStackRegistry.g().an.a(this.vX.xd, this.wa, f);
        if ((int)f != (int)this.wc) {
            this.jM();
        }
        return f;
    }

    public float jW() {
        @Nullable Float f = this.b(null);
        if (f == null) {
            f = Float.valueOf(this.jY());
        }
        return f.floatValue();
    }

    @Nullable
    public Float b(@Nullable Float f) {
        assert (this.vX != null) : "Holder must not be null when getting value";
        return ItemStackRegistry.g().an.a(this.vX.xd, this.wa, f);
    }

    protected void a(PlayerBridge_8 playerBridge_8) {
        for (Object object : playerBridge_8.jT()) {
            this.wg.add(object.kn());
        }
        for (Object object : playerBridge_8.jU()) {
            this.wh.add(object.ki());
        }
        for (Object object : playerBridge_8.jV()) {
            this.a((KfFunction)object);
        }
    }

    @Generated
    public String jX() {
        return this.wa;
    }

    @Generated
    public float jY() {
        return this.we;
    }

    @Generated
    public float jZ() {
        return this.wf;
    }
}
