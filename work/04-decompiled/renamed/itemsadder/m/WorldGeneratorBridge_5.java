package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.BlockNms_1_21_3_22;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class WorldGeneratorBridge_5
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aos;

    WorldGeneratorBridge_5(Codec codec, WorldGenerator worldGenerator) {
        this.aos = worldGenerator;
        super(codec);
    }

    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aos.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), BlockNms_1_21_3_22.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
