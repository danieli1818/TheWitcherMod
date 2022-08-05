package me.danieli1818.thewitcher.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class InventoryUtils {

	public static boolean hasItemInInventory(Inventory inventory, Item item) {
		ItemStack itemStack = new ItemStack(item);
		for (int i = 0; i < inventory.getContainerSize(); i++) {
			ItemStack currentItemStack = inventory.getItem(i);
			if (!currentItemStack.isEmpty() && currentItemStack.sameItem(itemStack)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasItemInInventory(Inventory inventory, Item item, CompoundTag tag) {
		ItemStack itemStack = new ItemStack(item);
		if (tag == null) {
			for (int i = 0; i < inventory.getContainerSize(); i++) {
				ItemStack currentItemStack = inventory.getItem(i);
				if (!currentItemStack.isEmpty() && currentItemStack.sameItem(itemStack)
						&& (!currentItemStack.hasTag() || currentItemStack.getTag().isEmpty())) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < inventory.getContainerSize(); i++) {
				ItemStack currentItemStack = inventory.getItem(i);
				if (!currentItemStack.isEmpty() && currentItemStack.sameItem(itemStack)
						&& tag.equals(currentItemStack.getTag())) {
					return true;
				}
			}
		}

		return false;
	}

	public static int getFirstItemInInventory(Inventory inventory, Item item) {
		ItemStack itemStack = new ItemStack(item);
		for (int i = 0; i < inventory.getContainerSize(); i++) {
			ItemStack currentItemStack = inventory.getItem(i);
			if (!currentItemStack.isEmpty() && currentItemStack.sameItem(itemStack)) {
				return i;
			}
		}
		return -1;
	}

	public static int getFirstItemInInventory(Inventory inventory, Item item, CompoundTag tag) {
		ItemStack itemStack = new ItemStack(item);
		if (tag == null) {
			for (int i = 0; i < inventory.getContainerSize(); i++) {
				ItemStack currentItemStack = inventory.getItem(i);
				if (!currentItemStack.isEmpty() && currentItemStack.sameItem(itemStack)
						&& (!currentItemStack.hasTag() || currentItemStack.getTag().isEmpty())) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < inventory.getContainerSize(); i++) {
				ItemStack currentItemStack = inventory.getItem(i);
				if (!currentItemStack.isEmpty() && currentItemStack.sameItem(itemStack)
						&& tag.equals(currentItemStack.getTag())) {
					return i;
				}
			}
		}

		return -1;
	}

}
