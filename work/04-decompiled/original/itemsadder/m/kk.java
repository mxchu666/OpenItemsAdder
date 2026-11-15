package itemsadder.m;

import dev.lone.itemsadder.api.Events.ComplexFurnitureInteractEvent;
import itemsadder.m.ai;
import itemsadder.m.aro;
import itemsadder.m.bcc;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.jn;
import itemsadder.m.jp;
import itemsadder.m.my;
import itemsadder.m.mz;
import itemsadder.m.qm;
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

public class kk
implements ai {
    private final WeakHashMap zl = new WeakHashMap();

    public kk(Plugin plugin) {
        bev.a(this, plugin);
        d.g().ar.a(new my(PlayerInteractEvent.class, this::a));
    }

    @mz
    private void a(PlayerInteractEvent playerInteractEvent, qm qm2, ItemStack itemStack) {
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
            location = bcy.r(playerInteractEvent);
            if (location == null) {
                return;
            }
        }
        jn jn2 = jn.c(qm2);
        if (jn2 == null) {
            return;
        }
        if (!bcc.b(playerInteractEvent.getClickedBlock(), player)) {
            return;
        }
        if (this.zl.containsKey(player)) {
            int n = Math.max(200, player.getPing() + 200);
            if (System.currentTimeMillis() - (Long)this.zl.get(player) < (long)n) {
                return;
            }
        }
        this.zl.put(player, System.currentTimeMillis());
        bce.iA("ComplexFurnitureEventsHandler - getClickedPosition: " + String.valueOf(playerInteractEvent.getClickedPosition()));
        bce.iA("ComplexFurnitureEventsHandler - getClickedBlock: " + String.valueOf(playerInteractEvent.getClickedBlock()));
        bce.iA("ComplexFurnitureEventsHandler - HAND: " + String.valueOf(playerInteractEvent.getHand()));
        BlockFace blockFace = playerInteractEvent.getBlockFace();
        if (Boolean.FALSE.equals(jn2.xM)) {
            Vector vector = aro.b(player.getEyeLocation(), player.getEyeLocation().add(player.getEyeLocation().getDirection().multiply(5)), true);
            if (vector == null) {
                return;
            }
            location = vector.toLocation(player.getWorld());
        }
        jn2.a(player, qm2, itemStack, location, blockFace);
    }

    @EventHandler
    private void a(PlayerInteractEvent playerInteractEvent) {
        if (bev.s(playerInteractEvent) || playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        Player player = playerInteractEvent.getPlayer();
        jp jp2 = jn.aq(player);
        if (jp2 == null) {
            return;
        }
        if (!bev.b(new ComplexFurnitureInteractEvent(playerInteractEvent.getPlayer(), jp2.kD().eh(), playerInteractEvent.getAction(), jp2.kD()))) {
            return;
        }
        jp2.as(player);
    }

    @EventHandler
    private void c(PlayerQuitEvent playerQuitEvent) {
        this.zl.remove(playerQuitEvent.getPlayer());
    }
}
