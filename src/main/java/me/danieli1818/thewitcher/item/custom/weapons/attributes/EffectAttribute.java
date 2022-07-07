package me.danieli1818.thewitcher.item.custom.weapons.attributes;

import java.util.Random;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class EffectAttribute implements SwordAttribute {

	private MobEffect effect;
	private float chance;
	private int level;
	private int time;
	
	public EffectAttribute(MobEffect effect, float chance, int level, int time) {
		this.effect = effect;
		this.chance = chance;
		this.level = level;
		this.time = time;
	}
	
	public MobEffect getEffect() {
		return effect;
	}
	
	public float getChance() {
		return chance;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getTime() {
		return time;
	}

	@Override
	public void onHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		Random rnd = new Random();
		if (rnd.nextFloat() > getChance()) {
			return;
		}
		pTarget.addEffect(new MobEffectInstance(getEffect(), getTime(), getLevel()), pAttacker);
	}

	@Override
	public void onBlockAttack(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		
	}

	@Override
	public void onParry(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
		
	}
	
}
