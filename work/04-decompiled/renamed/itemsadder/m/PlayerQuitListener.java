package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NFile;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.NFileHelper;
import itemsadder.m.PlayerBridge_27;
import itemsadder.m.PluginContract;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class PlayerQuitListener
extends PlayerBridge_27
implements PluginContract {
    protected final Map ce = Collections.synchronizedMap(new HashMap());
    long cf = 0L;

    public PlayerQuitListener(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        super(plugin, itemStackRegistry);
        ListenerBridge.a(this, plugin);
    }

    @Override
    public void u(Player player) {
        File file = new File(ItemStackRegistry.i + "players/stats/" + player.getUniqueId().toString() + ".nbt");
        try {
            this.ce.put(player.getUniqueId(), new NFileHelper(new NFile(file)));
        }
        catch (Exception exception) {
            this.cb.getLogger().log(Level.SEVERE, String.valueOf(ChatColor.RED) + "Error loading player stats file '" + player.getName() + "' " + String.valueOf(ChatColor.AQUA) + String.valueOf(player.getUniqueId()) + String.valueOf(ChatColor.RED) + ": " + String.valueOf(ChatColor.YELLOW) + exception.getMessage());
            exception.printStackTrace();
            try {
                File file2 = new File(ItemStackRegistry.i + "players/stats/" + player.getUniqueId().toString() + ".nbt");
                FileUtils.moveFile((File)file, (File)new File(ItemStackRegistry.i + "players/stats/corrupted/" + player.getUniqueId().toString() + "___" + System.currentTimeMillis() + ".nbt"));
                this.ce.put(player.getUniqueId(), new NFileHelper(new NFile(file2)));
                this.cb.getLogger().log(Level.SEVERE, "Moved corrupted file to 'corrupted' folder and re-generated new one.");
            }
            catch (Exception exception2) {
                this.cb.getLogger().log(Level.SEVERE, String.valueOf(ChatColor.RED) + "Error Re-generating player stats file '" + player.getName() + "' " + String.valueOf(ChatColor.AQUA) + player.getUniqueId().toString() + String.valueOf(ChatColor.RED) + ": " + String.valueOf(ChatColor.YELLOW) + exception2.getMessage());
                exception2.printStackTrace();
            }
        }
    }

    @Override
    public boolean v(Player player) {
        return this.ce.containsKey(player.getUniqueId());
    }

    @Override
    public boolean a(Player player, String string) {
        return ((NFileHelper)this.ce.get((Object)player.getUniqueId())).cg.hasKey(string);
    }

    @Override
    public void a(Player player, String string, float f) {
        if (!this.v(player)) {
            return;
        }
        NFileHelper nFileHelper = (NFileHelper)this.ce.get(player.getUniqueId());
        NFile nFile = nFileHelper.cg;
        if (nFile.getFloat(string) == f) {
            return;
        }
        nFileHelper.g(true);
        nFile.setFloat(string, f);
    }

    @Override
    @Nullable
    public Float a(Player player, String string, @Nullable Float f) {
        if (!this.v(player)) {
            return f;
        }
        NFile nFile = ((NFileHelper)this.ce.get((Object)player.getUniqueId())).cg;
        if (nFile.hasKey(string)) {
            return Float.valueOf(nFile.getFloat(string));
        }
        return f;
    }

    @Override
    void a(UUID uUID) {
        NFileHelper nFileHelper = (NFileHelper)this.ce.get(uUID);
        if (nFileHelper != null) {
            if (!nFileHelper.al()) {
                return;
            }
            BukkitTaskBridge.h(() -> {
                try {
                    nFileHelper.g(false);
                    nFileHelper.cg.save();
                    this.ce.remove(uUID);
                }
                catch (IOException iOException) {
                    CommandSenderBridge_5.error("Error saving player stats: " + String.valueOf(uUID), iOException);
                }
            });
        }
    }

    @Override
    public void ak() {
        int n = 0;
        for (Map.Entry entry : this.ce.entrySet()) {
            try {
                NFileHelper nFileHelper = (NFileHelper)entry.getValue();
                if (!nFileHelper.al()) continue;
                nFileHelper.cg.save();
            }
            catch (IOException iOException) {
                CommandSenderBridge_5.error("Error saving player stats: " + String.valueOf(entry.getKey()), iOException);
            }
            ++n;
        }
        if (Main.KO.gY("debug.player-stats.log-save")) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + "Saved " + n + " player stats files");
        }
    }

    @Override
    public void e(boolean bl) {
        if (bl) {
            Bukkit.getServer().getScheduler().runTaskAsynchronously(this.cb, this::ak);
        } else {
            this.ak();
        }
    }

    @EventHandler
    void b(PlayerQuitEvent playerQuitEvent) {
        this.a(playerQuitEvent.getPlayer().getUniqueId());
    }

    @EventHandler
    void a(WorldSaveEvent worldSaveEvent) {
        if (System.currentTimeMillis() - this.cf <= 10000L) {
            return;
        }
        this.cf = System.currentTimeMillis();
        this.e(true);
    }

    @EventHandler
    void a(PluginDisableEvent pluginDisableEvent) {
        if (!pluginDisableEvent.getPlugin().getName().equals(this.cb.getName())) {
            return;
        }
        this.ak();
    }
}
