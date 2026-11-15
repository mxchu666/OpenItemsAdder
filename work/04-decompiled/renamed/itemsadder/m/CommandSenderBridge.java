package itemsadder.m;

import beer.devs.fastnbt.nms.Version;
import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.resourcepack.av;
import dev.lone.itemsadder.resourcepack.ax;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketContainerHolder;
import itemsadder.m.PlayerBridge_2;
import itemsadder.m.PlayerHolder_3;
import itemsadder.m.PluginBridge_2;
import itemsadder.m.PluginBridge_6;
import itemsadder.m.PluginFileConfigurationHolder;
import itemsadder.m.VersionHelper_3;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.Nullable;

public abstract class CommandSenderBridge {
    final Plugin ayw;
    public final av ayx;
    protected Boolean ayy;
    private final PluginFileConfigurationHolder ayz;
    public boolean ayA;
    public boolean ayB;
    protected String hash;

    public CommandSenderBridge(Plugin plugin, av av2) {
        this.ayw = plugin;
        this.ayx = av2;
        this.ayz = new PluginFileConfigurationHolder(plugin, true, "storage/cache/various/resourcepacks.yml", false);
    }

    public abstract String getName();

    public void i(CommandSender commandSender) {
        CommandSenderBridge_5.c(commandSender, "Pack hosting not configured. Please read the tutorials.");
    }

    public void co(@Nullable Player player) {
    }

    void BZ() {
        if (MaterialBarColorHolder.db) {
            PlayerHolder_3.us().a(this.Ca(), MaterialBarColorHolder.cm, this.hash, MaterialBarColorHolder.de, PluginBridge_6.gF("1337"));
        } else {
            PlayerHolder_3.us().ur();
        }
    }

    public abstract void bU();

    public abstract void a(@Nullable Runnable var1, CommandSender var2);

    @Nullable
    public abstract String Ca();

    public boolean j(CommandSender commandSender) {
        return true;
    }

    public abstract void cp(Player var1);

    public int Cb() {
        Collection collection = Bukkit.getOnlinePlayers();
        collection.forEach(this::cp);
        return collection.size();
    }

    public void f(PlayerJoinEvent playerJoinEvent) {
        if (playerJoinEvent.getPlayer().isOp() && this.a(true, (CommandSender)playerJoinEvent.getPlayer())) {
            return;
        }
        if (!MaterialBarColorHolder.dc) {
            return;
        }
        if (this.ayx.aui.ayB) {
            CommandSenderBridge_5.error("[!] Resourcepack invalid url, can't apply to player: " + this.Ca());
            return;
        }
        if (!this.ayx.auh.asl || this.ayA) {
            playerJoinEvent.getPlayer().kickPlayer(Main.PQ.ir("resourcepack-not-ready"));
            return;
        }
        this.cq(playerJoinEvent.getPlayer());
    }

    public void cq(Player player) {
        Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(this.ayw, () -> {
            if (player == null || !player.isOnline()) {
                return;
            }
            this.cp(player);
        }, (long)MaterialBarColorHolder.dd);
    }

