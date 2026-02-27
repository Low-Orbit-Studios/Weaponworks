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

// Big thanks to Mickelus for letting me reference/adapt some lines from his work! Check out tetra if you haven't already.

public class ThrownWeaponRenderer extends EntityRenderer<AbstractThrowable> {
    public ThrownWeaponRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(AbstractThrowable pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();

        float velocity = (float) pEntity.getDeltaMovement().normalize().length();
        boolean shouldSpin = (velocity > 0.1 || pEntity.isNoPhysics()) && !(pEntity.inGroundCheck || pEntity.isInWall() || pEntity.isOnGround() || pEntity.isInWaterOrBubble() || pEntity.isInPowderSnow);
        if (shouldSpin && (pEntity instanceof ThrownDaggerEntity || pEntity instanceof ThrownHatchetEntity)) {
            verticalSpin(pEntity, pPartialTick, pPoseStack);
        } else {
            pointFirst(pEntity, pPartialTick, pPoseStack);
            if (pEntity instanceof ThrownHatchetEntity) { // hatchet hits blocks properly
                pPoseStack.translate(0.1,-0.1, 0);
                pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(25));
                pPoseStack.mulPose(Vector3f.YN.rotationDegrees(180));
            }
        }

        if (pEntity instanceof ThrownJavelinEntity) {
            pPoseStack.translate(0.35,-0.35,0); // Translates the point to where the hitbox is
        }

        if (pEntity instanceof ThrownShurikenEntity || pEntity instanceof ThrownBoomerangEntity) {
            pointHorizontal(pEntity,pPartialTick,pPoseStack, shouldSpin); // Points these entities sideways
        }

        var usedItem = pEntity.getPickupItem();
        Minecraft.getInstance().getItemRenderer().renderStatic(usedItem, ItemTransforms.TransformType.FIXED,
                pPackedLight, OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pEntity.getId());

        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    public void pointFirst(AbstractThrowable pEntity, float partialTicks, PoseStack pPoseStack) {

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

    public void verticalSpin(AbstractThrowable entity, float partialTicks, PoseStack poseStack) {

        float spinModifier = entity.tickCount + partialTicks;
        // Points away from player
        float yRotModifier = 270.0F;
        //poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entity.getYRot(), entity.getYRot()) + yRotModifier));
        poseStack.mulPose(Vector3f.YP.rotationDegrees(entity.getYRot() + yRotModifier));
        //epic spinny
        float zRotModifier = spinModifier * -60f;
        //poseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.getXRot(), entity.getXRot()) + zRotModifier));
        poseStack.mulPose(Vector3f.ZP.rotationDegrees(entity.getXRot() + zRotModifier));

        poseStack.mulPose(Vector3f.XP.rotationDegrees(180.0f));
    }

    public void pointHorizontal(AbstractThrowable entity, float partialTicks, PoseStack poseStack, boolean shouldSpin) {
        poseStack.mulPose(Vector3f.XP.rotationDegrees(90));
        poseStack.mulPose(Vector3f.YP.rotationDegrees(-45));
        if (shouldSpin) {
            float spinModifier = (entity.tickCount + partialTicks) * -40f;
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(entity.getXRot() + spinModifier));
        }
    }

    // This stops it from trying to render it like a normal entity
    @Override
    public ResourceLocation getTextureLocation(AbstractThrowable pEntity) {
        return null;
    }
}
