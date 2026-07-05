package main.Blocks;


import com.mojang.logging.LogUtils;
import io.netty.util.internal.logging.InternalLogger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;

import java.util.Random;


public class CorruptedCandle extends CandleBlock {
    private  SimpleParticleType particleTypes ;
    public CorruptedCandle(Properties p_152801_,SimpleParticleType particleTypes) {
        super(p_152801_);
        this.particleTypes = particleTypes;
    }
    public static VoxelShape Candle_box = Shapes.or(
            Block.box(4.8, 0, 4.8, 11,5 , 11),
            Block.box(5.9, 0, 5.9, 10, 9, 10)
            );
    @Override
    protected VoxelShape getShape(BlockState p_152817_, BlockGetter p_152818_, BlockPos p_152819_, CollisionContext p_152820_) {
        return Candle_box;
    }

    @Override
    public void animateTick(BlockState p_220697_, Level p_220698_, BlockPos p_220699_, RandomSource p_220700_) {
        super.animateTick(p_220697_, p_220698_, p_220699_, p_220700_);
        long time = p_220698_.getDayTime() % 24000;
        if (time>13000 && !p_220698_.getBlockState(p_220699_).getValue(LIT))
        {
            spawnParticleExplosion(p_220698_,p_220699_,p_220700_);
            p_220698_.setBlockAndUpdate(p_220699_,p_220697_.setValue(LIT,true));
        }
        else if (time <=13000 && p_220698_.getBlockState(p_220699_).getValue(LIT))
        {
            p_220698_.setBlockAndUpdate(p_220699_,p_220697_.setValue(LIT,false));
        }
        if (p_220697_.getValue(LIT)){
            Random random = new Random();
            if (random.nextInt(2)==0){
            p_220698_.addParticle(particleTypes,p_220699_.getX()+0.5,p_220699_.getY()+1,p_220699_.getZ()+0.5,0,0.01,0);
        }
        }
    }
    private void spawnParticleExplosion(Level level, BlockPos pos, RandomSource random) {
        double x = pos.getX() + 0.5;
        double y = pos.getY() + 0.5;
        double z = pos.getZ() + 0.5;
        for (int i = 0; i < 20; i++) {
            double dx = (random.nextDouble() - 0.5) * 0.6;
            double dy = (random.nextDouble() - 0.5) * 0.6;
            double dz = (random.nextDouble() - 0.5) * 0.6;
            level.addParticle(
                    particleTypes,
                    x + dx, y + dy, z + dz,
                    dx * 0.5, dy * 0.5, dz * 0.5
            );
        }
        for (int i = 0; i < 10; i++) {
            double dx = (random.nextDouble() - 0.5) * 0.3;
            double dy = (random.nextDouble() - 0.5) * 0.3;
            double dz = (random.nextDouble() - 0.5) * 0.3;
            level.addParticle(
                    ParticleTypes.POOF,
                    x + dx, y + dy, z + dz,
                    dx * 0.2, dy * 0.2, dz * 0.2
            );
        }
    }
}
