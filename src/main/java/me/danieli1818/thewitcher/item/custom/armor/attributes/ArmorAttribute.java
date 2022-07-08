package me.danieli1818.thewitcher.item.custom.armor.attributes;

import net.minecraft.world.entity.player.Player;

public interface ArmorAttribute {
	
	public void onArmorWear(Player player, int numOfPieces);

}
