package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.InstanceHolder_3;
import itemsadder.m.InventoryIntItemStackData;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PacketListener;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PacketListener_2;
import itemsadder.m.PlayerHolder_2;
import java.util.concurrent.TimeUnit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantInventory;
import org.bukkit.plugin.Plugin;

public class InventoryClickListener
implements Listener {
    PacketAdapter gd;
    PacketAdapter ge;
    Cache gf = CacheBuilder.newBuilder().expireAfterWrite(30L, TimeUnit.MINUTES).build();
    private static InventoryClickListener gg;

    public static void i(boolean bl) {
        if (bl) {
            InventoryClickListener.register();
        } else {
            InventoryClickListener.unregister();
        }
    }

    public static void register() {
        if (gg == null) {
            gg = new InventoryClickListener();
            gg.au();
        }
    }

    public static void unregister() {
        if (gg != null) {
            gg.av();
            gg = null;
        }
    }

    private void au() {
        this.gd = new PacketListener(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.OPEN_WINDOW_MERCHANT}));
        PacketListenerRegistry.b((com.comphenix.protocol.events.PacketListener)this.gd);
        this.ge = new PacketListener_2(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Client.TR_SEL}));
        PacketListenerRegistry.b((com.comphenix.protocol.events.PacketListener)this.ge);
        ListenerBridge.b(this, (Plugin)Main.rS());
    }

    private void av() {
        PacketListenerRegistry.c((com.comphenix.protocol.events.PacketListener)this.gd);
        PacketListenerRegistry.c((com.comphenix.protocol.events.PacketListener)this.ge);
        ListenerBridge.b(this);
    }

    private void a(Player player, InventoryIntItemStackData inventoryIntItemStackData) {
        BukkitTaskBridge.b(() -> {
            ItemStack itemStack;
            Inventory inventory = inventoryIntItemStackData.gi;
            ItemStack itemStack2 = inventoryIntItemStackData.gk;
            ItemStack itemStack3 = inventoryIntItemStackData.gl;
            ItemStack itemStack4 = inventory.getItem(0);
            if (ItemStackBridge_2.at(itemStack4) || ItemStackBridge_2.at(inventory.getItem(2))) {
                return;
            }
            ItemStack itemStack5 = itemStack2.clone();
            itemStack5.setAmount(itemStack4.getAmount());
            PlayerHolder_2.b(player, itemStack5, 0);
            if (itemStack3 != null && !ItemStackBridge_2.at(itemStack = inventory.getItem(1))) {
                ItemStack itemStack6 = itemStack3.clone();
                itemStack6.setAmount(itemStack.getAmount());
                PlayerHolder_2.b(player, itemStack6, 1);
            }
        }, 3L);
    }

    private boolean b(ItemStack itemStack, ItemStack itemStack2) {
        if (ItemStackBridge_2.at(itemStack) && ItemStackBridge_2.at(itemStack2)) {
            return true;
        }
        if (itemStack == null || itemStack2 == null) {
            return false;
        }
        if (itemStack.getAmount() < itemStack2.getAmount()) {
            return false;
        }
        if (!ItemStackBuilder_4.isCustomItem(itemStack) && !ItemStackBuilder_4.isCustomItem(itemStack)) {
            return itemStack.isSimilar(itemStack2);
        }
        return ItemStackBuilder_4.b(itemStack, itemStack2);
    }

    @EventHandler
    private void b(InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.getClickedInventory() == null) {
            return;
        }
        if (inventoryClickEvent.getView().getTopInventory() instanceof MerchantInventory) {
            if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
                return;
            }
            Player player = (Player)inventoryClickEvent.getWhoClicked();
            InventoryIntItemStackData inventoryIntItemStackData = (InventoryIntItemStackData)this.gf.getIfPresent(player);
            if (inventoryIntItemStackData == null) {
                return;
            }
            if (inventoryClickEvent.getClickedInventory() instanceof MerchantInventory && inventoryClickEvent.getSlotType() == InventoryType.SlotType.RESULT) {
                player.updateInventory();
                PacketContainer packetContainer = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Client.TR_SEL);
                packetContainer.getIntegers().write(0, (Object)inventoryIntItemStackData.gj);
                PacketListenerRegistry.b(player, packetContainer, false);
            }
            this.a(player, inventoryIntItemStackData);
        }
    }

    @EventHandler
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        HumanEntity humanEntity = inventoryCloseEvent.getPlayer();
        if (humanEntity instanceof Player) {
            Player player = (Player)humanEntity;
            this.gf.invalidate(player);
            InstanceHolder_3.aob.invalidate(player);
            InstanceHolder_3.vv().ch(player);
        }
    }
}
