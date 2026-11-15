package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NItem;
import java.util.List;
import net.kyori.adventure.text.Component;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface aii {
    public void b(Player var1, Component var2);

    public int bT(Player var1);

    public String K(Material var1);

    default public String W(ItemStack itemStack) {
        return this.K(itemStack.getType());
    }

    public void c(ItemStack var1, String var2);

    @Nullable
    public Double X(ItemStack var1);

    public void c(NItem var1, String var2);

    public ItemStack Y(ItemStack var1);

    public void f(@NotNull ItemStack var1, @NotNull ItemStack var2);

    default public void a(ItemStack itemStack, float f, String string) {
        throw new UnsupportedOperationException("This method is not supported in this version of Minecraft!");
    }

    default public boolean Z(ItemStack itemStack) {
        return false;
    }

    public void a(ItemStack var1, int var2, float var3, boolean var4, int var5, @Nullable String var6, @Nullable String var7, @Nullable Boolean var8, @Nullable List var9);

    default public boolean aa(ItemStack itemStack) {
        return false;
    }

    default public void a(ItemStack itemStack, EquipmentSlot equipmentSlot, @Nullable NamespacedKey namespacedKey, @Nullable String string, @Nullable NamespacedKey namespacedKey2, @Nullable List list, @Nullable Boolean bl, @Nullable Boolean bl2, @Nullable Boolean bl3, @Nullable Boolean bl4) {
        throw new UnsupportedOperationException("This method is not supported in this version of Minecraft!");
    }

    default public void a(ItemStack itemStack, @Nullable NamespacedKey namespacedKey) {
        throw new UnsupportedOperationException("This method is not supported in this version of Minecraft!");
    }

    public void ab(ItemStack var1);

    default public void b(ItemStack itemStack, @Nullable NamespacedKey namespacedKey) {
        throw new UnsupportedOperationException("This method is not supported in this version of Minecraft!");
    }

    public boolean g(ItemStack var1, ItemStack var2);

    default public void d(ItemStack itemStack, String string) {
        throw new UnsupportedOperationException("This method is not supported in this version of Minecraft!");
    }

    default public void a(ItemStack itemStack, Color color) {
        throw new UnsupportedOperationException("This method is not supported in this version of Minecraft!");
    }

    default public void a(ItemStack itemStack, List list) {
        throw new UnsupportedOperationException("This method is not supported in this version of Minecraft!");
    }

    default public void b(ItemStack itemStack, List list) {
        throw new UnsupportedOperationException("This method is not supported in this version of Minecraft!");
    }
}
