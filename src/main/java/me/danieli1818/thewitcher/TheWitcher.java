package me.danieli1818.thewitcher;

import me.danieli1818.thewitcher.block.ModBlocks;
import me.danieli1818.thewitcher.item.ModItems;
import me.danieli1818.thewitcher.painting.ModPaintings;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TheWitcher.MOD_ID)
public class TheWitcher {
	public static final String MOD_ID = "thewitcher";

	public TheWitcher() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);
		
		ModPaintings.register(modEventBus);

		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::clientSetup);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			FlowerPotBlock flowerPotBlock = (FlowerPotBlock)Blocks.FLOWER_POT;
			flowerPotBlock.addPlant(ModBlocks.PINK_ROSE.getId(), ModBlocks.POTTED_PINK_ROSE);
			flowerPotBlock.addPlant(ModBlocks.WHITE_ROSE.getId(), ModBlocks.POTTED_WHITE_ROSE);
		});
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_DOOR.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_TRAPDOOR.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINK_ROSE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PINK_ROSE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.WHITE_ROSE.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_WHITE_ROSE.get(), RenderType.cutout());
	}

}
