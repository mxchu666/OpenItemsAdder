package itemsadder.m;

import itemsadder.m.aaf;
import itemsadder.m.qm;
import itemsadder.m.vp;
import itemsadder.m.vq;
import itemsadder.m.vr;
import itemsadder.m.vs;
import java.lang.runtime.SwitchBootstraps;
import java.util.Objects;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.jetbrains.annotations.Nullable;

public class vj {
    final Character MF;
    final RecipeChoice MG;
    final ItemStack MH;
    public final int MI;
    Integer MJ = null;

    public vj(Character c, vp vp2) {
        this(c, vp2, 1);
    }

    public vj(Character c, vp vp2, @Deprecated int n) {
        this.MF = Character.valueOf(Character.toLowerCase(c.charValue()));
        this.MH = vp2.rt();
        this.MH.setAmount(n);
        vp vp3 = vp2;
        Objects.requireNonNull(vp3);
        vp vp4 = vp3;
        int n2 = 0;
        switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{vs.class, vr.class, vq.class}, (Object)vp4, n2)) {
            case 0: {
                vs vs2 = (vs)vp4;
                this.MG = new RecipeChoice.MaterialChoice(vs2.Ne);
                this.MI = vj.x(this.MH.getType());
                return;
            }
            case 1: {
                vr vr2 = (vr)vp4;
                this.MG = new RecipeChoice.ExactChoice(this.MH);
                this.MI = vj.x(this.MH.getType());
                return;
            }
            case 2: {
                vq vq2 = (vq)vp4;
                this.MG = new RecipeChoice.ExactChoice(this.MH);
                this.MJ = vq2.oP().Gi;
                this.MI = this.MJ;
                return;
            }
        }
        throw new IllegalStateException("Unexpected ingredient type.");
    }

    public static int x(@Nullable Material material) {
        if (material == null || material.isAir()) {
            return -666;
        }
        return aaf.tg().C(material);
    }

    public static Integer S(@Nullable ItemStack itemStack) {
        if (itemStack == null) {
            return vj.x(null);
        }
        if (qm.isCustomItem(itemStack)) {
            return qm.v(itemStack);
        }
        return vj.x(itemStack.getType());
    }

    public static int a(@Nullable vj vj2) {
        if (vj2 == null) {
            return vj.x(null);
        }
        return vj2.MI;
    }

    public RecipeChoice rd() {
        return this.MG;
    }

    public Character ri() {
        return this.MF;
    }

    public ItemStack getItem() {
        return this.MH;
    }

    @Nullable
    public Integer rj() {
        return this.MJ;
    }

    public boolean ny() {
        return this.MJ != null;
    }

    public boolean e(ItemStack itemStack) {
        if (this.ny()) {
            return qm.a((Integer)this.MI, itemStack);
        }
        return this.MH.getType() == itemStack.getType() && !qm.isCustomItem(itemStack);
    }

    public boolean rk() {
        return this.MH == null || this.MH.getType() == Material.AIR;
    }
}
