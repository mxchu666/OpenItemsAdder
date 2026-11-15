package dev.lone.itemsadder.resourcepack;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.aa;
import dev.lone.itemsadder.resourcepack.ad;
import dev.lone.itemsadder.resourcepack.ax;
import dev.lone.itemsadder.resourcepack.ay;
import itemsadder.m.ae;
import itemsadder.m.ag;
import itemsadder.m.azu;
import itemsadder.m.azw;
import itemsadder.m.azx;
import itemsadder.m.azy;
import itemsadder.m.azz;
import itemsadder.m.bab;
import itemsadder.m.bac;
import itemsadder.m.bad;
import itemsadder.m.bce;
import java.util.WeakHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class av {
    public final ay aug;
    public ad auh;
    public azu aui;
    @Nullable
    public aa auj = null;
    private final WeakHashMap auk = new WeakHashMap();

    public av(Plugin plugin) {
        switch (ae.dg) {
            case LOBFILE: {
                this.aui = new azy(plugin, this);
                break;
            }
            case AUTO_EXTERNAL_LEGACY: {
                this.aui = new azx(plugin, this);
                break;
            }
            case EXTERNAL: {
                this.aui = new azw(plugin, this);
                break;
            }
            case SIMPLE_SELF_HOST: {
                this.aui = new bac(plugin, this);
                break;
            }
            case SELF_HOST: {
                this.aui = new bab(plugin, this);
                break;
            }
            case NO_HOST: {
                this.aui = new azz(plugin, this);
                bce.warn(" ");
                bce.warn("'no-host' selected. You have to handle the pack upload and apply manually or using another plugin.");
                bce.warn(" ");
                break;
            }
            default: {
                this.aui = new bad(plugin, this);
            }
        }
        this.auh = new ad(this);
        this.aug = new ay();
        this.aug.register();
        if (this.auj != null) {
            this.auj.unregister();
        }
        if (ae.dg != ag.NO_HOST) {
            this.auj = new aa(this);
            this.auj.register(plugin);
        }
        if (Main.rW()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (this.auk.containsKey(player)) continue;
                bce.warn("Setting player resourcepack status to installed because the plugin was reloaded.");
                this.a(player, ax.INSTALLED);
            }
        }
    }

    public void a(Player player, ax ax2) {
        if (ax2 == ax.NONE) {
            this.auk.remove(player);
            return;
        }
        this.auk.put(player, ax2);
    }

    public void ci(Player player) {
        this.auk.remove(player);
    }

    public ax cj(Player player) {
        if (!this.auk.containsKey(player)) {
            return ax.NONE;
        }
        return (ax)((Object)this.auk.get(player));
    }

    public boolean ck(Player player) {
        ax ax2 = (ax)((Object)this.auk.get(player));
        if (ax2 == null) {
            return false;
        }
        return ax2 == ax.INSTALLED;
    }

    public void bU() {
        this.aui.bU();
        if (this.auj != null) {
            this.auj.unregister();
        }
        this.aug.unregister();
    }

    public void zB() {
        this.auh.cy();
    }
}
