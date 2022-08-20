package me.danieli1818.thewitcher.block;

import java.util.List;

import com.google.common.base.Supplier;

import me.danieli1818.thewitcher.TheWitcher;
import me.danieli1818.thewitcher.block.custom.CitrineLampBlock;
import me.danieli1818.thewitcher.block.custom.SpeedyBlock;
import me.danieli1818.thewitcher.block.custom.crops.CucumberPlantBlock;
import me.danieli1818.thewitcher.item.ModCreativeModeTab;
import me.danieli1818.thewitcher.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GlassBlock;
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

	private static RegistryObject<Block> registerBlockWithoutItem(String name,
			Supplier<? extends Block> blockSupplier) {
		return BLOCKS.register(name, blockSupplier);
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
			() -> new StairBlock(() -> ModBlocks.RUBY_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties
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
	public static final RegistryObject<Block> RUBY_FENCE_GATE = registerBlock(
			"ruby_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
					.strength(4.25F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)),
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
			() -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL)
					.strength(4.25F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)),
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
	public static final RegistryObject<Block> CITRINE_FENCE_GATE = registerBlock(
			"citrine_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
					.strength(4.25F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)),
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
			() -> new PressurePlateBlock(Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL)
					.strength(4.25F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> CITRINE_LAMP = registerBlock("citrine_lamp", () -> new CitrineLampBlock(),
			ModCreativeModeTab.EXAMPLES_TAB);

	public static final RegistryObject<Block> EBONY_DOOR = registerBlock("ebony_door",
			() -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()),
			ModCreativeModeTab.MINERALS_TAB);
	public static final RegistryObject<Block> EBONY_TRAPDOOR = registerBlock("ebony_trapdoor",
			() -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(4.25F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.STONE).noOcclusion()),
			ModCreativeModeTab.MINERALS_TAB);

	// Item is registered in ModItems since it's used as a creative mode tab icon
	public static final RegistryObject<Block> PINK_ROSE = registerBlockWithoutItem("pink_rose",
			() -> new FlowerBlock(MobEffects.LEVITATION, 8,
					BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
	public static final RegistryObject<Block> POTTED_PINK_ROSE = registerBlockWithoutItem("potted_pink_rose",
			() -> new FlowerPotBlock(null, ModBlocks.PINK_ROSE,
					BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));
	public static final RegistryObject<Block> WHITE_ROSE = registerBlock("white_rose",
			() -> new FlowerBlock(MobEffects.LEVITATION, 8,
					BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
			ModCreativeModeTab.FLOWERS_TAB);
	public static final RegistryObject<Block> POTTED_WHITE_ROSE = registerBlockWithoutItem("potted_white_rose",
			() -> new FlowerPotBlock(null, ModBlocks.WHITE_ROSE,
					BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

	// Item is registered in ModItems since it's used as a creative mode tab icon
	public static final RegistryObject<Block> THE_WHITE_WOLF_AND_THE_SWALLOW_WINDOW = registerBlockWithoutItem(
			"the_white_wolf_and_the_swallow_window",
			() -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()));

	public static final RegistryObject<Block> CUCUMBER_PLANT = registerBlockWithoutItem("cucumber_plant",
			() -> new CucumberPlantBlock());

	public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
			() -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.0F, 5.0F)
					.requiresCorrectToolForDrops().sound(SoundType.STONE)),
			ModCreativeModeTab.EXAMPLES_TAB, "tooltip.thewitcher.block.speedy_block");

}
