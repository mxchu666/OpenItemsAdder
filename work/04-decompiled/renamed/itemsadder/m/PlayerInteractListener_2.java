package itemsadder.m;

import dev.lone.itemsadder.api.Events.ComplexFurnitureInteractEvent;
import itemsadder.m.ClassRefData;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.LocationBridge_2;
import itemsadder.m.LocationHolder;
import itemsadder.m.PlayerBridge_16;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import itemsadder.m.RecordOfValue_20;
import java.util.WeakHashMap;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class PlayerInteractListener_2
implements PluginContract {
    private final WeakHashMap zl = new WeakHashMap();

    public PlayerInteractListener_2(Plugin plugin) {
        ListenerBridge.a(this, plugin);
        ItemStackRegistry.g().ar.a(new ClassRefData(PlayerInteractEvent.class, this::a));
    }

    @PluginContract_19
    private void a(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        Location location;
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (playerInteractEvent.getClickedBlock() == null) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        if (!player.isSneaking()) {
            location = playerInteractEvent.getClickedBlock().getRelative(playerInteractEvent.getBlockFace()).getLocation().add(0.5, 0.5, 0.5);
        } else {
            location = ColorBridge.r(playerInteractEvent);
            if (location == null) {
                return;
            }
        }
        PlayerBridge_16 playerBridge_16 = PlayerBridge_16.c(itemStackBuilder_4);
        if (playerBridge_16 == null) {
            return;
        }
        if (!LocationBridge_2.b(playerInteractEvent.getClickedBlock(), player)) {
            return;
        }
        if (this.zl.containsKey(player)) {
            int n = Math.max(200, player.getPing() + 200);
            if (System.currentTimeMillis() - (Long)this.zl.get(player) < (long)n) {
                return;
            }
        }
        this.zl.put(player, System.currentTimeMillis());
        CommandSenderBridge_5.iA("ComplexFurnitureEventsHandler - getClickedPosition: " + String.valueOf(playerInteractEvent.getClickedPosition()));
        CommandSenderBridge_5.iA("ComplexFurnitureEventsHandler - getClickedBlock: " + String.valueOf(playerInteractEvent.getClickedBlock()));
        CommandSenderBridge_5.iA("ComplexFurnitureEventsHandler - HAND: " + String.valueOf(playerInteractEvent.getHand()));
        BlockFace blockFace = playerInteractEvent.getBlockFace();
        if (Boolean.FALSE.equals(playerBridge_16.xM)) {
            Vector vector = LocationHolder.b(player.getEyeLocation(), player.getEyeLocation().add(player.getEyeLocation().getDirection().multiply(5)), true);
            if (vector == null) {
                return;
            }
            location = vector.toLocation(player.getWorld());
        }
        playerBridge_16.a(player, itemStackBuilder_4, itemStack, location, blockFace);
    }

    @EventHandler
    private void a(PlayerInteractEvent playerInteractEvent) {
        if (ListenerBridge.s(playerInteractEvent) || playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        RecordOfValue_20 recordOfValue_20 = PlayerBridge_16.aq(player);
        if (recordOfValue_20 == null) {
            return;
        }
        if (!ListenerBridge.b(new ComplexFurnitureInteractEvent(playerInteractEvent.getPlayer(), recordOfValue_20.kD().eh(), playerInteractEvent.getAction(), recordOfValue_20.kD()))) {
            return;
        }
        recordOfValue_20.as(player);
    }

    @EventHandler
    private void c(PlayerQuitEvent playerQuitEvent) {
        this.zl.remove(playerQuitEvent.getPlayer());
    }
}
