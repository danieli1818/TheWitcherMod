package me.danieli1818.thewitcher.item.custom;

import java.util.List;

import me.danieli1818.thewitcher.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class DowsingRodItem extends Item {

	public DowsingRodItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public InteractionResult useOn(UseOnContext pContext) {
		Level level = pContext.getLevel();
		if (level.isClientSide) {
			BlockPos positionedClicked = pContext.getClickedPos();
			Player player = pContext.getPlayer();
			
			boolean hasFoundValuableBlock = false;
			int numOfBlocksUnderSelectedBlock = positionedClicked.getY() + 64;
			for (int i = 0; i <= numOfBlocksUnderSelectedBlock; i++) {
				Block currentBlock = level.getBlockState(positionedClicked.below(i)).getBlock();
				if (isValuableBlock(currentBlock)) {
					hasFoundValuableBlock = true;
					sendBlockDataToPlayer(positionedClicked.below(i), player, currentBlock);
					break;
				}
			}
			if (!hasFoundValuableBlock) {
				player.sendMessage(new TranslatableComponent("item.thewitcher.dowsing_rod.no_valuables")
						, player.getUUID());
			}
		}
		
		pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), 
				(Player player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
		
		return super.useOn(pContext);
	}
	
	private void sendBlockDataToPlayer(BlockPos blockPos, Player player, Block block) {
		player.sendMessage(new TextComponent("Found " + block.asItem().getRegistryName().toString() + 
				" at (" + blockPos.getX() + "," + blockPos.getY() + "," + blockPos.getZ() + ")")
				, player.getUUID());
	}
	
	private boolean isValuableBlock(Block block) {
		return ForgeRegistries.BLOCKS.tags().getTag(ModTags.Blocks.DOWSING_ROD_VALUABLES).contains(block);
	}
	
	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents,
			TooltipFlag pIsAdvanced) {
		if (Screen.hasShiftDown()) {
			pTooltipComponents.add(new TranslatableComponent("tooltip.thewitcher.dowsing_rod.tooltip.shift"));
		} else {
			pTooltipComponents.add(new TranslatableComponent("tooltip.thewitcher.dowsing_rod.tooltip"));
		}
	}
	
	
}
