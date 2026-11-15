package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.aaf;
import itemsadder.m.aqp;
import itemsadder.m.bce;
import itemsadder.m.d;
import itemsadder.m.ms;
import itemsadder.m.ra;
import itemsadder.m.za;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class xq
extends za {
    public xq() {
        Main.cM("iablock").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            bce.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        if (!s.c((Permissible)player, "ia.admin.iablock")) {
            return true;
        }
        Block block = aqp.ca(player);
        if (block == null || block.getType() == Material.AIR) {
            return true;
        }
        ms ms2 = d.g().b(block);
        if (!ms2.isCustomBlock(block)) {
            if (ms2.T(block)) {
                Integer n;
                String string2 = ms2.aa(block);
                if (string2 != null) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Crop Seed: " + string2);
                }
                if ((n = ms2.ae(block)) != null) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Fire Age: " + n);
                }
            } else {
                player.sendMessage(String.valueOf(ChatColor.AQUA) + String.valueOf(block.getType()));
            }
        } else {
            String string3 = ms2.Y(block);
            ra ra2 = (ra)d.g().e(string3);
            if (ra2 == null) {
                if (d.g().af.containsKey(string3)) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Type: " + string3 + String.valueOf(ChatColor.DARK_GRAY) + " (liquid)");
                } else {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Type: " + string3 + String.valueOf(ChatColor.DARK_GRAY) + " (removed from IA configs)");
                }
            } else {
                Integer n;
                player.sendMessage(String.valueOf(ChatColor.AQUA) + "Type: " + ra2.getNamespacedID());
                player.sendMessage(String.valueOf(ChatColor.AQUA) + "Chunk: " + block.getChunk().getX() + ", " + block.getChunk().getZ());
                if (block.getType() == Material.FIRE && ms2.T(block) && (n = ms2.ae(block)) != null) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Fire age: " + n);
                }
            }
        }
        if (aaf.aL(block)) {
            player.sendMessage("(Is a tile entity)");
        }
        return true;
    }
}
