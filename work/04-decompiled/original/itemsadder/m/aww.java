package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.awv;
import itemsadder.m.bcg;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class aww
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aoy;

    aww(Codec codec, WorldGenerator worldGenerator) {
        this.aoy = worldGenerator;
        super(codec);
    }

    @bcg
    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aoy.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), awv.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
