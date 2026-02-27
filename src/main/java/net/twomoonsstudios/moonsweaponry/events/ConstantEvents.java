package net.twomoonsstudios.moonsweaponry.events;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderArmEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
//import net.twomoonsstudios.moonsweaponry.item.weapons.BombCannonItem;


@Mod.EventBusSubscriber
public class ConstantEvents {


    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent event) {
        Player player = event.getEntity();
        Item heldItem = player.getMainHandItem().getItem();
        //boolean isBombCannon = heldItem instanceof BombCannonItem;
//        boolean isArmed = false;
//        if (isBombCannon) {
//            isArmed = ((BombCannonItem) heldItem).isArmed(player.getMainHandItem());
//        }
//        if (isBombCannon && isArmed && player.getMainArm() == HumanoidArm.RIGHT) {
//            event.getRenderer().getModel().rightArmPose = HumanoidModel.ArmPose.CROSSBOW_HOLD;
//        }
//        if (isBombCannon && isArmed && player.getMainArm() == HumanoidArm.LEFT) {
//            event.getRenderer().getModel().leftArmPose = HumanoidModel.ArmPose.CROSSBOW_HOLD;
//        }
    }

    // Set up animation for bomb loading. A good time var:
//    @SubscribeEvent
//    public static void renderPlayerHands(RenderHandEvent event) {
//        Player player = Minecraft.getInstance().player;
//        PoseStack poseStack = event.getPoseStack();
//        assert player != null;
//        ItemStack mainhandStack = player.getMainHandItem();
//        boolean rightHanded = (player.getMainArm().equals(HumanoidArm.RIGHT));
//        boolean mainHand = event.getHand().equals(InteractionHand.MAIN_HAND);
//        if (mainhandStack.getItem() instanceof BombCannonItem bombCannonItem) {
//            var time = 72000 - player.getUseItemRemainingTicks();
//            if (!mainHand) {
//                if (0 < time && time < 20) {
//                    poseStack.popPose();
//                    poseStack.translate(0,3,0);
//                    poseStack.pushPose();
//                }
//            }
//        }
//    }

}
