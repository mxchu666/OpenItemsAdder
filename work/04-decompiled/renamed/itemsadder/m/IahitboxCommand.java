package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.PluginCommand_2;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class IahitboxCommand
extends PluginCommand_2 {
    public IahitboxCommand() {
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
            CommandSenderBridge_5.g((CommandSender)player, "disabled-furniture-hitboxes");
        } else {
            player.setMetadata("DrawFurnitureHitbox", (MetadataValue)new FixedMetadataValue((Plugin)Main.rS(), (Object)true));
            CommandSenderBridge_5.g((CommandSender)player, "enabled-furniture-hitboxes");
        }
        return true;
    }
}