    public boolean cr(Player player) {
        if (!this.ayx.auh.asl) {
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("resourcepack-not-ready"));
            return false;
        }
        if (this.a(true, (CommandSender)player)) {
            return false;
        }
        if (this.ayB) {
            CommandSenderBridge_5.error("[!] Resourcepack invalid url, can't apply to player: " + this.ayx.aui.Ca());
            CommandSenderBridge_5.f((CommandSender)player, Main.PQ.ir("resourcepack-error"));
            return false;
        }
        return this.ayx.cj(player) != ax.SERVER_SENT;
    }

    void cs(Player player) {
        PlayerHolder_3.a(player, this.Ca(), MaterialBarColorHolder.cm, this.hash, MaterialBarColorHolder.de && !player.hasPermission("ia.resourcepack.bypasskick"), Main.PQ.c("resourcepack-popup-message", player));
    }

    public boolean a(boolean bl, @Nullable CommandSender commandSender) {
        if (this.ayy == null) {
            if (this.ayx.aui instanceof PluginBridge_2) {
                this.ayy = false;
                return false;
            }
            String string = this.Ca();
            this.ayy = this.ayx.aui instanceof PlayerBridge_2 || string == null || string.isEmpty();
        }
        if (this.ayy.booleanValue() && bl) {
            CommandSenderBridge.l(commandSender);
        }
        return this.ayy;
    }

    public boolean Cc() {
        return this.a(false, null);
    }

    public boolean Cd() {
        String string = this.Ca();
        return string == null || string.isEmpty();
    }

    void Ce() {
        this.ayz.gN("").forEach(this.ayz::gQ);
        this.ayz.save();
    }

    void go(String string) {
        try {
            this.ayz.d("last_url", this.Ca());
            this.ayz.d("last_hash", string);
            this.ayz.save();
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to save resourcepack hash to cache file.", throwable);
        }
    }

    void gp(String string) {
        this.ayz.d("last_etag", string);
        this.ayz.save();
    }

    @Nullable
    String Cf() {
        return this.ayz.gV("last_etag");
    }

    @Nullable
    String Cg() {
        return this.ayz.gV("last_hash");
    }

    @Nullable
    public static HttpURLConnection gq(String string) {
        String string2;
        int n2;
        URL uRL = new URL(string);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        try {
            n2 = httpURLConnection.getResponseCode();
        }
        catch (IOException iOException) {
            InputStream inputStream = httpURLConnection.getErrorStream();
            if (inputStream != null) {
                String string3 = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                CommandSenderBridge_5.error("HTTP error for " + string + ": " + httpURLConnection.getResponseCode() + " body=" + string3);
            }
            throw iOException;
        }
        if (CommandSenderBridge.bx(n2) && (string2 = httpURLConnection.getHeaderField("Location")) != null) {
            URL uRL2 = new URL(uRL, string2);
            CommandSenderBridge_5.log("[Pack] Redirect: '" + string + "' -> '" + String.valueOf(uRL2) + "'");
            return CommandSenderBridge.gq(uRL2.toString());
        }
        return httpURLConnection;
    }

    public static boolean bx(int n2) {
        if (n2 != 200) {
            return n2 == 302 || n2 == 301 || n2 == 303;
        }
        return false;
    }

    public static String c(InputStream inputStream) {
        int n2;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] byArray = new byte[2048];
        while ((n2 = inputStream.read(byArray)) != -1) {
            messageDigest.update(byArray, 0, n2);
        }
        byte[] byArray2 = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray2) {
            String string = Integer.toHexString(0xFF & by);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static boolean gr(String string) {
        return string.equals("application/zip") || string.equals("application/x-zip-compressed");
    }

    public static void k(CommandSender commandSender) {
        if (commandSender instanceof ConsoleCommandSender) {
            CommandSenderBridge.Ch();
            return;
        }
        int n2 = VersionHelper_3.sY();
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.GOLD) + "ResourcePack");
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.YELLOW) + " - Path: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().as.auh.yE());
        if (!(ItemStackRegistry.g().as.aui instanceof PluginBridge_2)) {
            CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.YELLOW) + " - URL: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().as.aui.Ca());
        }
        int n3 = (int)((double)ItemStackRegistry.g().as.auh.yA() / (double)(n2 * 1024 * 1024) * 100.0);
        CommandSenderBridge_5.e(commandSender, String.valueOf(ChatColor.YELLOW) + " - Size: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().as.auh.yC() + String.valueOf(ChatColor.YELLOW) + "/" + String.valueOf(ChatColor.AQUA) + n2 + " MB " + String.valueOf(ChatColor.GRAY) + "(" + n3 + "%)");
    }

    public static void Ch() {
        int n2 = VersionHelper_3.sY();
        CommandSenderBridge_5.log(String.valueOf(ChatColor.GOLD) + "ResourcePack");
        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + " - Path: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().as.auh.yE());
        if (!(ItemStackRegistry.g().as.aui instanceof PluginBridge_2)) {
            CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + " - Download: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().as.aui.Ca());
        }
        int n3 = (int)((double)ItemStackRegistry.g().as.auh.yA() / (double)(n2 * 1024 * 1024) * 100.0);
        CommandSenderBridge_5.log(String.valueOf(ChatColor.YELLOW) + " - Size: " + String.valueOf(ChatColor.AQUA) + ItemStackRegistry.g().as.auh.yC() + String.valueOf(ChatColor.YELLOW) + "/" + String.valueOf(ChatColor.AQUA) + n2 + " MB " + String.valueOf(ChatColor.GRAY) + "(" + n3 + "%)");
    }

    public static void l(CommandSender commandSender) {
        if (Version.isAtLeast((Version)Version.v1_21_6) && commandSender instanceof Player) {
            Player player = (Player)commandSender;
            PacketContainerHolder.tp().bJ(player);
        }
        commandSender.sendMessage(" ");
        commandSender.sendMessage(" ");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "Welcome! Thanks for buying ItemsAdder! " + String.valueOf(ChatColor.RED) + "<3");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "Before using the plugin you have to finish installation (it's easy).");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "Resourcepack hosting: " + String.valueOf(ChatColor.AQUA) + "https://a.devs.beer/ia-host-pack");
        commandSender.sendMessage(String.valueOf(ChatColor.GREEN) + "Have fun! :D");
        commandSender.sendMessage(" ");
        commandSender.sendMessage(" ");
    }

    protected static void m(CommandSender commandSender) {
        commandSender.sendMessage(" ");
        commandSender.sendMessage(" ");
        commandSender.sendMessage(String.valueOf(ChatColor.YELLOW) + "Before using the plugin you have to run /iazip command to generate the resourcepack.");
        commandSender.sendMessage(" ");
        commandSender.sendMessage(" ");
    }
}
