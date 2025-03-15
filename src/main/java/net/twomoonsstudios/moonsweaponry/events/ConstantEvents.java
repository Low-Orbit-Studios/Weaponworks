package net.twomoonsstudios.moonsweaponry.events;

import com.google.gson.Gson;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.AttackDamageMobEffect;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;
import net.twomoonsstudios.moonsweaponry.item.weapons.BombCannonItem;
import net.twomoonsstudios.moonsweaponry.newConfig.ConfigHelper;
import net.twomoonsstudios.moonsweaponry.newConfig.WeaponworksConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod.EventBusSubscriber
public class ConstantEvents {

    static ConfigHelper config = new ConfigHelper(FMLPaths.CONFIGDIR.get());

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
