package me.danieli1818.thewitcher.item.custom;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LanternItem extends Item {

	public LanternItem() {
		super(new Properties().tab(CreativeModeTab.TAB_TOOLS));
	}

	@Override
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
		if (pIsSelected) {
			if (pEntity instanceof Player) {
				Player player = (Player)pEntity;
				player.sendMessage(new TextComponent("Yay it works!"), player.getUUID());
			}
		}
	}
	
}
