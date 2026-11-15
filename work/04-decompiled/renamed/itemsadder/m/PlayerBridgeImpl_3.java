package itemsadder.m;

import itemsadder.m.Opaque123;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PlayerBridge_15;
import itemsadder.m.PlayerBridge_8;
import itemsadder.m.RightEnum;
import itemsadder.m.WorldBridge_4;
import java.util.List;
import lombok.Generated;

public class PlayerBridgeImpl_3
extends PlayerBridge_8 {
    final PermissibleBridge ww;
    final PermissibleBridge wx;
    final PermissibleBridge wy;
    final int wz;
    final int wA = 0;
    final RightEnum wB;

    public PlayerBridgeImpl_3(PlayerBridge_15 playerBridge_15, String string, String string2, String string3, RightEnum rightEnum, PermissibleBridge permissibleBridge, PermissibleBridge permissibleBridge2, PermissibleBridge permissibleBridge3, int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2, float f3, List list) {
        super(playerBridge_15, string, string2, string3, n, bl, bl2, bl3, bl4, f, f2, f3, list);
        this.wB = rightEnum;
        this.ww = permissibleBridge;
        this.wx = permissibleBridge2;
        this.wy = permissibleBridge3;
        this.wz = n2;
    }

    public PlayerBridgeImpl_3 d(PlayerBridge_15 playerBridge_15) {
        PlayerBridgeImpl_3 playerBridgeImpl_3 = new PlayerBridgeImpl_3(playerBridge_15, this.bL, this.bM, this.wa, this.wB, this.ww, this.wx, this.wy, this.vJ, this.wz, this.vP, this.vQ, this.vR, this.vS, this.wd, this.we, this.wf, this.vI);
        playerBridgeImpl_3.a(this);
        this.jM();
        return playerBridgeImpl_3;
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
        if (this.ww == null || this.wx == null || this.wy == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        while ((float)n < f) {
            if ((float)n < f && n == (int)f) {
                stringBuilder.append(Opaque123.c(this.wx.if(), 0));
            } else {
                stringBuilder.append(Opaque123.c(this.ww.if(), 0));
            }
            ++n;
        }
        n = (int)f;
        while ((float)n < this.wf) {
            if (!((float)n < f) || n != (int)f) {
                stringBuilder.append(Opaque123.c(this.wy.if(), 0));
            }
            ++n;
        }
        if (this.wB == RightEnum.LEFT) {
            stringBuilder = new StringBuilder(new StringBuilder(stringBuilder.toString()).reverse().toString());
        }
        stringBuilder = new StringBuilder(Opaque123.c(stringBuilder.toString(), this.vL));
        stringBuilder = new StringBuilder(Opaque123.c(stringBuilder.toString(), this.vJ));
        this.vW = stringBuilder.toString();
        this.vZ = false;
        return this.vW;
    }

    @Override
    public int jJ() {
        if (!this.jL()) {
            return 0;
        }
        return this.wz * this.ww.getWidth();
    }

    @Generated
    public PermissibleBridge kc() {
        return this.ww;
    }

    @Override
    public /* synthetic */ WorldBridge_4 a(PlayerBridge_15 playerBridge_15) {
        return this.d(playerBridge_15);
    }
}
