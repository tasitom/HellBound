package main.Blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class CorruptedBlocks extends Block {

    public CorruptedBlocks(Properties p_49795_) {
        super(p_49795_);
    }
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        Long time = level.getDayTime() % 24000;
            if (time>13000){
                if (random.nextInt(5) == 0) {
                    double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.4;
                    double y = pos.getY() + 0.5;
                    double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.4;
                    level.addParticle(ParticleTypes.FLAME, x, y, z, 0.0, 0.03, 0.0 );
                }
            }
    }
    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        if (random.nextInt(20)==0){
        for (BlockPos checkPos : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
            if (checkPos.equals(pos)) continue;
            BlockState checkState = level.getBlockState(checkPos);
            if (checkState.is(Blocks.GRASS_BLOCK)) {
                level.setBlockAndUpdate(checkPos,state);
            }
        }
        }
    }
}
