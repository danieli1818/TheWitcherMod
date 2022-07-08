package me.danieli1818.thewitcher.item;

import com.google.common.base.Supplier;

import me.danieli1818.thewitcher.TheWitcher;
import me.danieli1818.thewitcher.item.custom.DowsingRodItem;
import me.danieli1818.thewitcher.item.custom.LanternItem;
import me.danieli1818.thewitcher.item.custom.armor.ActiveArmorItem;
import me.danieli1818.thewitcher.item.custom.armor.attributes.EffectArmorAttribute;
import me.danieli1818.thewitcher.item.custom.fuel.CoalCokeItem;
import me.danieli1818.thewitcher.item.custom.weapons.SteelSwordItem;
import me.danieli1818.thewitcher.item.custom.weapons.attributes.EffectSwordAttribute;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
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

	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			TheWitcher.MOD_ID);

	public static final RegistryObject<Item> RUBY = registerItem("ruby", PreciousStone::new);

	public static final RegistryObject<Item> RAW_RUBY = registerItem("raw_ruby", PreciousStone::new);

	public static final RegistryObject<Item> CITRINE = registerItem("citrine", PreciousStone::new);

	public static final RegistryObject<Item> RAW_CITRINE = registerItem("raw_citrine", PreciousStone::new);

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

}
