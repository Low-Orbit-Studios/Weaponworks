package net.twomoonsstudios.moonsweaponry;

import com.mojang.logging.LogUtils;
import io.github.hornster.itemfig.api.serialization.ItemFigApi;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.SpectralArrowRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
//import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.entity.ThrownKnifeRenderer;
import net.twomoonsstudios.moonsweaponry.entity.WeaponworksEntities;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoonsWeaponry.MOD_ID)
public class MoonsWeaponry
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "moonsweaponry";
    // Directly reference a slf4j logger
    protected static final Logger LOGGER = LogUtils.getLogger();

    public static Logger getLogger() {
        return LOGGER;
    }

    public MoonsWeaponry() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MoonsWeaponsConfig.register();

        WeaponworksEntities.register(modEventBus);
        ModItems.register(modEventBus);

        // here lies the site where calico made a tiny mistake and got stuck for a week

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("GREMLINS OF ALL KINDS ARISE!!! Weaponworks setting up!");
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code

            EntityRenderers.register(WeaponworksEntities.THROWN_KNIFE.get(), ThrownKnifeRenderer::new);
        }
    }
}
