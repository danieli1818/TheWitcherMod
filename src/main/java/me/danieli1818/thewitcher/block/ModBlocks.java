package me.danieli1818.thewitcher.block;

import java.util.List;

import com.google.common.base.Supplier;

import me.danieli1818.thewitcher.TheWitcher;
import me.danieli1818.thewitcher.block.custom.SpeedyBlock;
import me.danieli1818.thewitcher.item.ModCreativeModeTab;
import me.danieli1818.thewitcher.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StoneButtonBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.TooltipFlag;

public class ModBlocks {

	private ModBlocks() {

	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}

	private static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> blockSupplier,
			CreativeModeTab tab, String tooltip) {
		RegistryObject<Block> blockRegistry = BLOCKS.register(name, blockSupplier);
		registerBlockItem(name, blockRegistry, tab, tooltip);
		return blockRegistry;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
			CreativeModeTab tab, String tooltip) {
		return ModItems.registerItem(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)) {
			public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
				pTooltip.add(new TranslatableComponent(tooltip));
			};
		});
	}

	private static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> blockSupplier,
			CreativeModeTab tab) {
		RegistryObject<Block> blockRegistry = BLOCKS.register(name, blockSupplier);
		registerBlockItem(name, blockRegistry, tab);
		return blockRegistry;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
			CreativeModeTab tab) {
		return ModItems.registerItem(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			TheWitcher.MOD_ID);

	public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4.5F, 5.4F)
					.requiresCorrectToolForDrops().sound(SoundType.STONE)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> RUBY_STAIRS = registerBlock("ruby_stairs",
			() -> new StairBlock(() -> ModBlocks.CITRINE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties
					.of(Material.METAL).strength(4.25F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> RUBY_SLAB = registerBlock("ruby_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> RUBY_FENCE = registerBlock("ruby_fence",
			() -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
			() -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> RUBY_WALL = registerBlock("ruby_wall",
			() -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> RUBY_BUTTON = registerBlock("ruby_button",
			() -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL).noCollission()),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
			() -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);

	public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock("citrine_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> CITRINE_STAIRS = registerBlock("citrine_stairs",
			() -> new StairBlock(() -> ModBlocks.CITRINE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties
					.of(Material.METAL).strength(4.25F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> CITRINE_SLAB = registerBlock("citrine_slab",
			() -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> CITRINE_FENCE = registerBlock("citrine_fence",
			() -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> CITRINE_FENCE_GATE = registerBlock("citrine_fence_gate",
			() -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> CITRINE_WALL = registerBlock("citrine_wall",
			() -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> CITRINE_BUTTON = registerBlock("citrine_button",
			() -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL).noCollission()),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> CITRINE_PRESSURE_PLATE = registerBlock("citrine_pressure_plate",
			() -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	
	public static final RegistryObject<Block> EBONY_DOOR = registerBlock("ebony_door",
			() -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> EBONY_TRAPDOOR = registerBlock("ebony_trapdoor",
			() -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()),
			ModCreativeModeTab.MINERALS_TAB);

	public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
			() -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.0F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.STONE)),
			ModCreativeModeTab.EXAMPLES_TAB, "tooltip.thewitcher.block.speedy_block");

}
