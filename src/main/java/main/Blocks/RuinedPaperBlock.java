package main.Blocks;

import main.Items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RuinedPaperBlock extends Block {
    public RuinedPaperBlock(Properties p_49795_) {
        super(p_49795_);
    }
    public static VoxelShape box = Shapes.box(0.0625D, 0.0D, 0.0625D,
            0.875D,  0.0625D, 0.9375D);
    @Override
    protected ItemInteractionResult useItemOn(ItemStack p_316304_, BlockState p_316362_, Level p_316459_, BlockPos p_316366_, Player p_316132_, InteractionHand p_316595_, BlockHitResult p_316140_) {
        return ItemInteractionResult.FAIL;
    }
    @Override
    protected VoxelShape getShape(BlockState p_152817_, BlockGetter p_152818_, BlockPos p_152819_, CollisionContext p_152820_) {
        return box;
    }
    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        level.addFreshEntity(new ItemEntity(level,pos.getX(),pos.getY(),pos.getZ(),ModItems.RUINED_PAPER.toStack()));
        if (!(player.experienceLevel*10/100 <= 0)){
        player.giveExperienceLevels(player.experienceLevel*10/100);}
        else {
            player.giveExperienceLevels(1);
        }
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
