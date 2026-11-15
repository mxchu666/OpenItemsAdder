package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.BlockBridge_13;
import itemsadder.m.BlockBridge_9;
import itemsadder.m.BlockRegistry;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerHolder_4;
import itemsadder.m.PluginCommand_2;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class IablockCommand
extends PluginCommand_2 {
    public IablockCommand() {
        Main.cM("iablock").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] stringArray) {
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (!(commandSender instanceof Player)) {
            CommandSenderBridge_5.iy("command-ingame-only");
            return true;
        }
        Player player = (Player)commandSender;
        if (!s.c((Permissible)player, "ia.admin.iablock")) {
            return true;
        }
        Block block = PlayerHolder_4.ca(player);
        if (block == null || block.getType() == Material.AIR) {
            return true;
        }
        BlockBridge_9 blockBridge_9 = ItemStackRegistry.g().b(block);
        if (!blockBridge_9.isCustomBlock(block)) {
            if (blockBridge_9.T(block)) {
                Integer n;
                String string2 = blockBridge_9.aa(block);
                if (string2 != null) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Crop Seed: " + string2);
                }
                if ((n = blockBridge_9.ae(block)) != null) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Fire Age: " + n);
                }
            } else {
                player.sendMessage(String.valueOf(ChatColor.AQUA) + String.valueOf(block.getType()));
            }
        } else {
            String string3 = blockBridge_9.Y(block);
            BlockBridge_13 blockBridge_13 = (BlockBridge_13)ItemStackRegistry.g().e(string3);
            if (blockBridge_13 == null) {
                if (ItemStackRegistry.g().af.containsKey(string3)) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Type: " + string3 + String.valueOf(ChatColor.DARK_GRAY) + " (liquid)");
                } else {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Type: " + string3 + String.valueOf(ChatColor.DARK_GRAY) + " (removed from IA configs)");
                }
            } else {
                Integer n;
                player.sendMessage(String.valueOf(ChatColor.AQUA) + "Type: " + blockBridge_13.getNamespacedID());
                player.sendMessage(String.valueOf(ChatColor.AQUA) + "Chunk: " + block.getChunk().getX() + ", " + block.getChunk().getZ());
                if (block.getType() == Material.FIRE && blockBridge_9.T(block) && (n = blockBridge_9.ae(block)) != null) {
                    player.sendMessage(String.valueOf(ChatColor.AQUA) + "Fire age: " + n);
                }
            }
        }
        if (BlockRegistry.aL(block)) {
            player.sendMessage("(Is a tile entity)");
        }
        return true;
    }
}
