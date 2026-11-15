package itemsadder.m;

import itemsadder.m.afz;
import itemsadder.m.jl;
import itemsadder.m.mm;
import itemsadder.m.qm;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.Nullable;

public class kh
extends jl {
    public static final NamespacedKey yX = new NamespacedKey("itemsadder", "vehicle");
    public static final String yY = "vehicle";
    final float yZ;
    final float za;
    float zb = 0.0f;
    float zc = 0.0f;
    float zd = 0.0f;
    Vector ze;
    int zf = 60;
    int zg = 300;
    public final List zh = new ArrayList();
    int zi;
    Vector zj;

    public kh(qm qm2, boolean bl, boolean bl2, float f, float f2, float f3, float f4, float f5, int n, int n2) {
        super(qm2, EntityType.ARMOR_STAND, bl, bl2);
        this.yZ = f;
        this.za = f2;
        this.zb = f3;
        this.zc = f4;
        this.zd = f5;
        this.zf = n;
        this.zg = n2;
        this.ze = new Vector(0.5, 0.5, 0.5);
    }

    public void a(int n, double d, double d2, double d3) {
        this.zi = n;
        this.zj = new Vector(d, d2, d3);
    }

    public Vector kX() {
        return this.zj;
    }

    public int kY() {
        return this.zi;
    }

    public float kZ() {
        return this.yZ;
    }

    public float la() {
        return this.za;
    }

    public float lb() {
        return this.zb;
    }

    public float lc() {
        return this.zc;
    }

    public float fu() {
        return this.zd;
    }

    public int ld() {
        return this.zf;
    }

    public int le() {
        return this.zg;
    }

    public mm a(mm mm2) {
        this.zh.add(mm2);
        return mm2;
    }

    public List lf() {
        return this.zh;
    }

    public boolean i(ItemStack itemStack) {
        for (mm mm2 : this.zh) {
            if (!mm2.itemStack.isSimilar(itemStack)) continue;
            return true;
        }
        return false;
    }

    public int j(ItemStack itemStack) {
        for (mm mm2 : this.zh) {
            if (!mm2.itemStack.isSimilar(itemStack)) continue;
            return mm2.BG;
        }
        return 0;
    }

    @Nullable
    public ItemStack k(ItemStack itemStack) {
        for (mm mm2 : this.zh) {
            if (!mm2.itemStack.isSimilar(itemStack)) continue;
            return mm2.BF;
        }
        return null;
    }

    public static void C(Entity entity) {
        kh kh2 = (kh)kh.c(entity, yY);
        if (kh2 != null) {
            kh2.q(entity);
        }
    }

    @Override
    public void q(Entity entity) {
        afz.b(entity, this.yZ);
        afz.tK().a(entity, this.xw, this.xx);
    }

    @Override
    public void a(Entity entity, qm qm2) {
        super.a(entity, qm2);
        entity.getPersistentDataContainer().set(xq, PersistentDataType.STRING, (Object)yY);
        entity.setCustomName("ItemsAdder_vehicle");
        entity.setCustomNameVisible(false);
    }

    public static boolean D(Entity entity) {
        String string = (String)entity.getPersistentDataContainer().get(xq, PersistentDataType.STRING);
        return string != null && string.equals(yY);
    }
}
