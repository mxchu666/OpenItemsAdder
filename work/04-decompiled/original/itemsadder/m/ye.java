package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.bce;
import itemsadder.m.za;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ye
extends za {
    public ye() {
        Main.cM("iahitbox").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        Player player = (Player)commandSender;
        if (player.hasMetadata("DrawFurnitureHitbox")) {
            player.removeMetadata("DrawFurnitureHitbox", (Plugin)Main.rS());
            bce.g((CommandSender)player, "disabled-furniture-hitboxes");
        } else {
            player.setMetadata("DrawFurnitureHitbox", (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)true));
            bce.g((CommandSender)player, "enabled-furniture-hitboxes");
        }
        return true;
    }
}
