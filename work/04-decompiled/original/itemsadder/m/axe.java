package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.axd;
import itemsadder.m.bcg;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NonNull;

class axe
extends Feature {
    final /* synthetic */ Feature aoG;

    axe(Codec codec, Feature feature) {
        this.aoG = feature;
        super(codec);
    }

    @bcg
    public boolean place(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aoG.place((FeatureConfiguration)((NoneFeatureConfiguration)featurePlaceContext.config()), axd.a(featurePlaceContext.level()), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin());
    }
}
