package dev.lone.itemsadder.Core.OtherPlugins.PAPI;

import itemsadder.m.d;
import itemsadder.m.fw;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PAPI_FontImages
extends PlaceholderExpansion {
    public boolean canRegister() {
        return true;
    }

    public String getAuthor() {
        return "LoneDev";
    }

    public String getIdentifier() {
        return "img";
    }

    public String getRequiredPlugin() {
        return null;
    }

    public String getVersion() {
        return "1.0.1";
    }

    public boolean persist() {
        return true;
    }

    public String onPlaceholderRequest(Player player, String string) {
        if (string.startsWith("offset_")) {
            return d.g().al.aT(string);
        }
        fw fw2 = d.g().al.aR(string);
        if (fw2 == null) {
            return string + "_NOT_FOUND";
        }
        return fw2.Q(true);
    }
}
