package itemsadder.m;

import itemsadder.m.aaa;
import itemsadder.m.aiq;
import itemsadder.m.bbf;
import itemsadder.m.bbs;
import itemsadder.m.qm;
import itemsadder.m.uw;
import itemsadder.m.wb;
import itemsadder.m.wd;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class wc
extends uw {
    public final wb Ni;
    public final wb Nj;
    public final wb Nk;
    public final wd Nl;

    public wc(bbf bbf2, String string, String string2, ItemStack itemStack, wb wb2, wb wb3, wb wb4, wd wd2) {
        super(bbf2, string, string2, itemStack);
        this.Ni = wb2;
        this.Nj = wb3;
        this.Nk = wb4;
        this.Nl = wd2;
        this.Mc = 1;
    }

    @Override
    public boolean qS() {
        return this.Nj != null && this.Nj.Ng.getType() != Material.AIR && this.Nk != null && this.Nk.Ng.getType() != Material.AIR;
    }

    public ItemStack T(ItemStack itemStack) {
        ItemStack itemStack2 = bbs.au(this.Ma);
        if (this.Nl.Ns) {
            aiq.tX().f(itemStack, itemStack2);
        }
        if (aaa.Va) {
            List list;
            ItemMeta itemMeta = itemStack2.getItemMeta();
            ItemMeta itemMeta2 = itemStack.getItemMeta();
            if (this.Nl.Nm && itemMeta2.hasDisplayName()) {
                itemMeta.displayName(itemMeta2.displayName());
            }
            if (this.Nl.Nn && (list = itemMeta2.lore()) != null) {
                List list2 = itemMeta.lore();
                if (list2 != null) {
                    list.addAll(list2);
                }
                itemMeta.lore(list);
            }
            itemStack2.setItemMeta(itemMeta);
        }
        if (this.Nl.No) {
            bbs.i(itemStack, itemStack2);
        }
        if (this.Nl.Np && bbs.av(itemStack)) {
            int n = bbs.al(itemStack);
            int n2 = bbs.E(itemStack2);
            int n3 = (int)Math.ceil((double)n / (double)bbs.E(itemStack) * (double)n2);
            bbs.d(itemStack2, n3);
        }
        if (this.Nl.Nr) {
            bbs.j(itemStack, itemStack2);
        }
        if (this.Nl.Nq) {
            itemStack2.setType(itemStack.getType());
        }
        return itemStack2;
    }

    public boolean b(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3) {
        return this.a(this.Ni, itemStack) && this.a(this.Nj, itemStack2) && this.a(this.Nk, itemStack3);
    }

    private boolean a(wb wb2, ItemStack itemStack) {
        if ((itemStack == null || itemStack.getType() == Material.AIR) && wb2.getItem() != null && wb2.getItem().getType() != Material.AIR) {
            return false;
        }
        boolean bl = qm.isCustomItem(itemStack);
        if (wb2.ru()) {
            if (bl) {
                return wb2.cy(qm.u(itemStack));
            }
            return false;
        }
        if (bl) {
            return false;
        }
        return wb2.getItem().getType() == itemStack.getType();
    }
}
