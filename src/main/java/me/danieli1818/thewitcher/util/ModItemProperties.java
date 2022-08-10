package me.danieli1818.thewitcher.util;

import me.danieli1818.thewitcher.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {

	public static void addCustomItemProperties() {
		registerBow(ModItems.ZEFHAR_BOW.get());
	}
	
	public static void registerBow(Item item) {
		registerBow(item, 20);
	}
	
	public static void registerBow(Item item, int fullPulledTicks) {
		ItemProperties.register(item, new ResourceLocation("pull"), (pStack, pLevel, pEntity, pSeed) -> {
	         if (pEntity == null) {
	             return 0.0F;
	         } else {
	             return pEntity.getUseItem() != pStack ? 0.0F : (float)(pStack.getUseDuration() - pEntity.getUseItemRemainingTicks()) / fullPulledTicks;
	         }
	      });
		ItemProperties.register(item, new ResourceLocation("pulling"), (pStack, pLevel, pEntity, pSeed) -> {
	         return pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F;
	      });
	}
	
}
