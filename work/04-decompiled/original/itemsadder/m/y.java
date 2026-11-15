package itemsadder.m;

import itemsadder.m.d;
import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public abstract class y {
    final Plugin cb;
    final d cc;

    protected y(Plugin plugin, d d2) {
        this.cb = plugin;
        this.cc = d2;
    }

    public void u(Player player) {
    }

    public boolean v(Player player) {
        return true;
    }

    public abstract boolean a(Player var1, String var2);

    public abstract void a(Player var1, String var2, float var3);

    public float b(Player player, String string, float f) {
        Float f2 = this.a(player, string, Float.valueOf(f));
        if (f2 == null) {
            f2 = Float.valueOf(f);
        }
        return f2.floatValue();
    }

    @Nullable
    public abstract Float a(Player var1, String var2, @Nullable Float var3);

    void a(UUID uUID) {
    }

    public void ak() {
    }

    public void e(boolean bl) {
    }
}
