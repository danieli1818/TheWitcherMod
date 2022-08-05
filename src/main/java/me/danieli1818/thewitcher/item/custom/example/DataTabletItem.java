package me.danieli1818.thewitcher.item.custom.example;

import java.util.List;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class DataTabletItem extends Item {

	public static final String DATA_NBT_TAG = "thewitcher.data";

	public DataTabletItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		if (pPlayer.getItemInHand(pUsedHand).hasTag()) {
			pPlayer.getItemInHand(pUsedHand).setTag(new CompoundTag());
		}

		return super.use(pLevel, pPlayer, pUsedHand);
	}

	@Override
	public boolean isFoil(ItemStack pStack) {
		return pStack.hasTag();
	}

	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents,
			TooltipFlag pIsAdvanced) {
		if (pStack.hasTag()) {
			String data = pStack.getTag().getString(DATA_NBT_TAG);
			if (data != null) {
				pTooltipComponents.add(new TextComponent(data));
			}
		}
	}
	
}
