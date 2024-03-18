package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;

public class WeaponworksEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoonsWeaponry.MOD_ID);

    public static final RegistryObject<EntityType<ThrownKnife>> THROWN_KNIFE =
            ENTITY_TYPES.register("thrown_knife", () -> EntityType.Builder.<ThrownKnife>of(ThrownKnife::new, MobCategory.MISC)
                    .sized(0.4f, 0.4f).build("thrown_knife"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
