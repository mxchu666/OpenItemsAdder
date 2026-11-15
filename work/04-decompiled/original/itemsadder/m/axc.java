package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.axb;
import itemsadder.m.bcg;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NonNull;

class axc
extends Feature {
    final /* synthetic */ Feature aoE;

    axc(Codec codec, Feature feature) {
        this.aoE = feature;
        super(codec);
    }

    @bcg
    public boolean place(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aoE.place((FeatureConfiguration)((NoneFeatureConfiguration)featurePlaceContext.config()), axb.a(featurePlaceContext.level()), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin());
    }
}
