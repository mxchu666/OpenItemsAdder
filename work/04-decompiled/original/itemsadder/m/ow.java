package itemsadder.m;

import dev.lone.itemsadder.api.ItemsAdder;
import itemsadder.m.bay;
import itemsadder.m.ox;
import itemsadder.m.ql;
import org.bukkit.block.Block;

public class ow {
    public final ox DU;
    public final ox DV;
    public final int DW;
    public final int DX;
    public final boolean DY;

    public ow(ox ox2, ox ox3, int n, int n2, boolean bl) {
        this.DU = ox2;
        this.DV = ox3;
        this.DW = n;
        this.DX = n2;
        this.DY = bl;
    }

    public void ao(Block block) {
        if (this.DU.Ea instanceof ql && ((ql)this.DU.Ea).kH() != -1) {
            bay.bk(block);
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
