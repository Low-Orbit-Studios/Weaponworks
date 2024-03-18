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

// Big thanks to Mickelus for letting me reference/adapt some lines from his work! Check out tetra if you haven't already.

@OnlyIn(Dist.CLIENT)
public class ThrownKnifeRenderer extends EntityRenderer<ThrownKnife> {
    public ThrownKnifeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(ThrownKnife pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();

        tranformRendering(pEntity, pPartialTick, pPoseStack);

        Minecraft.getInstance().getItemRenderer().renderStatic(pEntity.getUsedItem(), ItemTransforms.TransformType.FIXED,
                pPackedLight, OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pEntity.getId());

        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    public void tranformRendering(ThrownKnife pEntity, float partialTicks, PoseStack pPoseStack) {

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

    // This stops it from trying to render it like a normal entity
    @Override
    public ResourceLocation getTextureLocation(ThrownKnife pEntity) {
        return null;
    }
}
