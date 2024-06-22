package net.twomoonsstudios.moonsweaponry.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;

// Big thanks to Mickelus for letting me reference/adapt some lines from his work! Check out tetra if you haven't already.

@OnlyIn(Dist.CLIENT)
public class ThrownKnifeRenderer extends EntityRenderer<ThrownKnifeEntity> {
    public ThrownKnifeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(ThrownKnifeEntity pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();

        float velocity = (float) pEntity.getDeltaMovement().normalize().length();
        boolean shouldSpin = (velocity > 0.1 || pEntity.isNoPhysics()) && !(pEntity.inGroundCheck || pEntity.isInWall() || pEntity.isOnGround() || pEntity.isInWaterOrBubble() || pEntity.isInPowderSnow);
        if (shouldSpin) {
            spin(pEntity, pPartialTick, pPoseStack);
        } else {pointFirst(pEntity, pPartialTick, pPoseStack);}

        var usedItem = pEntity.getUsedItem();
        Minecraft.getInstance().getItemRenderer().renderStatic(usedItem, ItemTransforms.TransformType.FIXED,
                pPackedLight, OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pEntity.getId());

        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    public void pointFirst(ThrownKnifeEntity pEntity, float partialTicks, PoseStack pPoseStack) {

        // Points away from player
        float yRotModifier = 270.0F;
        pPoseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, pEntity.getYRot(), pEntity.getYRot()) + yRotModifier));

        // Make the point go forward
        float zRotModifier = 135.0F;
        pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, pEntity.getXRot(), pEntity.getXRot()) + zRotModifier));

        // stops it from pointing right at me since I don't wanna get stabbed as I throw it
        float xRotModifier = 180.0F;
        pPoseStack.mulPose(Vector3f.XP.rotationDegrees(xRotModifier));
    }

    public void spin(ThrownKnifeEntity entity, float partialTicks, PoseStack poseStack) {

        float spinModifier = entity.tickCount + partialTicks;
        // Points away from player
        float yRotModifier = 270.0F;
        poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entity.getYRot(), entity.getYRot()) + yRotModifier));

        //epic spinny
        float zRotModifier = spinModifier * -30;
        poseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.getXRot(), entity.getXRot()) + zRotModifier));

        float xRotModifier = 180.0F;
        poseStack.mulPose(Vector3f.XP.rotationDegrees(xRotModifier));

        poseStack.translate(-0.2f,0.2f,0f);
    }



    // This stops it from trying to render it like a normal entity
    @Override
    public ResourceLocation getTextureLocation(ThrownKnifeEntity pEntity) {
        return null;
    }
}
