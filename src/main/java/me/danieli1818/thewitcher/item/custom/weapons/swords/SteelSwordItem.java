package me.danieli1818.thewitcher.item.custom.weapons.swords;

import java.util.ArrayList;
import java.util.List;

import me.danieli1818.thewitcher.item.custom.weapons.swords.attributes.SwordAttribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SteelSwordItem extends SwordItem {
	
	private List<SwordAttribute> swordAttributes;

	public SteelSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties, List<SwordAttribute> swordAttributes) {
		super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
		
		this.swordAttributes = swordAttributes;
	}
	
	public SteelSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
		super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
		
		this.swordAttributes = new ArrayList<>();
	}
	
	public SteelSwordItem addSwordAttribute(SwordAttribute swordAttribute) {
		this.swordAttributes.add(swordAttribute);
		return this;
	}
	
	public SteelSwordItem removeSwordAttribute(SwordAttribute swordAttribute) {
		this.swordAttributes.remove(swordAttribute);
		return this;
	}
	
	@Override
	public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		for (SwordAttribute swordAttribute : swordAttributes) {
			swordAttribute.onHurtEnemy(pStack, pTarget, pAttacker);
		}
		return super.hurtEnemy(pStack, pTarget, pAttacker);
	}

}
