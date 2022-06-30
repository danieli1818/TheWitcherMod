package me.danieli1818.thewitcher.block;

import com.google.common.base.Supplier;

import me.danieli1818.thewitcher.TheWitcher;
import me.danieli1818.thewitcher.block.custom.SpeedyBlock;
import me.danieli1818.thewitcher.item.ModCreativeModeTab;
import me.danieli1818.thewitcher.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

	private ModBlocks() {
		
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
	private static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> blockSupplier, CreativeModeTab tab) {
		RegistryObject<Block> blockRegistry = BLOCKS.register(name, blockSupplier);
		registerBlockItem(name, blockRegistry, tab);
		return blockRegistry;
	}
	
	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
		return ModItems.registerItem(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
	
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS
			, TheWitcher.MOD_ID);
	
	public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> 
		new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5F, 5.4F)
				.requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTab.MINERALS_TAB);
	
	public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block", () -> 
	new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.25F, 5.0F)
			.requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTab.MINERALS_TAB);
	
	public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block", () -> 
	new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.0F, 5.0F)
			.requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTab.EXAMPLES_TAB);
	
}
