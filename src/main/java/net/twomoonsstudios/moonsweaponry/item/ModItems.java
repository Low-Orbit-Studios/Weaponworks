package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.constants.CommonConstants;
import net.twomoonsstudios.moonsweaponry.item.weapons.*;

import java.util.Map;

import static net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig.*;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoonsWeaponry.MOD_ID);

    public static void register(IEventBus eventBus){
        try{
            var weaponConfigs = WEAPON_CONFIGS;
            var weaponConfigTypes = weaponConfigs.keySet();
            for (var weaponType : weaponConfigTypes) {
                var weaponCategory = weaponConfigs.get(weaponType);

                for (var entry : weaponCategory.entrySet()) {
                    WeaponConfigObj weaponConfig = entry.getValue();
                    var weaponId = weaponConfig.getConfigObjId();
                    switch (weaponType) {

                        case GREATSWORD -> {
                            ITEMS.register(weaponId, () -> new GreatswordItem(weaponConfig));
                        }
                        case HALBERD -> {
                            ITEMS.register(weaponId, () -> new HalberdItem(weaponConfig));
                        }
                        case HAMMER -> {
                            ITEMS.register(weaponId, () -> new HammerItem(weaponConfig));
                        }
                        case KATANA -> {
                            ITEMS.register(weaponId, () -> new KatanaItem(weaponConfig));
                        }
                        case RAPIER -> {
                            ITEMS.register(weaponId, () -> new RapierItem(weaponConfig));
                        }
                        case SCYTHE -> {
                            ITEMS.register(weaponId, () -> new ScytheItem(weaponConfig));
                        }
                        case WARGLAIVE -> {
                            ITEMS.register(weaponId, () -> new WarglaiveItem(weaponConfig));
                        }
                        default -> throw new Exception("Unknown weapon type to load: " + weaponId);
                    }
                }
            }
        }
        catch(Exception ex){
            MoonsWeaponry.getLogger().error("Failed to load weapons: " + ex.getMessage());
        }


        ITEMS.register(eventBus);
    }
}
