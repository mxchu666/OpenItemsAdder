package itemsadder.m;

import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.Nullable;

public final class RecordOfString_10
extends Record {
    private final String KA;
    private final File KB;
    @Nullable
    private final Float KC;
    @Nullable
    private final Float KD;
    @Nullable
    private final Integer KE;
    @Nullable
    private final Boolean KF;
    @Nullable
    private final Integer KG;
    @Nullable
    private final Boolean KH;
    @Nullable
    private final Float KI;
    @Nullable
    private final Integer KJ;
    @Nullable
    private final Boolean KK;

    public RecordOfString_10(String string, File file, @Nullable Float f, @Nullable Float f2, @Nullable Integer n, @Nullable Boolean bl, @Nullable Integer n2, @Nullable Boolean bl2, @Nullable Float f3, @Nullable Integer n3, @Nullable Boolean bl3) {
        this.KA = string;
        this.KB = file;
        this.KC = f;
        this.KD = f2;
        this.KE = n;
        this.KF = bl;
        this.KG = n2;
        this.KH = bl2;
        this.KI = f3;
        this.KJ = n3;
        this.KK = bl3;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{RecordOfString_10.class, "path;resourceAsset;volume;pitch;weight;stream;attenuationDistance;preload;durationSeconds;bitrateQuality;mono", "KA", "KB", "KC", "KD", "KE", "KF", "KG", "KH", "KI", "KJ", "KK"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{RecordOfString_10.class, "path;resourceAsset;volume;pitch;weight;stream;attenuationDistance;preload;durationSeconds;bitrateQuality;mono", "KA", "KB", "KC", "KD", "KE", "KF", "KG", "KH", "KI", "KJ", "KK"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{RecordOfString_10.class, "path;resourceAsset;volume;pitch;weight;stream;attenuationDistance;preload;durationSeconds;bitrateQuality;mono", "KA", "KB", "KC", "KD", "KE", "KF", "KG", "KH", "KI", "KJ", "KK"}, this, object);
    }

    public String pK() {
        return this.KA;
    }

    public File pL() {
        return this.KB;
    }

    @Nullable
    public Float pM() {
        return this.KC;
    }

    @Nullable
    public Float pN() {
        return this.KD;
    }

    @Nullable
    public Integer pO() {
        return this.KE;
    }

    @Nullable
    public Boolean pP() {
        return this.KF;
    }

    @Nullable
    public Integer pQ() {
        return this.KG;
    }

    @Nullable
    public Boolean pR() {
        return this.KH;
    }

    @Nullable
    public Float pS() {
        return this.KI;
    }

    @Nullable
    public Integer pT() {
        return this.KJ;
    }

    @Nullable
    public Boolean pU() {
        return this.KK;
    }
}
