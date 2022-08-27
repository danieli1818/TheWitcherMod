package me.danieli1818.thewitcher.world.placement;

import me.danieli1818.thewitcher.block.ModBlocks;
import me.danieli1818.thewitcher.world.feature.ModTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModTreePlacements {

	public static final Holder<PlacedFeature> EBONY_CHECKED = PlacementUtils.m_206513_("ebony_checked",
			ModTreeFeatures.EBONY_TREE, PlacementUtils.m_206493_(ModBlocks.EBONY_SAPLING.get()));

}
