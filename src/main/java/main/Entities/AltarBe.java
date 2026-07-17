package main.Entities;

import main.Blocks.AltarControllerBlock;
import main.Blocks.ModBlocks;
import main.Multiblock.SinAltarPattern;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AltarBe extends BlockEntity {
    public AltarBe(BlockPos pos, BlockState blockState) {
        super(ModEntities.ALTAR_BE.get(), pos, blockState);
    }
    private boolean formed = false;

    public static void tick(Level level, BlockPos pos, BlockState state, AltarBe be) {
        if (level.isClientSide) return;
        int stage = state.getValue(AltarControllerBlock.altar_state);
        boolean nowFormed = SinAltarPattern.SIN_ALTAR.matches(level, pos);
        if (nowFormed != be.formed && stage==2 ) {
            be.formed = nowFormed;
            be.setChanged();
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
            if (nowFormed) be.onFormed();
        }
    }
    private void onFormed() {
        System.out.println("Formed");
    }
    public boolean isActive(Level level){return level.getDayTime()%24000 >13000;}
    public boolean isFormed() { return formed; }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider p) {
        tag.putBoolean("Formed", formed);
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider p) {
        formed = tag.getBoolean("Formed");
    }
}
