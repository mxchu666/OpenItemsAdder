package dev.lone.itemsadder.resourcepack;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketListener;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.ab;
import dev.lone.itemsadder.resourcepack.av;
import dev.lone.itemsadder.resourcepack.ax;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PlayerBridge_2;
import itemsadder.m.PluginBridge_2;
import itemsadder.m.PluginContract;
import java.text.MessageFormat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.plugin.Plugin;

public class aa
implements PluginContract {
    private PacketListener arX = null;
    private final av arY;

    public aa(av av2) {
        this.arY = av2;
        PacketType[] packetTypeArray = new PacketType[]{PacketType.Play.Server.ADD_RESOURCE_PACK, PacketType.Configuration.Server.ADD_RESOURCE_PACK};
        this.arX = new ab(this, (Plugin)Main.rS(), ListenerPriority.HIGHEST, packetTypeArray, av2);
    }

    public void register(Plugin plugin) {
        ListenerBridge.a(this, plugin);
        PacketListenerRegistry.b(this.arX);
    }

    @Override
    public void unregister() {
        ListenerBridge.b(this);
        PacketListenerRegistry.c(this.arX);
    }

    @EventHandler
    public void c(PlayerJoinEvent playerJoinEvent) {
        if (this.arY.aui instanceof PlayerBridge_2) {
            Player player = playerJoinEvent.getPlayer();
            CommandSenderBridge.l((CommandSender)player);
        }
        if (MaterialBarColorHolder.db) {
            return;
        }
        if (this.arY.aui instanceof PluginBridge_2) {
            return;
        }
        this.arY.aui.f(playerJoinEvent);
    }

    @EventHandler
    public void a(PlayerResourcePackStatusEvent playerResourcePackStatusEvent) {
        switch (playerResourcePackStatusEvent.getStatus()) {
            case ACCEPTED: {
                this.arY.a(playerResourcePackStatusEvent.getPlayer(), ax.PLAYER_DOWNLOADING);
                break;
            }
            case SUCCESSFULLY_LOADED: {
                this.arY.a(playerResourcePackStatusEvent.getPlayer(), ax.INSTALLED);
                break;
            }
            case DECLINED: {
                if (Main.KO.gY("resource-pack.kick-player-on-decline") && !playerResourcePackStatusEvent.getPlayer().hasPermission("ia.resourcepack.bypasskick")) {
                    playerResourcePackStatusEvent.getPlayer().kickPlayer(Main.PQ.ir("resourcepack-kick-declined"));
                }
                this.arY.a(playerResourcePackStatusEvent.getPlayer(), ax.DECLINED);
                break;
            }
            case FAILED_DOWNLOAD: {
                if (Main.KO.gY("resource-pack.kick-player-on-fail") && !playerResourcePackStatusEvent.getPlayer().hasPermission("ia.resourcepack.bypasskick")) {
                    playerResourcePackStatusEvent.getPlayer().kickPlayer(Main.PQ.ir("resourcepack-error-failed-download"));
                }
                this.arY.a(playerResourcePackStatusEvent.getPlayer(), ax.FAILED_DOWNLOAD);
                break;
            }
            case DISCARDED: {
                if (!Main.KO.gY("resource-pack.kick-player-on-fail") || playerResourcePackStatusEvent.getPlayer().hasPermission("ia.resourcepack.bypasskick")) break;
                playerResourcePackStatusEvent.getPlayer().kickPlayer(Main.PQ.ir("resourcepack-error-discarded"));
                break;
            }
            case INVALID_URL: {
                playerResourcePackStatusEvent.getPlayer().sendMessage(Main.PQ.ir("resourcepack-error-invalid-url"));
                CommandSenderBridge_5.warn(MessageFormat.format("Invalid resourcepack URL. Failed to apply it to player {0}", playerResourcePackStatusEvent.getPlayer().getName()));
                CommandSenderBridge_5.warn(MessageFormat.format("Pack UUID: {0}", playerResourcePackStatusEvent.getID()));
                break;
            }
            case FAILED_RELOAD: {
                if (!Main.KO.gY("resource-pack.kick-player-on-fail") || playerResourcePackStatusEvent.getPlayer().hasPermission("ia.resourcepack.bypasskick")) break;
                playerResourcePackStatusEvent.getPlayer().kickPlayer(Main.PQ.ir("resourcepack-error-failed-reload"));
            }
        }
        if (playerResourcePackStatusEvent.getPlayer().isOnline()) {
            switch (playerResourcePackStatusEvent.getStatus()) {
                case ACCEPTED: {
                    this.arY.aug.cl(playerResourcePackStatusEvent.getPlayer());
                    break;
                }
                case SUCCESSFULLY_LOADED: 
                case DECLINED: 
                case FAILED_DOWNLOAD: 
                case DISCARDED: 
                case INVALID_URL: 
                case FAILED_RELOAD: {
                    this.arY.aug.cm(playerResourcePackStatusEvent.getPlayer());
                }
            }
        }
    }

    @EventHandler
    public void c(PlayerQuitEvent playerQuitEvent) {
        this.arY.ci(playerQuitEvent.getPlayer());
    }
}
