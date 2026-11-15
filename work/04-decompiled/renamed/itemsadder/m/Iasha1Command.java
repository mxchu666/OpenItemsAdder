package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.ad;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PluginCommand_2;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.codec.digest.DigestUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Iasha1Command
extends PluginCommand_2 {
    private boolean SF;

    public Iasha1Command() {
        Main.cM("iasha1").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length == 0) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            return true;
        }
        if (this.SF) {
            CommandSenderBridge_5.g(commandSender, "sha1-wait-previous-execution");
            return true;
        }
        CommandSenderBridge_5.g(commandSender, "sha1-loading");
        this.SF = true;
        BukkitTaskBridge.h(() -> {
            try {
                String string = stringArray[0].equals("online") ? ad.c(DigestUtils.sha1((InputStream)new URL(ItemStackRegistry.g().as.aui.Ca()).openStream())) : ItemStackRegistry.g().as.auh.yF();
                if (commandSender instanceof Player) {
                    CommandSenderBridge_5.f(commandSender, "SHA1: " + string);
                }
                CommandSenderBridge_5.log("SHA1: " + string);
                this.SF = false;
            }
            catch (Exception exception) {
                this.SF = false;
                exception.printStackTrace();
            }
        });
        return true;
    }
}
