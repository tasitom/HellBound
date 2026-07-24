package main.Renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import main.Entities.PedestalEntity;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class PedestalRenderer implements BlockEntityRenderer<PedestalEntity> {
    private final ItemRenderer itemRenderer;
    public PedestalRenderer(BlockEntityRendererProvider.Context context, ItemRenderer itemRenderer){
        this.itemRenderer = itemRenderer;
    }
    @Override
    public void render(PedestalEntity pedestalEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        BlockPos abovePos = pedestalEntity.getBlockPos().above();
        int lightAbove = LevelRenderer.getLightColor(pedestalEntity.getLevel(), abovePos);
        ItemStack stack = pedestalEntity.getInventory().getStackInSlot(0);

        if (!stack.isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5, 1.0, 0.5); // center in block, not just Y
            poseStack.scale(0.5f, 0.5f, 0.5f);
            itemRenderer.renderStatic(
                    stack,
                    ItemDisplayContext.FIXED,
                    lightAbove,
                    OverlayTexture.NO_OVERLAY,
                    poseStack,
                    multiBufferSource,
                    pedestalEntity.getLevel(),
                    0
            );
            poseStack.popPose();
        }
    }
}
