package itemsadder.m;

import itemsadder.m.Opaque123;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerBridge_15;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.WorldBridge_4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class PlayerBridgeImpl
extends PlayerBridge_8 {
    final List wk = Collections.synchronizedList(new ArrayList());
    final int wl = 0;
    float wm;

    public PlayerBridgeImpl(PlayerBridge_15 playerBridge_15, String string, String string2, String string3, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2, float f3, List list) {
        super(playerBridge_15, string, string2, string3, n, bl, bl2, bl3, bl4, f, f2, f3, list);
    }

    public PlayerBridgeImpl b(PlayerBridge_15 playerBridge_15) {
        PlayerBridgeImpl playerBridgeImpl = new PlayerBridgeImpl(playerBridge_15, this.bL, this.bM, this.wa, this.vJ, this.vP, this.vQ, this.vR, this.vS, this.wd, this.we, this.wf, this.vI);
        playerBridgeImpl.a(this);
        this.jM();
        return playerBridgeImpl;
    }

    @Override
    public float k(float f) {
        if (this.wm == f) {
            return this.wm;
        }
        this.wm = f;
        return this.wm;
    }

    @Override
    public float jW() {
        return this.wm;
    }

    @Override
    @Nullable
    public Float b(@Nullable Float f) {
        return Float.valueOf(this.jW());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int jJ() {
        if (!this.jL()) {
            return 0;
        }
        List list = this.wk;
        synchronized (list) {
            int n = 0;
            for (int i = 0; i < this.wk.size(); ++i) {
                PermissibleBridge permissibleBridge = (PermissibleBridge)this.wk.get(i);
                n += permissibleBridge.getWidth();
            }
            return n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String jK() {
        if (this.vL == null) {
            return "";
        }
        if (this.vW != null && !this.vZ) {
            return this.vW;
        }
        List list = this.wk;
        synchronized (list) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.wk.size(); ++i) {
                PermissibleBridge permissibleBridge = (PermissibleBridge)this.wk.get(i);
                stringBuilder.append(permissibleBridge.if());
            }
            stringBuilder = new StringBuilder(Opaque123.c(stringBuilder.toString(), 0));
            stringBuilder = new StringBuilder(Opaque123.c(stringBuilder.toString(), this.vL));
            stringBuilder = new StringBuilder(Opaque123.c(stringBuilder.toString(), this.vJ));
            this.vW = stringBuilder.toString();
            this.vZ = false;
            return this.vW;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(PermissibleBridge permissibleBridge) {
        this.jM();
        List list = this.wk;
        synchronized (list) {
            this.wk.add(permissibleBridge);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(int n, PermissibleBridge permissibleBridge) {
        this.jM();
        List list = this.wk;
        synchronized (list) {
            this.wk.add(n, permissibleBridge);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void Z(int n) {
        this.jM();
        List list = this.wk;
        synchronized (list) {
            this.wk.remove(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ka() {
        this.jM();
        List list = this.wk;
        synchronized (list) {
            this.wk.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int kb() {
        List list = this.wk;
        synchronized (list) {
            return this.wk.size();
        }
    }

    @Override
    public /* synthetic */ WorldBridge_4 a(PlayerBridge_15 playerBridge_15) {
        return this.b(playerBridge_15);
    }
}
