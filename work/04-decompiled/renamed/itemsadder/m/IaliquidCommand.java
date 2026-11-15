package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.BiomeHolder;
import itemsadder.m.BlockBridge_7;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.MinecraftKeyHelper;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PluginCommand_2;
import java.awt.Color;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class IaliquidCommand
extends PluginCommand_2 {
    public IaliquidCommand() {
        Main.cM("ialiquid").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        Object object;
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            CommandSenderBridge_5.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        if (!s.c((Permissible)player, "ia.admin.ialiquid")) {
            return true;
        }
        Block block = null;
        if (stringArray.length == 0) {
            block = PlayerHolder_4.bZ(player);
        } else if (stringArray.length == 1) {
            if (player.isOp()) {
                if (stringArray[0].equals("debug")) {
                    var7_7 = 5;
                    object = player.getLocation();
                    for (int i = object.getBlockX() - var7_7; i < object.getBlockX() + var7_7; ++i) {
                        for (int j = object.getBlockY() - var7_7; j < object.getBlockY() + var7_7; ++j) {
                            for (int k = object.getBlockZ() - var7_7; k < object.getBlockZ() + var7_7; ++k) {
                                Location location = new Location(object.getWorld(), (double)i, (double)j, (double)k);
                                String string2 = BiomeHolder.tG().bd(location.getBlock());
                                if (!string2.startsWith("ia")) continue;
                                MinecraftKeyHelper.a(player, location, new Color(Color.RED.getRed(), Color.RED.getGreen(), Color.RED.getBlue(), 127).getRGB(), 3000, string2);
                            }
                        }
                    }
                } else if (stringArray[0].equals("clean")) {
                    var7_7 = 5;
                    object = player.getLocation();
                    for (int i = object.getBlockX() - var7_7; i < object.getBlockX() + var7_7; ++i) {
                        for (int j = object.getBlockY() - var7_7; j < object.getBlockY() + var7_7; ++j) {
                            for (int k = object.getBlockZ() - var7_7; k < object.getBlockZ() + var7_7; ++k) {
                                Location location = new Location(object.getWorld(), (double)i, (double)j, (double)k);
                                String string3 = BiomeHolder.tG().bd(location.getBlock());
                                if (!string3.startsWith("ia")) continue;
                                Block block2 = location.getBlock();
                                BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(block2.getChunk());
                                if (blockBridge_9.T(block2)) {
                                    String[] stringArray2 = blockBridge_9.ac(location.getBlock()).split(":");
                                    BiomeHolder.tG().a(location.getBlock(), stringArray2[0], stringArray2[1]);
                                    blockBridge_9.c(block, true);
                                } else {
                                    BiomeHolder.tG().a(location.getBlock(), "minecraft", "plains");
                                }
                                commandSender.sendMessage("Reset biome around player");
                            }
                        }
                    }
                }
            }
        } else if (stringArray.length == 3 && ColorBridge.iJ(stringArray[0]) && ColorBridge.iJ(stringArray[1]) && ColorBridge.iJ(stringArray[2])) {
            block = player.getWorld().getBlockAt(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
        } else {
            CommandSenderBridge_5.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&e/ialiquid &b[x] [y] [z]"));
            CommandSenderBridge_5.f(commandSender, ColorBridge.gH("&6Example: &e/ialiquid"));
        }
        if (block == null) {
            return true;
        }
        if (BlockBridge_7.c(block.getType())) {
            BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().a(block.getChunk());
            if (!blockBridge_9.T(block)) {
                player.sendMessage(String.valueOf(ChatColor.AQUA) + String.valueOf(block.getType()));
            } else {
                object = blockBridge_9.ab(block);
                player.sendMessage(String.valueOf(ChatColor.AQUA) + "Liquid: " + (String)object);
                if (object != null) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Bucket: " + (String)ItemStackRegistry.g().bf.get(object));
                }
            }
        } else {
            player.sendMessage(String.valueOf(ChatColor.AQUA) + String.valueOf(block.getType()));
        }
        player.sendMessage(String.valueOf(ChatColor.AQUA) + "Block Biome: " + BiomeHolder.tG().bd(block));
        return true;
    }
}
