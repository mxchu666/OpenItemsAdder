package dev.lone.itemsadder.Core.OtherPlugins;

import com.infernalsuite.asp.api.AdvancedSlimePaperAPI;
import dev.lone.itemsadder.Core.OtherPlugins.AdvancedSlimePaperWrapper;
import org.bukkit.World;

public class AdvancedSlimePaperWrapperv4
extends AdvancedSlimePaperWrapper {
    private final AdvancedSlimePaperAPI slimeWorldManager = AdvancedSlimePaperAPI.instance();

    AdvancedSlimePaperWrapperv4() {
    }

    @Override
    public boolean isSlimeWorld(World world) {
        return this.slimeWorldManager.getLoadedWorld(world.getName()) != null;
    }
}
