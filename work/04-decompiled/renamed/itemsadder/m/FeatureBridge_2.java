package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.BlockNms_26_1_2_22;
import itemsadder.m.PluginContract_4;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jspecify.annotations.NonNull;

class FeatureBridge_2
extends Feature {
    final /* synthetic */ Feature aoG;

    FeatureBridge_2(Codec codec, Feature feature) {
        this.aoG = feature;
        super(codec);
    }

    @PluginContract_4
    public boolean place(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aoG.place((FeatureConfiguration)((NoneFeatureConfiguration)featurePlaceContext.config()), BlockNms_26_1_2_22.a(featurePlaceContext.level()), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin());
    }
}
