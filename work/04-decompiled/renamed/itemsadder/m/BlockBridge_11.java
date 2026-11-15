package itemsadder.m;

import dev.lone.itemsadder.api.ItemsAdder;
import itemsadder.m.BlockBridge_2;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.MaterialBridge_5;
import org.bukkit.block.Block;

public class BlockBridge_11 {
    public final MaterialBridge_5 DU;
    public final MaterialBridge_5 DV;
    public final int DW;
    public final int DX;
    public final boolean DY;

    public BlockBridge_11(MaterialBridge_5 materialBridge_5, MaterialBridge_5 materialBridge_52, int n, int n2, boolean bl) {
        this.DU = materialBridge_5;
        this.DV = materialBridge_52;
        this.DW = n;
        this.DX = n2;
        this.DY = bl;
    }

    public void ao(Block block) {
        if (this.DU.Ea instanceof LocationBridgeBuilder_2 && ((LocationBridgeBuilder_2)this.DU.Ea).kH() != -1) {
            BlockBridge_2.bk(block);
        }
        if (!this.DV.DZ) {
            if (this.DU.DZ) {
                ItemsAdder.removeCustomBlock(block.getLocation());
            }
            block.setType(this.DV.bE, !this.DY);
        } else {
            this.DV.Ea.as(block);
        }
    }
}
