package itemsadder.m;

import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.InstanceHolder_3;
import itemsadder.m.InventoryClickListener;
import itemsadder.m.InventoryIntItemStackData;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.PacketListenerRegistry;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

class PacketListener_2
extends PacketAdapter {
    final /* synthetic */ InventoryClickListener gh;

    PacketListener_2(InventoryClickListener inventoryClickListener, PacketAdapter.AdapterParameteters adapterParameteters) {
        this.gh = inventoryClickListener;
        super(adapterParameteters);
    }

    public void onPacketReceiving(PacketEvent packetEvent) {
        if (packetEvent.isCancelled() || packetEvent.isPlayerTemporary()) {
            return;
        }
        Player player = packetEvent.getPlayer();
        if (!(player.getOpenInventory().getTopInventory() instanceof MerchantInventory)) {
            return;
        }
        MerchantInventory merchantInventory = (MerchantInventory)player.getOpenInventory().getTopInventory();
        Merchant merchant = merchantInventory.getMerchant();
        Integer n = (Integer)packetEvent.getPacket().getIntegers().read(0);
        if (n > merchant.getRecipeCount() - 1) {
            return;
        }
        if (!InstanceHolder_3.aob.asMap().containsKey(player)) {
            return;
        }
        MerchantRecipe merchantRecipe = merchant.getRecipe(n.intValue());
        ItemStack itemStack = merchantRecipe.getAdjustedIngredient1();
        ItemStack itemStack2 = merchantRecipe.getIngredients().size() == 2 ? (ItemStack)merchantRecipe.getIngredients().get(1) : null;
        ItemStack itemStack3 = merchantRecipe.getResult();
        boolean bl = ItemStackBuilder_4.isCustomItem(itemStack);
        boolean bl2 = ItemStackBuilder_4.isCustomItem(itemStack2);
        if (bl || bl2) {
            BukkitTaskBridge.b(() -> {
                if (!ItemStackBridge_2.at(merchantInventory.getItem(2))) {
                    return;
                }
                @NotNull List list = merchant.getRecipes();
                int n2 = list.size();
                for (int i = n + 1; i < n2; ++i) {
                    MerchantRecipe merchantRecipe = (MerchantRecipe)list.get(i);
                    ItemStack itemStack4 = merchantRecipe.getAdjustedIngredient1();
                    ItemStack itemStack5 = merchantRecipe.getIngredients().size() == 2 ? (ItemStack)merchantRecipe.getIngredients().get(1) : null;
                    ItemStack itemStack6 = merchantRecipe.getResult();
                    if (!this.gh.b(itemStack, itemStack4) || !this.gh.b(itemStack2, itemStack5) || !this.gh.b(itemStack3, itemStack6)) continue;
                    PacketContainer packetContainer = packetEvent.getPacket().deepClone();
                    packetContainer.getIntegers().write(0, (Object)i);
                    PacketListenerRegistry.b(player, packetContainer, false);
                    InventoryIntItemStackData inventoryIntItemStackData = new InventoryIntItemStackData((Inventory)merchantInventory, i, itemStack, itemStack2);
                    this.gh.gf.put(player, inventoryIntItemStackData);
                    this.gh.a(player, inventoryIntItemStackData);
                    return;
                }
            }, 3L);
        }
    }
}
