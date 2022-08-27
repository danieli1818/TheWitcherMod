package me.danieli1818.thewitcher.world.feature;

import java.util.List;

import me.danieli1818.thewitcher.world.placement.ModTreePlacements;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

public class ModVegetationFeatures {

	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> MOD_TREES_PLAINS = FeatureUtils
			.m_206488_("mod_trees_plains", Feature.RANDOM_SELECTOR,
					new RandomFeatureConfiguration(
							List.of(new WeightedPlacedFeature(ModTreePlacements.EBONY_CHECKED, 0.5F)),
							ModTreePlacements.EBONY_CHECKED));

}
