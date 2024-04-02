package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.entity.thrownKnife.ThrownIronKnifeEntity;

public class WeaponworksEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoonsWeaponry.MOD_ID);

    public static final RegistryObject<EntityType<ThrownKnifeEntity>> THROWN_IRON_KNIFE_ENTITY_TYPE =
            ENTITY_TYPES.register("thrown_iron_knife", () -> EntityType.Builder.<ThrownKnifeEntity>of(ThrownIronKnifeEntity::new, MobCategory.MISC)
                    .sized(0.4f, 0.4f)
                    .build(new ResourceLocation(MoonsWeaponry.MOD_ID, "thrown_iron_knife_entity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
