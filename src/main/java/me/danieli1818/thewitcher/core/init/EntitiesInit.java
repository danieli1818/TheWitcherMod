package me.danieli1818.thewitcher.core.init;

import me.danieli1818.thewitcher.TheWitcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import me.danieli1818.thewitcher.entities.BOAR;

public class EntitiesInit {

	private EntitiesInit() {}
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, TheWitcher.MOD_ID);
	
	public static final RegistryObject<EntityType<BOAR>> BOAR = ENTITIES.register("boar", 
			() -> EntityType.Builder.of(BOAR::new, MobCategory.MONSTER).build(new ResourceLocation(TheWitcher.MOD_ID, "boar").getPath()));
	
}
