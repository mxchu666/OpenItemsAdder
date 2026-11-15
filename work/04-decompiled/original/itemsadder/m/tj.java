package itemsadder.m;

import itemsadder.m.ti;
import java.io.File;
import org.jetbrains.annotations.Nullable;

public class tj {
    public String KA;
    public File KB;
    @Nullable
    public Float KC;
    @Nullable
    public Float KD;
    @Nullable
    public Integer HM;
    @Nullable
    public Boolean KF;
    @Nullable
    public Integer KG;
    @Nullable
    public Boolean KH;
    @Nullable
    public Float KI;
    @Nullable
    public Integer bv;
    @Nullable
    public Boolean bw;

    public tj(String string, File file) {
        this.KA = string;
        this.KB = file;
    }

    public tj(String string, File file, @Nullable Float f, @Nullable Float f2, @Nullable Integer n, @Nullable Boolean bl, @Nullable Integer n2, @Nullable Boolean bl2, @Nullable Float f3, @Nullable Integer n3, @Nullable Boolean bl3) {
        this.KA = string;
        this.KB = file;
        this.KC = f;
        this.KD = f2;
        this.HM = n;
        this.KF = bl;
        this.KG = n2;
        this.KH = bl2;
        this.KI = f3;
        this.bv = n3;
        this.bw = bl3;
    }

    public tj c(@Nullable Float f) {
        this.KC = f;
        return this;
    }

    public tj d(@Nullable Float f) {
        this.KD = f;
        return this;
    }

    public tj j(@Nullable Integer n) {
        this.HM = n;
        return this;
    }

    public tj f(@Nullable Boolean bl) {
        this.KF = bl;
        return this;
    }

    public tj k(@Nullable Integer n) {
        this.KG = n;
        return this;
    }

    public tj g(@Nullable Boolean bl) {
        this.KH = bl;
        return this;
    }

    public tj e(@Nullable Float f) {
        this.KI = f;
        return this;
    }

    public tj l(@Nullable Integer n) {
        this.bv = n;
        return this;
    }

    public tj h(@Nullable Boolean bl) {
        this.bw = bl;
        return this;
    }

    public ti pV() {
        return new ti(this.KA, this.KB, this.KC, this.KD, this.HM, this.KF, this.KG, this.KH, this.KI, this.bv, this.bw);
    }
}
