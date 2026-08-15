package main.Blocks;

import main.Entities.PedestalEntity;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.extensions.common.IClientBlockExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class PedestalBlock extends Block implements EntityBlock {
    public PedestalBlock(Properties properties) {
        super(properties);
    }private VoxelShape shape = Shapes.or(box(2.5,0,2.5,13.6,1.3,13.6),box(4.1,1.3,4.1,11.8,2.5,11.8),box(5,8,5,11,13,11));
    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PedestalEntity(blockPos,blockState);
    }
    @Override
    public void initializeClient(Consumer<IClientBlockExtensions> consumer) {
        consumer.accept(new IClientBlockExtensions() {
            @Override
            public boolean addDestroyEffects(BlockState state, Level level, BlockPos pos, ParticleEngine manager) {
                return true;
            }
            @Override
            public boolean addHitEffects(BlockState state, Level level, HitResult target, ParticleEngine manager) {
                return true;
            }
        });
    }
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult
    ) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof PedestalEntity pedestal) {
            if (pedestal.getInventory().getStackInSlot(0).isEmpty()) {
                if (!level.isClientSide) {
                    ItemStack toInsert = stack.copyWithCount(1);
                    ItemStack remainder = pedestal.getInventory().insertItem(0, toInsert, false);
                    if (remainder.isEmpty()) {
                        stack.shrink(1);
                    }
                    pedestal.setChanged();
                    pedestal.updateBlock();
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shape;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof PedestalEntity pedestal) {
                if (!pedestal.getInventory().getStackInSlot(0).isEmpty()) {
                    ItemStack stack = pedestal.getInventory().getStackInSlot(0);
                    player.addItem(stack);
                    pedestal.updateBlock();
                    return InteractionResult.SUCCESS;
                }
                else {
                    return InteractionResult.FAIL;
                }
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
}
