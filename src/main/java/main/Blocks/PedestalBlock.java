package main.Blocks;

import main.Entities.PedestalEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class PedestalBlock extends Block implements EntityBlock {
    public PedestalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PedestalEntity(blockPos,blockState);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof PedestalEntity pedestal) {
                if (pedestal.getInventory().getStackInSlot(0).isEmpty()) {
                    ItemStack toInsert = stack.copyWithCount(1); // or however many you want to move
                    ItemStack remainder = pedestal.getInventory().insertItem(0, toInsert, false);
                    if (remainder.isEmpty()) {
                        stack.shrink(1);
                    }
                    pedestal.updateBlock();
                    return ItemInteractionResult.SUCCESS;
                } else {
                    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                }
            }
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
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
