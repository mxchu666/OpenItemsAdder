package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.axf;
import itemsadder.m.bcg;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NonNull;

class axg
extends Feature {
    final /* synthetic */ Feature aoI;

    axg(Codec codec, Feature feature) {
        this.aoI = feature;
        super(codec);
    }

    @bcg
    public boolean place(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aoI.place((FeatureConfiguration)((NoneFeatureConfiguration)featurePlaceContext.config()), axf.a(featurePlaceContext.level()), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin());
    }
}
