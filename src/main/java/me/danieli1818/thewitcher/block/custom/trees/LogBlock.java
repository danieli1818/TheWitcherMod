package me.danieli1818.thewitcher.block.custom.trees;

import me.danieli1818.thewitcher.block.custom.types.FlammableRotatedPillarBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ToolAction;

public class LogBlock extends FlammableRotatedPillarBlock {

	private Block strippedLogBlock;
	
	public LogBlock(Block strippedLogBlock) {
		this(strippedLogBlock, MaterialColor.WOOD, MaterialColor.PODZOL);
	}
	
	public LogBlock(Block strippedLogBlock, MaterialColor topColor, MaterialColor barkColor) {
		this(BlockBehaviour.Properties.of(Material.WOOD, (blockState) -> {
	         return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
	      }).strength(2.0F).sound(SoundType.WOOD), 5, 5, strippedLogBlock);
	}
	
	public LogBlock(Properties properties, Block strippedLogBlock) {
		this(properties, 5, 5, strippedLogBlock);
	}
	
	public LogBlock(Properties properties, int flammability, int fireSpreadSpeed, Block strippedLogBlock) {
		super(properties, flammability, fireSpreadSpeed);
		this.strippedLogBlock = strippedLogBlock;
	}
	
	@Override
	public BlockState getToolModifiedState(BlockState state, Level level, BlockPos pos, Player player, ItemStack stack,
			ToolAction toolAction) {
		
		if (stack.getItem() instanceof AxeItem) {
			return strippedLogBlock.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
		}
		
		return super.getToolModifiedState(state, level, pos, player, stack, toolAction);
	}
	
}
