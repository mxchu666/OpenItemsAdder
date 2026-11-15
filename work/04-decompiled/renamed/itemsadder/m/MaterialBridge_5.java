package itemsadder.m;

import itemsadder.m.BlockBridge_13;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.SoundCategoryBridge;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class MaterialBridge_5 {
    public boolean DZ;
    public Material bE;
    public BlockBridge_13 Ea;

    public MaterialBridge_5(Material material) {
        this.DZ = false;
        this.bE = material;
    }

    public MaterialBridge_5(BlockBridge_13 blockBridge_13) {
        this.DZ = true;
        this.Ea = blockBridge_13;
    }

    public static MaterialBridge_5 by(String string) {
        if (!ItemStackRegistry.g().f(string)) {
            Material material = (Material)SoundCategoryBridge.e(string.toUpperCase(), Material.class);
            if (material == null) {
                throw new IllegalArgumentException("Unknown item/material: " + string);
            }
            return new MaterialBridge_5(material);
        }
        ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().e(string);
        if (itemStackBuilder_4 == null) {
            throw new IllegalArgumentException("Unknown item/material: " + string);
        }
        if (itemStackBuilder_4 instanceof BlockBridge_13) {
            return new MaterialBridge_5((BlockBridge_13)itemStackBuilder_4);
        }
        throw new IllegalArgumentException("Item is not placeable: " + string);
    }

    public boolean ap(Block block) {
        if (this.DZ) {
            if (LocationBridgeBuilder_2.av(block)) {
                BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
                if (!blockBridge_9.isCustomBlock(block)) {
                    return false;
                }
                BlockBridge_13 blockBridge_13 = (BlockBridge_13)ItemStackRegistry.g().e(blockBridge_9.Y(block));
                if (blockBridge_13 == null) {
                    return false;
                }
                return blockBridge_13.equals(this.Ea);
            }
        } else {
            return block.getType().equals((Object)this.bE);
        }
        return false;
    }

    public String mj() {
        if (this.DZ) {
            return this.Ea.Gh;
        }
        return this.bE.toString();
    }
}
