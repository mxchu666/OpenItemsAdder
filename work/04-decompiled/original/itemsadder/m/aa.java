package itemsadder.m;

import beer.devs.fastnbt.nms.nbt.NFile;
import dev.lone.itemsadder.Main;
import itemsadder.m.ab;
import itemsadder.m.ai;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.y;
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

public class aa
extends y
implements ai {
    protected final Map ce = Collections.synchronizedMap(new HashMap());
    long cf = 0L;

    public aa(Plugin plugin, d d2) {
        super(plugin, d2);
        bev.a(this, plugin);
    }

    @Override
    public void u(Player player) {
        File file = new File(d.i + "players/stats/" + player.getUniqueId().toString() + ".nbt");
        try {
            this.ce.put(player.getUniqueId(), new ab(new NFile(file)));
        }
        catch (Exception exception) {
            this.cb.getLogger().log(Level.SEVERE, String.valueOf(ChatColor.RED) + "Error loading player stats file '" + player.getName() + "' " + String.valueOf(ChatColor.AQUA) + String.valueOf(player.getUniqueId()) + String.valueOf(ChatColor.RED) + ": " + String.valueOf(ChatColor.YELLOW) + exception.getMessage());
            exception.printStackTrace();
            try {
                File file2 = new File(d.i + "players/stats/" + player.getUniqueId().toString() + ".nbt");
                FileUtils.moveFile((File)file, (File)new File(d.i + "players/stats/corrupted/" + player.getUniqueId().toString() + "___" + System.currentTimeMillis() + ".nbt"));
                this.ce.put(player.getUniqueId(), new ab(new NFile(file2)));
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
        return ((ab)this.ce.get((Object)player.getUniqueId())).cg.hasKey(string);
    }

    @Override
    public void a(Player player, String string, float f2) {
        if (!this.v(player)) {
            return;
        }
        ab ab2 = (ab)this.ce.get(player.getUniqueId());
        NFile nFile = ab2.cg;
        if (nFile.getFloat(string) == f2) {
            return;
        }
        ab2.g(true);
        nFile.setFloat(string, f2);
    }

    @Override
    @Nullable
    public Float a(Player player, String string, @Nullable Float f2) {
        if (!this.v(player)) {
            return f2;
        }
        NFile nFile = ((ab)this.ce.get((Object)player.getUniqueId())).cg;
        if (nFile.hasKey(string)) {
            return Float.valueOf(nFile.getFloat(string));
        }
        return f2;
    }

    @Override
    void a(UUID uUID) {
        ab ab2 = (ab)this.ce.get(uUID);
        if (ab2 != null) {
            if (!ab2.al()) {
                return;
            }
            bcp.h(() -> {
                try {
                    ab2.g(false);
                    ab2.cg.save();
                    this.ce.remove(uUID);
                }
                catch (IOException iOException) {
                    bce.error("Error saving player stats: " + String.valueOf(uUID), iOException);
                }
            });
        }
    }

    @Override
    public void ak() {
        int n = 0;
        for (Map.Entry entry : this.ce.entrySet()) {
            try {
                ab ab2 = (ab)entry.getValue();
                if (!ab2.al()) continue;
                ab2.cg.save();
            }
            catch (IOException iOException) {
                bce.error("Error saving player stats: " + String.valueOf(entry.getKey()), iOException);
            }
            ++n;
        }
        if (Main.KO.gY("debug.player-stats.log-save")) {
            bce.log(String.valueOf(ChatColor.YELLOW) + "Saved " + n + " player stats files");
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
