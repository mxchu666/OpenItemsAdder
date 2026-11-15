package itemsadder.m;

import itemsadder.m.NothingEnum;
import java.util.HashSet;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public interface LocationWrapper {
    public NothingEnum a(Object var1, Object var2, Object var3, HashSet var4);

    public NothingEnum a(Entity var1, HashSet var2);

    @Nullable
    public Vector a(Location var1, Location var2, boolean var3);
}
