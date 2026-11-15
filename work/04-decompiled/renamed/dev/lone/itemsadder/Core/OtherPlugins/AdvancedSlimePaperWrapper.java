package dev.lone.itemsadder.Core.OtherPlugins;

import dev.lone.itemsadder.Core.OtherPlugins.AdvancedSlimePaperWrapperDummy;
import dev.lone.itemsadder.Core.OtherPlugins.AdvancedSlimePaperWrapperv3;
import dev.lone.itemsadder.Core.OtherPlugins.AdvancedSlimePaperWrapperv4;
import org.bukkit.World;

public abstract class AdvancedSlimePaperWrapper {
    private static AdvancedSlimePaperWrapper inst;

    public static AdvancedSlimePaperWrapper inst() {
        if (inst == null) {
            return null;
        }
        return inst;
    }

    public static void init() {
        try {
            Class.forName("com.infernalsuite.aswm.api.AdvancedSlimePaperAPI");
            inst = new AdvancedSlimePaperWrapperv3();
            return;
        }
        catch (ClassNotFoundException | NoClassDefFoundError throwable) {
            try {
                Class.forName("com.infernalsuite.asp.api.AdvancedSlimePaperAPI");
                inst = new AdvancedSlimePaperWrapperv4();
                return;
            }
            catch (ClassNotFoundException | NoClassDefFoundError throwable2) {
                inst = new AdvancedSlimePaperWrapperDummy();
                return;
            }
        }
    }

    public abstract boolean isSlimeWorld(World var1);
}
