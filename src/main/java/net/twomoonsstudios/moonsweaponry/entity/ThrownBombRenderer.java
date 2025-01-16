package net.twomoonsstudios.moonsweaponry.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.item.ModItems;

public class ThrownBombRenderer extends EntityRenderer<ThrownBombEntity> {

    public ThrownBombRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(ThrownBombEntity entity, float entityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.translate(0f,1f, 0f);
        verticalSpin(entity, pPartialTick, pPoseStack);
        BlockPos offsetLightCoords = new BlockPos(entity.getPosition(pPartialTick).add(0,1,0));
        int temp = getBlockLightLevel(entity, offsetLightCoords) + getSkyLightLevel(entity, offsetLightCoords);
        pPackedLight = 1048576 * Math.min(Math.max(0, temp), 15);

        Minecraft.getInstance().getItemRenderer().renderStatic(ModItems.BOMB.get().getDefaultInstance(), ItemTransforms.TransformType.FIXED,
                pPackedLight, OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, entity.getId());

        pPoseStack.popPose();
        super.render(entity, entityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownBombEntity thrownBombEntity) {
        return null;
    }

    public void verticalSpin(AbstractThrowable entity, float partialTicks, PoseStack poseStack) {

        float spinModifier = entity.tickCount + partialTicks;
        // Points away from player
        float yRotModifier = 270.0F;
        poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entity.getYRot(), entity.getYRot()) + yRotModifier));

        if (entity.getDeltaMovement().length() >= 0.3) {
            float zRotModifier = (float) (spinModifier * -entity.getDeltaMovement().length());
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.getXRot(), entity.getXRot()) + zRotModifier));
        } else {
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.getXRot(), entity.getXRot())));
        }

        //poseStack.mulPose(Vector3f.XP.rotationDegrees(180.0f));
    }
}
