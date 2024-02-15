package net.twomoonsstudios.moonsweaponry.events;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

@Mod.EventBusSubscriber
public class SetupEvents {
    @SubscribeEvent
    public static void reloadConfigs(PlayerEvent.PlayerLoggedInEvent event) {
        MoonsWeaponsConfig.register();
    }
}
