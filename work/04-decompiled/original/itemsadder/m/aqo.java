package itemsadder.m;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import itemsadder.m.bev;
import java.util.Collection;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public interface aqo {
    public int bT(Player var1);

    public void a(PacketContainer var1, EnumWrappers.ItemSlot var2, ItemStack var3);

    public void h(Player var1, Entity var2);

    public void i(Player var1, Entity var2);

    default public void a(Player player, Entity entity, Vector vector) {
        PlayerInteractAtEntityEvent playerInteractAtEntityEvent = new PlayerInteractAtEntityEvent(player, entity, vector, EquipmentSlot.HAND);
        if (bev.b((Event)playerInteractAtEntityEvent)) {
            this.i(player, entity);
        }
    }

    default public void j(Player player, Entity entity) {
        PlayerInteractEntityEvent playerInteractEntityEvent = new PlayerInteractEntityEvent(player, entity, EquipmentSlot.HAND);
        if (bev.b((Event)playerInteractEntityEvent)) {
            this.i(player, entity);
        }
    }

    default public void a(Player player, @NotNull Collection collection) {
    }

    default public void b(Player player, @NotNull Collection collection) {
    }

    public void a(Player var1, float var2);

    public void aO(Player var1);

    public double a(Player var1, double var2);

    public void bV(Player var1);

    public boolean a(Player var1, EquipmentSlot var2, Block var3, Location var4, BlockFace var5);

    public void c(Player var1, ItemStack var2, int var3);

    public void a(Player var1, EquipmentSlot var2);

    default public void a(Player player, Block block, Block block2) {
        BlockPlaceEvent blockPlaceEvent = new BlockPlaceEvent(block, block.getState(), block2, player.getInventory().getItemInMainHand(), player, true);
        bev.b((Event)blockPlaceEvent);
    }
}
