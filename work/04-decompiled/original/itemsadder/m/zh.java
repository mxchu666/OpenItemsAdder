package itemsadder.m;

import itemsadder.m.bbs;
import itemsadder.m.bce;
import itemsadder.m.bcp;
import itemsadder.m.bev;
import itemsadder.m.d;
import itemsadder.m.qm;
import java.util.regex.Pattern;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class zh
implements Listener {
    public void register(Plugin plugin) {
        bev.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        String string = playerCommandPreprocessEvent.getMessage();
        Pattern pattern = Pattern.compile("/(?:[^:]+:enchant|enchant)(.*)");
        if (pattern.matcher(string).matches()) {
            Player player = playerCommandPreprocessEvent.getPlayer();
            bcp.c(() -> {
                ItemStack itemStack = player.getInventory().getItemInMainHand();
                qm qm2 = d.g().a(itemStack);
                if (qm2 != null) {
                    boolean bl = false;
                    if (qm2.isBlockAllEnchants()) {
                        if (bbs.as(itemStack)) {
                            bl = true;
                        }
                    } else if (qm2.mT() != null) {
                        for (Enchantment enchantment : qm2.mT()) {
                            if (!bbs.c(itemStack, enchantment)) continue;
                            bl = true;
                        }
                    }
                    if (bl) {
                        bce.c((CommandSender)player, String.valueOf(ChatColor.RED) + "You can't add this enchantment to this custom item.");
                    }
                }
            }, 5L);
        }
    }
}
