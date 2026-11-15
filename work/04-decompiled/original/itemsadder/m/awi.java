package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.awh;
import itemsadder.m.bcg;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class awi
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aok;

    awi(Codec codec, WorldGenerator worldGenerator) {
        this.aok = worldGenerator;
        super(codec);
    }

    @bcg
    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aok.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), awh.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
