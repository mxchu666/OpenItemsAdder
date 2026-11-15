package itemsadder.m;

import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.aiy;
import itemsadder.m.aow;
import itemsadder.m.avl;
import itemsadder.m.avm;
import itemsadder.m.avn;
import itemsadder.m.bcp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentExactPredicate;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.protocol.game.PacketPlayOutOpenWindowMerchant;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.world.entity.player.PlayerInventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantRecipe;
import net.minecraft.world.item.trading.MerchantRecipeList;
import org.bukkit.craftbukkit.v1_21_R5.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftInventoryMerchant;
import org.bukkit.craftbukkit.v1_21_R5.inventory.CraftMerchant;
import org.bukkit.entity.Player;
import org.bukkit.inventory.MerchantInventory;
import org.jetbrains.annotations.Nullable;

public class avv
implements avl {
    @Override
    public void d(PacketEvent packetEvent) {
        PacketPlayOutOpenWindowMerchant packetPlayOutOpenWindowMerchant = (PacketPlayOutOpenWindowMerchant)packetEvent.getPacket().getHandle();
        int n = packetPlayOutOpenWindowMerchant.e().size();
        if (n == 0) {
            return;
        }
        packetEvent.setCancelled(true);
        bcp.i(() -> {
            this.a(packetPlayOutOpenWindowMerchant, packetEvent);
            avn.aob.put(packetEvent.getPlayer(), true);
            aow.a(packetEvent.getPlayer(), packetEvent.getPacket(), false);
        });
    }

    public MerchantRecipeList a(MerchantRecipeList merchantRecipeList) {
        MerchantRecipeList merchantRecipeList2 = new MerchantRecipeList();
        for (MerchantRecipe merchantRecipe : merchantRecipeList) {
            merchantRecipeList2.add((Object)merchantRecipe.v());
        }
        return merchantRecipeList2;
    }

    private synchronized void a(PacketPlayOutOpenWindowMerchant packetPlayOutOpenWindowMerchant, PacketEvent packetEvent) {
        MerchantRecipe merchantRecipe;
        int n;
        ItemStack itemStack22;
        if (!(packetEvent.getPlayer().getOpenInventory().getTopInventory() instanceof CraftInventoryMerchant)) {
            return;
        }
        MerchantRecipeList merchantRecipeList = this.a(packetPlayOutOpenWindowMerchant.e());
        Player player = packetEvent.getPlayer();
        EntityPlayer entityPlayer = ((CraftPlayer)player).getHandle();
        PlayerInventory playerInventory = entityPlayer.gs();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (ItemStack itemStack22 : playerInventory.getContents()) {
            if (!this.a(itemStack22)) continue;
            arrayList.add(itemStack22);
        }
        CraftInventoryMerchant craftInventoryMerchant = (CraftInventoryMerchant)player.getOpenInventory().getTopInventory();
        itemStack22 = ((CraftMerchant)craftInventoryMerchant.getMerchant()).getMerchant();
        @Nullable avm avm2 = (avm)anX.getIfPresent(player);
        if (avm2 != null) {
            n = 0;
            boolean bl = false;
            Iterator iterator = merchantRecipeList.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (n > avm2.pe && n < itemStack22.gJ().size()) {
                    iterator.remove();
                    itemStack22.gJ().remove(n);
                    bl = true;
                }
                ++n;
            }
            if (bl) {
                anX.invalidate(player);
            }
            if (player.getOpenInventory().getTopInventory() instanceof MerchantInventory) {
                iterator = ((CraftInventoryMerchant)player.getOpenInventory().getTopInventory()).getInventory();
                ItemStack itemStack3 = iterator.a(0);
                if (this.a(itemStack3)) {
                    arrayList.add(itemStack3);
                }
                if (this.a((ItemStack)(merchantRecipe = iterator.a(1)))) {
                    arrayList.add(merchantRecipe);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        n = merchantRecipeList.size() - 1;
        ArrayList<MerchantRecipe> arrayList2 = new ArrayList<MerchantRecipe>();
        int n2 = merchantRecipeList.size();
        for (int i = 0; i < n2; ++i) {
            merchantRecipe = (MerchantRecipe)merchantRecipeList.get(i);
            ItemStack itemStack4 = merchantRecipe.a();
            ItemStack itemStack5 = merchantRecipe.c();
            ItemStack itemStack6 = null;
            ItemStack itemStack7 = null;
            for (ItemStack itemStack8 : arrayList) {
                if (this.c(itemStack4, itemStack8) && !this.b(itemStack8, itemStack4)) {
                    itemStack6 = itemStack8;
                }
                if (!this.c(itemStack5, itemStack8) || this.b(itemStack8, itemStack5)) continue;
                itemStack7 = itemStack8;
            }
            if (itemStack6 == null && itemStack7 == null) continue;
            MerchantRecipe merchantRecipe2 = merchantRecipe.v();
            if (itemStack6 != null) {
                merchantRecipe2.c = new ItemCost((Holder)itemStack6.h().e(), itemStack4.M(), DataComponentExactPredicate.a((DataComponentMap)itemStack6.a()));
            }
            if (itemStack7 != null) {
                merchantRecipe2.d = Optional.of(new ItemCost((Holder)itemStack7.h().e(), itemStack5.M(), DataComponentExactPredicate.a((DataComponentMap)itemStack7.a())));
            }
            arrayList2.add(merchantRecipe2);
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        anX.put(player, new avm(packetPlayOutOpenWindowMerchant.b(), n));
        itemStack22.gJ().addAll(arrayList2);
        packetEvent.getPacket().getSpecificModifier(MerchantRecipeList.class).write(0, (Object)merchantRecipeList);
    }

    private boolean b(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack2.f() && itemStack.f()) {
            return true;
        }
        ItemStack itemStack3 = itemStack.v();
        if (itemStack3.p() > 0) {
            itemStack3.b(itemStack3.o());
        }
        return ItemStack.c((ItemStack)itemStack3, (ItemStack)itemStack2);
    }

    private boolean a(ItemStack itemStack) {
        if (itemStack.h() == Items.a) {
            return false;
        }
        return aiy.a(itemStack);
    }

    private boolean c(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null && itemStack2 == null) {
            return false;
        }
        if (itemStack == null || itemStack2 == null) {
            return false;
        }
        if (itemStack.h() == Items.a && itemStack2.h() == Items.a) {
            return false;
        }
        if (itemStack.o() != itemStack2.o()) {
            return false;
        }
        if (itemStack.c(DataComponents.b) && itemStack2.c(DataComponents.b)) {
            NBTTagCompound nBTTagCompound = ((CustomData)itemStack.a(DataComponents.b)).e();
            NBTTagCompound nBTTagCompound2 = ((CustomData)itemStack2.a(DataComponents.b)).e();
            if (nBTTagCompound.b("itemsadder") && nBTTagCompound2.b("itemsadder")) {
                NBTTagCompound nBTTagCompound3 = (NBTTagCompound)nBTTagCompound.m("itemsadder").get();
                NBTTagCompound nBTTagCompound4 = (NBTTagCompound)nBTTagCompound2.m("itemsadder").get();
                return nBTTagCompound3.i("namespace").equals(nBTTagCompound4.i("namespace")) && nBTTagCompound3.i("id").equals(nBTTagCompound4.i("id"));
            }
        }
        return false;
    }
}
