package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.awz;
import itemsadder.m.bcg;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class axa
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aoC;

    axa(Codec codec, WorldGenerator worldGenerator) {
        this.aoC = worldGenerator;
        super(codec);
    }

    @bcg
    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aoC.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), awz.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
