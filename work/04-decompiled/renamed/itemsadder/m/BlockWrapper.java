package itemsadder.m;

import itemsadder.m.EntityBridge_5;
import itemsadder.m.LocationBridgeBuilder_2;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface BlockWrapper {
    default public boolean a(Event event) {
        return false;
    }

    public void f(Block var1, LocationBridgeBuilder_2 var2);

    @Nullable
    public Sound E(Material var1);

    @Nullable
    public Sound F(Material var1);

    @Nullable
    public Sound G(Material var1);

    @Nullable
    public Sound H(Material var1);

    public Sound I(Material var1);

    public void aX(Block var1);

    public void aY(Block var1);

    public void k(Block var1, boolean var2);

    public boolean aZ(Block var1);

    public void c(Block var1, int var2);

    default public void ba(Block block) {
        this.c(block, 0);
    }

    public boolean a(Block var1, EntityBridge_5 var2);

    public boolean b(Block var1, ItemStack var2);

    public String bb(@NotNull Block var1);
}
