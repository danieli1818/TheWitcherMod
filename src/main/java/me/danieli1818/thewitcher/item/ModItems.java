package me.danieli1818.thewitcher.item;

import com.google.common.base.Supplier;

import me.danieli1818.thewitcher.TheWitcher;
import me.danieli1818.thewitcher.block.ModBlocks;
import me.danieli1818.thewitcher.item.custom.LanternItem;
import me.danieli1818.thewitcher.item.custom.armor.ActiveArmorItem;
import me.danieli1818.thewitcher.item.custom.armor.attributes.EffectArmorAttribute;
import me.danieli1818.thewitcher.item.custom.example.DataTabletItem;
import me.danieli1818.thewitcher.item.custom.example.DowsingRodItem;
import me.danieli1818.thewitcher.item.custom.fuel.CoalCokeItem;
import me.danieli1818.thewitcher.item.custom.weapons.bows.CustomModBowItem;
import me.danieli1818.thewitcher.item.custom.weapons.swords.SteelSwordItem;
import me.danieli1818.thewitcher.item.custom.weapons.swords.attributes.EffectSwordAttribute;
import me.danieli1818.thewitcher.sound.ModSounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {

	private ModItems() {

	}

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

	public static RegistryObject<Item> registerItem(String name, Supplier<? extends Item> itemSupplier) {
		return ITEMS.register(name, itemSupplier);
	}

	public static RegistryObject<Item> registerBlockItem(RegistryObject<? extends Block> block, CreativeModeTab tab) {
		return ITEMS.register(block.getId().getPath(),
				() -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			TheWitcher.MOD_ID);

	public static final RegistryObject<Item> RUBY = registerItem("ruby", PreciousStone::new);

	public static final RegistryObject<Item> RAW_RUBY = registerItem("raw_ruby", PreciousStone::new);

	public static final RegistryObject<Item> CITRINE = registerItem("citrine", PreciousStone::new);

	public static final RegistryObject<Item> RAW_CITRINE = registerItem("raw_citrine", PreciousStone::new);

	public static final RegistryObject<Item> RAW_METEORITE = registerItem("raw_meteorite", PreciousStone::new);

	public static final RegistryObject<Item> RED_RAW_METEORITE = registerItem("raw_red_meteorite", PreciousStone::new);

	public static final RegistryObject<Item> BLUE_RAW_METEORITE = registerItem("raw_blue_meteorite",
			PreciousStone::new);

	public static final RegistryObject<Item> YELLOW_RAW_METEORITE = registerItem("raw_yellow_meteorite",
			PreciousStone::new);

	public static final RegistryObject<Item> RAW_METEORITE_INGOT = registerItem("meteorite_ingot", PreciousStone::new);

	public static final RegistryObject<Item> RAW_RED_METEORITE_INGOT = registerItem("red_meteorite_ingot",
			PreciousStone::new);

	public static final RegistryObject<Item> RAW_BLUE_METEORITE_INGOT = registerItem("blue_meteorite_ingot",
			PreciousStone::new);

	public static final RegistryObject<Item> RAW_YELLOW_METEORITE_INGOT = registerItem("yellow_meteorite_ingot",
			PreciousStone::new);

	public static final RegistryObject<Item> LANTERN = registerItem("lantern", LanternItem::new);

	public static final RegistryObject<Item> DOWSING_ROD = registerItem("dowsing_rod",
			() -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModeTab.EXAMPLES_TAB).durability(16)));

	public static final RegistryObject<Item> CUCUMBER = registerItem("cucumber",
			() -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXAMPLES_TAB).food(ModFoods.CUCUMBER)));

	public static final RegistryObject<Item> COAL_COKE = registerItem("coal_coke",
			() -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.MINERALS_TAB)));

	public static final RegistryObject<Item> RUBY_SWORD = registerItem("ruby_sword",
			() -> new SwordItem(ModTiers.RUBY, 2, 3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB)));
	public static final RegistryObject<Item> RUBY_PICKAXE = registerItem("ruby_pickaxe",
			() -> new PickaxeItem(ModTiers.RUBY, 1, 1f, new Item.Properties().tab(ModCreativeModeTab.MOD_TOOLS_TAB)));
	public static final RegistryObject<Item> RUBY_SHOVEL = registerItem("ruby_shovel",
			() -> new ShovelItem(ModTiers.RUBY, 1, 1f, new Item.Properties().tab(ModCreativeModeTab.MOD_TOOLS_TAB)));
	public static final RegistryObject<Item> RUBY_AXE = registerItem("ruby_axe",
			() -> new AxeItem(ModTiers.RUBY, 1, 1f, new Item.Properties().tab(ModCreativeModeTab.MOD_TOOLS_TAB)));
	public static final RegistryObject<Item> RUBY_HOE = registerItem("ruby_hoe",
			() -> new HoeItem(ModTiers.RUBY, 0, 0f, new Item.Properties().tab(ModCreativeModeTab.MOD_TOOLS_TAB)));

	public static final RegistryObject<Item> RUBY_HELMET = registerItem("ruby_helmet",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.HEAD,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)));
	public static final RegistryObject<Item> RUBY_CHESTPLATE = registerItem("ruby_chestplate",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.CHEST,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)));
	public static final RegistryObject<Item> RUBY_LEGGINGS = registerItem("ruby_leggings",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.LEGS,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)));
	public static final RegistryObject<Item> RUBY_BOOTS = registerItem("ruby_boots",
			() -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.FEET,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)));

	public static final RegistryObject<Item> MAGICAL_RUBY_HELMET = registerItem("magical_ruby_helmet",
			() -> new ActiveArmorItem(ModArmorMaterials.MAGICAL_RUBY, EquipmentSlot.HEAD,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)).addAttribute(
							new EffectArmorAttribute(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2), 2))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 3), 3))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 4), 4)));
	public static final RegistryObject<Item> MAGICAL_RUBY_CHESTPLATE = registerItem("magical_ruby_chestplate",
			() -> new ActiveArmorItem(ModArmorMaterials.MAGICAL_RUBY, EquipmentSlot.CHEST,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)).addAttribute(
							new EffectArmorAttribute(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2), 2))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 3), 3))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 4), 4)));
	public static final RegistryObject<Item> MAGICAL_RUBY_LEGGINGS = registerItem("magical_ruby_leggings",
			() -> new ActiveArmorItem(ModArmorMaterials.MAGICAL_RUBY, EquipmentSlot.LEGS,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)).addAttribute(
							new EffectArmorAttribute(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2), 2))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 3), 3))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 4), 4)));
	public static final RegistryObject<Item> MAGICAL_RUBY_BOOTS = registerItem("magical_ruby_boots",
			() -> new ActiveArmorItem(ModArmorMaterials.MAGICAL_RUBY, EquipmentSlot.FEET,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)).addAttribute(
							new EffectArmorAttribute(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2), 2))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 3), 3))
							.addAttribute(new EffectArmorAttribute(
									new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 4), 4)));

	public static final RegistryObject<Item> CITRINE_SWORD = registerItem("citrine_sword",
			() -> new SwordItem(ModTiers.CITRINE, 2, 3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB)));
	public static final RegistryObject<Item> CITRINE_PICKAXE = registerItem("citrine_pickaxe",
			() -> new PickaxeItem(ModTiers.CITRINE, 1, 1f,
					new Item.Properties().tab(ModCreativeModeTab.MOD_TOOLS_TAB)));
	public static final RegistryObject<Item> CITRINE_SHOVEL = registerItem("citrine_shovel",
			() -> new ShovelItem(ModTiers.CITRINE, 1, 1f, new Item.Properties().tab(ModCreativeModeTab.MOD_TOOLS_TAB)));
	public static final RegistryObject<Item> CITRINE_AXE = registerItem("citrine_axe",
			() -> new AxeItem(ModTiers.CITRINE, 1, 1f, new Item.Properties().tab(ModCreativeModeTab.MOD_TOOLS_TAB)));
	public static final RegistryObject<Item> CITRINE_HOE = registerItem("citrine_hoe",
			() -> new HoeItem(ModTiers.CITRINE, 0, 0f, new Item.Properties().tab(ModCreativeModeTab.MOD_TOOLS_TAB)));

	public static final RegistryObject<Item> CITRINE_HELMET = registerItem("citrine_helmet",
			() -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.HEAD,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)));
	public static final RegistryObject<Item> CITRINE_CHESTPLATE = registerItem("citrine_chestplate",
			() -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.CHEST,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)));
	public static final RegistryObject<Item> CITRINE_LEGGINGS = registerItem("citrine_leggings",
			() -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.LEGS,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)));
	public static final RegistryObject<Item> CITRINE_BOOTS = registerItem("citrine_boots",
			() -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.FEET,
					new Item.Properties().tab(ModCreativeModeTab.ARMOR_TAB)));

	public static final RegistryObject<Item> RUBY_POISON_SWORD = registerItem("ruby_poison_sword",
			() -> new SteelSwordItem(ModTiers.RUBY, 2, 3f, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB))
					.addSwordAttribute(new EffectSwordAttribute(MobEffects.POISON, 0.5f, 1, 200)));

	public static final RegistryObject<Item> DATA_TABLET = registerItem("data_tablet",
			() -> new DataTabletItem(new Item.Properties().tab(ModCreativeModeTab.EXAMPLES_TAB).stacksTo(1)));
	
	public static final RegistryObject<Item> ZEFHAR_BOW = registerItem("zefhar_bow",
			() -> new CustomModBowItem(40, 0.0F, 0.2F, new Item.Properties().tab(ModCreativeModeTab.WEAPONS_TAB).durability(500)));
	
	public static final RegistryObject<Item> CUCUMBER_SEEDS = registerItem("cucumber_seeds",
			() -> new ItemNameBlockItem(ModBlocks.CUCUMBER_PLANT.get(), new Item.Properties().tab(ModCreativeModeTab.PLANTS_TAB)));
	
	public static final RegistryObject<Item> RENAISSANCE_STRINGS_MUSIC_DISC = registerItem("renaissance_strings_music_disc",
			() -> new RecordItem(4, ModSounds.RENAISSANCE_STRINGS, new Item.Properties().tab(ModCreativeModeTab.MUSIC).stacksTo(1)));

	// Block Items
	public static final RegistryObject<Item> PINK_ROSE = registerBlockItem(ModBlocks.PINK_ROSE,
			ModCreativeModeTab.FLOWERS_TAB);

	public static final RegistryObject<Item> THE_WHITE_WOLF_AND_THE_SWALLOW_WINDOW = registerBlockItem(
			ModBlocks.THE_WHITE_WOLF_AND_THE_SWALLOW_WINDOW, ModCreativeModeTab.DECORATION_BLOCKS_TAB);
	
	public static final RegistryObject<Item> EBONY_LOG = registerBlockItem(
			ModBlocks.EBONY_LOG, ModCreativeModeTab.WOOD);

}
