package main.Entities;

import main.Blocks.AltarControllerBlock;
import main.Multiblock.SinAltarPattern;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public class AltarBe extends BlockEntity {
    public AltarBe(BlockPos pos, BlockState blockState) {
        super(ModEntities.ALTAR_BE.get(), pos, blockState);
    }
    private boolean formed = false;
    public static Map<String,Integer> sins = new HashMap<>();
    static {
        int i =1;
        for (SinAltarPattern.Sins sin : SinAltarPattern.Sins.values()) {
            sins.put(sin.name(),i);
            i++;
        }
    }
    public static void tick(Level level, BlockPos pos, BlockState state, AltarBe be) {
        if (level.isClientSide) return;
        int stage = state.getValue(AltarControllerBlock.altar_state);
        boolean nowFormed = SinAltarPattern.matchesAny(level,pos);
        if (!be.formed && nowFormed){
            be.formed = nowFormed;
            BlockState newState = state.setValue(AltarControllerBlock.Sins, sins.get(SinAltarPattern.get_Sin(level, pos)));
            level.setBlockAndUpdate(pos, newState);
            be.setChanged();
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
            System.out.println(level.getBlockState(pos).getValue(AltarControllerBlock.Sins));
            System.out.println(sins.get(SinAltarPattern.get_Sin(level,pos)));
        }
        else if (be.formed && !nowFormed){
            be.formed = nowFormed;
            BlockState newState = state.setValue(AltarControllerBlock.Sins, 0);
            level.setBlockAndUpdate(pos, newState);
            be.setChanged();
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
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
