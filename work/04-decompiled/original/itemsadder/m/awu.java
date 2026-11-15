package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.awt;
import itemsadder.m.bcg;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class awu
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aow;

    awu(Codec codec, WorldGenerator worldGenerator) {
        this.aow = worldGenerator;
        super(codec);
    }

    @bcg
    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aow.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), awt.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
