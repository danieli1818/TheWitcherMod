package me.danieli1818.thewitcher.item;

import me.danieli1818.thewitcher.util.ModTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {

	public static final ForgeTier RUBY = new ForgeTier(2, 1500, 8.0f, 3f, 24, ModTags.Blocks.NEEDS_RUBY_TOOL,
			() -> Ingredient.of(ModItems.RUBY.get()));
	
	public static final ForgeTier CITRINE = new ForgeTier(2, 1400, 7.0f, 2.5f, 22, ModTags.Blocks.NEEDS_CITRINE_TOOL,
			() -> Ingredient.of(ModItems.CITRINE.get()));

}
