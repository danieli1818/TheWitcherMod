package me.danieli1818.thewitcher.item.custom.weapons.attributes;

import java.util.Random;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class EffectSwordAttribute implements SwordAttribute {

	private MobEffectInstance effect;
	private float chance;
	
	public EffectSwordAttribute(MobEffect effect, float chance, int level, int time) {
		this.effect = new MobEffectInstance(effect, time, level);
		this.chance = chance;
	}
	
	public EffectSwordAttribute(MobEffectInstance effect, float chance) {
		this.effect = new MobEffectInstance(effect);
		this.chance = chance;
	}
	
	public MobEffectInstance getEffect() {
		return effect;
	}
	
	public float getChance() {
		return chance;
	}

	@Override
	public void onHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		Random rnd = new Random();
		if (rnd.nextFloat() > getChance()) {
			return;
		}
		pTarget.addEffect(new MobEffectInstance(getEffect()), pAttacker);
	}

	@Override
	public void onBlockAttack(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		
	}

	@Override
	public void onParry(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		
	}
	
}
