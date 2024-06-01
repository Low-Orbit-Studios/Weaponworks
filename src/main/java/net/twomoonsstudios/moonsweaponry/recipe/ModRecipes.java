package net.twomoonsstudios.moonsweaponry.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.RegisterTextureAtlasSpriteLoadersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;

import static net.twomoonsstudios.moonsweaponry.constants.RecipeConstants.WEAPON_STATION_RECIPE_TYPE_ID;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MoonsWeaponry.MOD_ID);

    public static final RegistryObject<RecipeSerializer<WeaponStationRecipe>> WEAPON_STATION_SERIALIZER =
            SERIALIZERS.register(WEAPON_STATION_RECIPE_TYPE_ID, () -> WeaponStationRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
