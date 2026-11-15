package itemsadder.m;

import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import java.util.Random;
import lombok.Generated;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemStackBridge_32 {
    ItemStack itemStack;
    @Nullable
    final ItemStackBuilder_4 IP;
    final int IQ;
    final int IR;
    final float IS;
    final boolean IT;
    final boolean IU;

    public ItemStackBridge_32(int n, int n2, float f, boolean bl) {
        this.IQ = n;
        this.IR = n2;
        this.IS = f;
        this.IT = bl;
        this.IU = f >= 100.0f;
        this.IP = null;
    }

    public ItemStackBridge_32(@NotNull ItemStack itemStack, int n, int n2, float f, boolean bl) {
        if (itemStack instanceof ItemStackBuilder_4) {
            ItemStackBuilder_4 itemStackBuilder_4;
            this.IP = itemStackBuilder_4 = (ItemStackBuilder_4)itemStack;
            this.itemStack = this.IP;
        } else {
            this.IP = null;
            this.itemStack = itemStack;
        }
        this.IQ = n;
        this.IR = n2;
        this.IS = f;
        this.IT = bl;
        this.IU = f >= 100.0f;
    }

    public void M(@NotNull ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @NotNull
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @NotNull
    public ItemStack av(boolean bl) {
        return this.b(null, bl);
    }

    @Nullable
    public ItemStackBuilder_4 oP() {
        return this.IP;
    }

    public boolean oQ() {
        return this.IP != null;
    }

    public boolean dy() {
        if (!this.IU) {
            return !(Math.random() * 100.0 > (double)this.IS);
        }
        return true;
    }

    public ItemStack b(@Nullable ItemStack itemStack, boolean bl) {
        if (bl) {
            ItemStack itemStack2 = this.itemStack.clone();
            itemStack2.setAmount(this.a(itemStack, this.IQ, this.IR));
            return itemStack2;
        }
        return this.itemStack;
    }

    public static int j(int n, int n2, int n3) {
        Random random = new Random();
        if (n < 1) {
            return random.nextInt(n3 - n2 + 1) + n2;
        }
        int n4 = random.nextInt(n + 2) - 1;
        if (n4 < 0) {
            n4 = 0;
        }
        return random.nextInt(n3 - n2 + 2) + n2 * (n4 + 1);
    }

    public int a(@Nullable ItemStack itemStack, int n, int n2) {
        int n3 = -1;
        if (!this.IT && itemStack != null && itemStack.getType() != Material.AIR) {
            n3 = ItemStackBridge_2.b(itemStack, Enchantment.FORTUNE);
        }
        return ItemStackBridge_32.j(n3, n, n2);
    }

    @Generated
    public int oR() {
        return this.IQ;
    }

    @Generated
    public int oS() {
        return this.IR;
    }

    @Generated
    public float oT() {
        return this.IS;
    }

    @Generated
    public boolean oU() {
        return this.IU;
    }
}
