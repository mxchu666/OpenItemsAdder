package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.afj;
import itemsadder.m.aqp;
import itemsadder.m.arf;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import itemsadder.m.d;
import itemsadder.m.kd;
import itemsadder.m.ms;
import itemsadder.m.za;
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

public class yk
extends za {
    public yk() {
        Main.cM("ialiquid").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        Object object;
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            bce.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        if (!s.c((Permissible)player, "ia.admin.ialiquid")) {
            return true;
        }
        Block block = null;
        if (stringArray.length == 0) {
            block = aqp.bZ(player);
        } else if (stringArray.length == 1) {
            if (player.isOp()) {
                if (stringArray[0].equals("debug")) {
                    var7_7 = 5;
                    object = player.getLocation();
                    for (int i = object.getBlockX() - var7_7; i < object.getBlockX() + var7_7; ++i) {
                        for (int j = object.getBlockY() - var7_7; j < object.getBlockY() + var7_7; ++j) {
                            for (int k = object.getBlockZ() - var7_7; k < object.getBlockZ() + var7_7; ++k) {
                                Location location = new Location(object.getWorld(), (double)i, (double)j, (double)k);
                                String string2 = afj.tG().bd(location.getBlock());
                                if (!string2.startsWith("ia")) continue;
                                arf.a(player, location, new Color(Color.RED.getRed(), Color.RED.getGreen(), Color.RED.getBlue(), 127).getRGB(), 3000, string2);
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
                                String string3 = afj.tG().bd(location.getBlock());
                                if (!string3.startsWith("ia")) continue;
                                Block block2 = location.getBlock();
                                ms ms2 = d.g().a(block2.getChunk());
                                if (ms2.T(block2)) {
                                    String[] stringArray2 = ms2.ac(location.getBlock()).split(":");
                                    afj.tG().a(location.getBlock(), stringArray2[0], stringArray2[1]);
                                    ms2.c(block, true);
                                } else {
                                    afj.tG().a(location.getBlock(), "minecraft", "plains");
                                }
                                commandSender.sendMessage("Reset biome around player");
                            }
                        }
                    }
                }
            }
        } else if (stringArray.length == 3 && bcy.iJ(stringArray[0]) && bcy.iJ(stringArray[1]) && bcy.iJ(stringArray[2])) {
            block = player.getWorld().getBlockAt(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
        } else {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage"));
            bce.f(commandSender, bcy.gH("&e/ialiquid &b[x] [y] [z]"));
            bce.f(commandSender, bcy.gH("&6Example: &e/ialiquid"));
        }
        if (block == null) {
            return true;
        }
        if (kd.c(block.getType())) {
            ms ms3 = d.g().a(block.getChunk());
            if (!ms3.T(block)) {
                player.sendMessage(String.valueOf(ChatColor.AQUA) + String.valueOf(block.getType()));
            } else {
                object = ms3.ab(block);
                player.sendMessage(String.valueOf(ChatColor.AQUA) + "Liquid: " + (String)object);
                if (object != null) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Bucket: " + (String)d.g().bf.get(object));
                }
            }
        } else {
            player.sendMessage(String.valueOf(ChatColor.AQUA) + String.valueOf(block.getType()));
        }
        player.sendMessage(String.valueOf(ChatColor.AQUA) + "Block Biome: " + afj.tG().bd(block));
        return true;
    }
}
