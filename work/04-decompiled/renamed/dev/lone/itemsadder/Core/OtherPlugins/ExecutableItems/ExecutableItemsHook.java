package dev.lone.itemsadder.Core.OtherPlugins.ExecutableItems;

import com.ssomar.score.api.executableitems.ExecutableItemsAPI;
import com.ssomar.score.api.executableitems.config.ExecutableItemInterface;
import java.util.Optional;
import org.bukkit.inventory.ItemStack;

public class ExecutableItemsHook {
    public static ItemStack getExecutableItem(String string) {
        ItemStack itemStack = null;
        Optional optional = ExecutableItemsAPI.getExecutableItemsManager().getExecutableItem(string);
        if (optional.isPresent()) {
            itemStack = ((ExecutableItemInterface)optional.get()).buildItem(1, Optional.empty(), Optional.empty());
        }
        return itemStack;
    }
}
