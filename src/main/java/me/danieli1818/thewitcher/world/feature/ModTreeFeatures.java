package me.danieli1818.thewitcher.world.feature;

import me.danieli1818.thewitcher.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModTreeFeatures {

	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> EBONY_TREE = FeatureUtils.m_206488_("ebony",
			Feature.TREE,
			new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
					new StraightTrunkPlacer(5, 6, 3), BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
					new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4), new TwoLayersFeatureSize(1, 0, 2))
							.build());
	
}
