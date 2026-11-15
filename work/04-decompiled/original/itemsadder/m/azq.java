package itemsadder.m;

import dev.lone.itemsadder.resourcepack.generator.file.data.g;
import dev.lone.itemsadder.utils.json.c;
import itemsadder.m.azr;
import itemsadder.m.bce;
import itemsadder.m.bcy;
import java.io.File;
import org.jetbrains.annotations.Nullable;

public class azq
extends azr {
    private final File aye;

    public azq(File file) {
        super(file.getAbsolutePath());
        this.aye = file;
    }

    @Nullable
    public g Bt() {
        try {
            return this.C(c.N(this.aye));
        }
        catch (Throwable throwable) {
            bce.error("Failed to validate model: " + bcy.I(this.aye));
            bce.error(throwable.getMessage());
            return null;
        }
    }
}
