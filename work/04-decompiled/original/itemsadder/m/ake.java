package itemsadder.m;

import itemsadder.m.hb;
import java.util.function.Predicate;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public interface ake {
    public void b(Mob var1);

    public void a(Mob var1, boolean var2, int var3, EntityType var4, float var5, float var6, boolean var7);

    public void a(Mob var1, boolean var2, int var3);

    public void a(Mob var1, boolean var2, int var3, double var4, int var6);

    public void a(Mob var1, boolean var2, int var3, EntityType var4, int var5, boolean var6, boolean var7, @Nullable Predicate var8);

    public void a(Mob var1, boolean var2, int var3, double var4, boolean var6);

    public void a(Mob var1, boolean var2, int var3, double var4, int var6, float var7);

    public void a(Mob var1, boolean var2, int var3, EntityType var4, float var5, double var6, double var8, @Nullable Predicate var10);

    default public void a(Mob mob, boolean bl, int n, @Nullable hb[] hbArray, @Nullable hb[] hbArray2) {
    }

    public void b(Mob var1, boolean var2, int var3);

    public void c(Mob var1, boolean var2, int var3);

    public void a(Mob var1, boolean var2, int var3, Predicate var4, double var5, int var7);

    public void a(Mob var1, boolean var2, int var3, boolean var4);

    public void d(Mob var1, boolean var2, int var3);

    public void a(Mob var1, boolean var2, int var3, Predicate var4);

    public void a(Mob var1, int var2, int var3, int var4);

    public void a(Mob var1, int var2, boolean var3, float var4);
}
