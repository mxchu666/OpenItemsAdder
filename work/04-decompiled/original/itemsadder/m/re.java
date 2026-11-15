package itemsadder.m;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class re {
    @NotNull
    public String HL;
    @Nullable
    public Integer HM;
    @Nullable
    public Integer mr;
    @Nullable
    public Integer ms;
    @Nullable
    public Boolean HN;

    public re(@NotNull String string, @Nullable Integer n, @Nullable Integer n2, @Nullable Integer n3, @Nullable Boolean bl) {
        this.HL = string;
        this.HM = n;
        this.mr = n2;
        this.ms = n3;
        this.HN = bl;
    }
}
