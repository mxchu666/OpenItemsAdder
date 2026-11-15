package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.injector.GamePhase;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Main;
import itemsadder.m.aaa;
import itemsadder.m.ae;
import itemsadder.m.ai;
import itemsadder.m.aow;
import itemsadder.m.aqp;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.fw;
import itemsadder.m.xf;
import itemsadder.m.xg;
import itemsadder.m.xh;
import itemsadder.m.xi;
import itemsadder.m.xk;
import itemsadder.m.xl;
import itemsadder.m.xm;
import itemsadder.m.xn;
import itemsadder.m.zw;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Team;

public class xe
implements ai {
    public static String Sf;
    private final d Sg;
    public static final Pattern Sh;
    private PacketListener Si;
    private PacketListener Sj;
    private PacketListener Sk;
    private final PacketListener Sl;
    Cache gf = CacheBuilder.newBuilder().expireAfterWrite(20L, TimeUnit.SECONDS).build();

    public xe(Plugin plugin, d d2) {
        this.Sg = d2;
        Sf = Main.PQ.ir("font-image-chat-hover");
        bev.a(this, plugin);
        for (Player player : Bukkit.getOnlinePlayers()) {
            aqp.uW().b(player, d.g().al.ul);
        }
        if (ae.eE || ae.eN) {
            this.Sj = new xf(this, PacketAdapter.params().plugin(plugin).types(new PacketType[]{PacketType.Play.Server.DISGUISED_CHAT}).optionAsync().listenerPriority(ListenerPriority.NORMAL));
            aow.b(this.Sj);
            this.Si = new xg(this, PacketAdapter.params().plugin(plugin).types(new PacketType[]{PacketType.Play.Server.SYSTEM_CHAT}).optionAsync().listenerPriority(ListenerPriority.NORMAL));
            aow.b(this.Si);
            this.Sk = new xh(this, PacketAdapter.params().plugin(plugin).types(new PacketType[]{PacketType.Play.Server.CHAT}).optionAsync().listenerPriority(ListenerPriority.NORMAL));
            aow.b(this.Sk);
        }
        this.Sl = new xi(this, PacketAdapter.params().plugin(plugin).serverSide().optionAsync().gamePhase(GamePhase.PLAYING).types(new PacketType[]{PacketType.Play.Server.OPEN_WINDOW}).listenerPriority(ListenerPriority.HIGH));
        aow.b(this.Sl);
        if (ae.eE && ae.eM) {
            bcp.a(bukkitRunnable -> {
                for (Team team : Bukkit.getScoreboardManager().getMainScoreboard().getTeams()) {
                    team.setDisplayName(xk.replaceFontImages(team.getDisplayName()));
                    team.setPrefix(xk.replaceFontImages(team.getPrefix()));
                    team.setSuffix(xk.replaceFontImages(team.getSuffix()));
                }
            }, 20L, (long)Main.KO.gW("font_images.scoreboard-teams.update-every-ticks"));
        }
        if (ae.eE && ae.eK) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                this.i(player, false);
            }
        }
    }

    @Override
    public void unregister() {
        ai.super.unregister();
        aow.c(this.Sj);
        aow.c(this.Si);
        aow.c(this.Sk);
        aow.c(this.Sl);
    }

    public static String f(Player player, String string) {
        Matcher matcher = Sh.matcher(string);
        while (matcher.find()) {
            String string2 = matcher.group();
            fw fw2 = d.g().al.aR(string2);
            if (fw2 == null || fw2.a((Permissible)player)) continue;
            string = StringUtils.replace((String)string, (String)string2, (String)StringUtils.replace((String)string2, (String)":", (String)" "));
        }
        return string;
    }

    public String g(Player player, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int n = string.length();
            for (int i = 0; i < n; ++i) {
                fw fw2 = this.Sg.al.a(string, i);
                if (fw2 != null) {
                    if (!fw2.a((Permissible)player)) {
                        stringBuilder.append(fw2.getId());
                        continue;
                    }
                    stringBuilder.append(fw2.ij());
                    if (!fw2.ik()) continue;
                    ++i;
                    continue;
                }
                stringBuilder.append(string.charAt(i));
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return stringBuilder.toString();
    }

    private void bo(Player player) {
        this.i(player, true);
    }

    private void i(Player player, boolean bl) {
        if (bl) {
            aqp.uW().b(player, d.g().al.ul);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedHashMap linkedHashMap = d.g().al.um;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            fw fw2 = (fw)entry.getValue();
            if (!fw2.ih() || !fw2.a((Permissible)player)) continue;
            arrayList.add(fw2.ij());
        }
        if (!arrayList.isEmpty()) {
            aqp.uW().a(player, arrayList);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void b(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        if (player.hasMetadata("NPC")) {
            return;
        }
        if (ae.eK) {
            this.bo(player);
        }
    }

    @EventHandler(priority=EventPriority.LOWEST, ignoreCancelled=true)
    private void a(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        if (ae.eE) {
            asyncPlayerChatEvent.setMessage(xe.f(asyncPlayerChatEvent.getPlayer(), asyncPlayerChatEvent.getMessage()));
            asyncPlayerChatEvent.setMessage(this.g(asyncPlayerChatEvent.getPlayer(), asyncPlayerChatEvent.getMessage()));
        }
        if (ae.eN) {
            asyncPlayerChatEvent.setMessage(xm.e((Permissible)asyncPlayerChatEvent.getPlayer(), asyncPlayerChatEvent.getMessage()));
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        if (!Main.KO.gY("font_images.command.enabled")) {
            return;
        }
        if (!playerCommandPreprocessEvent.getMessage().startsWith("/")) {
            return;
        }
        if (ae.eE) {
            playerCommandPreprocessEvent.setMessage(xe.f(playerCommandPreprocessEvent.getPlayer(), playerCommandPreprocessEvent.getMessage()));
            playerCommandPreprocessEvent.setMessage(this.g(playerCommandPreprocessEvent.getPlayer(), playerCommandPreprocessEvent.getMessage()));
        }
        if (ae.eN) {
            playerCommandPreprocessEvent.setMessage(xm.e((Permissible)playerCommandPreprocessEvent.getPlayer(), playerCommandPreprocessEvent.getMessage()));
        }
        if (!playerCommandPreprocessEvent.getPlayer().hasPermission("ia.user.image.command")) {
            return;
        }
        if (ae.eE) {
            for (String string : Main.KO.hg("font_images.command.excluded")) {
                if (!playerCommandPreprocessEvent.getMessage().startsWith("/" + string)) continue;
                return;
            }
            playerCommandPreprocessEvent.setMessage(xk.replaceFontImages((Permissible)playerCommandPreprocessEvent.getPlayer(), playerCommandPreprocessEvent.getMessage()));
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(ServerCommandEvent serverCommandEvent) {
        if (!ae.eJ) {
            return;
        }
        for (String string : ae.eL) {
            if (!serverCommandEvent.getCommand().startsWith(string)) continue;
            return;
        }
        serverCommandEvent.setCommand(xk.replaceFontImages((Permissible)serverCommandEvent.getSender(), serverCommandEvent.getCommand()));
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BroadcastMessageEvent broadcastMessageEvent) {
        if (ae.eE && zw.UO) {
            broadcastMessageEvent.message(xl.h(broadcastMessageEvent.message()));
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(SignChangeEvent signChangeEvent) {
        if (!aaa.Va) {
            return;
        }
        if (ae.eG && signChangeEvent.getPlayer().hasPermission("ia.user.image.sign")) {
            signChangeEvent.lines().replaceAll(xl::h);
        }
        if (ae.eO && signChangeEvent.getPlayer().hasPermission("ia.user.text_effect.sign")) {
            signChangeEvent.lines().replaceAll(xn::h);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(PlayerEditBookEvent playerEditBookEvent) {
        if (!aaa.Va) {
            return;
        }
        if (!ae.eP && !ae.eH) {
            return;
        }
        boolean bl = playerEditBookEvent.getPlayer().hasPermission("ia.user.text_effect.book");
        boolean bl2 = playerEditBookEvent.getPlayer().hasPermission("ia.user.image.book");
        BookMeta bookMeta = playerEditBookEvent.getNewBookMeta();
        ArrayList arrayList = new ArrayList(bookMeta.pages());
        arrayList.replaceAll(component -> {
            if (bl && ae.eP) {
                component = xn.a((Permissible)playerEditBookEvent.getPlayer(), component);
            }
            if (bl2 && ae.eH) {
                component = xl.a((Permissible)playerEditBookEvent.getPlayer(), component);
            }
            return component;
        });
        if (bookMeta.title() != null && bookMeta.author() != null) {
            if (bl && ae.eP) {
                bookMeta = bookMeta.toBuilder().title(xn.a((Permissible)playerEditBookEvent.getPlayer(), bookMeta.title())).author(xn.a((Permissible)playerEditBookEvent.getPlayer(), bookMeta.author())).build();
            }
            if (bl2 && ae.eH) {
                bookMeta = bookMeta.toBuilder().title(xl.a((Permissible)playerEditBookEvent.getPlayer(), bookMeta.title())).author(xl.a((Permissible)playerEditBookEvent.getPlayer(), bookMeta.author())).build();
            }
        }
        bookMeta = bookMeta.toBuilder().title(bookMeta.title()).author(bookMeta.author()).pages(arrayList).build();
        playerEditBookEvent.setNewBookMeta(bookMeta);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PrepareAnvilEvent prepareAnvilEvent) {
        if (!aaa.Va) {
            return;
        }
        if (!ae.eI && !ae.eQ) {
            return;
        }
        ItemStack itemStack = prepareAnvilEvent.getResult();
        if (itemStack == null) {
            return;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null && itemMeta.hasDisplayName()) {
            if (ae.eQ && prepareAnvilEvent.getView().getPlayer().hasPermission("ia.user.text_effect.anvil")) {
                itemMeta.displayName(xn.h(itemMeta.displayName()));
            }
            if (ae.eI && prepareAnvilEvent.getView().getPlayer().hasPermission("ia.user.image.anvil")) {
                itemMeta.displayName(xl.h(itemMeta.displayName()));
            }
            itemStack.setItemMeta(itemMeta);
        }
    }

    static {
        Sh = Pattern.compile(":([a-z_\\-0-9]+):", 2);
    }
}
