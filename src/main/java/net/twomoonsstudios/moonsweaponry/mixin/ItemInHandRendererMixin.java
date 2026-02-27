//package net.twomoonsstudios.moonsweaponry.mixin;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import net.minecraft.client.player.AbstractClientPlayer;
//import net.minecraft.client.player.LocalPlayer;
//import net.minecraft.client.renderer.ItemInHandRenderer;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.entity.HumanoidArm;
//import net.minecraft.world.item.ItemStack;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//import java.util.List;
//
//@Mixin(ItemInHandRenderer.class)
//public abstract class ItemInHandRendererMixin {
//
//    @Shadow
//    protected abstract void renderPlayerArm(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pCombinedLight, float pEquippedProgress, float pSwingProgress, HumanoidArm pSide);
//
//    @Inject(method = "renderArmWithItem", at = @At("RETURN"))
//    private void renderArmWithItem(AbstractClientPlayer pPlayer, float pPartialTicks, float pPitch, InteractionHand pHand, float pSwingProgress, ItemStack pStack, float pEquippedProgress, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pCombinedLight, CallbackInfo ci) {
//        if (pHand == InteractionHand.OFF_HAND) {
//            HumanoidArm offHandArm = pPlayer.getMainArm().getOpposite();
//            renderPlayerArm(pMatrixStack, pBuffer, pCombinedLight, 0, 0, offHandArm);
//        }
//    };
//
//
//    @Inject(method = "selectionUsingItemWhileHoldingBowLike", at = @At("HEAD"))
//    private static void selectionUsingItemWhileHoldingBowLike(LocalPlayer pPlayer, CallbackInfoReturnable<ItemInHandRenderer.HandRenderSelection> cir) {}
////}
