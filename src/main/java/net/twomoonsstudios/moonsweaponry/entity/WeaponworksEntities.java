package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;

public class WeaponworksEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoonsWeaponry.MOD_ID);

    public static final RegistryObject<EntityType<ThrownDaggerEntity>> THROWN_DAGGER_ENTITY_TYPE =
            ENTITY_TYPES.register("thrown_dagger", () -> EntityType.Builder.<ThrownDaggerEntity>of(ThrownDaggerEntity::new, MobCategory.MISC)
                    .sized(0.4f,0.4f)
                    .build(new ResourceLocation(MoonsWeaponry.MOD_ID, "thrown_dagger_entity").toString()));

    public static final RegistryObject<EntityType<ThrownJavelinEntity>> THROWN_JAVELIN_ENTITY_TYPE =
            ENTITY_TYPES.register("thrown_javelin", () -> EntityType.Builder.<ThrownJavelinEntity>of(ThrownJavelinEntity::new, MobCategory.MISC)
                    .sized(0.4f,0.4f)
                    .build(new ResourceLocation(MoonsWeaponry.MOD_ID, "thrown_javelin_entity").toString()));

    public static final RegistryObject<EntityType<ThrownShurikenEntity>> THROWN_SHURIKEN_ENTITY_TYPE =
            ENTITY_TYPES.register("thrown_shuriken", () -> EntityType.Builder.<ThrownShurikenEntity>of(ThrownShurikenEntity::new, MobCategory.MISC)
                    .sized(0.4f,0.4f)
                    .build(new ResourceLocation(MoonsWeaponry.MOD_ID, "thrown_shuriken_entity").toString()));

    public static final RegistryObject<EntityType<ThrownHatchetEntity>> THROWN_HATCHET_ENTITY_TYPE =
            ENTITY_TYPES.register("thrown_hatchet", () -> EntityType.Builder.<ThrownHatchetEntity>of(ThrownHatchetEntity::new, MobCategory.MISC)
                    .sized(0.4f,0.4f)
                    .build(new ResourceLocation(MoonsWeaponry.MOD_ID, "thrown_hatchet_entity").toString()));

    public static final RegistryObject<EntityType<ThrownBoomerangEntity>> THROWN_BOOMERANG_ENTITY_TYPE =
            ENTITY_TYPES.register("thrown_boomerang", () -> EntityType.Builder.<ThrownBoomerangEntity>of(ThrownBoomerangEntity::new, MobCategory.MISC)
                    .sized(0.7f,0.3f)
                    .build(new ResourceLocation(MoonsWeaponry.MOD_ID, "thrown_boomerang_entity").toString()));

    public static final RegistryObject<EntityType<ThrownBombEntity>> THROWN_BOMB_ENTITY_TYPE =
            ENTITY_TYPES.register("thrown_bomb", () -> EntityType.Builder.<ThrownBombEntity>of(ThrownBombEntity::new, MobCategory.MISC)
                    .sized(.8f,.8f)
                    .build(new ResourceLocation(MoonsWeaponry.MOD_ID, "thrown_bomb_entity").toString()));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
