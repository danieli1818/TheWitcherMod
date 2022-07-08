package me.danieli1818.thewitcher.item;

import java.util.function.Supplier;

import me.danieli1818.thewitcher.TheWitcher;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModArmorMaterials implements ArmorMaterial {
	RUBY("ruby", 30, new int[] { 2, 6, 8, 3 }, 28, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.75F, 0.0F,
			() -> Ingredient.of(ModItems.RUBY.get())),
	MAGICAL_RUBY("magical_ruby", 30, new int[] { 2, 6, 8, 3 }, 30, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.75F, 0.0F,
			() -> Ingredient.of(ModItems.RUBY.get())),
	CITRINE("citrine", 29, new int[] { 2, 6, 8, 2 }, 27, SoundEvents.ARMOR_EQUIP_GOLD, 1.5F, 0.0F,
			() -> Ingredient.of(ModItems.CITRINE.get()));

	private static final int[] HEALTH_PER_SLOT = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredientSupplier;

	private ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
			SoundEvent sound, float toughness, float knockbackResistance,
			Supplier<Ingredient> repairIngredientSupplier) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotProtections = slotProtections;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredientSupplier = repairIngredientSupplier;
	}

	public int getDurabilityForSlot(EquipmentSlot pSlot) {
		return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
	}

	public int getDefenseForSlot(EquipmentSlot pSlot) {
		return this.slotProtections[pSlot.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredientSupplier.get();
	}

	public String getName() {
		return TheWitcher.MOD_ID + ":" + this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	/**
	 * Gets the percentage of knockback resistance provided by armor of the
	 * material.
	 */
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
