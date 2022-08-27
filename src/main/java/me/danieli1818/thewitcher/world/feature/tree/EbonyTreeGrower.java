package me.danieli1818.thewitcher.world.feature.tree;

import java.util.Random;

import me.danieli1818.thewitcher.world.feature.ModTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class EbonyTreeGrower extends AbstractTreeGrower {

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> m_203525_(Random rnd, boolean hasBeehive) {
		return ModTreeFeatures.EBONY_TREE;
	}

}
