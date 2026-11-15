package itemsadder.m;

import com.mojang.serialization.Codec;
import itemsadder.m.BlockNms_1_20_6_22;
import itemsadder.m.PluginContract_4;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.WorldGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.WorldGenFeatureEmptyConfiguration;
import org.jspecify.annotations.NonNull;

class WorldGeneratorBridge
extends WorldGenerator {
    final /* synthetic */ WorldGenerator aok;

    WorldGeneratorBridge(Codec codec, WorldGenerator worldGenerator) {
        this.aok = worldGenerator;
        super(codec);
    }

    @PluginContract_4
    public boolean a(@NonNull FeaturePlaceContext featurePlaceContext) {
        return this.aok.a((WorldGenFeatureConfiguration)((WorldGenFeatureEmptyConfiguration)featurePlaceContext.f()), BlockNms_1_20_6_22.a(featurePlaceContext.b()), featurePlaceContext.c(), featurePlaceContext.d(), featurePlaceContext.e());
    }
}
