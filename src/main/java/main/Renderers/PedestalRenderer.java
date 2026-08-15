package main.Renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import main.Entities.PedestalEntity;
import main.GeckolibRelated.PedestalsGeoModel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoCube;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PedestalRenderer extends GeoBlockRenderer<PedestalEntity> {
    private final ItemRenderer itemRenderer;

    public PedestalRenderer(ItemRenderer itemRenderer) {
        super(new PedestalsGeoModel());
        this.itemRenderer = itemRenderer;
    }
    @Override
    public void renderFinal(PoseStack poseStack, PedestalEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
        BlockPos abovePos = animatable.getBlockPos().above();
        float time = animatable.getLevel().getGameTime()+partialTick;
        int lightAbove = LevelRenderer.getLightColor(animatable.getLevel(), abovePos);
        ItemStack stack = animatable.getInventory().getStackInSlot(0);
        if (!stack.isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5, 0.6, 0.5); // center in block, not just Y
            poseStack.scale(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(time));
            poseStack.mulPose(Axis.XP.rotationDegrees(time));
            poseStack.mulPose(Axis.ZP.rotationDegrees(time));
            itemRenderer.renderStatic(
                    stack,
                    ItemDisplayContext.FIXED,
                    lightAbove,
                    OverlayTexture.NO_OVERLAY,
                    poseStack,
                    bufferSource,
                    animatable.getLevel(),
                    0
            );
            poseStack.popPose();
        }
    }


}
