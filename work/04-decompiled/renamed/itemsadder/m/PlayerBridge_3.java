package itemsadder.m;

import dev.lone.itemsadder.resourcepack.ad;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public abstract class PlayerBridge_3 {
    String ayM;
    boolean ayN;

    public PlayerBridge_3(String string) {
        this.ayM = string;
    }

    public boolean Cj() {
        return this.ayN;
    }

    @Nullable
    public abstract String a(ad var1, @Nullable Player var2);
}
