package me.danieli1818.thewitcher.painting;

import me.danieli1818.thewitcher.TheWitcher;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {

	private static final DeferredRegister<Motive> PAINTING_MOTIVES = DeferredRegister
			.create(ForgeRegistries.PAINTING_TYPES, TheWitcher.MOD_ID);

	public static final RegistryObject<Motive> THE_WITCHER_AND_THE_SWALLOW = PAINTING_MOTIVES
			.register("the_witcher_and_the_swallow", () -> new Motive(128, 128));

	public static void register(IEventBus eventBus) {
		PAINTING_MOTIVES.register(eventBus);
	}

}
