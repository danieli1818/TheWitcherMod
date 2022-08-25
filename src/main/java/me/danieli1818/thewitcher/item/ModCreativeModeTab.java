package me.danieli1818.thewitcher.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

	public static final CreativeModeTab MINERALS_TAB = new CreativeModeTab("minerals") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.CITRINE.get());
		}
	};
	
	public static final CreativeModeTab EXAMPLES_TAB = new CreativeModeTab("examples") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.DOWSING_ROD.get());
		}
	};
	
	public static final CreativeModeTab MOD_TOOLS_TAB = new CreativeModeTab("mod_tools") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.CITRINE_PICKAXE.get());
		}
	};
	
	public static final CreativeModeTab WEAPONS_TAB = new CreativeModeTab("weapons") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.CITRINE_SWORD.get());
		}
	};
	
	public static final CreativeModeTab ARMOR_TAB = new CreativeModeTab("armor") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.RUBY_CHESTPLATE.get());
		}
	};
	
	public static final CreativeModeTab FLOWERS_TAB = new CreativeModeTab("flowers") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.PINK_ROSE.get());
		}
	};
	
	public static final CreativeModeTab DECORATION_BLOCKS_TAB = new CreativeModeTab("decoration_blocks") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.THE_WHITE_WOLF_AND_THE_SWALLOW_WINDOW.get());
		}
	};
	
	public static final CreativeModeTab PLANTS_TAB = new CreativeModeTab("plants") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.CUCUMBER_SEEDS.get());
		}
	};
	
	public static final CreativeModeTab MUSIC = new CreativeModeTab("music") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.RENAISSANCE_STRINGS_MUSIC_DISC.get());
		}
	};
	
	public static final CreativeModeTab WOOD = new CreativeModeTab("wood") {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.EBONY_LOG.get());
		}
	};
	
}
