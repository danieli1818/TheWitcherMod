package me.danieli1818.thewitcher.block.custom.trees;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModLeavesBlock extends LeavesBlock {
	
	private int flammability;
	private int fireSpreadSpeed;

	public ModLeavesBlock(Properties properties) {
		this(properties, 60, 30);
	}
	
	public ModLeavesBlock(Properties properties, int flammability, int fireSpreadSpeed) {
		super(properties);
		this.flammability = flammability;
		this.fireSpreadSpeed = fireSpreadSpeed;
	}
	
	@Override
	public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return true;
	}
	
	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return flammability;
	}
	
	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return fireSpreadSpeed;
	}

}
