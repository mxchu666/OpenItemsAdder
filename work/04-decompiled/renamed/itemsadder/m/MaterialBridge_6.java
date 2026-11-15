package itemsadder.m;

import itemsadder.m.ColorBridge_2;
import itemsadder.m.HeadEnum;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PluginFileConfigurationHolder;
import lombok.Generated;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.Nullable;

public class MaterialBridge_6
extends ItemStackBuilder_4 {
    public final HeadEnum Fs;
    final boolean Ft;
    @Nullable
    private ColorBridge_2 Fu;

    @Nullable
    public static ColorBridge_2 j(ItemStackBuilder_4 itemStackBuilder_4) {
        if (itemStackBuilder_4 instanceof MaterialBridge_6) {
            MaterialBridge_6 materialBridge_6 = (MaterialBridge_6)itemStackBuilder_4;
            return materialBridge_6.mB();
        }
        return null;
    }

    public MaterialBridge_6(PluginFileConfigurationHolder pluginFileConfigurationHolder, String string, String string2, Material material, @Nullable Color color, boolean bl) {
        super(pluginFileConfigurationHolder, string, string2, material);
        this.Fs = MaterialBridge_6.i(material);
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

    public void a(ColorBridge_2 colorBridge_2) {
        this.Fu = colorBridge_2;
        this.setColor(colorBridge_2.HC);
    }

    @Nullable
    public ColorBridge_2 mB() {
        return this.Fu;
    }

    @Nullable
    public static Material a(@Nullable HeadEnum headEnum) {
        if (headEnum != null) {
            switch (headEnum) {
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

    public static HeadEnum i(Material material) {
        switch (material) {
            case LEATHER_CHESTPLATE: {
                return HeadEnum.CHEST;
            }
            case LEATHER_LEGGINGS: {
                return HeadEnum.LEGS;
            }
            case LEATHER_BOOTS: {
                return HeadEnum.FEET;
            }
        }
        return HeadEnum.HEAD;
    }

    @Generated
    public boolean mC() {
        return this.Ft;
    }
}
