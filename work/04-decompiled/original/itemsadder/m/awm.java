package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.awl;
import itemsadder.m.bcg;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class awm
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aoo;

    awm(Codec codec, WorldGenerator worldGenerator) {
        this.aoo = worldGenerator;
        super(codec);
    }

    @bcg
    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aoo.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), awl.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
