package itemsadder.m;

import itemsadder.m.ItemStackRegistry;
import itemsadder.m.PlayerQuitListenerBase;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.CrafterCraftEvent;

public class CrafterCraftListener
implements Listener {
    @EventHandler
    private void a(CrafterCraftEvent crafterCraftEvent) {
        String string = crafterCraftEvent.getRecipe().getKey().toString();
        if (string.startsWith(PlayerQuitListenerBase.ami) || ItemStackRegistry.g().aW.cx(string) != null) {
            crafterCraftEvent.setCancelled(true);
        }
    }
}
