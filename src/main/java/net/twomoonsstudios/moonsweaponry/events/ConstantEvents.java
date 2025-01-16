package net.twomoonsstudios.moonsweaponry.events;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.twomoonsstudios.moonsweaponry.item.weapons.BombCannonItem;

@Mod.EventBusSubscriber
public class ConstantEvents {
    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent event) {
        Player player = event.getEntity();
        Item heldItem = player.getMainHandItem().getItem();
        boolean isBombCannon = heldItem instanceof BombCannonItem;
        boolean isArmed = false;
        if (isBombCannon) {
            isArmed = ((BombCannonItem) heldItem).isArmed(player.getMainHandItem());
        }
        if (isBombCannon && isArmed && player.getMainArm() == HumanoidArm.RIGHT) {
            event.getRenderer().getModel().rightArmPose = HumanoidModel.ArmPose.CROSSBOW_HOLD;
        }
        if (isBombCannon && isArmed && player.getMainArm() == HumanoidArm.LEFT) {
            event.getRenderer().getModel().leftArmPose = HumanoidModel.ArmPose.CROSSBOW_HOLD;
        }
    }
}
