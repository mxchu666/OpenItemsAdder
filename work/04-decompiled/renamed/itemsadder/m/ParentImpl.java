package itemsadder.m;

import dev.lone.itemsadder.resourcepack.generator.file.data.g;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.Parent_2;
import java.io.File;
import org.jetbrains.annotations.Nullable;

public class ParentImpl
extends Parent_2 {
    private final File aye;

    public ParentImpl(File file) {
        super(file.getAbsolutePath());
        this.aye = file;
    }

    @Nullable
    public g Bt() {
        try {
            return this.C(c.N(this.aye));
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Failed to validate model: " + ColorBridge.I(this.aye));
            CommandSenderBridge_5.error(throwable.getMessage());
            return null;
        }
    }
}
