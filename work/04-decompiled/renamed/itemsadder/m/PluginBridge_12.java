package itemsadder.m;

import itemsadder.m.ClassRefData;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.EntityTypeBridge_4;
import itemsadder.m.ItemStackBuilder_4;
import itemsadder.m.ItemStackRegistry;
import itemsadder.m.ListenerBridge;
import itemsadder.m.PluginContract;
import itemsadder.m.PluginContract_19;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PluginBridge_12
implements PluginContract {
    public PluginBridge_12(Plugin plugin) {
        ListenerBridge.a(this, plugin);
        ItemStackRegistry.g().ar.a(new ClassRefData(PlayerInteractEvent.class, this::a));
    }

    @PluginContract_19
    private void a(PlayerInteractEvent playerInteractEvent, ItemStackBuilder_4 itemStackBuilder_4, ItemStack itemStack) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        EntityTypeBridge_4 entityTypeBridge_4 = (EntityTypeBridge_4)itemStackBuilder_4.Ge.bn("entity_summoner");
        if (entityTypeBridge_4 == null) {
            return;
        }
        CommandSenderBridge_5.iA("getClickedPosition: " + String.valueOf(playerInteractEvent.getClickedPosition()));
        CommandSenderBridge_5.iA("getClickedBlock: " + String.valueOf(playerInteractEvent.getClickedBlock()));
        entityTypeBridge_4.a(playerInteractEvent.getPlayer(), itemStack, ColorBridge.r(playerInteractEvent));
    }
}
