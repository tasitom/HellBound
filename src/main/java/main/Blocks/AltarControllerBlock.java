package main.Blocks;

import main.Entities.AltarBe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.swing.*;

public class AltarControllerBlock extends Block implements EntityBlock {
    public static IntegerProperty altar_state = IntegerProperty.create("altar_state",0,2);
    public static IntegerProperty Sins = IntegerProperty.create("sin",0,7);
    public AltarControllerBlock(Properties props) { super(props);
        registerDefaultState(defaultBlockState().setValue(altar_state,0).setValue(Sins,0));
    }
    private VoxelShape Box0 = Shapes.box(0,0,0,1,0.6,1);
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AltarBe(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : (lvl, pos, st, be) ->
                AltarBe.tick(lvl, pos, st, (AltarBe) be);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(altar_state,Sins);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.is(ModBlocks.CANDLE_ENVY.asItem()) && state.getValue(altar_state)<2){
            level.setBlockAndUpdate(pos,state.setValue(altar_state,state.getValue(altar_state)+1));
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.FAIL;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Integer boxstate = state.getValue(altar_state);
        if (boxstate==0){
            return Box0;
        }
        return super.getShape(state,level,pos,context);
    }
}
