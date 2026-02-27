package net.twomoonsstudios.moonsweaponry.mixin;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.FoodOnAStickItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.item.weapons.BoomerangItem;
import net.twomoonsstudios.moonsweaponry.item.weapons.ShurikenItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerRenderer.class)
public class
PlayerRendererMixin {


    @Inject(method = "getArmPose", at = @At("HEAD"), cancellable = true)
    private static void getArmPose(AbstractClientPlayer pPlayer, InteractionHand pHand, CallbackInfoReturnable<HumanoidModel.ArmPose> callbackInfoReturnable) {
        boolean isSidethrowItem = false;
        Item item =  pPlayer.getItemInHand(pHand).getItem();
        if (item instanceof ShurikenItem) {isSidethrowItem = true;}
        if (item instanceof BoomerangItem) {isSidethrowItem = true;}
        if (isSidethrowItem) {
            if (pPlayer.getCooldowns().isOnCooldown(item)) {
                //throw pose
                callbackInfoReturnable.setReturnValue(HumanoidModel.ArmPose.valueOf("SIDE_THROW_END"));
            }
            else if (pPlayer.getUseItemRemainingTicks() > 2) {
                callbackInfoReturnable.setReturnValue(HumanoidModel.ArmPose.valueOf("SIDE_THROW_START"));
            }
            //MoonsWeaponry.getLogger().debug("Value 1: {}", pPlayer.getUseItemRemainingTicks());
            //MoonsWeaponry.getLogger().debug("Value 2: {}", 72000 - pPlayer.getUseItemRemainingTicks());
        }
    }

}
