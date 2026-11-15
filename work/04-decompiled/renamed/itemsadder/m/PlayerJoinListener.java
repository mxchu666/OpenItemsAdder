package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.wrappers.EnumWrappers;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.EntityHolder;
import itemsadder.m.EntityMetadataPacketListener;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PacketContainerHelper;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerHolder_4;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener
implements Listener {
    private static PlayerJoinListener Vg;
    private boolean registered;
    static List Vh;
    static List Vi;
    private PacketAdapter LS;

    public static PlayerJoinListener tf() {
        if (Vg == null) {
            Vg = new PlayerJoinListener();
        }
        return Vg;
    }

    private void register() {
        this.registered = true;
        ListenerBridge.b(this, (Plugin)Main.rS());
        this.LS = new EntityMetadataPacketListener(this, new PacketAdapter.AdapterParameteters().plugin((Plugin)Main.rS()).types(new PacketType[]{PacketType.Play.Server.ENTITY_EQUIPMENT, PacketType.Play.Server.ENTITY_METADATA}));
        PacketListenerRegistry.b((PacketListener)this.LS);
    }

    private void unregister() {
        this.registered = false;
        PacketListenerRegistry.c((PacketListener)this.LS);
    }

    public static void O() {
        if (Vg == null) {
            return;
        }
        Vg.unregister();
        Vg.mc();
    }

    public void bC(Player player) {
        if (!this.registered) {
            this.register();
        }
        Vh.add(player);
        Vi.add(player.getEntityId());
        EntityHolder.tK().bM(player);
        EntityHolder.tK().c((LivingEntity)player, true);
    }

    public void bD(Player player) {
        Vh.remove(player);
        Vi.remove((Object)player.getEntityId());
        EntityHolder.tK().c((LivingEntity)player, false);
        EntityHolder.tK().bN(player);
    }

    public void mc() {
        for (int i = 0; i < Vh.size(); ++i) {
            Player player = (Player)Vh.get(i);
            this.bD(player);
        }
        Vh.clear();
    }

    @EventHandler
    private void b(PlayerJoinEvent playerJoinEvent) {
        for (Player player : Vh) {
            EntityHolder.tK().c((LivingEntity)player, true);
            EntityHolder.tK().bM(player);
        }
    }

    @EventHandler
    private void a(PlayerQuitEvent playerQuitEvent) {
        Player player = playerQuitEvent.getPlayer();
        Vh.remove(player);
        Vi.remove((Object)player.getEntityId());
    }

    @EventHandler
    private void a(PlayerItemHeldEvent playerItemHeldEvent) {
        this.bE(playerItemHeldEvent.getPlayer());
    }

    @EventHandler
    private void a(PlayerSwapHandItemsEvent playerSwapHandItemsEvent) {
        this.bE(playerSwapHandItemsEvent.getPlayer());
    }

    private void bE(Player player) {
        if (Vh.contains(player)) {
            BukkitTaskBridge.c(() -> {
                PlayerHolder_4.l(player, false);
                PlayerJoinListener.bF(player);
            }, 2L);
        }
    }

    private static void bF(Player player) {
        PlayerJoinListener.a(player, EnumWrappers.ItemSlot.MAINHAND);
        PlayerJoinListener.a(player, EnumWrappers.ItemSlot.OFFHAND);
    }

    private static void a(Player player, EnumWrappers.ItemSlot itemSlot) {
        PacketContainerHelper packetContainerHelper = PlayerHolder_4.a(player, itemSlot, null);
        PacketListenerRegistry.a(packetContainerHelper.uX().getHandle(), true);
        packetContainerHelper.cc(player);
    }

    static {
        Vh = new ArrayList();
        Vi = new ArrayList();
    }
}
