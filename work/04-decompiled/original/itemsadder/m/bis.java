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

public class bis {
    private final ItemStack aEn;

    public static bis aD(ItemStack itemStack) {
        return new bis(itemStack.clone());
    }

    public bis(Material material) {
        this(new ItemStack(material));
    }

    public bis(ItemStack itemStack) {
        this.aEn = Objects.requireNonNull(itemStack, "item");
    }

    public bis m(Consumer consumer) {
        consumer.accept(this.aEn);
        return this;
    }

    public bis n(Consumer consumer) {
        return this.m(itemStack -> {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta != null) {
                consumer.accept(itemMeta);
                itemStack.setItemMeta(itemMeta);
            }
        });
    }

    public bis a(Class clazz, Consumer consumer) {
        return this.n((T itemMeta) -> {
            if (clazz.isInstance(itemMeta)) {
                consumer.accept(clazz.cast(itemMeta));
            }
        });
    }

    public bis ah(Material material) {
        return this.m(itemStack -> itemStack.setType(material));
    }

    public bis bY(int n) {
        return this.d((short)n);
    }

    public bis d(short s) {
        return this.m(itemStack -> itemStack.setDurability(s));
    }

    public bis bZ(int n) {
        return this.m(itemStack -> itemStack.setAmount(n));
    }

    public bis a(Enchantment enchantment) {
        return this.a(enchantment, 1);
    }

    public bis a(Enchantment enchantment, int n) {
        return this.n((T itemMeta) -> itemMeta.addEnchant(enchantment, n, true));
    }

    public bis b(Enchantment enchantment) {
        return this.n((T itemMeta) -> itemMeta.removeEnchant(enchantment));
    }

    public bis EZ() {
        return this.n((T itemMeta) -> itemMeta.getEnchants().keySet().forEach(arg_0 -> ((ItemMeta)itemMeta).removeEnchant(arg_0)));
    }

    public bis js(String string) {
        return this.n((T itemMeta) -> itemMeta.setDisplayName(string));
    }

    public bis jt(String string) {
        return this.S(Collections.singletonList(string));
    }

    public bis n(String ... stringArray) {
        return this.S(Arrays.asList(stringArray));
    }

    public bis S(List list) {
        return this.n((T itemMeta) -> itemMeta.setLore(list));
    }

    public bis ju(String string) {
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

    public bis o(String ... stringArray) {
        return this.T(Arrays.asList(stringArray));
    }

    public bis T(List list) {
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

    public bis a(ItemFlag ... itemFlagArray) {
        return this.n((T itemMeta) -> itemMeta.addItemFlags(itemFlagArray));
    }

    public bis Fa() {
        return this.a(ItemFlag.values());
    }

    public bis b(ItemFlag ... itemFlagArray) {
        return this.n((T itemMeta) -> itemMeta.removeItemFlags(itemFlagArray));
    }

    public bis Fb() {
        return this.b(ItemFlag.values());
    }

    public bis a(Color color) {
        return this.a(LeatherArmorMeta.class, (T leatherArmorMeta) -> leatherArmorMeta.setColor(color));
    }

    public ItemStack Fc() {
        return this.aEn;
    }
}
