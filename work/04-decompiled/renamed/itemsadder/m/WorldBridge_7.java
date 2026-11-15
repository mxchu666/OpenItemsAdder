package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBridge_20;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.jetbrains.annotations.Nullable;

public abstract class WorldBridge_7
extends BlockPopulator {
    private static int Ot = 0;
    final int Ou;
    public final WeakReference Ov;
    public final List Ow = new ArrayList();
    final int Ox;
    final int Oy;

    public WorldBridge_7(World world) {
        this.Ou = Ot++;
        this.Ov = new WeakReference<World>(world);
        this.Oy = world.getMaxHeight() - 1;
        this.Ox = world.getMinHeight();
    }

    public void a(MaterialBridge_20 materialBridge_20) {
        World world;
        this.Ow.add(materialBridge_20);
        if (Main.KO.gY("debug." + this.rM() + ".log-loading") && (world = (World)this.Ov.get()) != null) {
            CommandSenderBridge_5.log("[" + this.ra() + "] '" + materialBridge_20.oz + "' registered in world '" + world.getName() + "'. File: " + materialBridge_20.Ok);
        }
    }

    public String rM() {
        return switch (this.ra()) {
            case "block_populator" -> "blocks-populators";
            case "surface_decorator" -> "surface-decorators";
            case "tree_populator" -> "trees-populators";
            case "cave_decorator" -> "cave-decorators";
            default -> {
                CommandSenderBridge_5.error("Unknown type name: " + this.ra());
                yield "unknown";
            }
        };
    }

    protected abstract String ra();

    @Nullable
    public World cE() {
        if (this.Ov == null) {
            return null;
        }
        return (World)this.Ov.get();
    }

    public abstract void hn();

    public void rN() {
        this.Ow.clear();
        World world = (World)this.Ov.get();
        if (world != null) {
            world.getPopulators().removeIf(blockPopulator -> {
                if (!(blockPopulator instanceof WorldBridge_7)) {
                    return false;
                }
                return this.Ou == ((WorldBridge_7)blockPopulator).Ou;
            });
        }
    }
}
