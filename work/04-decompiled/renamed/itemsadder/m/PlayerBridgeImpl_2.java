package itemsadder.m;

import itemsadder.m.Opaque123;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerBridge_15;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.WorldBridge_4;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class PlayerBridgeImpl_2
extends PlayerBridge_8 {
    public final List ws;
    @Nullable
    PermissibleBridge wt;
    float wu;
    final int wv = 0;

    public PlayerBridgeImpl_2(PlayerBridge_15 playerBridge_15, String string, String string2, String string3, List list, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2, float f3, List list2) {
        super(playerBridge_15, string, string2, string3, n, bl, bl2, bl3, bl4, f, f2, f3, list2);
        this.ws = list;
    }

    public PlayerBridgeImpl_2 c(PlayerBridge_15 playerBridge_15) {
        PlayerBridgeImpl_2 playerBridgeImpl_2 = new PlayerBridgeImpl_2(playerBridge_15, this.bL, this.bM, this.wa, this.ws, this.vJ, this.vP, this.vQ, this.vR, this.vS, this.wd, this.we, this.wf, this.vI);
        playerBridgeImpl_2.a(this);
        this.jM();
        return playerBridgeImpl_2;
    }

    @Override
    public String jK() {
        if (this.vL == null) {
            return "";
        }
        float f = this.jW();
        if (this.vW != null && !this.vZ) {
            return this.vW;
        }
        PermissibleBridge permissibleBridge = this.l(f);
        if (permissibleBridge == null) {
            return "";
        }
        String string = permissibleBridge.if();
        string = Opaque123.c(string, 0);
        string = Opaque123.c(string, this.vL);
        this.vW = string = Opaque123.c(string, this.vJ);
        this.vZ = false;
        return string;
    }

    @Nullable
    public PermissibleBridge l(float f) {
        PermissibleBridge permissibleBridge;
        int n = f <= this.we ? 0 : (f >= this.we + (float)this.ws.size() - 1.0f ? this.ws.size() - 1 : (int)(f - this.we));
        this.wt = permissibleBridge = (PermissibleBridge)this.ws.get(n);
        this.wu = f;
        return permissibleBridge;
    }

    @Override
    public int jJ() {
        if (!this.jL()) {
            return 0;
        }
        if (this.wt == null) {
            this.l(this.jW());
        }
        return this.wt.getWidth();
    }

    @Override
    public /* synthetic */ WorldBridge_4 a(PlayerBridge_15 playerBridge_15) {
        return this.c(playerBridge_15);
    }
}
