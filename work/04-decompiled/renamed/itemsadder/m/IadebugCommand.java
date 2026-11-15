package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EnumWrappersHolder;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.LivingEntityRegistry;
import itemsadder.m.LocationBridgeBuilder_2;
import itemsadder.m.LocationBridge_7;
import itemsadder.m.PluginCommand_2;
import itemsadder.m.SoundCategoryBridge;
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

public class IadebugCommand
extends PluginCommand_2 {
    static final int Sy = 10;
    private final Map Sz = new HashMap();

    public IadebugCommand() {
        Main.cM("iadebug").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!PluginCommand_2.a(1, stringArray)) {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&e/iadebug <action> [arguments]"));
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&6Example: &e/iadebug region"));
            return true;
        }
        if (stringArray[0].equals("region")) {
            BlockBridge_9 blockBridge_9 = null;
            if (commandSender instanceof Player) {
                Player player = (Player)commandSender;
                if (stringArray.length == 1) {
                    blockBridge_9 = ItemStackRegistry.g().a(player.getLocation());
                }
            }
            if (blockBridge_9 == null) {
                if (!PluginCommand_2.a(4, stringArray)) {
                    CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
                    CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&e/iadebug <action> [arguments]"));
                    CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&6Example: &e/iadebug region"));
                    return true;
                }
                try {
                    blockBridge_9 = ItemStackRegistry.g().a(Bukkit.getWorld((String)stringArray[1]), Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3]));
                }
                catch (Throwable throwable) {
                    CommandSenderBridge_5.f(commandSender, "Command error. Make sure you used it correctly.");
                    return true;
                }
            }
            CommandSenderBridge_5.f(commandSender, "Region: " + blockBridge_9.lQ());
            CommandSenderBridge_5.f(commandSender, "Loaded Chunks: " + blockBridge_9.lP());
            CommandSenderBridge_5.f(commandSender, "Size: " + blockBridge_9.lR());
        } else if (stringArray[0].equals("placeCrops")) {
            LocationBridge_7 locationBridge_7 = (LocationBridge_7)ItemStackRegistry.g().ab.get(stringArray[1]);
            if (locationBridge_7 == null) {
                CommandSenderBridge_5.f(commandSender, "Crop not found: " + stringArray[1]);
                return true;
            }
            boolean bl = PluginCommand_2.a(stringArray, 4, true);
            Player player = (Player)commandSender;
            Location location = player.getLocation().add(0.0, 1.0, 0.0);
            World world = location.getWorld();
            int n = PluginCommand_2.a(stringArray, 2, 10);
            int n2 = PluginCommand_2.a(stringArray, 3, -1);
            for (int i = -n; i <= n; ++i) {
                for (int j = -n; j <= n; ++j) {
                    int n3;
                    Location location2;
                    Location location3 = location.clone().add((double)i, 0.0, (double)j);
                    location3.setY((double)(world.getHighestBlockYAt(location3) + 1));
                    if (!location3.getBlock().getType().isAir() && !location3.getBlock().isReplaceable() || !bl && ItemStackRegistry.g().v().m(location3) || !(location2 = location3.clone().add(0.0, -1.0, 0.0)).getBlock().getType().isSolid() || !location2.getBlock().getType().isOccluding()) continue;
                    if (locationBridge_7.hN && location2.getBlock().getType() != Material.FARMLAND) {
                        location2.getBlock().setType(Material.FARMLAND);
                    }
                    if ((n3 = n2) == -1) {
                        n3 = ColorBridge.v(0, locationBridge_7.hK);
                    }
                    ItemStackRegistry.g().v().kO.a(location3.getBlock(), locationBridge_7.hD, n3);
                    location3.getBlock().setType(Material.AIR);
                }
            }
        } else if (stringArray[0].equals("cleanCrops")) {
            AtomicInteger atomicInteger = new AtomicInteger();
            ItemStackRegistry.g().v().kO.a((chunk, blockBridge_5) -> {
                if (!ItemStackRegistry.g().v().kO.c((Chunk)chunk).bh().bi().isEmpty()) {
                    atomicInteger.getAndIncrement();
                    ItemStackRegistry.g().v().kO.d((Chunk)chunk);
                }
            });
            CommandSenderBridge_5.f(commandSender, "Cleaned crops data in " + atomicInteger.get() + " loaded chunks.");
        } else if (stringArray[0].equals("stopEmote")) {
            LivingEntityRegistry.db().X((Player)commandSender);
        } else if (stringArray[0].equals("tnt")) {
            String string2 = PluginCommand_2.a(stringArray, 1, null);
            if (string2 == null) {
                CommandSenderBridge_5.f(commandSender, "You must provide a namespaced ID of a custom block.");
                return true;
            }
            LocationBridgeBuilder_2 locationBridgeBuilder_2 = ItemStackRegistry.g().h(string2);
            if (locationBridgeBuilder_2 == null) {
                CommandSenderBridge_5.f(commandSender, "Custom block not found: " + string2);
                return true;
            }
            BlockData blockData = locationBridgeBuilder_2.FD.pb();
            EnumWrappersHolder.vC().aoJ.a(((Player)commandSender).getLocation(), 5, blockData, (Player)commandSender, null);
        } else if (stringArray[0].equalsIgnoreCase("starve")) {
            Player player = (Player)commandSender;
            player.setFoodLevel(0);
            player.setSaturation(0.0f);
        } else if (stringArray[0].equalsIgnoreCase("get-item-with-custom-model-data")) {
            Player player = (Player)commandSender;
            @Nullable Material material = SoundCategoryBridge.ig(PluginCommand_2.a(stringArray, 1, null));
            if (material == null) {
                CommandSenderBridge_5.f(commandSender, "Material not found");
                return true;
            }
            ItemStack itemStack = new ItemStack(material);
            ItemStackBridge_2.b(itemStack, PluginCommand_2.a(stringArray, 2, 0));
            player.getInventory().addItem(new ItemStack[]{itemStack});
            CommandSenderBridge_5.f(commandSender, "Item has been added to the inventory.");
        } else if (stringArray[0].equalsIgnoreCase("messages")) {
            if (!(commandSender instanceof Player)) {
                CommandSenderBridge_5.g(commandSender, "command-ingame-only");
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
        List list = IadebugCommand.a(arrayList, n);
        if (list.isEmpty()) {
            return;
        }
        int n2 = n * 10 + 1;
        int n3 = n2 + list.size() - 1;
        CommandSenderBridge_5.a((CommandSender)player, (Component)Component.text((String)("Language messages " + n2 + "\u2013" + n3 + " / " + arrayList.size()), (TextColor)NamedTextColor.DARK_GRAY));
        for (String string : list) {
            Component component = ((TextComponent)Component.text((String)string, (TextColor)NamedTextColor.AQUA).append((Component)Component.text((String)" \u00bb ", (TextColor)NamedTextColor.DARK_GRAY))).append(Main.PQ.it(string));
            CommandSenderBridge_5.a((CommandSender)player, component);
        }
        int n4 = n + 1;
        if (n4 * 10 < arrayList.size()) {
            String string;
            this.Sz.put(player.getUniqueId(), n4);
            string = ((TextComponent)((TextComponent)Component.text((String)"[ Show next 10 \u00bb ]", (TextColor)NamedTextColor.AQUA).decorate(TextDecoration.BOLD)).clickEvent(ClickEvent.runCommand((String)("/iadebug messages " + n4)))).hoverEvent((HoverEventSource)Component.text((String)"Print the next 10 language messages", (TextColor)NamedTextColor.GRAY));
            CommandSenderBridge_5.a((CommandSender)player, (Component)string);
        } else {
            this.Sz.remove(player.getUniqueId());
            CommandSenderBridge_5.a((CommandSender)player, (Component)Component.text((String)"End of language messages.", (TextColor)NamedTextColor.DARK_GRAY));
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
