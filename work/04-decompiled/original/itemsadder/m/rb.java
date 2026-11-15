package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.bdf;
import itemsadder.m.qm;
import itemsadder.m.ry;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class rb
extends qm {
    public final Material Hr;
    public final List Hs;

    public rb(bbf bbf2, String string, String string2, Material material, Material material2) {
        super(bbf2, string, string2, material);
        this.Hr = material2;
        this.Hs = new ArrayList();
    }

    public List nD() {
        return this.Hs;
    }

    public ry a(ry ry2) {
        this.Hs.add(ry2);
        return ry2;
    }

    public void aw(Block block) {
        block.setType(this.Hr);
    }

    public List L(ItemStack itemStack) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (ry ry2 : this.Hs) {
            if (!ry2.dy()) continue;
            arrayList.add(ry2.b(itemStack, true));
        }
        return arrayList;
    }

    public void b(ItemStack itemStack, Location location) {
        for (ry ry2 : this.Hs) {
            if (!ry2.dy()) continue;
            bdf.b(location, ry2.b(itemStack, true));
        }
    }

    public void N(Location location) {
        for (ry ry2 : this.Hs) {
            if (!ry2.dy()) continue;
            bdf.b(location, ry2.av(true));
        }
    }

    public static boolean ax(Block block) {
        if (block == null) {
            return false;
        }
        return block.getType() == Material.BEETROOTS || block.getType() == Material.CARROTS || block.getType() == Material.NETHER_WART || block.getType() == Material.POTATOES || block.getType() == Material.SWEET_BERRY_BUSH || block.getType() == Material.WHEAT;
    }
}
