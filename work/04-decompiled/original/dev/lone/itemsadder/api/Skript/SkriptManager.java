package dev.lone.itemsadder.api.Skript;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import itemsadder.m.bce;
import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SkriptManager {
    private static SkriptAddon addon;

    public void init(JavaPlugin javaPlugin) {
        try {
            addon = Skript.registerAddon((JavaPlugin)javaPlugin);
            try {
                addon.loadClasses("dev.lone.itemsadder.api.Skript.implementation", new String[]{"expressions"});
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            bce.log(String.valueOf(ChatColor.AQUA) + "Registered Skript API");
        }
        catch (Exception exception) {
            bce.log(String.valueOf(ChatColor.YELLOW) + exception.getMessage());
        }
    }

    public SkriptAddon getAddonInstance() {
        return addon;
    }
}
