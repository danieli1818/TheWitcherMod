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
	
}
