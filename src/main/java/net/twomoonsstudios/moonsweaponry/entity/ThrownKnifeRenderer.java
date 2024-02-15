package net.twomoonsstudios.moonsweaponry.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThrownKnifeRenderer extends EntityRenderer<ThrownKnife> {
    public ThrownKnifeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public void render(ThrownKnife pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        // Thank you Mickelus for letting me adapt this line!
        Minecraft.getInstance().getItemRenderer().renderStatic(pEntity.getUsedItem(), ItemTransforms.TransformType.FIXED,
                pPackedLight, OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pEntity.getId());

        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownKnife pEntity) {
        return null;
    }
}
