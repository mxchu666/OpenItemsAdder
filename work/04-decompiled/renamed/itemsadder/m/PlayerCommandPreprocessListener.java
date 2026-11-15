package itemsadder.m;

import itemsadder.m.BukkitTaskBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.ItemStackBridge_2;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
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

public class PlayerCommandPreprocessListener
implements Listener {
    public void register(Plugin plugin) {
        ListenerBridge.a(this, plugin);
    }

    @EventHandler(ignoreCancelled=true, priority=EventPriority.MONITOR)
    private void b(PlayerCommandPreprocessEvent playerCommandPreprocessEvent) {
        String string = playerCommandPreprocessEvent.getMessage();
        Pattern pattern = Pattern.compile("/(?:[^:]+:enchant|enchant)(.*)");
        if (pattern.matcher(string).matches()) {
            Player player = playerCommandPreprocessEvent.getPlayer();
            BukkitTaskBridge.c(() -> {
                ItemStack itemStack = player.getInventory().getItemInMainHand();
                ItemStackBuilder_4 itemStackBuilder_4 = ItemStackRegistry.g().a(itemStack);
                if (itemStackBuilder_4 != null) {
                    boolean bl = false;
                    if (itemStackBuilder_4.isBlockAllEnchants()) {
                        if (ItemStackBridge_2.as(itemStack)) {
                            bl = true;
                        }
                    } else if (itemStackBuilder_4.mT() != null) {
                        for (Enchantment enchantment : itemStackBuilder_4.mT()) {
                            if (!ItemStackBridge_2.c(itemStack, enchantment)) continue;
                            bl = true;
                        }
                    }
                    if (bl) {
                        CommandSenderBridge_5.c((CommandSender)player, String.valueOf(ChatColor.RED) + "You can't add this enchantment to this custom item.");
                    }
                }
            }, 5L);
        }
    }
}
