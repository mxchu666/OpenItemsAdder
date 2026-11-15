package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketListener;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Main;
import itemsadder.m.aiq;
import itemsadder.m.ak;
import itemsadder.m.al;
import itemsadder.m.am;
import itemsadder.m.aow;
import itemsadder.m.avn;
import itemsadder.m.bbs;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.qm;
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

public class aj
implements Listener {
    PacketAdapter gd;
    PacketAdapter ge;
    Cache gf = CacheBuilder.newBuilder().expireAfterWrite(30L, TimeUnit.MINUTES).build();
    private static aj gg;

    public static void i(boolean bl) {
        if (bl) {
            aj.register();
        } else {
            aj.unregister();
        }
    }

    public static void register() {
        if (gg == null) {
            gg = new aj();
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
        this.gd = new ak(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.OPEN_WINDOW_MERCHANT}));
        aow.b((PacketListener)this.gd);
        this.ge = new al(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Client.TR_SEL}));
        aow.b((PacketListener)this.ge);
        bev.b(this, (Plugin)Main.rS());
    }

    private void av() {
        aow.c((PacketListener)this.gd);
        aow.c((PacketListener)this.ge);
        bev.b(this);
    }

    private void a(Player player, am am2) {
        bcp.b(() -> {
            ItemStack itemStack;
            Inventory inventory = am2.gi;
            ItemStack itemStack2 = am2.gk;
            ItemStack itemStack3 = am2.gl;
            ItemStack itemStack4 = inventory.getItem(0);
            if (bbs.at(itemStack4) || bbs.at(inventory.getItem(2))) {
                return;
            }
            ItemStack itemStack5 = itemStack2.clone();
            itemStack5.setAmount(itemStack4.getAmount());
            aiq.b(player, itemStack5, 0);
            if (itemStack3 != null && !bbs.at(itemStack = inventory.getItem(1))) {
                ItemStack itemStack6 = itemStack3.clone();
                itemStack6.setAmount(itemStack.getAmount());
                aiq.b(player, itemStack6, 1);
            }
        }, 3L);
    }

    private boolean b(ItemStack itemStack, ItemStack itemStack2) {
        if (bbs.at(itemStack) && bbs.at(itemStack2)) {
            return true;
        }
        if (itemStack == null || itemStack2 == null) {
            return false;
        }
        if (itemStack.getAmount() < itemStack2.getAmount()) {
            return false;
        }
        if (!qm.isCustomItem(itemStack) && !qm.isCustomItem(itemStack)) {
            return itemStack.isSimilar(itemStack2);
        }
        return qm.b(itemStack, itemStack2);
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
            am am2 = (am)this.gf.getIfPresent(player);
            if (am2 == null) {
                return;
            }
            if (inventoryClickEvent.getClickedInventory() instanceof MerchantInventory && inventoryClickEvent.getSlotType() == InventoryType.SlotType.RESULT) {
                player.updateInventory();
                PacketContainer packetContainer = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Client.TR_SEL);
                packetContainer.getIntegers().write(0, (Object)am2.gj);
                aow.b(player, packetContainer, false);
            }
            this.a(player, am2);
        }
    }

    @EventHandler
    private void a(InventoryCloseEvent inventoryCloseEvent) {
        HumanEntity humanEntity = inventoryCloseEvent.getPlayer();
        if (humanEntity instanceof Player) {
            Player player = (Player)humanEntity;
            this.gf.invalidate(player);
            avn.aob.invalidate(player);
            avn.vv().ch(player);
        }
    }
}
