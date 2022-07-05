package me.danieli1818.thewitcher.util;

import me.danieli1818.thewitcher.TheWitcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

	public static final class Blocks {
		
		public static final TagKey<Block> DOWSING_ROD_VALUABLES = tag("dowsing_rod_valuables");
		
		public static final TagKey<Block> NEEDS_RUBY_TOOL = forgeTag("needs_ruby_tool");
		public static final TagKey<Block> NEEDS_CITRINE_TOOL = forgeTag("needs_citrine_tool");
		
		private static TagKey<Block> tag(String name) {
			return BlockTags.create(new ResourceLocation(TheWitcher.MOD_ID, name));
		}
		
		private static TagKey<Block> forgeTag(String name) {
			return BlockTags.create(new ResourceLocation("forge", name));
		}
		
	}
	
	public static final class Items {
		
		public static final TagKey<Item> RUBY_GEMS = forgeTag("gems/ruby");
		public static final TagKey<Item> CITRINE_GEMS = forgeTag("gems/citrine");
		
		@SuppressWarnings("unused")
		private static TagKey<Item> tag(String name) {
			return ItemTags.create(new ResourceLocation(TheWitcher.MOD_ID, name));
		}
		
		private static TagKey<Item> forgeTag(String name) {
			return ItemTags.create(new ResourceLocation("forge", name));
		}
		
	}
	
	
}
