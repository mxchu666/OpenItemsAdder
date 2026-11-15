package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Date;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public class CommandSenderBridge_3
extends CommandSenderBridge {
    public CommandSenderBridge_3(Plugin plugin, av av2) {
        super(plugin, av2);
    }

    @Override
    public String getName() {
        return "external";
    }

    @Override
    public void i(CommandSender commandSender) {
        CommandSenderBridge_5.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] You have to run " + String.valueOf(ChatColor.YELLOW) + "/iazip" + String.valueOf(ChatColor.RED) + " command which will compress the pack.");
        CommandSenderBridge_5.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] - upload the pack on a supported website and get the URL.");
        CommandSenderBridge_5.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] - copy the URL into the config.yml file");
        CommandSenderBridge_5.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] - run /iareload");
        CommandSenderBridge_5.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] More info on resourcepack hosting websites here: " + String.valueOf(ChatColor.AQUA) + "https://a.devs.beer/ia-external-host");
    }

    @Override
    public void bU() {
    }

    @Override
    @Nullable
    public String Ca() {
        Object object = Main.KO.gV("resource-pack.hosting.external-host.url");
        if (object == null || ((String)object).isEmpty()) {
            return null;
        }
        if (((String)object).endsWith("dl=0")) {
            object = ((String)object).replace("dl=0", "raw=1");
        } else if (((String)object).endsWith("dl=1")) {
            object = ((String)object).replace("dl=1", "raw=1");
        }
        if (!((String)object).startsWith("http://") && !((String)object).startsWith("https://")) {
            object = "http://" + (String)object;
        }
        return object;
    }

    @Override
    public void cp(Player player) {
        if (!this.cr(player)) {
            return;
        }
        if (this.ayx.aui.Cd()) {
            this.i((CommandSender)player);
            return;
        }
        this.cs(player);
    }

    @Override
    public void a(@Nullable Runnable runnable, CommandSender commandSender) {
        this.ayy = null;
        if (this.a(true, commandSender)) {
            return;
        }
        String string = this.Ca();
        if (string == null || string.isEmpty()) {
            CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] No URL set. Please upload your pack and set the 'url' in config.yml");
            this.ayB = true;
            return;
        }
        CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.AQUA) + "[Pack] Checking resourcepack url: " + string);
        try {
            this.ayA = true;
            HttpURLConnection httpURLConnection = CommandSenderBridge_3.gq(string);
            if (httpURLConnection != null) {
                String string2;
                long l = httpURLConnection.getLastModified();
                if (l == 0L) {
                    string2 = httpURLConnection.getHeaderField("etag");
                    CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.AQUA) + "[Pack] ETag: " + string2);
                } else {
                    string2 = Long.toString(l);
                    CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.AQUA) + "[Pack] LastEdit: " + ColorBridge.a(new Date(l)));
                }
                @Nullable String string3 = this.Cf();
                @Nullable String string4 = this.Cg();
                if (string3 != null && string4 != null && string3.equals(string2)) {
                    CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] URL should be valid. Remote file didn't change. Skipped hash calculation.");
                    this.hash = string4;
                    httpURLConnection.disconnect();
                    this.ayB = false;
                    this.ayA = false;
                    if (runnable != null) {
                        runnable.run();
                    }
                    return;
                }
                this.gp(string2);
                String string5 = httpURLConnection.getContentType();
                if (MaterialBarColorHolder.dH) {
                    CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.YELLOW) + "[Pack] Skipped file type checking, this may cause resourcepack apply loop and other issues if the file is not valid. DON'T ASK FOR SUPPORT!");
                    this.ayB = false;
                } else {
                    boolean bl = CommandSenderBridge_3.gr(string5);
                    if (!bl) {
                        CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] URL is not a zip file (" + this.getName() + "). Type: " + string5 + " URL: " + string);
                    }
                    if (!this.ayB) {
                        this.ayB = !bl;
                    }
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                this.hash = CommandSenderBridge_3.c(inputStream);
                httpURLConnection.disconnect();
                if (this.ayB) {
                    CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] URL is not valid (" + this.getName() + "). Type: " + string5 + " URL: " + string);
                } else {
                    CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] URL is valid (" + this.getName() + "). URL: " + string);
                }
            } else {
                this.ayB = true;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] No resourcepack found in this URL. It was probably deleted. URL: " + string);
            fileNotFoundException.printStackTrace();
            this.ayB = true;
        }
        catch (Exception exception) {
            CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] URL is not valid. Please check config.yml. URL: " + string);
            exception.printStackTrace();
            this.ayB = true;
        }
        this.go(this.hash);
        this.ayA = false;
        if (!this.ayB) {
            this.BZ();
        }
        if (runnable != null) {
            runnable.run();
        }
        if (!this.ayB) {
            this.Ce();
            CommandSenderBridge.k(commandSender);
        }
    }
}
