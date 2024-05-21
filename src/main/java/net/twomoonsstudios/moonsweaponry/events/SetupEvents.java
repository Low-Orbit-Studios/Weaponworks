package net.twomoonsstudios.moonsweaponry.events;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import net.twomoonsstudios.moonsweaponry.item.ModifiableBowItem;

import static net.twomoonsstudios.moonsweaponry.MoonsWeaponry.MOD_ID;

@Mod.EventBusSubscriber
public class SetupEvents {
    @SubscribeEvent
    public static void reloadConfigs(PlayerEvent.PlayerLoggedInEvent event) {
        MoonsWeaponsConfig.register();
    }

    public static void registerBowPredicates(Item bow) {
        ItemProperties.register(bow, new ResourceLocation("pulling"), (stack, level, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);


        ItemProperties.register(bow, new ResourceLocation("pull"), (stack, level, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F :
                        (float) (stack.getUseDuration() - entity.getUseItemRemainingTicks()) / ((ModifiableBowItem)stack.getItem()).getDrawDuration();
            }
        });
    }

    @SubscribeEvent
    public static void fixBowFOV(ComputeFovModifierEvent event) {
        Player player = event.getPlayer();
        if (player.isUsingItem()) {
            if (player.getUseItem().getItem() instanceof ModifiableBowItem bowItem) {
                float progressPercent = (float) (player.getUseItem().getUseDuration() - player.getUseItemRemainingTicks()) / bowItem.getDrawDuration();
                progressPercent = progressPercent * progressPercent;
                event.setNewFovModifier((float) (event.getFovModifier() - Math.min((progressPercent), 0.3)));
            }
        }
    }
}
