package me.danieli1818.thewitcher.entities;

import me.danieli1818.thewitcher.core.init.EntitiesInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;

public class BOAR extends Animal implements Enemy {

	public BOAR(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
		return EntitiesInit.BOAR.get().create(level);
	}

	
	
}
