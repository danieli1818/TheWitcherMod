package me.danieli1818.thewitcher.item.custom.weapons.bows;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class CustomModBowItem extends ProjectileWeaponItem implements Vanishable, ModBowItem {
	
	private int maxDrawDuration;
	private int defaultProjectileRange;
	private float inaccuracy;
	private float critChance;
	protected static final Random RANDOM = new Random();

	/**
	 * Create custom mod bow item
	 * @param maxDrawDuration Max draw duration must be positive
	 * @param defaultProjectileRange Default projectile range must be positive
	 * @param inaccuracy Inaccuracy value 0 for making the bow completely accurate
	 * @param critChance The chance of the bow to make a critical hit
	 * @param pProperties Properties of the item
	 */
	public CustomModBowItem(int maxDrawDuration, int defaultProjectileRange, float inaccuracy, float critChance, Properties pProperties) {
		super(pProperties);
		this.maxDrawDuration = maxDrawDuration;
		this.defaultProjectileRange = defaultProjectileRange;
		this.inaccuracy = inaccuracy;
		this.critChance = critChance;
	}
	
	/**
	 * Create custom mod bow item
	 * @param maxDrawDuration Max draw duration must be positive
	 * @param inaccuracy Inaccuracy value 0 for making the bow completely accurate
	 * @param critChance The chance of the bow to make a critical hit
	 * @param pProperties Properties of the item
	 */
	public CustomModBowItem(int maxDrawDuration, float inaccuracy, float critChance, Properties pProperties) {
		super(pProperties);
		this.maxDrawDuration = maxDrawDuration;
		float factor = maxDrawDuration / 20.0F;
		this.defaultProjectileRange = (int)(45 / ((1 / (factor * factor)) + (2 / factor)));
		this.inaccuracy = inaccuracy;
		this.critChance = critChance;
	}

	/**
    * Called when the player stops using an Item (stops holding the right mouse button).
    */
	public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
		if (pEntityLiving instanceof Player) {
			Player player = (Player)pEntityLiving;
			boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
			ItemStack itemstack = player.getProjectile(pStack);

			int i = this.getUseDuration(pStack) - pTimeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, !itemstack.isEmpty() || flag);
			if (i < 0) return;

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(Items.ARROW);
				}

				float f = getPowerForTime(i);
				System.out.println("Time: " + i);
				System.out.println("Force: " + f);
				System.out.println("DefaultProjectileRange: " + getDefaultProjectileRange());
				System.out.println("Final force:" + f * 3.0F * (getDefaultProjectileRange() / 15.0F));
				if (!((double)f < 0.1D)) {
					boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, pStack, player));
					if (!pLevel.isClientSide) {
						ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
						AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, itemstack, player);
						abstractarrow = customArrow(abstractarrow);
						abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F * (getDefaultProjectileRange() / 15.0F), getInaccuracy());
						if (RANDOM.nextFloat() <= getCritChance()) {
							abstractarrow.setCritArrow(true);
						}

						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
						if (j > 0) {
							abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);
						}

						int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, pStack);
						if (k > 0) {
							abstractarrow.setKnockback(k);
						}

						if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0) {
							abstractarrow.setSecondsOnFire(100);
						}

						pStack.hurtAndBreak(1, player, (pPlayer) -> {
							pPlayer.broadcastBreakEvent(player.getUsedItemHand());
						});
						if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
							abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
						}

						pLevel.addFreshEntity(abstractarrow);
					}

					pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
					if (!flag1 && !player.getAbilities().instabuild) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							player.getInventory().removeItem(itemstack);
						}
					}

					player.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}

	/**
	 * Gets the velocity of the arrow entity from the bow's charge
	 */
	public float getPowerForTime(int pCharge) {
		float f = (float)pCharge / getMaxDrawDuration();
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	/**
	* How long it takes to use or consume an item
	*/
	public int getUseDuration(ItemStack pStack) {
	   return 72000;
   	}

   	/**
	* returns the action that specifies what animation to play when the items is being used
	*/
   	public UseAnim getUseAnimation(ItemStack pStack) {
	   return UseAnim.BOW;
   	}

   	/**
	* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
	* {@link #onItemUse}.
	*/
   	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
	   ItemStack itemstack = pPlayer.getItemInHand(pHand);
	   boolean flag = !pPlayer.getProjectile(itemstack).isEmpty();

	   InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, pLevel, pPlayer, pHand, flag);
	   if (ret != null) return ret;

	   if (!pPlayer.getAbilities().instabuild && !flag) {
		   return InteractionResultHolder.fail(itemstack);
	   } else {
		   pPlayer.startUsingItem(pHand);
		   return InteractionResultHolder.consume(itemstack);
	   }
   	}

   	/**
	* Get the predicate to match ammunition when searching the player's inventory, not their main/offhand
	*/
   	public Predicate<ItemStack> getAllSupportedProjectiles() {
   		return ARROW_ONLY;
   	}

   	public AbstractArrow customArrow(AbstractArrow arrow) {
   		return arrow;
   	}

   	public int getDefaultProjectileRange() {
   		return defaultProjectileRange;
   	}

	@Override
	public int getMaxDrawDuration() {
		return maxDrawDuration;
	}

	@Override
	public float getInaccuracy() {
		return inaccuracy;
	}

	@Override
	public float getCritChance() {
		return critChance;
	}

	
	
}
