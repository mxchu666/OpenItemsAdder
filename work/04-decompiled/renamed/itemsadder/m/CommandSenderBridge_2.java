package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.IareloadCommand;
import itemsadder.m.IazipCommand;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerBridge_3;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.ServerCommandListener;
import java.awt.Color;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.Date;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public abstract class CommandSenderBridge_2
extends CommandSenderBridge {
    private final String ayC;
    private PlayerBridge_3 ayD;
    public final PluginFileConfigurationHolder ayE;
    private final String ayF;
    private ServerCommandListener ayG;
    private boolean ayH;
    public boolean ayI;
    public boolean ayJ = false;

    public CommandSenderBridge_2(Plugin plugin, String string, av av2, String string2, String string3) {
        super(plugin, av2);
        this.ayE = new PluginFileConfigurationHolder(plugin, true, "storage" + File.separator + "cache" + File.separator + "various" + File.separator + string3 + ".yml", false, false, false, null);
        this.ayC = string2;
        this.ayF = string;
        this.ayH = this.ayE.z("accepted-privacy", false);
        if (!this.ayH) {
            this.ayG = new ServerCommandListener(plugin, this);
        }
    }

    public void a(PlayerBridge_3 playerBridge_3) {
        this.ayD = playerBridge_3;
    }

    @Override
    public String getName() {
        return this.ayF;
    }

    @Override
    public void i(CommandSender commandSender) {
        CommandSenderBridge_5.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] You have to run " + String.valueOf(ChatColor.YELLOW) + "/iazip" + String.valueOf(ChatColor.RED) + " command which will compress and upload the pack online automatically.");
        CommandSenderBridge_5.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] Then you have to accept the privacy policy.");
        CommandSenderBridge_5.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] Please read the wiki for more information: " + String.valueOf(ChatColor.AQUA) + "https://a.devs.beer/ia-complete-install");
    }

    @Override
    public void bU() {
        if (this.ayG != null) {
            this.ayG.bU();
        }
    }

    @Override
    public boolean j(CommandSender commandSender) {
        if (this.ayH) {
            return true;
        }
        this.ayI = true;
        this.c((CommandSender)Bukkit.getConsoleSender(), true);
        if (commandSender instanceof Player) {
            this.cv((Player)commandSender);
        }
        return false;
    }

    @Override
    public void cp(Player player) {
        if (!this.ayH || this.Cd()) {
            this.i((CommandSender)player);
            return;
        }
        if (!this.cr(player)) {
            return;
        }
        this.cs(player);
    }

    @Override
    public void f(PlayerJoinEvent playerJoinEvent) {
        if (!this.ayH) {
            return;
        }
        super.f(playerJoinEvent);
    }

    @Override
    @Nullable
    public String Ca() {
        Object object = this.ayE.az("pack_url", null);
        if (object == null || ((String)object).isEmpty()) {
            return null;
        }
        if (!((String)object).startsWith("http://") && !((String)object).startsWith("https://")) {
            object = "http://" + (String)object;
        }
        return object;
    }

    @Override
    public void co(@Nullable Player player) {
        if (!this.ayH) {
            this.c((CommandSender)player, false);
            return;
        }
        CommandSenderBridge_5.log(String.valueOf(ChatColor.GREEN) + "[Pack] Resource pack successfully compressed. Uploading...");
        this.cu(player);
    }

    private void cu(Player player) {
        String string = this.ayD.a(this.ayx.auh, player);
        if (string != null) {
            this.ayE.d("pack_url", string);
            this.ayE.save();
            this.ayE.reload();
        }
        this.ayJ = string == null;
    }

    @Override
    public void a(@Nullable Runnable runnable, CommandSender commandSender) {
        this.ayy = null;
        if (this.ayD.Cj()) {
            return;
        }
        if (!this.ayH) {
            return;
        }
        if (this.a(true, commandSender)) {
            return;
        }
        if (!ItemStackRegistry.g().as.auh.yB()) {
            CommandSenderBridge.m(commandSender);
            return;
        }
        this.hash = this.ayx.auh.yF();
        this.go(this.hash);
        String string = this.Ca();
        if (string == null || string.isEmpty()) {
            if (!this.ayJ) {
                this.i(commandSender);
            }
            this.ayB = true;
            if (runnable != null) {
                runnable.run();
            }
        } else {
            try {
                this.ayA = true;
                HttpURLConnection httpURLConnection = CommandSenderBridge_2.gq(string);
                if (httpURLConnection != null) {
                    String string2;
                    String string3 = httpURLConnection.getContentType();
                    long l = httpURLConnection.getLastModified();
                    if (!this.ayB) {
                        this.ayB = !CommandSenderBridge_2.gr(string3);
                    }
                    httpURLConnection.disconnect();
                    String string4 = string2 = l != 0L ? ", LastEdit: " + ColorBridge.a(new Date(l)) : "";
                    if (this.ayB) {
                        CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] Resourcepack URL is not valid, not a zip file (" + this.getName() + "). Type: " + string3 + string2 + " URL: " + string);
                    } else {
                        CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] Resourcepack URL is valid (" + this.getName() + ")" + string2 + ". URL: " + string);
                    }
                } else {
                    this.ayB = true;
                }
            }
            catch (Exception exception) {
                CommandSenderBridge_5.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] Resourcepack URL is not valid. Please check config.yml. URL: " + string);
                this.ayB = true;
                exception.printStackTrace();
            }
            this.ayA = false;
            if (!this.ayB) {
                this.BZ();
                CommandSenderBridge.k(commandSender);
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void b(CommandSender commandSender, boolean bl) {
        IazipCommand.SE = false;
        IareloadCommand.SE = false;
        this.ayI = false;
        this.ayH = bl;
        this.ayE.d("accepted-privacy", bl);
        this.ayE.save();
        this.ayE.reload();
        if (bl) {
            CommandSenderBridge_5.g(commandSender, "hosting-privacy-policy-accepted");
            CommandSenderBridge_5.g(commandSender, "compressing-resourcepack");
            IazipCommand.g(commandSender);
        } else {
            CommandSenderBridge_5.g(commandSender, "hosting-privacy-policy-declined");
        }
    }

    private void c(CommandSender commandSender, boolean bl) {
        if (bl) {
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + " ");
        }
        CommandSenderBridge_5.a(commandSender, "hosting-privacy-policy-ask", string -> {
            string = string.replace("{privacy_url}", this.ayC);
            string = string.replace("{provider}", this.getName());
            return string;
        });
        if (bl) {
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            CommandSenderBridge_5.f(commandSender, String.valueOf(ChatColor.RED) + " ");
        }
    }

    private void cv(Player player) {
        Component component = PluginBridge_6.gK(Main.PQ.ir("hosting-privacy-policy-title")).append(PluginBridge_6.gK(Main.PQ.ir("hosting-privacy-policy-content"))).append((Component)Component.newline()).append(((TextComponent)Component.text((String)this.ayC).color(TextColor.color((int)Color.CYAN.getRGB()))).clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.OPEN_URL, (String)this.ayC))).append((Component)Component.newline()).append(((TextComponent)Component.text((String)"ACCEPT (/acceptprivacy)").color(TextColor.color((int)Color.GREEN.getRGB()))).clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.RUN_COMMAND, (String)"/acceptprivacy"))).append((Component)Component.newline()).append(((TextComponent)Component.text((String)"DECLINE (/declineprivacy)").color(TextColor.color((int)Color.RED.getRGB()))).clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.RUN_COMMAND, (String)"/declineprivacy")));
        PluginBridge_6.CC().player(player).sendMessage(component);
    }
}
