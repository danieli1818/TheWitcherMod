package me.danieli1818.thewitcher.world.placement;

import me.danieli1818.thewitcher.world.feature.ModVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModVegetationPlacements {

	public static final Holder<PlacedFeature> MOD_TREES_PLAINS = PlacementUtils.m_206509_("mod_trees_plains",
			ModVegetationFeatures.MOD_TREES_PLAINS,
			VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.5F, 2)));

}
