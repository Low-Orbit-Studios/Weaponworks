package net.twomoonsstudios.moonsweaponry.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.block.ModBlocks;

import static net.twomoonsstudios.moonsweaponry.constants.CommonConstants.WEAPON_STATION_ID;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MoonsWeaponry.MOD_ID);

    public static final RegistryObject<BlockEntityType<WeaponStationBlockEntity>> WEAPON_STATION =
            BLOCK_ENTITIES.register(WEAPON_STATION_ID, () -> BlockEntityType.Builder.of(WeaponStationBlockEntity::new,
                    ModBlocks.WEAPON_STATION.get()).build(null));


    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }

}
