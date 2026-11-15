package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.axi;
import itemsadder.m.bbi;
import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.bx;
import itemsadder.m.d;
import itemsadder.m.da;
import itemsadder.m.ms;
import itemsadder.m.ql;
import itemsadder.m.za;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class xv
extends za {
    static final int Sy = 10;
    private final Map Sz = new HashMap();

    public xv() {
        Main.cM("iadebug").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!za.a(1, stringArray)) {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            bce.f(commandSender, bcy.gH("&e/iadebug <action> [arguments]"));
            bce.f(commandSender, bcy.gH("&6Example: &e/iadebug region"));
            return true;
        }
        if (stringArray[0].equals("region")) {
            ms ms2 = null;
            if (commandSender instanceof Player) {
                Player player = (Player)commandSender;
                if (stringArray.length == 1) {
                    ms2 = d.g().a(player.getLocation());
                }
            }
            if (ms2 == null) {
                if (!za.a(4, stringArray)) {
                    bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
                    bce.f(commandSender, bcy.gH("&e/iadebug <action> [arguments]"));
                    bce.f(commandSender, bcy.gH("&6Example: &e/iadebug region"));
                    return true;
                }
                try {
                    ms2 = d.g().a(Bukkit.getWorld((String)stringArray[1]), Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3]));
                }
                catch (Throwable throwable) {
                    bce.f(commandSender, "Command error. Make sure you used it correctly.");
                    return true;
                }
            }
            bce.f(commandSender, "Region: " + ms2.lQ());
            bce.f(commandSender, "Loaded Chunks: " + ms2.lP());
            bce.f(commandSender, "Size: " + ms2.lR());
        } else if (stringArray[0].equals("placeCrops")) {
            bx bx2 = (bx)d.g().ab.get(stringArray[1]);
            if (bx2 == null) {
                bce.f(commandSender, "Crop not found: " + stringArray[1]);
                return true;
            }
            boolean bl = za.a(stringArray, 4, true);
            Player player = (Player)commandSender;
            Location location = player.getLocation().add(0.0, 1.0, 0.0);
            World world = location.getWorld();
            int n = za.a(stringArray, 2, 10);
            int n2 = za.a(stringArray, 3, -1);
            for (int i = -n; i <= n; ++i) {
                for (int j = -n; j <= n; ++j) {
                    int n3;
                    Location location2;
                    Location location3 = location.clone().add((double)i, 0.0, (double)j);
                    location3.setY((double)(world.getHighestBlockYAt(location3) + 1));
                    if (!location3.getBlock().getType().isAir() && !location3.getBlock().isReplaceable() || !bl && d.g().v().m(location3) || !(location2 = location3.clone().add(0.0, -1.0, 0.0)).getBlock().getType().isSolid() || !location2.getBlock().getType().isOccluding()) continue;
                    if (bx2.hN && location2.getBlock().getType() != Material.FARMLAND) {
                        location2.getBlock().setType(Material.FARMLAND);
                    }
                    if ((n3 = n2) == -1) {
                        n3 = bcy.v(0, bx2.hK);
                    }
                    d.g().v().kO.a(location3.getBlock(), bx2.hD, n3);
                    location3.getBlock().setType(Material.AIR);
                }
            }
        } else if (stringArray[0].equals("cleanCrops")) {
            AtomicInteger atomicInteger = new AtomicInteger();
            d.g().v().kO.a((chunk, bm2) -> {
                if (!d.g().v().kO.c((Chunk)chunk).bh().bi().isEmpty()) {
                    atomicInteger.getAndIncrement();
                    d.g().v().kO.d((Chunk)chunk);
                }
            });
            bce.f(commandSender, "Cleaned crops data in " + atomicInteger.get() + " loaded chunks.");
        } else if (stringArray[0].equals("stopEmote")) {
            da.db().X((Player)commandSender);
        } else if (stringArray[0].equals("tnt")) {
            String string2 = za.a(stringArray, 1, null);
            if (string2 == null) {
                bce.f(commandSender, "You must provide a namespaced ID of a custom block.");
                return true;
            }
            ql ql2 = d.g().h(string2);
            if (ql2 == null) {
                bce.f(commandSender, "Custom block not found: " + string2);
                return true;
            }
            BlockData blockData = ql2.FD.pb();
            axi.vC().aoJ.a(((Player)commandSender).getLocation(), 5, blockData, (Player)commandSender, null);
        } else if (stringArray[0].equalsIgnoreCase("starve")) {
            Player player = (Player)commandSender;
            player.setFoodLevel(0);
            player.setSaturation(0.0f);
        } else if (stringArray[0].equalsIgnoreCase("get-item-with-custom-model-data")) {
            Player player = (Player)commandSender;
            @Nullable Material material = bbi.ig(za.a(stringArray, 1, null));
            if (material == null) {
                bce.f(commandSender, "Material not found");
                return true;
            }
            ItemStack itemStack = new ItemStack(material);
            bbs.b(itemStack, za.a(stringArray, 2, 0));
            player.getInventory().addItem(new ItemStack[]{itemStack});
            bce.f(commandSender, "Item has been added to the inventory.");
        } else if (stringArray[0].equalsIgnoreCase("messages")) {
            if (!(commandSender instanceof Player)) {
                bce.g(commandSender, "command-ingame-only");
                return true;
            }
            Player player = (Player)commandSender;
            int n = 0;
            if (stringArray.length > 1) {
                try {
                    n = Integer.parseInt(stringArray[1]);
                }
                catch (NumberFormatException numberFormatException) {
                    return true;
                }
                if (!Integer.valueOf(n).equals(this.Sz.get(player.getUniqueId()))) {
                    return true;
                }
            }
            this.e(player, n);
        }
        return true;
    }

    private void e(Player player, int n) {
        ArrayList arrayList = new ArrayList(Main.PQ.CK());
        Collections.sort(arrayList);
        List list = xv.a(arrayList, n);
        if (list.isEmpty()) {
            return;
        }
        int n2 = n * 10 + 1;
        int n3 = n2 + list.size() - 1;
        bce.a((CommandSender)player, (Component)Component.text((String)("Language messages " + n2 + "\u2013" + n3 + " / " + arrayList.size()), (TextColor)NamedTextColor.DARK_GRAY));
        for (String string : list) {
            Component component = ((TextComponent)Component.text((String)string, (TextColor)NamedTextColor.AQUA).append((Component)Component.text((String)" \u00bb ", (TextColor)NamedTextColor.DARK_GRAY))).append(Main.PQ.it(string));
            bce.a((CommandSender)player, component);
        }
        int n4 = n + 1;
        if (n4 * 10 < arrayList.size()) {
            String string;
            this.Sz.put(player.getUniqueId(), n4);
            string = ((TextComponent)((TextComponent)Component.text((String)"[ Show next 10 \u00bb ]", (TextColor)NamedTextColor.AQUA).decorate(TextDecoration.BOLD)).clickEvent(ClickEvent.runCommand((String)("/iadebug messages " + n4)))).hoverEvent((HoverEventSource)Component.text((String)"Print the next 10 language messages", (TextColor)NamedTextColor.GRAY));
            bce.a((CommandSender)player, (Component)string);
        } else {
            this.Sz.remove(player.getUniqueId());
            bce.a((CommandSender)player, (Component)Component.text((String)"End of language messages.", (TextColor)NamedTextColor.DARK_GRAY));
        }
    }

    static List a(List list, int n) {
        if (n < 0 || n > list.size() / 10) {
            return List.of();
        }
        int n2 = n * 10;
        if (n2 == list.size()) {
            return List.of();
        }
        return List.copyOf(list.subList(n2, Math.min(n2 + 10, list.size())));
    }
}
