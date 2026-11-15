package itemsadder.m;

import com.google.common.collect.ImmutableList;
import itemsadder.m.LocationBridge_14;
import itemsadder.m.PlayerBridgeBuilder;
import itemsadder.m.PlayerBridgeBuilderImpl;
import itemsadder.m.PlayerBridge_21;
import lombok.Generated;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class PlayerBridge_6
extends LocationBridge_14 {
    @Nullable
    public final ImmutableList iv;
    @Nullable
    public final Integer iw;
    @Nullable
    public final Integer ix;
    @Nullable
    public final Integer iy;
    @Nullable
    final PlayerBridge_21 iz;

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
    protected PlayerBridge_6(PlayerBridgeBuilder playerBridgeBuilder) {
        super(playerBridgeBuilder);
        this.iv = playerBridgeBuilder.iv;
        this.iw = playerBridgeBuilder.iw;
        this.ix = playerBridgeBuilder.ix;
        this.iy = playerBridgeBuilder.iy;
        this.iz = playerBridgeBuilder.iz;
    }

    @Generated
    public static PlayerBridgeBuilder bM() {
        return new PlayerBridgeBuilderImpl();
    }
}
