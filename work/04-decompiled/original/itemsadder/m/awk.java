package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.awj;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class awk
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aom;

    awk(Codec codec, WorldGenerator worldGenerator) {
        this.aom = worldGenerator;
        super(codec);
    }

    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aom.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), awj.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
