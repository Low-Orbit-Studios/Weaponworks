package net.twomoonsstudios.moonsweaponry.events;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import net.twomoonsstudios.moonsweaponry.item.ModifiableBowItem;
import net.twomoonsstudios.moonsweaponry.item.weapons.BombCannonItem;

@Mod.EventBusSubscriber
public class SetupEvents {
    @SubscribeEvent
    public static void reloadConfigs(PlayerEvent.PlayerLoggedInEvent event) {
        MoonsWeaponsConfig.register();
    }

    public static void registerBowPredicates(ModifiableBowItem bow) {
        ItemProperties.register(bow, new ResourceLocation("pulling"), (stack, level, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);


        ItemProperties.register(bow, new ResourceLocation("pull"), (stack, level, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F :
                        (float) Math.min((bow.getUseDuration(stack) - entity.getUseItemRemainingTicks()), bow.getDrawDuration()) / bow.getDrawDuration();
            }
        });
    }

    public static void registerBombCannonPredicates(BombCannonItem bombCannonItem) {
        ItemProperties.register(bombCannonItem, new ResourceLocation("charging"), (stack, level, entity, seed) ->
                bombCannonItem.isCharging(stack) ? 1.0F : 0.0F
                );

        ItemProperties.register(bombCannonItem, new ResourceLocation("armed"), (stack, level, entity, seed) ->
                bombCannonItem.isArmed(stack) ? 1.0F : 0.0F );
    }

    @SubscribeEvent
    public static void fixBowFOV(ComputeFovModifierEvent event) {
        Player player = event.getPlayer();
        if (player.isUsingItem()) {
            ItemStack itemStack = player.getUseItem();
            Item item = itemStack.getItem();
            int useDuration = item.getUseDuration(itemStack);
            int remainingTicks = player.getUseItemRemainingTicks();

            if (player.getUseItem().getItem() instanceof ModifiableBowItem bowItem) {
                float progressPercent = (float) Math.min((bowItem.getUseDuration(itemStack) - player.getUseItemRemainingTicks()), bowItem.getDrawDuration())
                        / bowItem.getDrawDuration();
                // has a range from 72000 - 72000 / 30 to 72000 - 0 / 30 SO we want it to take the maximum of 30
                event.setNewFovModifier((float) (event.getFovModifier() - Math.min((0.3 * progressPercent), 0.3)));
            }
            if (player.getUseItem().getItem() instanceof BombCannonItem bombCannonItem) {
                float progress = (float) (Math.min(30, bombCannonItem.getUseDuration(itemStack) - player.getUseItemRemainingTicks())) / 30;
                progress = Math.min(Math.abs(progress), 1);
                event.setNewFovModifier((float) (event.getFovModifier() - Math.min(0.2 * progress, 0.2)));
            }
        }
        if (player.getMainHandItem().getItem() instanceof BombCannonItem bombCannonItem && bombCannonItem.isArmed(player.getMainHandItem())) {
            event.setNewFovModifier(event.getFovModifier() - 0.2F);
        }
    }
}