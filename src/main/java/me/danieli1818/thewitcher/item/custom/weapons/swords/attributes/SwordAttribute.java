package me.danieli1818.thewitcher.item.custom.weapons.swords.attributes;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface SwordAttribute {

	public void onHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker);
	
	public void onBlockAttack(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker);
	
	public void onParry(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker);
	
}
