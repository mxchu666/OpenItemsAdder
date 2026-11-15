package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.awr;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class aws
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aou;

    aws(Codec codec, WorldGenerator worldGenerator) {
        this.aou = worldGenerator;
        super(codec);
    }

    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aou.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), awr.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
