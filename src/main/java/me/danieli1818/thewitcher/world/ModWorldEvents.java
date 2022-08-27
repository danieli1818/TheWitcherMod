package me.danieli1818.thewitcher.world;

import me.danieli1818.thewitcher.TheWitcher;
import me.danieli1818.thewitcher.world.gen.ModTreesGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheWitcher.MOD_ID)
public class ModWorldEvents {

	@SubscribeEvent
	public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
		ModTreesGeneration.generateTrees(event);
	}
	
}
