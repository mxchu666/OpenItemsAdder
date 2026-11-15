package itemsadder.m;

import itemsadder.m.asf;
import itemsadder.m.d;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.CrafterCraftEvent;

public class vi
implements Listener {
    @EventHandler
    private void a(CrafterCraftEvent crafterCraftEvent) {
        String string = crafterCraftEvent.getRecipe().getKey().toString();
        if (string.startsWith(asf.ami) || d.g().aW.cx(string) != null) {
            crafterCraftEvent.setCancelled(true);
        }
    }
}
