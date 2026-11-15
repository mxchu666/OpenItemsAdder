package itemsadder.m;

import itemsadder.m.ItemStackBridge_32;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.LocationBridge_4;
import itemsadder.m.PluginFileConfigurationHolder;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class MaterialBridge_9
extends ItemStackBuilder_4 {
    public final Material Hr;
    public final List Hs;

    public MaterialBridge_9(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material, Material material2) {
        super(pluginFileConfigurationHolder, string, string2, material);
        this.Hr = material2;
        this.Hs = new ArrayList();
    }

    public List nD() {
        return this.Hs;
    }

    public ItemStackBridge_32 a(ItemStackBridge_32 itemStackBridge_32) {
        this.Hs.add(itemStackBridge_32);
        return itemStackBridge_32;
    }

    public void aw(Block block) {
        block.setType(this.Hr);
    }

    public List L(ItemStack itemStack) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (ItemStackBridge_32 itemStackBridge_32 : this.Hs) {
            if (!itemStackBridge_32.dy()) continue;
            arrayList.add(itemStackBridge_32.b(itemStack, true));
        }
        return arrayList;
    }

    public void b(ItemStack itemStack, Location location) {
        for (ItemStackBridge_32 itemStackBridge_32 : this.Hs) {
            if (!itemStackBridge_32.dy()) continue;
            LocationBridge_4.b(location, itemStackBridge_32.b(itemStack, true));
        }
    }

    public void N(Location location) {
        for (ItemStackBridge_32 itemStackBridge_32 : this.Hs) {
            if (!itemStackBridge_32.dy()) continue;
            LocationBridge_4.b(location, itemStackBridge_32.av(true));
        }
    }

    public static boolean ax(Block block) {
        if (block == null) {
            return false;
        }
        return block.getType() == Material.BEETROOTS || block.getType() == Material.CARROTS || block.getType() == Material.NETHER_WART || block.getType() == Material.POTATOES || block.getType() == Material.SWEET_BERRY_BUSH || block.getType() == Material.WHEAT;
    }
}
