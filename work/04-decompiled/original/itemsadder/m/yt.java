package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.ad;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.d;
import itemsadder.m.za;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.codec.digest.DigestUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class yt
extends za {
    private boolean SF;

    public yt() {
        Main.cM("iasha1").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length == 0) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            return true;
        }
        if (this.SF) {
            bce.g(commandSender, "sha1-wait-previous-execution");
            return true;
        }
        bce.g(commandSender, "sha1-loading");
        this.SF = true;
        bcp.h(() -> {
            try {
                String string = stringArray[0].equals("online") ? ad.c(DigestUtils.sha1((InputStream)new URL(d.g().as.aui.Ca()).openStream())) : d.g().as.auh.yF();
                if (commandSender instanceof Player) {
                    bce.f(commandSender, "SHA1: " + string);
                }
                bce.log("SHA1: " + string);
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
