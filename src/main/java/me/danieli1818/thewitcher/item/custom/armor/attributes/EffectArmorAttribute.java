package me.danieli1818.thewitcher.item.custom.armor.attributes;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;

public class EffectArmorAttribute implements ArmorAttribute {
	
	private MobEffectInstance effect;
	private int minNumOfPieces;

	public EffectArmorAttribute(MobEffectInstance effect, int minNumOfPieces) {
		this.effect = new MobEffectInstance(effect);
		this.minNumOfPieces = minNumOfPieces;
	}
	
	@Override
	public void onArmorWear(Player player, int numOfPieces) {
		if (numOfPieces >= minNumOfPieces) {
			if (!player.hasEffect(effect.getEffect()) || player.getEffect(effect.getEffect()).getAmplifier() < effect.getAmplifier()) {
				player.addEffect(new MobEffectInstance(effect));
			}
		}
	}

}
