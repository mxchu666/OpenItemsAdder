package itemsadder.m;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketListener;
import com.comphenix.protocol.injector.GamePhase;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import dev.lone.itemsadder.Main;
import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.DisguisedChatComponentListener;
import itemsadder.m.DisguisedChatComponentListener_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.PacketContainerHelper_3;
import itemsadder.m.PacketListenerRegistry;
import itemsadder.m.PermissibleBridge;
import itemsadder.m.PermissibleBridge_2;
import itemsadder.m.PermissibleBridge_3;
import itemsadder.m.PermissibleBridge_4;
import itemsadder.m.PlayerChatComponentListener;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PluginContract;
import itemsadder.m.SystemChatComponentListener;
import itemsadder.m.VersionHelper;
import itemsadder.m.VersionHelper_3;
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

public class PlayerJoinListener_10
implements PluginContract {
    public static String Sf;
    private final ItemStackRegistry Sg;
    public static final Pattern Sh;
    private PacketListener Si;
    private PacketListener Sj;
    private PacketListener Sk;
    private final PacketListener Sl;
    Cache gf = CacheBuilder.newBuilder().expireAfterWrite(20L, TimeUnit.SECONDS).build();

    public PlayerJoinListener_10(Plugin plugin, ItemStackRegistry itemStackRegistry) {
        this.Sg = itemStackRegistry;
        Sf = Main.PQ.ir("font-image-chat-hover");
        ListenerBridge.a(this, plugin);
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerHolder_4.uW().b(player, ItemStackRegistry.g().al.ul);
        }
        if (MaterialBarColorHolder.eE || MaterialBarColorHolder.eN) {
            this.Sj = new DisguisedChatComponentListener(this, PacketAdapter.params().plugin(plugin).types(new PacketType[]{PacketType.Play.Server.DISGUISED_CHAT}).optionAsync().listenerPriority(ListenerPriority.NORMAL));
            PacketListenerRegistry.b(this.Sj);
            this.Si = new SystemChatComponentListener(this, PacketAdapter.params().plugin(plugin).types(new PacketType[]{PacketType.Play.Server.SYSTEM_CHAT}).optionAsync().listenerPriority(ListenerPriority.NORMAL));
            PacketListenerRegistry.b(this.Si);
            this.Sk = new PlayerChatComponentListener(this, PacketAdapter.params().plugin(plugin).types(new PacketType[]{PacketType.Play.Server.CHAT}).optionAsync().listenerPriority(ListenerPriority.NORMAL));
            PacketListenerRegistry.b(this.Sk);
        }
        this.Sl = new DisguisedChatComponentListener_2(this, PacketAdapter.params().plugin(plugin).serverSide().optionAsync().gamePhase(GamePhase.PLAYING).types(new PacketType[]{PacketType.Play.Server.OPEN_WINDOW}).listenerPriority(ListenerPriority.HIGH));
        PacketListenerRegistry.b(this.Sl);
        if (MaterialBarColorHolder.eE && MaterialBarColorHolder.eM) {
            BukkitTaskBridge.a(bukkitRunnable -> {
                for (Team team : Bukkit.getScoreboardManager().getMainScoreboard().getTeams()) {
                    team.setDisplayName(PermissibleBridge_2.replaceFontImages(team.getDisplayName()));
                    team.setPrefix(PermissibleBridge_2.replaceFontImages(team.getPrefix()));
                    team.setSuffix(PermissibleBridge_2.replaceFontImages(team.getSuffix()));
                }
            }, 20L, (long)Main.KO.gW("font_images.scoreboard-teams.update-every-ticks"));
        }
        if (MaterialBarColorHolder.eE && MaterialBarColorHolder.eK) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                this.i(player, false);
            }
        }
    }

    @Override
    public void unregister() {
        PluginContract.super.unregister();
        PacketListenerRegistry.c(this.Sj);
        PacketListenerRegistry.c(this.Si);
        PacketListenerRegistry.c(this.Sk);
        PacketListenerRegistry.c(this.Sl);
    }

    public static String f(Player player, String string) {
        Matcher matcher = Sh.matcher(string);
        while (matcher.find()) {
            String string2 = matcher.group();
            PermissibleBridge permissibleBridge = ItemStackRegistry.g().al.aR(string2);
            if (permissibleBridge == null || permissibleBridge.a((Permissible)player)) continue;
            string = StringUtils.replace((String)string, (String)string2, (String)StringUtils.replace((String)string2, (String)":", (String)" "));
        }
        return string;
    }

    public String g(Player player, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int n = string.length();
            for (int i = 0; i < n; ++i) {
                PermissibleBridge permissibleBridge = this.Sg.al.a(string, i);
                if (permissibleBridge != null) {
                    if (!permissibleBridge.a((Permissible)player)) {
                        stringBuilder.append(permissibleBridge.getId());
                        continue;
                    }
                    stringBuilder.append(permissibleBridge.ij());
                    if (!permissibleBridge.ik()) continue;
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
            PlayerHolder_4.uW().b(player, ItemStackRegistry.g().al.ul);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedHashMap linkedHashMap = ItemStackRegistry.g().al.um;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PermissibleBridge permissibleBridge = (PermissibleBridge)entry.getValue();
            if (!permissibleBridge.ih() || !permissibleBridge.a((Permissible)player)) continue;
            arrayList.add(permissibleBridge.ij());
        }
        if (!arrayList.isEmpty()) {
            PlayerHolder_4.uW().a(player, arrayList);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
    private void b(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        if (player.hasMetadata("NPC")) {
            return;
        }
        if (MaterialBarColorHolder.eK) {
            this.bo(player);
        }
    }

    @EventHandler(priority=EventPriority.LOWEST, ignoreCancelled=true)
    private void a(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        if (MaterialBarColorHolder.eE) {
            asyncPlayerChatEvent.setMessage(PlayerJoinListener_10.f(asyncPlayerChatEvent.getPlayer(), asyncPlayerChatEvent.getMessage()));
            asyncPlayerChatEvent.setMessage(this.g(asyncPlayerChatEvent.getPlayer(), asyncPlayerChatEvent.getMessage()));
        }
        if (MaterialBarColorHolder.eN) {
            asyncPlayerChatEvent.setMessage(PermissibleBridge_4.e((Permissible)asyncPlayerChatEvent.getPlayer(), asyncPlayerChatEvent.getMessage()));
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
        if (MaterialBarColorHolder.eE) {
            playerCommandPreprocessEvent.setMessage(PlayerJoinListener_10.f(playerCommandPreprocessEvent.getPlayer(), playerCommandPreprocessEvent.getMessage()));
            playerCommandPreprocessEvent.setMessage(this.g(playerCommandPreprocessEvent.getPlayer(), playerCommandPreprocessEvent.getMessage()));
        }
        if (MaterialBarColorHolder.eN) {
            playerCommandPreprocessEvent.setMessage(PermissibleBridge_4.e((Permissible)playerCommandPreprocessEvent.getPlayer(), playerCommandPreprocessEvent.getMessage()));
        }
        if (!playerCommandPreprocessEvent.getPlayer().hasPermission("ia.user.image.command")) {
            return;
        }
        if (MaterialBarColorHolder.eE) {
            for (String string : Main.KO.hg("font_images.command.excluded")) {
                if (!playerCommandPreprocessEvent.getMessage().startsWith("/" + string)) continue;
                return;
            }
            playerCommandPreprocessEvent.setMessage(PermissibleBridge_2.replaceFontImages((Permissible)playerCommandPreprocessEvent.getPlayer(), playerCommandPreprocessEvent.getMessage()));
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(ServerCommandEvent serverCommandEvent) {
        if (!MaterialBarColorHolder.eJ) {
            return;
        }
        for (String string : MaterialBarColorHolder.eL) {
            if (!serverCommandEvent.getCommand().startsWith(string)) continue;
            return;
        }
        serverCommandEvent.setCommand(PermissibleBridge_2.replaceFontImages((Permissible)serverCommandEvent.getSender(), serverCommandEvent.getCommand()));
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(BroadcastMessageEvent broadcastMessageEvent) {
        if (MaterialBarColorHolder.eE && VersionHelper_3.UO) {
            broadcastMessageEvent.message(PermissibleBridge_3.h(broadcastMessageEvent.message()));
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(SignChangeEvent signChangeEvent) {
        if (!VersionHelper.Va) {
            return;
        }
        if (MaterialBarColorHolder.eG && signChangeEvent.getPlayer().hasPermission("ia.user.image.sign")) {
            signChangeEvent.lines().replaceAll(PermissibleBridge_3::h);
        }
        if (MaterialBarColorHolder.eO && signChangeEvent.getPlayer().hasPermission("ia.user.text_effect.sign")) {
            signChangeEvent.lines().replaceAll(PacketContainerHelper_3::h);
        }
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void b(PlayerEditBookEvent playerEditBookEvent) {
        if (!VersionHelper.Va) {
            return;
        }
        if (!MaterialBarColorHolder.eP && !MaterialBarColorHolder.eH) {
            return;
        }
        boolean bl = playerEditBookEvent.getPlayer().hasPermission("ia.user.text_effect.book");
        boolean bl2 = playerEditBookEvent.getPlayer().hasPermission("ia.user.image.book");
        BookMeta bookMeta = playerEditBookEvent.getNewBookMeta();
        ArrayList arrayList = new ArrayList(bookMeta.pages());
        arrayList.replaceAll(component -> {
            if (bl && MaterialBarColorHolder.eP) {
                component = PacketContainerHelper_3.a((Permissible)playerEditBookEvent.getPlayer(), component);
            }
            if (bl2 && MaterialBarColorHolder.eH) {
                component = PermissibleBridge_3.a((Permissible)playerEditBookEvent.getPlayer(), component);
            }
            return component;
        });
        if (bookMeta.title() != null && bookMeta.author() != null) {
            if (bl && MaterialBarColorHolder.eP) {
                bookMeta = bookMeta.toBuilder().title(PacketContainerHelper_3.a((Permissible)playerEditBookEvent.getPlayer(), bookMeta.title())).author(PacketContainerHelper_3.a((Permissible)playerEditBookEvent.getPlayer(), bookMeta.author())).build();
            }
            if (bl2 && MaterialBarColorHolder.eH) {
                bookMeta = bookMeta.toBuilder().title(PermissibleBridge_3.a((Permissible)playerEditBookEvent.getPlayer(), bookMeta.title())).author(PermissibleBridge_3.a((Permissible)playerEditBookEvent.getPlayer(), bookMeta.author())).build();
            }
        }
        bookMeta = bookMeta.toBuilder().title(bookMeta.title()).author(bookMeta.author()).pages(arrayList).build();
        playerEditBookEvent.setNewBookMeta(bookMeta);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    private void a(PrepareAnvilEvent prepareAnvilEvent) {
        if (!VersionHelper.Va) {
            return;
        }
        if (!MaterialBarColorHolder.eI && !MaterialBarColorHolder.eQ) {
            return;
        }
        ItemStack itemStack = prepareAnvilEvent.getResult();
        if (itemStack == null) {
            return;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null && itemMeta.hasDisplayName()) {
            if (MaterialBarColorHolder.eQ && prepareAnvilEvent.getView().getPlayer().hasPermission("ia.user.text_effect.anvil")) {
                itemMeta.displayName(PacketContainerHelper_3.h(itemMeta.displayName()));
            }
            if (MaterialBarColorHolder.eI && prepareAnvilEvent.getView().getPlayer().hasPermission("ia.user.image.anvil")) {
                itemMeta.displayName(PermissibleBridge_3.h(itemMeta.displayName()));
            }
            itemStack.setItemMeta(itemMeta);
        }
    }

    static {
        Sh = Pattern.compile(":([a-z_\\-0-9]+):", 2);
    }
}
