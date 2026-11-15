package itemsadder.m;

import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.ajc;
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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundMerchantOffersPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.inventory.CraftInventoryMerchant;
import org.bukkit.craftbukkit.inventory.CraftMerchant;
import org.bukkit.entity.Player;
import org.bukkit.inventory.MerchantInventory;
import org.jetbrains.annotations.Nullable;

public class avz
implements avl {
    @Override
    public void d(PacketEvent packetEvent) {
        ClientboundMerchantOffersPacket clientboundMerchantOffersPacket = (ClientboundMerchantOffersPacket)packetEvent.getPacket().getHandle();
        int n = clientboundMerchantOffersPacket.getOffers().size();
        if (n == 0) {
            return;
        }
        packetEvent.setCancelled(true);
        bcp.i(() -> {
            this.a(clientboundMerchantOffersPacket, packetEvent);
            avn.aob.put(packetEvent.getPlayer(), true);
            aow.a(packetEvent.getPlayer(), packetEvent.getPacket(), false);
        });
    }

    public MerchantOffers a(MerchantOffers merchantOffers) {
        MerchantOffers merchantOffers2 = new MerchantOffers();
        for (MerchantOffer merchantOffer : merchantOffers) {
            merchantOffers2.add((Object)merchantOffer.copy());
        }
        return merchantOffers2;
    }

    private synchronized void a(ClientboundMerchantOffersPacket clientboundMerchantOffersPacket, PacketEvent packetEvent) {
        MerchantOffer merchantOffer;
        int n;
        ItemStack itemStack22;
        if (!(packetEvent.getPlayer().getOpenInventory().getTopInventory() instanceof CraftInventoryMerchant)) {
            return;
        }
        MerchantOffers merchantOffers = this.a(clientboundMerchantOffersPacket.getOffers());
        Player player = packetEvent.getPlayer();
        ServerPlayer serverPlayer = ((CraftPlayer)player).getHandle();
        Inventory inventory = serverPlayer.getInventory();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (ItemStack itemStack22 : inventory.getContents()) {
            if (!this.a(itemStack22)) continue;
            arrayList.add(itemStack22);
        }
        CraftInventoryMerchant craftInventoryMerchant = (CraftInventoryMerchant)player.getOpenInventory().getTopInventory();
        itemStack22 = ((CraftMerchant)craftInventoryMerchant.getMerchant()).getMerchant();
        @Nullable avm avm2 = (avm)anX.getIfPresent(player);
        if (avm2 != null) {
            n = 0;
            boolean bl = false;
            Iterator iterator = merchantOffers.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (n > avm2.pe && n < itemStack22.getOffers().size()) {
                    iterator.remove();
                    itemStack22.getOffers().remove(n);
                    bl = true;
                }
                ++n;
            }
            if (bl) {
                anX.invalidate(player);
            }
            if (player.getOpenInventory().getTopInventory() instanceof MerchantInventory) {
                iterator = ((CraftInventoryMerchant)player.getOpenInventory().getTopInventory()).getInventory();
                ItemStack itemStack3 = iterator.getItem(0);
                if (this.a(itemStack3)) {
                    arrayList.add(itemStack3);
                }
                if (this.a((ItemStack)(merchantOffer = iterator.getItem(1)))) {
                    arrayList.add(merchantOffer);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        n = merchantOffers.size() - 1;
        ArrayList<MerchantOffer> arrayList2 = new ArrayList<MerchantOffer>();
        int n2 = merchantOffers.size();
        for (int i = 0; i < n2; ++i) {
            merchantOffer = (MerchantOffer)merchantOffers.get(i);
            ItemStack itemStack4 = merchantOffer.getBaseCostA();
            ItemStack itemStack5 = merchantOffer.getCostB();
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
            MerchantOffer merchantOffer2 = merchantOffer.copy();
            if (itemStack6 != null) {
                merchantOffer2.baseCostA = new ItemCost((Holder)itemStack6.getItem().builtInRegistryHolder(), itemStack4.getCount(), DataComponentExactPredicate.allOf((DataComponentMap)itemStack6.getComponents()));
            }
            if (itemStack7 != null) {
                merchantOffer2.costB = Optional.of(new ItemCost((Holder)itemStack7.getItem().builtInRegistryHolder(), itemStack5.getCount(), DataComponentExactPredicate.allOf((DataComponentMap)itemStack7.getComponents())));
            }
            arrayList2.add(merchantOffer2);
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        anX.put(player, new avm(clientboundMerchantOffersPacket.getContainerId(), n));
        itemStack22.getOffers().addAll(arrayList2);
        packetEvent.getPacket().getSpecificModifier(MerchantOffers.class).write(0, (Object)merchantOffers);
    }

    private boolean b(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack2.isEmpty() && itemStack.isEmpty()) {
            return true;
        }
        ItemStack itemStack3 = itemStack.copy();
        if (itemStack3.getMaxDamage() > 0) {
            itemStack3.setDamageValue(itemStack3.getDamageValue());
        }
        return ItemStack.isSameItemSameComponents((ItemStack)itemStack3, (ItemStack)itemStack2);
    }

    private boolean a(ItemStack itemStack) {
        if (itemStack.getItem() == Items.AIR) {
            return false;
        }
        return ajc.a(itemStack);
    }

    private boolean c(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null && itemStack2 == null) {
            return false;
        }
        if (itemStack == null || itemStack2 == null) {
            return false;
        }
        if (itemStack.getItem() == Items.AIR && itemStack2.getItem() == Items.AIR) {
            return false;
        }
        if (itemStack.getDamageValue() != itemStack2.getDamageValue()) {
            return false;
        }
        if (itemStack.has(DataComponents.CUSTOM_DATA) && itemStack2.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag compoundTag = ((CustomData)itemStack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            CompoundTag compoundTag2 = ((CustomData)itemStack2.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            if (compoundTag.contains("itemsadder") && compoundTag2.contains("itemsadder")) {
                CompoundTag compoundTag3 = (CompoundTag)compoundTag.getCompound("itemsadder").get();
                CompoundTag compoundTag4 = (CompoundTag)compoundTag2.getCompound("itemsadder").get();
                return compoundTag3.getString("namespace").equals(compoundTag4.getString("namespace")) && compoundTag3.getString("id").equals(compoundTag4.getString("id"));
            }
        }
        return false;
    }
}
