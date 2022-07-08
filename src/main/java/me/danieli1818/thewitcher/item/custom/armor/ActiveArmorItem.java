package me.danieli1818.thewitcher.item.custom.armor;

import java.util.ArrayList;
import java.util.List;

import me.danieli1818.thewitcher.item.custom.armor.attributes.ArmorAttribute;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ActiveArmorItem extends ArmorItem {
	
	private List<ArmorAttribute> attributes;

	public ActiveArmorItem(ArmorMaterial material, EquipmentSlot slot, Item.Properties properties) {
		super(material, slot, properties);
		
		this.attributes = new ArrayList<>();
	}
	
	public ActiveArmorItem addAttribute(ArmorAttribute attribute) {
		this.attributes.add(attribute);
		return this;
	}
	
	public ActiveArmorItem removeAttribute(ArmorAttribute attribute) {
		this.attributes.remove(attribute);
		return this;
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {
		if (!level.isClientSide) {
			int numOfPieces = getNumOfPieces(player);
			if (numOfPieces != 0) {
				runOnArmorWear(player, numOfPieces);
			}
		}
	}
	
	private void runOnArmorWear(Player player, int numOfPieces) {
		for (ArmorAttribute armorAttribute : attributes) {
			armorAttribute.onArmorWear(player, numOfPieces);
		}
	}
	
	private int getNumOfPieces(Player player) {
		int numOfPieces = 0;
		for (ItemStack armorItemStack : player.getArmorSlots()) {
			if (isArmorPiece(armorItemStack)) {
				numOfPieces++;
			}
		}
		return numOfPieces;
	}
	
	private boolean isArmorPiece(ItemStack itemStack) {
		if (itemStack != null && !itemStack.isEmpty()) {
			Item item = itemStack.getItem();
			if (item instanceof ArmorItem) {
				return ((ArmorItem)item).getMaterial() == getMaterial();
			}
		}
		return false;
	}
	
}
