package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.uw;
import org.bukkit.inventory.ItemStack;

public class vb
extends uw {
    public ItemStack Mq;
    public ItemStack Mr;

    public vb(bbf bbf2, String string, String string2, ItemStack itemStack, ItemStack itemStack2) {
        super(bbf2, string, string2, itemStack);
        this.Mq = itemStack;
        this.Mr = itemStack2;
        this.Mc = 2;
    }

    public ItemStack rb() {
        return this.Mq;
    }

    public ItemStack rc() {
        return this.Mr;
    }

    public boolean O(ItemStack itemStack) {
        return this.Mr.isSimilar(itemStack);
    }

    @Override
    public boolean qS() {
        return this.Mq != null && this.Mr != null;
    }
}
