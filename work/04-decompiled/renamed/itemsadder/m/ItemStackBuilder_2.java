package itemsadder.m;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemStackBuilder_2 {
    private final ItemStack aEn;

    public static ItemStackBuilder_2 aD(ItemStack itemStack) {
        return new ItemStackBuilder_2(itemStack.clone());
    }

    public ItemStackBuilder_2(Material material) {
        this(new ItemStack(material));
    }

    public ItemStackBuilder_2(ItemStack itemStack) {
        this.aEn = Objects.requireNonNull(itemStack, "item");
    }

    public ItemStackBuilder_2 m(Consumer consumer) {
        consumer.accept(this.aEn);
        return this;
    }

    public ItemStackBuilder_2 n(Consumer consumer) {
        return this.m(itemStack -> {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta != null) {
                consumer.accept(itemMeta);
                itemStack.setItemMeta(itemMeta);
            }
        });
    }

    public ItemStackBuilder_2 a(Class clazz, Consumer consumer) {
        return this.n((T itemMeta) -> {
            if (clazz.isInstance(itemMeta)) {
                consumer.accept(clazz.cast(itemMeta));
            }
        });
    }

    public ItemStackBuilder_2 ah(Material material) {
        return this.m(itemStack -> itemStack.setType(material));
    }

    public ItemStackBuilder_2 bY(int n) {
        return this.d((short)n);
    }

    public ItemStackBuilder_2 d(short s) {
        return this.m(itemStack -> itemStack.setDurability(s));
    }

    public ItemStackBuilder_2 bZ(int n) {
        return this.m(itemStack -> itemStack.setAmount(n));
    }

    public ItemStackBuilder_2 a(Enchantment enchantment) {
        return this.a(enchantment, 1);
    }

    public ItemStackBuilder_2 a(Enchantment enchantment, int n) {
        return this.n((T itemMeta) -> itemMeta.addEnchant(enchantment, n, true));
    }

    public ItemStackBuilder_2 b(Enchantment enchantment) {
        return this.n((T itemMeta) -> itemMeta.removeEnchant(enchantment));
    }

    public ItemStackBuilder_2 EZ() {
        return this.n((T itemMeta) -> itemMeta.getEnchants().keySet().forEach(arg_0 -> ((ItemMeta)itemMeta).removeEnchant(arg_0)));
    }

    public ItemStackBuilder_2 js(String string) {
        return this.n((T itemMeta) -> itemMeta.setDisplayName(string));
    }

    public ItemStackBuilder_2 jt(String string) {
        return this.S(Collections.singletonList(string));
    }

    public ItemStackBuilder_2 n(String ... stringArray) {
        return this.S(Arrays.asList(stringArray));
    }

    public ItemStackBuilder_2 S(List list) {
        return this.n((T itemMeta) -> itemMeta.setLore(list));
    }

    public ItemStackBuilder_2 ju(String string) {
        return this.n((T itemMeta) -> {
            List list = itemMeta.getLore();
            if (list == null) {
                itemMeta.setLore(Collections.singletonList(string));
                return;
            }
            list.add(string);
            itemMeta.setLore(list);
        });
    }

    public ItemStackBuilder_2 o(String ... stringArray) {
        return this.T(Arrays.asList(stringArray));
    }

    public ItemStackBuilder_2 T(List list) {
        return this.n((T itemMeta) -> {
            List list2 = itemMeta.getLore();
            if (list2 == null) {
                itemMeta.setLore(list);
                return;
            }
            list2.addAll(list);
            itemMeta.setLore(list2);
        });
    }

    public ItemStackBuilder_2 a(ItemFlag ... itemFlagArray) {
        return this.n((T itemMeta) -> itemMeta.addItemFlags(itemFlagArray));
    }

    public ItemStackBuilder_2 Fa() {
        return this.a(ItemFlag.values());
    }

    public ItemStackBuilder_2 b(ItemFlag ... itemFlagArray) {
        return this.n((T itemMeta) -> itemMeta.removeItemFlags(itemFlagArray));
    }

    public ItemStackBuilder_2 Fb() {
        return this.b(ItemFlag.values());
    }

    public ItemStackBuilder_2 a(Color color) {
        return this.a(LeatherArmorMeta.class, (T leatherArmorMeta) -> leatherArmorMeta.setColor(color));
    }

    public ItemStack Fc() {
        return this.aEn;
    }
}
