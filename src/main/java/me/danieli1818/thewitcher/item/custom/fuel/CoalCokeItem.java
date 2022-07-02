package me.danieli1818.thewitcher.item.custom.fuel;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class CoalCokeItem extends Item {

	public CoalCokeItem(Properties pProperties) {
		super(pProperties);
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
		return 3200;
	}

}
