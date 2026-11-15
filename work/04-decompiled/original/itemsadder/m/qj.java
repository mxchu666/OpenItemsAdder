package itemsadder.m;

import itemsadder.m.bbf;
import itemsadder.m.qm;
import itemsadder.m.qt;
import itemsadder.m.rd;
import lombok.Generated;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.Nullable;

public class qj
extends qm {
    public final qt Fs;
    final boolean Ft;
    @Nullable
    private rd Fu;

    @Nullable
    public static rd j(qm qm2) {
        if (qm2 instanceof qj) {
            qj qj2 = (qj)qm2;
            return qj2.mB();
        }
        return null;
    }

    public qj(bbf bbf2, String string, String string2, Material material, @Nullable Color color, boolean bl) {
        super(bbf2, string, string2, material);
        this.Fs = qj.i(material);
        this.Ft = bl;
        this.setColor(color);
    }

    public void setColor(Color color) {
        if (color != null) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta)this.getItemMeta();
            leatherArmorMeta.setColor(color);
            leatherArmorMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_DYE});
            this.setItemMeta((ItemMeta)leatherArmorMeta);
        }
    }

    public int getColor() {
        return ((LeatherArmorMeta)this.getItemMeta()).getColor().asRGB();
    }

    public void a(rd rd2) {
        this.Fu = rd2;
        this.setColor(rd2.HC);
    }

    @Nullable
    public rd mB() {
        return this.Fu;
    }

    @Nullable
    public static Material a(@Nullable qt qt2) {
        if (qt2 != null) {
            switch (qt2) {
                case HEAD: {
                    return Material.LEATHER_HELMET;
                }
                case CHEST: {
                    return Material.LEATHER_CHESTPLATE;
                }
                case LEGS: {
                    return Material.LEATHER_LEGGINGS;
                }
                case FEET: {
                    return Material.LEATHER_BOOTS;
                }
            }
        }
        return null;
    }

    public static qt i(Material material) {
        switch (material) {
            case LEATHER_CHESTPLATE: {
                return qt.CHEST;
            }
            case LEATHER_LEGGINGS: {
                return qt.LEGS;
            }
            case LEATHER_BOOTS: {
                return qt.FEET;
            }
        }
        return qt.HEAD;
    }

    @Generated
    public boolean mC() {
        return this.Ft;
    }
}
