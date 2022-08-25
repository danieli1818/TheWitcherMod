package me.danieli1818.thewitcher.block.custom.trees;

import me.danieli1818.thewitcher.block.custom.types.FlammableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

public class WoodBlock extends FlammableBlock {

	private Block strippedWoodBlock;
	
	public WoodBlock(Properties properties, Block strippedWoodBlock) {
		this(properties, 5, 5, strippedWoodBlock);
	}
	
	public WoodBlock(Properties properties, int flammability, int fireSpreadSpeed, Block strippedWoodBlock) {
		super(properties, flammability, fireSpreadSpeed);
		this.strippedWoodBlock = strippedWoodBlock;
	}
	
	@Override
	public BlockState getToolModifiedState(BlockState state, Level level, BlockPos pos, Player player, ItemStack stack,
			ToolAction toolAction) {
		
		if (stack.getItem() instanceof AxeItem) {
			return strippedWoodBlock.defaultBlockState();
		}
		
		return super.getToolModifiedState(state, level, pos, player, stack, toolAction);
	}

}
