package net.twomoonsstudios.moonsweaponry;


import com.mojang.logging.LogUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.IArmPoseTransformer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.forgespi.Environment;
import net.twomoonsstudios.moonsweaponry.enchanting.ModEnchantments;
import net.twomoonsstudios.moonsweaponry.entity.ThrownBombRenderer;
import net.twomoonsstudios.moonsweaponry.entity.ThrownWeaponRenderer;
import net.twomoonsstudios.moonsweaponry.entity.WeaponworksEntities;
import net.twomoonsstudios.moonsweaponry.events.SetupEvents;
import net.twomoonsstudios.moonsweaponry.helpers.PoseHelper;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import net.twomoonsstudios.moonsweaponry.item.ModifiableBowItem;
//import net.twomoonsstudios.moonsweaponry.item.weapons.BombCannonItem;

import net.twomoonsstudios.moonsweaponry.newConfig.ConfigHelper;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MoonsWeaponry.MOD_ID)
public class MoonsWeaponry
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "moonsweaponry";
//    public static final String MOD_ID = "weaponworks";
//    public static final String MOD_ID_DEPRECATED = "moonsweaponry";
    // Directly reference a slf4j logger
    protected static final Logger LOGGER = LogUtils.getLogger();
    protected static final ConfigHelper configHelper = new ConfigHelper(FMLPaths.CONFIGDIR.get());

    public static Logger getLogger() {
        return LOGGER;
    }

    public static ConfigHelper getConfigHelper() {return configHelper;}

    public MoonsWeaponry() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        WeaponworksEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModEnchantments.register(modEventBus);
        // here lies the site where calico made a tiny mistake and got stuck for a week

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        if (Environment.get().getDist().isClient()) {
            new ConfigHelper(FMLPaths.CONFIGDIR.get());
        }
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
            // Register the renderer for the thrown weapons. Probably will have to redo this soon.
            EntityRenderers.register(WeaponworksEntities.THROWN_DAGGER_ENTITY_TYPE.get(), ThrownWeaponRenderer::new);
            EntityRenderers.register(WeaponworksEntities.THROWN_JAVELIN_ENTITY_TYPE.get(), ThrownWeaponRenderer::new);
            EntityRenderers.register(WeaponworksEntities.THROWN_SHURIKEN_ENTITY_TYPE.get(), ThrownWeaponRenderer::new);
            EntityRenderers.register(WeaponworksEntities.THROWN_HATCHET_ENTITY_TYPE.get(), ThrownWeaponRenderer::new);
            EntityRenderers.register(WeaponworksEntities.THROWN_BOOMERANG_ENTITY_TYPE.get(), ThrownWeaponRenderer::new);
            EntityRenderers.register(WeaponworksEntities.THROWN_BOMB_ENTITY_TYPE.get(), ThrownBombRenderer::new);
            // Fix the bow models so they register at the right times.
            SetupEvents.registerBowPredicates((ModifiableBowItem) ModItems.LONGBOW.get());
            SetupEvents.registerBowPredicates((ModifiableBowItem) ModItems.SHORTBOW.get());
            // Add the bomb cannon model predicates to fix the models
            //SetupEvents.registerBombCannonPredicates((BombCannonItem) ModItems.BOMB_CANNON.get());
            // Add the menu for the weapon station
            PoseHelper.registerSideThrowStartPose();
            PoseHelper.registerSideThrowEndPose();
        }
    }
}
