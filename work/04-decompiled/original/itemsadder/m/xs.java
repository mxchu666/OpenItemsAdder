package itemsadder.m;

import dev.lone.itemsadder.Main;
import dev.lone.itemsadder.s;
import itemsadder.m.aiq;
import itemsadder.m.bce;
import itemsadder.m.tk;
import itemsadder.m.xp;
import itemsadder.m.za;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.permissions.Permissible;
import org.jetbrains.annotations.NotNull;

public class xs
extends za {
    public xs() {
        Main.cM("iacolor").setExecutor((CommandExecutor)this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string2, @NotNull String[] stringArray) {
        Player player;
        if (!this.a(commandSender, command)) {
            return true;
        }
        if (stringArray.length == 1) {
            if (!(commandSender instanceof Player)) {
                return xp.a(commandSender);
            }
            player = (Player)commandSender;
        } else if (stringArray.length == 2) {
            if (!s.c((Permissible)commandSender, "ia.user.ia.categories.others")) {
                return true;
            }
            player = Bukkit.getPlayer((String)stringArray[1]);
            if (player == null) {
                bce.g(commandSender, "player-offline");
                return true;
            }
        } else {
            bce.f(commandSender, Main.PQ.ir("wrong-command-usage") + String.valueOf(ChatColor.YELLOW) + " /iacolor <color> [player]. Example: /iacolor #32a852 LoneDev");
            return true;
        }
        Integer n = tk.co(stringArray[0]);
        if (n == null) {
            bce.a(commandSender, "invalid-hex-color", (Object string) -> string.replace("{color}", stringArray[0]));
            return true;
        }
        Color color = Color.fromRGB((int)n);
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta instanceof PotionMeta) {
            ((PotionMeta)itemMeta).setColor(color);
        } else if (itemMeta instanceof LeatherArmorMeta) {
            ((LeatherArmorMeta)itemMeta).setColor(color);
        } else {
            aiq.tX().a(itemStack, color);
            return true;
        }
        itemStack.setItemMeta(itemMeta);
        bce.g(commandSender, "colored-successfully");
        return true;
    }
}
