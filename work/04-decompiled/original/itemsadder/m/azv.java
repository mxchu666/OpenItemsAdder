package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.av;
import itemsadder.m.azu;
import itemsadder.m.baa;
import itemsadder.m.bae;
import itemsadder.m.bbe;
import itemsadder.m.bbf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.yp;
import itemsadder.m.yy;
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

public abstract class azv
extends azu {
    private final String ayC;
    private bae ayD;
    public final bbf ayE;
    private final String ayF;
    private baa ayG;
    private boolean ayH;
    public boolean ayI;
    public boolean ayJ = false;

    public azv(Plugin plugin, String string, av av2, String string2, String string3) {
        super(plugin, av2);
        this.ayE = new bbf(plugin, true, "storage" + File.separator + "cache" + File.separator + "various" + File.separator + string3 + ".yml", false, false, false, null);
        this.ayC = string2;
        this.ayF = string;
        this.ayH = this.ayE.z("accepted-privacy", false);
        if (!this.ayH) {
            this.ayG = new baa(plugin, this);
        }
    }

    public void a(bae bae2) {
        this.ayD = bae2;
    }

    @Override
    public String getName() {
        return this.ayF;
    }

    @Override
    public void i(CommandSender commandSender) {
        bce.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] You have to run " + String.valueOf(ChatColor.YELLOW) + "/iazip" + String.valueOf(ChatColor.RED) + " command which will compress and upload the pack online automatically.");
        bce.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] Then you have to accept the privacy policy.");
        bce.c(commandSender, String.valueOf(ChatColor.RED) + "[Pack] Please read the wiki for more information: " + String.valueOf(ChatColor.AQUA) + "https://a.devs.beer/ia-complete-install");
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
        bce.log(String.valueOf(ChatColor.GREEN) + "[Pack] Resource pack successfully compressed. Uploading...");
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
        if (!d.g().as.auh.yB()) {
            azu.m(commandSender);
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
                HttpURLConnection httpURLConnection = azv.gq(string);
                if (httpURLConnection != null) {
                    String string2;
                    String string3 = httpURLConnection.getContentType();
                    long l = httpURLConnection.getLastModified();
                    if (!this.ayB) {
                        this.ayB = !azv.gr(string3);
                    }
                    httpURLConnection.disconnect();
                    String string4 = string2 = l != 0L ? ", LastEdit: " + bcy.a(new Date(l)) : "";
                    if (this.ayB) {
                        bce.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] Resourcepack URL is not valid, not a zip file (" + this.getName() + "). Type: " + string3 + string2 + " URL: " + string);
                    } else {
                        bce.b(commandSender, String.valueOf(ChatColor.GREEN) + "[Pack] Resourcepack URL is valid (" + this.getName() + ")" + string2 + ". URL: " + string);
                    }
                } else {
                    this.ayB = true;
                }
            }
            catch (Exception exception) {
                bce.b(commandSender, String.valueOf(ChatColor.RED) + "[Pack] Resourcepack URL is not valid. Please check config.yml. URL: " + string);
                this.ayB = true;
                exception.printStackTrace();
            }
            this.ayA = false;
            if (!this.ayB) {
                this.BZ();
                azu.k(commandSender);
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void b(CommandSender commandSender, boolean bl) {
        yy.SE = false;
        yp.SE = false;
        this.ayI = false;
        this.ayH = bl;
        this.ayE.d("accepted-privacy", bl);
        this.ayE.save();
        this.ayE.reload();
        if (bl) {
            bce.g(commandSender, "hosting-privacy-policy-accepted");
            bce.g(commandSender, "compressing-resourcepack");
            yy.g(commandSender);
        } else {
            bce.g(commandSender, "hosting-privacy-policy-declined");
        }
    }

    private void c(CommandSender commandSender, boolean bl) {
        if (bl) {
            bce.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            bce.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            bce.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            bce.f(commandSender, String.valueOf(ChatColor.RED) + " ");
        }
        bce.a(commandSender, "hosting-privacy-policy-ask", string -> {
            string = string.replace("{privacy_url}", this.ayC);
            string = string.replace("{provider}", this.getName());
            return string;
        });
        if (bl) {
            bce.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            bce.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            bce.f(commandSender, String.valueOf(ChatColor.RED) + " ");
            bce.f(commandSender, String.valueOf(ChatColor.RED) + " ");
        }
    }

    private void cv(Player player) {
        Component component = bbe.gK(Main.PQ.ir("hosting-privacy-policy-title")).append(bbe.gK(Main.PQ.ir("hosting-privacy-policy-content"))).append((Component)Component.newline()).append(((TextComponent)Component.text((String)this.ayC).color(TextColor.color((int)Color.CYAN.getRGB()))).clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.OPEN_URL, (String)this.ayC))).append((Component)Component.newline()).append(((TextComponent)Component.text((String)"ACCEPT (/acceptprivacy)").color(TextColor.color((int)Color.GREEN.getRGB()))).clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.RUN_COMMAND, (String)"/acceptprivacy"))).append((Component)Component.newline()).append(((TextComponent)Component.text((String)"DECLINE (/declineprivacy)").color(TextColor.color((int)Color.RED.getRGB()))).clickEvent(ClickEvent.clickEvent((ClickEvent.Action)ClickEvent.Action.RUN_COMMAND, (String)"/declineprivacy")));
        bbe.CC().player(player).sendMessage(component);
    }
}
