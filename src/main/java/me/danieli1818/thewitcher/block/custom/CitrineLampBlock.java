package me.danieli1818.thewitcher.block.custom;

import me.danieli1818.thewitcher.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class CitrineLampBlock extends Block {
	public static final BooleanProperty LIT = BlockStateProperties.LIT;

	public CitrineLampBlock() {
		super(Properties.of(Material.METAL).strength(4.0F, 5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)
				.lightLevel((BlockState state) -> state.getValue(CitrineLampBlock.LIT) ? 15 : 0).sound(ModSounds.CITRINE_LAMP_SOUNDS));
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand,
			BlockHitResult pHit) {
		if (!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND) {
			boolean isLit = pState.getValue(CitrineLampBlock.LIT);
			pLevel.setBlock(pPos, pState.setValue(CitrineLampBlock.LIT, !isLit), UPDATE_ALL);
		}
		return InteractionResult.SUCCESS;
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> pBuilder) {
		pBuilder.add(CitrineLampBlock.LIT);
	}

}
