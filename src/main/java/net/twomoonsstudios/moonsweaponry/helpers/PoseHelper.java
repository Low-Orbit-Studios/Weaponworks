package net.twomoonsstudios.moonsweaponry.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;

public class PoseHelper {
    static float conversion = Mth.HALF_PI/90f;
    //HumanoidModel.ArmPose sideThrowPose = new HumanoidModel.Arm());
            //you will have to extend the enum for armposes somehow (it says it can be done)
    // then you will use the first variable in IArmPoseTransformer to remodel the player stance
    public static void registerSideThrowStartPose() {
        HumanoidModel.ArmPose.create("SIDE_THROW_START", false, (humanoidModel, livingEntity, humanoidArm) -> {
            boolean mainhand = livingEntity.getUsedItemHand().equals(InteractionHand.MAIN_HAND);
            boolean righthand = livingEntity.getMainArm().equals(HumanoidArm.RIGHT);

            if ((mainhand && righthand) || (!mainhand && !righthand)) {
                humanoidModel.rightArm.xRot = 35f * conversion;
                humanoidModel.rightArm.yRot = Mth.PI;
                humanoidModel.rightArm.zRot = -70f * conversion;
            }
            else {
                humanoidModel.leftArm.xRot = 35f * conversion;
                humanoidModel.leftArm.yRot = Mth.PI;
                humanoidModel.leftArm.zRot = 70f * conversion;
            }
        });
    }

    public static void registerSideThrowEndPose() {
        HumanoidModel.ArmPose.create("SIDE_THROW_END", false, (humanoidModel, livingEntity, humanoidArm) -> {
            boolean mainhand = livingEntity.getUsedItemHand().equals(InteractionHand.MAIN_HAND);
            boolean righthand = livingEntity.getMainArm().equals(HumanoidArm.RIGHT);


            if ((mainhand && righthand) || (!mainhand && !righthand)) {
                humanoidModel.rightArm.xRot = -50f * conversion;
                humanoidModel.rightArm.yRot = 0;
                humanoidModel.rightArm.zRot = 0;
            }
            else {
                humanoidModel.leftArm.xRot = -50f * conversion;
                humanoidModel.leftArm.yRot = 0;
                humanoidModel.leftArm.zRot = 0;
            }
        });
    }
}
